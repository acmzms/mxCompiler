package Mxstar.AST;
import java.util.*;
import Mxstar.Symbol.*;
public class FuncCallExpression extends Expression {
    public String functionName;
    public List<Expression> arguments;
    public FunctionSymbol functionSymbol;
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
