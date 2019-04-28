package com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
class ASTscope
{
    public ASTscope() {}
    public void visitProgramnode(programnode p)
    {
        p.funcnames = new ArrayList<>();
        p.classnames = new HashMap<>();
        funcnode f1 = new funcnode("print", null);
        f1.settype(new type("void"));
        f1.getparams().add(new declaration(new type("string"), new idnode("str")));
        funcnode f2 = new funcnode("println", null);
        f2.settype(new type("void"));
        f2.getparams().add(new declaration(new type("string"), new idnode("str")));
        funcnode f3 = new funcnode("getString", null);
        f3.settype(new type("string"));
        funcnode f4 = new funcnode("getInt", null);
        f4.settype(new type("int"));
        funcnode f5 = new funcnode("toString", null);
        f5.settype(new type("string"));
        f5.getparams().add(new declaration(new type("int"), new idnode("i")));
        f1.seti(true);
        f2.seti(true);
        f3.seti(true);
        f4.seti(true);
        f5.seti(true);
        p.retfunc().add(f1);
        p.retfunc().add(f2);
        p.retfunc().add(f3);
        p.retfunc().add(f4);
        p.retfunc().add(f5);
        funcnode f6 = new funcnode("length", null);
        f6.settype(new type("int"));
        funcnode f7 = new funcnode("substring", null);
        f7.settype(new type("string"));
        f7.getparams().add(new declaration(new type("int"), new idnode("left")));
        f7.getparams().add(new declaration(new type("int"), new idnode("right")));
        funcnode f8 = new funcnode("parseInt", null);
        f8.settype(new type("int"));
        funcnode f9 = new funcnode("ord", null);
        f9.settype(new type("int"));
        f9.getparams().add(new declaration(new type("int"), new idnode("pos")));
        f6.seti(true);
        f7.seti(true);
        f8.seti(true);
        f9.seti(true);
        classnode c = new classnode("string");
        c.addfunc(f6);
        c.addfunc(f7);
        c.addfunc(f8);
        c.addfunc(f9);
        p.retclass().add(c);
        p.funcnames.add("print");
        p.funcnames.add("println");
        p.funcnames.add("getString");
        p.funcnames.add("getInt");
        p.funcnames.add("toString");
        ArrayList<String> str = new ArrayList<>();
        str.add("length");
        str.add("substring");
        str.add("parseInt");
        str.add("ord");
        p.classnames.put("string", str);
        for(int i = 0;i < p.retclass().size();i++)
        {
            p.accfield().addchildren(p.retclass().get(i).accfield());
            visitClassnode(p.retclass().get(i), p);
        }
        for(int i = 0;i < p.retfunc().size();i++)
        {
            p.accfield().addchildren(p.retfunc().get(i).accfield());
            visitFuncnode(p.retfunc().get(i), p);
        }
    }

    public void visitClassnode(classnode c, programnode p)
    {
        //p.classnames.put(c.getclassname().getid(), new ArrayList<>());
        ArrayList<String> a = new ArrayList<>();
        for(int i = 0;i < c.retfunc().size();i++)
        {
            c.accfield().addchildren(c.retfunc().get(i).accfield());
            a.add(c.retfunc().get(i).getname());
            visitFuncnode(c.retfunc().get(i), p);
        }
        p.classnames.put(c.getclassname().getid(), a);
    }

    public void visitFuncnode(funcnode f, programnode p)
    {
        blocknode b = f.getblock();
        p.funcnames.add(f.getname());
        visitBlocknode(b, p);
    }

    public void visitBlocknode(blocknode b, programnode p)
    {
        for(int i = 0;i < b.retblock().size();i++)
        {
            b.accfield().addchildren(b.retblock().get(i).accfield());
        }
    }
}