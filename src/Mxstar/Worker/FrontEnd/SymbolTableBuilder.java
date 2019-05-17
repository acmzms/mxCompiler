package Mxstar.Worker.FrontEnd;
import java.util.*;
import Mxstar.AST.*;
import Mxstar.Symbol.*;
import Mxstar.Worker.ErrorRecorder;
public class SymbolTableBuilder implements IAstVisitor {
    public ErrorRecorder errorRecorder;
    public GlobalSymbolTable globalSymbolTable;
    public SymbolTable currentSymbolTable;
    public FunctionSymbol curFunction;
    private String name;
    public HashMap<SymbolTable,ClassSymbol> symbolTableToClassSymbol;
    public SymbolTableBuilder(ErrorRecorder errorRecorder) {
        this.errorRecorder = errorRecorder;
        this.globalSymbolTable = new GlobalSymbolTable();
        this.currentSymbolTable = globalSymbolTable;
        this.symbolTableToClassSymbol = new HashMap<>();
    }
    private void enter(SymbolTable symbolTable) {
        currentSymbolTable = symbolTable;
    }
    private void leave() {
        currentSymbolTable = currentSymbolTable.parent;
        assert(currentSymbolTable != null);
    }
    private VariableType resolveVariableType(TypeNode node) {
        if(node instanceof PrimitiveTypeNode) {
            PrimitiveSymbol symbol = globalSymbolTable.getPrimitiveSymbol(((PrimitiveTypeNode) node).name);
            if(symbol != null) {
                return new PrimitiveType(symbol.name, symbol);
            } else {
                return null;
            }
        } else if(node instanceof ClassTypeNode) {
            ClassSymbol symbol = globalSymbolTable.getClassSymbol(((ClassTypeNode) node).className);
            if(symbol != null) {
                return new ClassType(symbol.name, symbol);
            } else {
                return null;
            }
        } else if(node instanceof ArrayTypeNode) {
            ArrayTypeNode oldArray = (ArrayTypeNode)node;
            VariableType baseType;
            if(oldArray.dimension == 1) {
                baseType = resolveVariableType(oldArray.baseType);
                if (oldArray.baseType instanceof PrimitiveTypeNode && ((PrimitiveTypeNode) oldArray.baseType).name.equals("void")) {
                    errorRecorder.addRecord();
                }
            } else {
                ArrayTypeNode newArray = new ArrayTypeNode();
                newArray.baseType = oldArray.baseType;
                newArray.dimension = oldArray.dimension - 1;
                baseType = resolveVariableType(newArray);
            }
            if(baseType != null) {
                return new ArrayType(baseType);
            } else {
                return null;
            }
        } else {
            assert false;
            return null;
        }
    }
    private VariableSymbol resolveVariableSymbol(String name, SymbolTable symbolTable) {
        VariableSymbol symbol = symbolTable.getVariableSymbol(name);
        if(symbol != null) {
            return symbol;
        } else {
            if(symbolTable.parent != null) {
                return resolveVariableSymbol(name, symbolTable.parent);
            } else {
                return null;
            }
        }
    }
    private VariableSymbol resolveVariableSymbol(String name) {
        return resolveVariableSymbol(name, currentSymbolTable);
    }
    private FunctionSymbol resolveFunctionSymbol(String name, SymbolTable symbolTable) {
        FunctionSymbol symbol = symbolTable.getFunctionSymbol(name);
        if(symbol != null) {
            return symbol;
        } else {
            if(symbolTable.parent != null) {
                return resolveFunctionSymbol(name, symbolTable.parent);
            } else {
                return null;
            }
        }
    }
    private FunctionSymbol resolveFunctionSymbol(String name) {
        this.name = name;
        return resolveFunctionSymbol(name, currentSymbolTable);
    }
    private void registerClass(ClassDeclaration classDeclaration) {
        if(globalSymbolTable.getClassSymbol(classDeclaration.name) != null) {
            errorRecorder.addRecord();
            return;
        }
        if(globalSymbolTable.getFunctionSymbol(classDeclaration.name) != null) {
            errorRecorder.addRecord();
            return;
        }
        ClassSymbol symbol = new ClassSymbol();
        symbol.name = classDeclaration.name;
        symbol.classSymbolTable = new SymbolTable(globalSymbolTable);
        classDeclaration.symbol = symbol;
        symbolTableToClassSymbol.put(symbol.classSymbolTable, symbol);
        globalSymbolTable.putClassSymbol(symbol.name, symbol);
    }
    private void registerClassFunctions(ClassDeclaration classDeclaration) {
        ClassSymbol symbol = globalSymbolTable.getClassSymbol(classDeclaration.name);
        enter(symbol.classSymbolTable);
        if(classDeclaration.constructor != null) {
            registerFunction(classDeclaration.constructor, symbol);
        }
        for(FuncDeclaration d : classDeclaration.methods) {
            registerFunction(d, symbol);
        }
        leave();
    }
    private void defineClassFields(ClassDeclaration classDeclaration) {
        ClassSymbol symbol = globalSymbolTable.getClassSymbol(classDeclaration.name);
        enter(symbol.classSymbolTable);
        for(VariableDeclaration d : classDeclaration.fields) {
            defineVariable(d);
        }
        leave();
    }
    private void defineClassFunctions(ClassDeclaration classDeclaration) {
        ClassSymbol symbol = globalSymbolTable.getClassSymbol(classDeclaration.name);
        enter(symbol.classSymbolTable);
        if(classDeclaration.constructor != null) {
            defineFunction(classDeclaration.constructor, symbol);
        }
        for(FuncDeclaration d : classDeclaration.methods) {
            defineFunction(d, symbol);
        }
        leave();
    }
    private void registerFunction(FuncDeclaration funcDeclaration, ClassSymbol classSymbol) {
        if(currentSymbolTable.getFunctionSymbol(funcDeclaration.name) != null) {
            errorRecorder.addRecord();
            return;
        }
        if(classSymbol == null && globalSymbolTable.getClassSymbol(funcDeclaration.name) != null) {
            errorRecorder.addRecord();
            return;
        }
        FunctionSymbol symbol = new FunctionSymbol();
        symbol.name = (classSymbol == null ? "" : classSymbol.name + ".") + funcDeclaration.name;
        symbol.isGlobalFunction = (classSymbol == null);
        symbol.returnType = resolveVariableType(funcDeclaration.retTypeNode);
        if(symbol.returnType == null) {
            errorRecorder.addRecord();
        }
        symbol.functionSymbolTable = null;
        if(classSymbol != null) {
            symbol.parameterNames.add("this");
            symbol.parameterTypes.add(new ClassType(classSymbol.name, classSymbol));
        }
        for(VariableDeclaration d : funcDeclaration.parameters) {
            symbol.parameterNames.add(d.name);
            VariableType type = resolveVariableType(d.typeNode);
            if(type == null) {
                errorRecorder.addRecord();
            }
            symbol.parameterTypes.add(type);
        }
        funcDeclaration.symbol = symbol;
        currentSymbolTable.putFunctionSymbol(funcDeclaration.name, symbol);
    }
    private void defineVariable(VariableDeclaration d) {
        VariableType type = resolveVariableType(d.typeNode);
        if(d.init != null) {
            d.init.accept(this);
        }
        if(type != null) {
            if(currentSymbolTable.getVariableSymbol(d.name) != null) {
                errorRecorder.addRecord();
            } else {
                if (type instanceof PrimitiveType && ((PrimitiveType) type).name.equals("void") || type instanceof ClassType && ((ClassType) type).name.equals("null")) {
                    errorRecorder.addRecord();
                }
                boolean isClassField = symbolTableToClassSymbol.containsKey(currentSymbolTable);
                boolean isGlobalVariable = currentSymbolTable == globalSymbolTable;
                d.symbol = new VariableSymbol(d.name, type, isClassField, isGlobalVariable);
                currentSymbolTable.putVariableSymbol(d.name, d.symbol);
                if(isGlobalVariable && d.init != null) {
                    globalSymbolTable.globalInitUsedVariables.add(d.symbol);
                }
            }
        } else {
            errorRecorder.addRecord();
        }
    }
    private void defineFunction(FuncDeclaration funcDeclaration, ClassSymbol classSymbol) {
        FunctionSymbol functionSymbol = currentSymbolTable.getFunctionSymbol(funcDeclaration.name);
        curFunction = functionSymbol;
        functionSymbol.functionSymbolTable = new SymbolTable(currentSymbolTable);
        enter(functionSymbol.functionSymbolTable);
        if(classSymbol != null) {
            defineVariable(new VariableDeclaration(new ClassTypeNode(classSymbol.name), "this", null));
        }
        for(VariableDeclaration d : funcDeclaration.parameters) {
            defineVariable(d);
        }
        for(Statement s : funcDeclaration.body) {
            s.accept(this);
        }
        leave();
        curFunction = null;
        functionSymbol.finish();
    }
    @Override public void visit(CompilationUnit node) {
        for(ClassDeclaration d : node.classes) {
            registerClass(d);
        }
        for(ClassDeclaration d : node.classes) {
            registerClassFunctions(d);
        }
        for(FuncDeclaration d : node.functions) {
            registerFunction(d, null);
        }
        if(errorRecorder.errorOccured()) {
            return;
        }
        for(ClassDeclaration d : node.classes) {
            defineClassFields(d);
        }
        for(Declaration d : node.declarations) {
            if(d instanceof VariableDeclaration) {
                defineVariable((VariableDeclaration) d);
            } else if(d instanceof ClassDeclaration) {
                defineClassFunctions((ClassDeclaration) d);
            } else {
                defineFunction((FuncDeclaration) d, null);
            }
        }
    }
    @Override public void visit(Declaration node) {
        assert false;
    }
    @Override public void visit(FuncDeclaration node) {}
    @Override public void visit(ClassDeclaration node) {}
    @Override public void visit(VariableDeclaration node) {
        defineVariable(node);
    }
    @Override public void visit(TypeNode node) {}
    @Override public void visit(ArrayTypeNode node) {}
    @Override public void visit(PrimitiveTypeNode node) {}
    @Override public void visit(ClassTypeNode node) {}
    @Override public void visit(Statement node) {
        assert false;
    }
    @Override public void visit(ForStatement node) {
        if(node.initStatement != null) {
            node.initStatement.accept(this);
        }
        if(node.condition != null) {
            node.condition.accept(this);
        }
        if(node.updateStatement != null) {
            node.updateStatement.accept(this);
        }
        node.body.accept(this);
    }
    @Override public void visit(WhileStatement node) {
        node.condition.accept(this);
        node.body.accept(this);
    }
    @Override public void visit(IfStatement node) {
        node.condition.accept(this);
        node.thenStatement.accept(this);
        if(node.elseStatement != null) {
            node.elseStatement.accept(this);
        }
    }
    @Override public void visit(ContinueStatement node) {}
    @Override public void visit(BreakStatement node) {}
    @Override public void visit(ReturnStatement node) {
        if(node.retExpression != null) {
            node.retExpression.accept(this);
        }
    }
    @Override public void visit(BlockStatement node) {
        SymbolTable symbolTable = new SymbolTable(currentSymbolTable);
        enter(symbolTable);
        for(Statement s : node.statements) {
            s.accept(this);
        }
        leave();
    }
    @Override public void visit(VariableDeclarationStatement node) {
        node.declaration.accept(this);
    }
    @Override public void visit(ExpressionStatement node) {
        node.expression.accept(this);
    }
    @Override public void visit(Expression node) {
        assert false;
    }
    @Override public void visit(Identifier node) {
        VariableSymbol symbol = resolveVariableSymbol(node.name);
        if(symbol == null) {
            errorRecorder.addRecord();
            node.type = null;
            return;
        }
        node.symbol = symbol;
        node.type = symbol.type;
        if(symbol.isGlobalVariable) {
            if(curFunction == null) {
                globalSymbolTable.globalInitUsedVariables.add(symbol);
            } else {
                curFunction.usedGlobalVariables.add(symbol);
                curFunction.withSideEffect = true;
            }
        }
    }
    @Override public void visit(LiteralExpression node) {
        switch(node.typeName) {
            case "int":
                node.type = new PrimitiveType("int", globalSymbolTable.getPrimitiveSymbol("int"));
                break;
            case "null":
                node.type = new ClassType("null", globalSymbolTable.getClassSymbol("null"));
                break;
            case "bool":
                node.type = new PrimitiveType("bool", globalSymbolTable.getPrimitiveSymbol("bool"));
                break;
            case "string":
                node.type = new ClassType("string", globalSymbolTable.getClassSymbol("string"));
                break;
            default:
                assert false;
        }
    }
    @Override public void visit(ArrayExpression node) {
        node.address.accept(this);
        node.index.accept(this);
        if(node.address.type instanceof ArrayType) {
            node.type = ((ArrayType) node.address.type).baseType;
        } else {
            node.type = null;
            errorRecorder.addRecord();
        }
    }
    @Override public void visit(FuncCallExpression node) {
        FunctionSymbol functionSymbol = resolveFunctionSymbol(node.functionName);
        if(functionSymbol == null) {
            errorRecorder.addRecord();
            return;
        }
        for(Expression e : node.arguments)
            e.accept(this);
        node.type = functionSymbol.returnType;
        node.functionSymbol = functionSymbol;
        if(curFunction != null) {
            curFunction.calleeSet.add(functionSymbol);
        }
    }
    @Override public void visit(NewExpression node) {
        for (Expression e : node.exprDimensions) {
            e.accept(this);
        }
        int dimension = node.exprDimensions.size() + node.restDemension;
        node.type = resolveVariableType(node.typeNode);
        if (node.type == null) {
            errorRecorder.addRecord();
            node.type = null;
            return;
        }
        if (dimension == 0 && node.typeNode instanceof PrimitiveTypeNode && ((PrimitiveTypeNode) node.typeNode).name.equals("void")) {
            errorRecorder.addRecord();
        }
        for (int i = 0; i < dimension; i++) {
            node.type = new ArrayType(node.type);
        }
    }
    @Override public void visit(MemberExpression node) {
        node.object.accept(this);
        if(node.object.type instanceof PrimitiveType) {
            errorRecorder.addRecord();
            node.type = null;
            return;
        }
        if(node.object.type instanceof ArrayType) {
            ArrayType arrayType = (ArrayType)node.object.type;
            if(node.methodCall == null || !node.methodCall.functionName.equals("size")) {
                errorRecorder.addRecord();
                node.type = null;
            } else {
                node.type = new PrimitiveType("int", globalSymbolTable.getPrimitiveSymbol("int"));
            }
        } else {
            ClassType classType = (ClassType) node.object.type;
            if(classType == null) {
                return;
            }
            if (node.fieldAccess != null) {
                node.fieldAccess.symbol = resolveVariableSymbol(node.fieldAccess.name, classType.symbol.classSymbolTable);
                if (node.fieldAccess.symbol == null) {
                    errorRecorder.addRecord();
                    node.type = null;
                    return;
                }
                node.fieldAccess.type = node.fieldAccess.symbol.type;
                node.type = node.fieldAccess.type;
            } else {
                try {
                    node.methodCall.functionSymbol = resolveFunctionSymbol(node.methodCall.functionName, classType.symbol.classSymbolTable);
                } catch (Exception e) {
                    e.getStackTrace();
                }
                if (node.methodCall.functionSymbol == null) {
                    errorRecorder.addRecord();
                    node.type = null;
                    return;
                }
                node.methodCall.type = node.methodCall.functionSymbol.returnType;
                node.type = node.methodCall.type;
                for (Expression e : node.methodCall.arguments)
                    e.accept(this);
            }
        }
    }
    @Override public void visit(UnaryExpression node) {
        node.expression.accept(this);
        node.type = node.expression.type;
    }
    private boolean isRelationOperator(String op) {
        switch(op) {
            case "==": case "!=": case "<": case "<=": case ">": case ">=":
                return true;
            default:
                return false;
        }
    }
    @Override public void visit(BinaryExpression node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        if(isRelationOperator(node.op)) {
            node.type = new PrimitiveType("bool", globalSymbolTable.getPrimitiveSymbol("bool"));
        } else {
            node.type = node.lhs.type;
        }
    }
    @Override public void visit(AssignExpression node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        node.type = new PrimitiveType("void", globalSymbolTable.getPrimitiveSymbol("void"));
    }
    @Override public void visit(EmptyStatement node) {}
}
