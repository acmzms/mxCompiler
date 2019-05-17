package Mxstar.AST;
import Mxstar.Symbol.*;
import org.antlr.v4.runtime.*;
public class Identifier extends Expression {
    public String name;
    public VariableSymbol symbol;
    public Identifier(Token token) {
        if(token != null) {
            this.name = token.getText();
        }
    }
    @Override public void accept(IAstVisitor visitor) {
        visitor.visit(this);
    }
}
