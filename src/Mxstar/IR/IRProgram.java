package Mxstar.IR;
import java.util.LinkedList;
import Mxstar.IR.Operand.StaticData;
public class IRProgram {
    public LinkedList<Function> functions;
    public LinkedList<StaticData> staticData;
    public IRProgram() {
        functions = new LinkedList<>();
        staticData = new LinkedList<>();
    }
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
