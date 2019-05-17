package Mxstar.Symbol;
import java.util.*;
import org.antlr.v4.misc.OrderedHashMap;
public class SymbolTable {
	public static int REGISTER_WIDTH = 8;
    public Map<String,VariableSymbol> variables;
    public Map<String,FunctionSymbol> functions;
    public SymbolTable parent;
    public List<SymbolTable> children;
    public Map<String, Integer> offsets;
    private Integer currentOffset;
    public SymbolTable(SymbolTable parent) {
        this.variables = new LinkedHashMap<>();
        this.functions = new LinkedHashMap<>();
        this.parent = parent;
        this.children = new LinkedList<>();
        this.offsets = new OrderedHashMap<>();
        this.currentOffset = 0;
    }
    public VariableSymbol getVariableSymbol(String name) {
        return variables.get(name);
    }
    public void putVariableSymbol(String name, VariableSymbol variableSymbol) {
        offsets.put(name, currentOffset);
        variables.put(name, variableSymbol);
        currentOffset += REGISTER_WIDTH;
    }
    public int getVariableOffset(String name) {
        return offsets.get(name);
    }
    public FunctionSymbol getFunctionSymbol(String name) {
        return functions.get(name);
    }
    public void putFunctionSymbol(String name, FunctionSymbol symbol) {
        functions.put(name, symbol);
    }
}
