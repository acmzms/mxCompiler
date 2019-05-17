package Mxstar.IR.Instruction;
import java.util.*;
import Mxstar.IR.BasicBlock;
import Mxstar.IR.IIRVisitor;
import Mxstar.IR.Operand.*;
import Mxstar.IR.RegisterSet;
import Mxstar.Worker.BackEnd.IRBuilder;
public class Return extends IRInstruction {
    public Return(BasicBlock bb) {
        super(bb);
    }
    @Override public void renameUseReg(HashMap<Register, Register> renameMap) {
    }
    @Override public void renameDefReg(HashMap<Register, Register> renameMap) {
    }
    @Override public LinkedList<Register> getDefRegs() {
        return new LinkedList<>();
    }
    @Override public LinkedList<Register> getUseRegs() {
        LinkedList<Register> regs = new LinkedList<>();
        if (bb.function.hasReturnValue) {
            regs.add(RegisterSet.vrax);
        }
        return regs;
    }
    @Override public LinkedList<StackSlot> getStackSlots() {
        return new LinkedList<>();
    }
    @Override public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
