package Mxstar.AST;
import java.util.*;
import Mxstar.Symbol.*;
public class FuncDeclaration extends Declaration {
    public TypeNode retTypeNode = null;
    public String name = null;
    public List<VariableDeclaration> parameters;
    public List<Statement> body;
    public FunctionSymbol symbol;
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
