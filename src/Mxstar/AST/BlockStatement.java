package Mxstar.AST;
import java.util.*;
public class BlockStatement extends Statement {
    public List<Statement> statements;
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
