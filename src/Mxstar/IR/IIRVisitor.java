package Mxstar.IR;
import Mxstar.IR.Instruction.*;
import Mxstar.IR.Operand.*;
public interface IIRVisitor {
    void visit(BasicBlock basicBlock);
    void visit(BinaryInst inst);
    void visit(Call inst);
    void visit(Cdq inst);
    void visit(CJump inst);
    void visit(Constant operand);
    void visit(Function function);
    void visit(FunctionAddress operand);
    void visit(Immediate operand);
    void visit(IRProgram program);
    void visit(Jump inst);
    void visit(Lea inst);
    void visit(Leave inst);
    void visit(Memory operand);
    void visit(Move inst);
    void visit(PhysicalRegister operand);
    void visit(Pop inst);
    void visit(Push inst);
    void visit(Return inst);
    void visit(StackSlot operand);
    void visit(StaticData operand);
    void visit(UnaryInst inst);
    void visit(VirtualRegister operand);
}
