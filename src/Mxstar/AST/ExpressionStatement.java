package Mxstar.AST;
public class ExpressionStatement extends Statement {
    public Expression expression = null;
    public ExpressionStatement() {}
    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
