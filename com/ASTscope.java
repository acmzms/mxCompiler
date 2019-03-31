package com;

class ASTscope
{
    public ASTscope() {}
    public void visitProgramnode(programnode p)
    {
        for(int i = 0;i < p.retclass().size();i++)
        {
            p.accfield().addchildren(p.retclass().get(i).accfield());
            visitClassnode(p.retclass().get(i));
        }
        for(int i = 0;i < p.retfunc().size();i++)
        {
            p.accfield().addchildren(p.retfunc().get(i).accfield());
            visitFuncnode(p.retfunc().get(i));
        }
    }

    public void visitClassnode(classnode c)
    {
        for(int i = 0;i < c.retfunc().size();i++)
        {
            c.accfield().addchildren(c.retfunc().get(i).accfield());
            visitFuncnode(c.retfunc().get(i));
        }
    }

    public void visitFuncnode(funcnode f)
    {
        blocknode b = f.getblock();
        visitBlocknode(b);
    }

    public void visitBlocknode(blocknode b)
    {
        for(int i = 0;i < b.retblock().size();i++)
        {
            b.accfield().addchildren(b.retblock().get(i).accfield());
            visitBlocknode(b);
        }
    }
}