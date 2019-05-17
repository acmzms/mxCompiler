package Mxstar.AST;
public class Declaration extends Node {
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
