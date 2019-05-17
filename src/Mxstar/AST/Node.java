package Mxstar.AST;
public abstract class Node {
    public abstract void accept(IAstVisitor visitor);
}
