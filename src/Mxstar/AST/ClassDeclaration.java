package Mxstar.AST;
import Mxstar.Symbol.ClassSymbol;
import java.util.*;
public class ClassDeclaration extends Declaration {
    public String name = null;
    public List<VariableDeclaration> fields;
    public List<FuncDeclaration> methods;
    public FuncDeclaration constructor;
    public ClassSymbol symbol;
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
