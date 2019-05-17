package Mxstar.AST;
public class VariableDeclarationStatement extends Statement {
    public VariableDeclaration declaration;
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
