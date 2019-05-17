package Mxstar.Symbol;
import Mxstar.IR.Operand.Memory;
import Mxstar.IR.Operand.VirtualRegister;
public class VariableSymbol {
    public String name;
    public VariableType type;
    public boolean isClassField;
    public boolean isGlobalVariable;
    public VirtualRegister virtualRegister;
    public VariableSymbol(String name, VariableType type, boolean isClassField, boolean isGlobalVariable) {
        this.name = name;
        this.type = type;
        this.isClassField = isClassField;
        this.isGlobalVariable = isGlobalVariable;
    }
}
