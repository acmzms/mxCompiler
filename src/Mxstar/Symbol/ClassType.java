package Mxstar.Symbol;
import java.util.*;
public class ClassType extends VariableType {
	public static int REGISTER_WIDTH = 8;	
	
    public String name;
    public ClassSymbol symbol;
    public ClassType() {}
    public ClassType(String name, ClassSymbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override public boolean match(VariableType other) {
        if(other instanceof ClassType) {
            String otherName = ((ClassType) other).name;
            if((otherName.equals("null") && name.equals("string")) || (otherName.equals("string") && name.equals("null"))) {
                return false;
            } else {
                return otherName.equals("null") || name.equals("null") || ((ClassType) other).name.equals(name);
            }
        } else {
            return false;
        }
    }
    @Override public int getBytes() {
        Collection<VariableSymbol> fields = symbol.classSymbolTable.variables.values();
        int countBytes = fields.size() * REGISTER_WIDTH;
        return countBytes;
    }
}
