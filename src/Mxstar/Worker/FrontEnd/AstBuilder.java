package Mxstar.Worker.FrontEnd;
import java.util.*;
import Mxstar.AST.*;
import Mxstar.Parser.*;
import Mxstar.Worker.ErrorRecorder;
import static Mxstar.Parser.MxstarParser.*;
public class AstBuilder extends MxstarBaseVisitor<Object> {
    public CompilationUnit compilationUnit;
    public ErrorRecorder errorRecorder;
    public AstBuilder(ErrorRecorder errorRecorder) {
        this.compilationUnit = new CompilationUnit();
        this.errorRecorder = errorRecorder;
    }
    public CompilationUnit getCompilationUnit() {
        return compilationUnit;
    }
    @Override public Object visitCompilationUnit(CompilationUnitContext ctx) {
        for(TranslationUnitContext c : ctx.translationUnit()) {
            if(c.classDeclaration() != null) {
                compilationUnit.add(visitClassDeclaration(c.classDeclaration()));
            } else if(c.functionDeclaration() != null) {
                compilationUnit.add(visitFunctionDeclaration(c.functionDeclaration()));
            } else {
                compilationUnit.addAll(visitVariableDeclaration(c.variableDeclaration()));
            }
        }
        return null;
    }
    @Override public ClassDeclaration visitClassDeclaration(ClassDeclarationContext ctx) {
        ClassDeclaration classDeclaration = new ClassDeclaration();
        classDeclaration.name = ctx.Identifier().getSymbol().getText();
        classDeclaration.methods = new LinkedList<>();
        classDeclaration.fields = new LinkedList<>();
        for(ConstructorDeclarationContext c : ctx.constructorDeclaration()) {
            if(classDeclaration.constructor == null) {
                classDeclaration.constructor = visitConstructorDeclaration(ctx.constructorDeclaration(0));
            } else {
                errorRecorder.addRecord();
            }
        }
        for(VariableDeclarationContext c : ctx.variableDeclaration()) {
            classDeclaration.fields.addAll(visitVariableDeclaration(c));
        }
        for(FunctionDeclarationContext c : ctx.functionDeclaration()) {
            FuncDeclaration d = visitFunctionDeclaration(c);
            if(d.name.equals(classDeclaration.name)) {
                errorRecorder.addRecord();
                continue;
            }
            classDeclaration.methods.add(d);
        }
        return classDeclaration;
    }
    @Override public FuncDeclaration visitFunctionDeclaration(FunctionDeclarationContext ctx) {
        FuncDeclaration funcDeclaration = new FuncDeclaration();
        funcDeclaration.retTypeNode = visitType(ctx.type());
        funcDeclaration.name = ctx.Identifier().getSymbol().getText();
        funcDeclaration.parameters = visitParameterList(ctx.parameterList());
        funcDeclaration.body = visitStatementList(ctx.statementList());
        return funcDeclaration;
    }
    @Override public List<VariableDeclaration> visitVariableDeclaration(VariableDeclarationContext ctx) {
        TypeNode typeNode = visitType(ctx.type());
        List<VariableDeclaration> declarations = visitVariableDeclarators(ctx.variableDeclarators());
        for(VariableDeclaration c : declarations) {
            c.typeNode = typeNode;
        }
        return declarations;
    }
    @Override public FuncDeclaration visitConstructorDeclaration(ConstructorDeclarationContext ctx) {
        FuncDeclaration constructor = new FuncDeclaration();
        constructor.retTypeNode = new PrimitiveTypeNode("void");
        constructor.name = ctx.Identifier().getSymbol().getText();
        constructor.parameters = visitParameterList(ctx.parameterList());
        constructor.body = visitStatementList(ctx.statementList());
        return constructor;
    }
    @Override public TypeNode visitType(TypeContext ctx) {
        if(ctx.empty().isEmpty()) {
            TypeNode ret = visitAtomType(ctx.atomType());
            return ret;
        } else {
            ArrayTypeNode arrayTypeNode = new ArrayTypeNode();
            arrayTypeNode.baseType = visitAtomType(ctx.atomType());
            arrayTypeNode.dimension = ctx.empty().size();
            return arrayTypeNode;
        }
    }
    @Override public List<VariableDeclaration> visitParameterList(ParameterListContext ctx) {
        List<VariableDeclaration> parameters = new LinkedList<>();
        if (ctx != null) {
            for (ParameterContext c : ctx.parameter()) {
                parameters.add((VariableDeclaration) c.accept(this));
            }
        }
        return parameters;
    }
    @Override public List<Statement> visitStatementList(StatementListContext ctx) {
        List<Statement> statements = new LinkedList<>();
        if(ctx.statement() != null) {
            for (StatementContext c : ctx.statement()) {
                if(c instanceof VariableDeclarationStatementContext) {
                    statements.addAll(visitVariableDeclarationStatement((VariableDeclarationStatementContext) c));
                } else {
                    statements.add((Statement) c.accept(this));
                }
            }
        }
        return statements;
    }
    @Override public List<VariableDeclaration> visitVariableDeclarators(VariableDeclaratorsContext ctx) {
        List<VariableDeclaration> declarations = new LinkedList<>();
        for(VariableDeclaratorContext c : ctx.variableDeclarator()) {
            declarations.add(visitVariableDeclarator(c));
        }
        return declarations;
    }
    @Override public TypeNode visitAtomType(AtomTypeContext ctx) {
        if(ctx.primitiveType() != null) {
            return visitPrimitiveType(ctx.primitiveType());
        } else {
            return visitClassType(ctx.classType());
        }
    }
    @Override public VariableDeclaration visitParameter(ParameterContext ctx) {
        VariableDeclaration variableDeclaration = new VariableDeclaration();
        variableDeclaration.typeNode = (TypeNode)ctx.type().accept(this);
        variableDeclaration.name = ctx.Identifier().getSymbol().getText();
        variableDeclaration.init = null;
        return variableDeclaration;
    }
    @Override public List<Statement> visitVariableDeclarationStatement(VariableDeclarationStatementContext ctx) {
        List<VariableDeclaration> declarations = visitVariableDeclaration(ctx.variableDeclaration());
        List<Statement> statements = new LinkedList<>();
        for(VariableDeclaration declaration : declarations) {
            VariableDeclarationStatement statement = new VariableDeclarationStatement();
            statement.declaration = declaration;
            statements.add(statement);
        }
        return statements;
    }
    @Override public Statement visitExpressionStatement(ExpressionStatementContext ctx) {
        ExpressionStatement expressionStatement = new ExpressionStatement();
        expressionStatement.expression = (Expression)ctx.expression().accept(this);
        return expressionStatement;
    }
    @Override public Statement visitIfStatement(IfStatementContext ctx) {
        IfStatement ifStatement = new IfStatement();
        ifStatement.condition = (Expression)ctx.expression().accept(this);
        ifStatement.thenStatement = (Statement)ctx.statement(0).accept(this);
        if(ctx.statement(1) != null) {
            ifStatement.elseStatement = (Statement) ctx.statement(1).accept(this);
        }
        return ifStatement;
    }
    @Override public Statement visitWhileStatement(WhileStatementContext ctx) {
        WhileStatement whileStatement = new WhileStatement();
        whileStatement.condition = (Expression)ctx.expression().accept(this);
        whileStatement.body = (Statement)ctx.statement().accept(this);
        return whileStatement;
    }
    @Override public Statement visitForStatement(ForStatementContext ctx) {
        ForStatement forStatement = new ForStatement();
        if(ctx.forInit != null) {
            forStatement.initStatement = new ExpressionStatement((Expression) ctx.forInit.accept(this));
        }
        if(ctx.forCondition != null) {
            forStatement.condition = (Expression) ctx.forCondition.accept(this);
        }
        if(ctx.forUpdate != null) {
            forStatement.updateStatement = new ExpressionStatement((Expression) ctx.forUpdate.accept(this));
        }
        forStatement.body = (Statement)ctx.statement().accept(this);
        return forStatement;
    }
    @Override public ReturnStatement visitReturnStatement(ReturnStatementContext ctx) {
        ReturnStatement returnStatement = new ReturnStatement();
        if(ctx.expression() != null) {
            returnStatement.retExpression = (Expression) ctx.expression().accept(this);
        }
        return returnStatement;
    }
    @Override public BreakStatement visitBreakStatement(BreakStatementContext ctx) {
        BreakStatement breakStatement = new BreakStatement();
        return breakStatement;
    }
    @Override public ContinueStatement visitContinueStatement(ContinueStatementContext ctx) {
        ContinueStatement continueStatement = new ContinueStatement();
        return continueStatement;
    }
    @Override public Statement visitBlockStatement(BlockStatementContext ctx) {
        BlockStatement blockStatement = new BlockStatement();
        blockStatement.statements = visitStatementList(ctx.statementList());
        return blockStatement;
    }
    @Override public EmptyStatement visitEmptyStatement(EmptyStatementContext ctx) {
        EmptyStatement emptyStatement = new EmptyStatement();
        return emptyStatement;
    }
    @Override public VariableDeclaration visitVariableDeclarator(VariableDeclaratorContext ctx) {
        VariableDeclaration declaration = new VariableDeclaration();
        declaration.typeNode = null;
        declaration.name = ctx.Identifier().getSymbol().getText();
        if(ctx.expression() == null) {
            declaration.init = null;
        } else {
            declaration.init = (Expression) ctx.expression().accept(this);
        }
        return declaration;
    }
    @Override public PrimitiveTypeNode visitPrimitiveType(PrimitiveTypeContext ctx) {
        PrimitiveTypeNode primitiveTypeNode = new PrimitiveTypeNode();
        primitiveTypeNode.name = ctx.token.getText();
        return primitiveTypeNode;
    }
    @Override public ClassTypeNode visitClassType(ClassTypeContext ctx) {
        ClassTypeNode classTypeNode = new ClassTypeNode();
        classTypeNode.className = ctx.token.getText();
        return classTypeNode;
    }
    @Override public Expression visitPrimaryExpression(PrimaryExpressionContext ctx) {
        if(ctx.token == null) {
            return (Expression) ctx.expression().accept(this);
        } else if(ctx.token.getType() == Identifier || ctx.token.getType() == This) {
            return new Identifier(ctx.token);
        } else {
            return new LiteralExpression(ctx.token);
        }
    }
    @Override public Expression visitMemberExpression(MemberExpressionContext ctx) {
        MemberExpression expression = new MemberExpression();
        expression.object = (Expression)ctx.expression().accept(this);
        if(ctx.Identifier() != null) {
            expression.fieldAccess = new Identifier(ctx.Identifier().getSymbol());
        } else {
            expression.methodCall = visitFunctionCall(ctx.functionCall());
        }
        return expression;
    }
    @Override public Expression visitArrayExpression(ArrayExpressionContext ctx) {
        ArrayExpression expression = new ArrayExpression();
        expression.address = (Expression)ctx.expression(0).accept(this);
        if(expression.address instanceof NewExpression && ctx.expression(0).stop.getText().equals("]")) {
            errorRecorder.addRecord();
        }
        expression.index = (Expression)ctx.expression(1).accept(this);
        return expression;
    }
    @Override public FuncCallExpression visitFuncCallExpression(FuncCallExpressionContext ctx) {
        return visitFunctionCall(ctx.functionCall());
    }
    @Override public Expression visitNewExpression(NewExpressionContext ctx) {
        return visitCreator(ctx.creator());
    }
    @Override public Expression visitUnaryExpression(UnaryExpressionContext ctx) {
        UnaryExpression expression = new UnaryExpression();
        if(ctx.postfix != null) {
            if(ctx.postfix.getText().equals("++")) {
                expression.op = "v++";
            } else {
                expression.op = "v--";
            }
        } else {
            switch(ctx.prefix.getText()) {
                case "++":
                    expression.op = "++v";
                    break;
                case "--":
                    expression.op = "--v";
                    break;
                default:
                    expression.op = ctx.prefix.getText();
            }
        }
        expression.expression = (Expression)ctx.expression().accept(this);
        return expression;
    }
    @Override public Expression visitBinaryExpression(BinaryExpressionContext ctx) {
        BinaryExpression expression = new BinaryExpression();
        expression.op = ctx.bop.getText();
        expression.lhs = (Expression)ctx.expression(0).accept(this);
        expression.rhs = (Expression)ctx.expression(1).accept(this);
        return expression;
    }
    @Override public Expression visitAssignExpression(AssignExpressionContext ctx) {
        AssignExpression expression = new AssignExpression();
        expression.lhs = (Expression)ctx.expression(0).accept(this);
        expression.rhs = (Expression)ctx.expression(1).accept(this);
        return expression;
    }
    @Override public Expression visitCreator(CreatorContext ctx) {
        NewExpression newExpression = new NewExpression();
        newExpression.typeNode = visitAtomType(ctx.atomType());
        newExpression.exprDimensions = new LinkedList<>();
        if(ctx.expression() != null) {
            for(ExpressionContext c : ctx.expression()) {
                newExpression.exprDimensions.add((Expression)c.accept(this));
            }
        }
        if(ctx.empty() != null) {
            newExpression.restDemension = ctx.empty().size();
        } else {
            newExpression.restDemension = 0;
        }
        return newExpression;
    }
    @Override public FuncCallExpression visitFunctionCall(FunctionCallContext ctx) {
        FuncCallExpression expression = new FuncCallExpression();
        expression.functionName = ctx.Identifier().getSymbol().getText();
        expression.arguments = new LinkedList<>();
        if( ctx.expression() != null) {
            for (ExpressionContext c : ctx.expression())
                expression.arguments.add((Expression) c.accept(this));
        }
        return expression;
    }
}

