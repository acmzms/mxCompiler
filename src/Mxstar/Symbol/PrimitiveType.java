package Mxstar.Symbol;
public class PrimitiveType extends VariableType{
	public static int REGISTER_WIDTH = 8;

    public String name;
    public PrimitiveSymbol symbol;
    public PrimitiveType() {}
    public PrimitiveType(String name, PrimitiveSymbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override public boolean match(VariableType other) {
        if(other instanceof PrimitiveType && ((PrimitiveType) other).name.equals(name)) {
            return true;
        } else {
            return false;
        }
    }
    @Override public int getBytes() {
        return REGISTER_WIDTH;
    }
}
