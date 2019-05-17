package Mxstar.Worker.FrontEnd;
import Mxstar.AST.*;
import Mxstar.Symbol.*;
import Mxstar.Worker.ErrorRecorder;
public class SemanticChecker implements IAstVisitor {
    GlobalSymbolTable globalSymbolTable;
    ErrorRecorder errorRecorder;
    FunctionSymbol currentFunction;
    int loopCount;
    public SemanticChecker(GlobalSymbolTable globalSymbolTable, ErrorRecorder errorRecorder) {
        this.globalSymbolTable = globalSymbolTable;
        this.errorRecorder = errorRecorder;
        this.loopCount = 0;
    }
    @Override public void visit(CompilationUnit node) {
        for(VariableDeclaration d : node.globalVariables) {
            d.accept(this);
        }
        for(FuncDeclaration d: node.functions) {
            d.accept(this);
        }
        for(ClassDeclaration d : node.classes) {
            d.accept(this);
        }
        FunctionSymbol mainFuntion = globalSymbolTable.getFunctionSymbol("main");
        if(mainFuntion == null) {
            errorRecorder.addRecord();
        } else {
            if(mainFuntion.returnType instanceof PrimitiveType && ((PrimitiveType) mainFuntion.returnType).name.equals("int")) {
                if(mainFuntion.parameterTypes.size() > 0) {
                    errorRecorder.addRecord();
                }
            } else {
                errorRecorder.addRecord();
            }
        }
    }
    @Override public void visit(Declaration node) {
        assert false;
    }
    @Override public void visit(FuncDeclaration node) {
        currentFunction = node.symbol;
        for(Statement s : node.body) {
            s.accept(this);
        }
    }
    @Override public void visit(ClassDeclaration node) {
        for(FuncDeclaration d : node.methods) {
            d.accept(this);
        }
        if(node.constructor != null) {
            node.constructor.accept(this);
            if (!node.constructor.name.equals(node.name)) {
                errorRecorder.addRecord();
            }
        }
    }
    @Override public void visit(VariableDeclaration node) {
        if(node.init != null) {
            if(!node.symbol.type.match(node.init.type)) {
                errorRecorder.addRecord();
            }
        }
    }
    @Override public void visit(TypeNode node) {}
    @Override public void visit(ArrayTypeNode node) {}
    @Override public void visit(PrimitiveTypeNode node) {}
    @Override public void visit(ClassTypeNode node) {}
    @Override public void visit(Statement node) {
        assert false;
    }
    private void checkBooleanExpression(Expression e) {
        if(e.type instanceof PrimitiveType && ((PrimitiveType) e.type).name.equals("bool")) {
            return;
        } else {
            errorRecorder.addRecord();
        }
    }
    @Override public void visit(ForStatement node) {
        if(node.initStatement != null) {
            node.initStatement.accept(this);
        }
        if(node.condition != null) {
            node.condition.accept(this);
            checkBooleanExpression(node.condition);
        }
        if(node.updateStatement != null) {
            node.updateStatement.accept(this);
        }
        loopCount++;
        node.body.accept(this);
        loopCount--;
    }
    @Override public void visit(WhileStatement node) {
        node.condition.accept(this);
        checkBooleanExpression(node.condition);
        loopCount++;
        node.body.accept(this);
        loopCount--;
    }
    @Override public void visit(IfStatement node) {
        node.condition.accept(this);
        checkBooleanExpression(node.condition);
        node.thenStatement.accept(this);
        if(node.elseStatement != null) {
            node.elseStatement.accept(this);
        }
    }
    @Override public void visit(ContinueStatement node) {
        if(loopCount == 0) {
            errorRecorder.addRecord();
        }
    }
    @Override public void visit(BreakStatement node) {
        if(loopCount == 0) {
            errorRecorder.addRecord();
        }
    }
    @Override public void visit(ReturnStatement node) {
        VariableType requiredType = currentFunction.returnType;
        PrimitiveType voidType = new PrimitiveType("void", globalSymbolTable.getPrimitiveSymbol("void"));
        if(requiredType.match(voidType) && node.retExpression != null) {
            errorRecorder.addRecord();
        }
        VariableType returnedType;
        if(node.retExpression == null) {
            returnedType = voidType;
        } else {
            returnedType = node.retExpression.type;
        }
        if(!requiredType.match(returnedType)) {
            errorRecorder.addRecord();
        }
    }
    @Override public void visit(BlockStatement node) {
        for(Statement s : node.statements) {
            s.accept(this);
        }
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
        if(node.name.equals("this"))
            node.modifiable = false;
        else
            node.modifiable = true;
    }
    @Override public void visit(LiteralExpression node) {
        node.modifiable = false;
    }
    @Override public void visit(ArrayExpression node) {
        node.address.accept(this);
        node.index.accept(this);
        node.modifiable = true;
    }
    @Override public void visit(FuncCallExpression node) {
        int parameterCount = node.functionSymbol.parameterTypes.size();
        int inClass = (node.functionSymbol.parameterNames.size() > 0 && node.functionSymbol.parameterNames.get(0).equals("this") ? 1 : 0);
        if(node.arguments.size() + inClass != parameterCount) {
            errorRecorder.addRecord();
        } else {
            for (int i = 0; i < node.arguments.size(); i++) {
                node.arguments.get(i).accept(this);
                if(!node.arguments.get(i).type.match(node.functionSymbol.parameterTypes.get(i + inClass))) {
                    errorRecorder.addRecord();
                }
            }
        }
        node.modifiable = false;
    }
    @Override public void visit(NewExpression node) {
        for(Expression e : node.exprDimensions) {
            e.accept(this);
        }
        node.modifiable = true;
    }
    @Override public void visit(MemberExpression node) {
        node.object.accept(this);
        if(node.object.type instanceof ArrayType) {
            node.modifiable = false;
        } else {
            if (node.methodCall != null) {
                node.methodCall.accept(this);
                node.modifiable = node.methodCall.modifiable;
            } else {
                node.modifiable = true;
            }
        }
    }
    private boolean isStringType(VariableType type) {
        return type instanceof ClassType && ((ClassType) type).name.equals("string");
    }
    private boolean isIntType(VariableType type) {
        return type instanceof PrimitiveType && ((PrimitiveType) type).name.equals("int");
    }
    private boolean isBoolType(VariableType type) {
        return type instanceof PrimitiveType && ((PrimitiveType) type).name.equals("bool");
    }
    @Override public void visit(UnaryExpression node) {
        node.expression.accept(this);
        boolean modifiableError = false;
        boolean typeError = false;
        boolean isInt = isIntType(node.expression.type);
        boolean isBool = isBoolType(node.expression.type);
        switch(node.op) {
            case "v++": case "v--":
                if(!node.expression.modifiable)
                    modifiableError = true;
                if(!isInt)
                    typeError = true;
                node.modifiable = false;
                break;
            case "++v": case "--v":
                if(!node.expression.modifiable)
                    modifiableError = true;
                if(!isInt)
                    typeError = true;
                node.modifiable = true;
                break;
            case "!":
                if(!isBool)
                    typeError = true;
                node.modifiable = false;
                break;
            case "~":
                if(!isInt)
                    typeError = true;
                node.modifiable = false;
                break;
            case "-":
                if(!isInt)
                    typeError = true;
                node.modifiable = false;
                break;
            default:
                assert false;
        }
        if(typeError) {
            errorRecorder.addRecord();
        } else if(modifiableError) {
            errorRecorder.addRecord();
        }
    }
    @Override public void visit(BinaryExpression node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        if(!node.lhs.type.match(node.rhs.type)) {
            errorRecorder.addRecord();
        } else {
            boolean isInt = isIntType(node.lhs.type);
            boolean isBool = isBoolType(node.lhs.type);
            boolean isString = isStringType(node.lhs.type);
            boolean typeError = false;
            switch(node.op) {
                case "*": case "/": case "%": case "-": case "<<": case ">>": case "&": case "|": case "^":
                    if(!isInt)
                        typeError = true;
                    break;
                case "<=": case ">": case "<": case ">=": case "+":
                    if(!isInt && !isString)
                        typeError = true;
                    break;
                case "&&": case "||":
                    if(!isBool)
                        typeError = true;
                    break;
                case "==": case "!=":
                    break;
                default:
                    assert false;
            }
            if(typeError) {
                errorRecorder.addRecord();
            }
        }
        node.modifiable = false;
    }
    @Override public void visit(AssignExpression node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        if(!node.lhs.type.match(node.rhs.type)) {
            errorRecorder.addRecord();
        }
        if(!node.lhs.modifiable) {
            errorRecorder.addRecord();
        }
        node.modifiable = false;
    }
    @Override public void visit(EmptyStatement node) {}
}
