package com;

import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class ASTsemantic {
    private int looplevel;
    private Stack<scope> currentscope;
    private classnode currentclass;
    private programnode root;
    public ASTsemantic() {
        looplevel = 0;
        currentscope = new Stack<>();
    }
    public boolean exist(String s)
    {
        if (s.equals("int") || s.equals("bool") || s.equals("string") || s.equals("void"))
        {
            return true;
        }
        if (root.classnames.containsKey(s))
        {
            return true;
        }
        return false;
    }

    public ArrayList<declaration> readdecl(node n, String name)
    {
        if (n instanceof programnode)
        {
            for (int i = 0; i < ((programnode) n).retfunc().size(); i++)
            {
                if (((programnode) n).retfunc().get(i).getname().equals(name))
                {
                    return ((programnode) n).retfunc().get(i).getparams();
                }
            }
        }
        if (n instanceof classnode)
        {
            for (int i = 0; i < ((classnode) n).retfunc().size(); i++)
            {
                if (((classnode) n).retfunc().get(i).getname().equals(name))
                {
                    return ((classnode) n).retfunc().get(i).getparams();
                }
            }
        }
        return null;
    }

    public type readtype(node n, String name)
    {
        if (n instanceof programnode)
        {
            for (int i = 0; i < ((programnode) n).retfunc().size(); i++)
            {
                if (((programnode) n).retfunc().get(i).getname().equals(name))
                {
                    return ((programnode) n).retfunc().get(i).gettype();
                }
            }
        }
        if (n instanceof classnode)
        {
            for (int i = 0; i < ((classnode) n).retfunc().size(); i++)
            {
                if (((classnode) n).retfunc().get(i).getname().equals(name))
                {
                    return ((classnode) n).retfunc().get(i).gettype();
                }
            }
        }
        return new type();
    }

    public type examinetype(type t, type tmp) throws Exception
    {
        if(t.isequal(new type(""))) {t = new type(tmp);}
        else if(tmp.isequal(new type(""))) {return t;}
        else
        {
            if(t.isequal(new type("null")))
            {
                if(tmp.isequal(new type("int")) || tmp.isequal(new type("void"))) {throw new Exception(("error 3 : wrong return type"));}
                else {t = new type(tmp);}
            }
            else if(t.isequal(new type("int")))
            {
                if(!(tmp.isequal(new type("int")) || tmp.isequal(new type("")))) {throw new Exception(("error 3 : wrong return type"));}
            }
            else if(t.isequal(new type("string")))
            {
                if(!(tmp.isequal(new type("string")))) {throw new Exception(("error 3 : wrong return type"));}
            }
            else if(!tmp.isequal(new type("null")))
            {
                if(!t.isequal(tmp)) {throw new Exception(("error 3 : wrong return type"));}
            }
        }
        return t;
    }

    //........................................................start.....................................................

    public void acceptProgramnode(programnode n) throws Exception
    {
        currentscope.push(n.accfield());
        currentclass = null;
        root = n;
        boolean b = false;
        for(int i = 0;i < n.retdecl().size();i++)
        {
            n.accfield().addvar(n.retdecl().get(i).gettyp(), new idnode(n.retdecl().get(i).getid()));
        }
        for(int i = 0;i < n.retclass().size();i++)
        {
            acceptClassnode(n.retclass().get(i));
        }
        for(int i = 0;i < n.retfunc().size();i++)
        {
            acceptFuncnode(n.retfunc().get(i));
            if(n.retfunc().get(i).getname().equals("main"))
            {
                if(n.retfunc().get(i).gettype().gettypename().equals("void")) {throw new Exception("error 0 : void main");}
                else {b = true;}
            }
        }
        for(int i = 0;i < n.retdecl().size();i++)
        {
            assignnode a = n.retdecl().get(i).geta();
            if(!exist(n.retdecl().get(i).gettyp().gettypename())){throw new Exception("error 4 : undefined class");}
            if(a != null) {acceptAssignnode(a);}
        }
        if(!b) {throw new Exception("error 0 : no main");}
        currentscope.pop();
        ArrayList<String> tes = new ArrayList<>();
        for(int i = 0;i < n.retfunc().size();i++)
        {
            tes.add(n.retfunc().get(i).getname());
        }
        for(int i = 0;i < n.retclass().size();i++)
        {
            if(tes.contains(n.retclass().get(i).getclassname().getid())) {throw new Exception("error 1 : alias");}
        }
        for(String i : n.accfield().getvar().keySet())
        {
            if(tes.contains(i)) {throw new Exception("error 1 : alias");}
        }
    }

    public void acceptClassnode(classnode n) throws Exception
    {
        if(n.getclassname().getid().equals("string")) {return;}
        currentclass = n;
        currentscope.push(n.accfield());
        for(int i = 0;i < n.retdecl().size();i++)
        {
            declaration d = n.retdecl().get(i);
            if(!exist(d.gettyp().gettypename())){throw new Exception("error 4 : undefined class");}
            n.accfield().addvar(d.gettyp(), new idnode (d.getid()));
        }
        for(int i = 0;i < n.retfunc().size();i++)
        {
            acceptFuncnode(n.retfunc().get(i));
            if(n.retfunc().get(i).gettype().gettypename().equals(""))
            {if(!n.retfunc().get(i).getname().equals(n.getclassname().getid())){throw new Exception("error 2 : wrong constructor name");}}
        }
        for(int i = 0;i < n.retdecl().size();i++)
        {
            if(!exist(n.retdecl().get(i).gettyp().gettypename())){throw new Exception("error 4 : undefined class");}
        }
        currentscope.pop();
        currentclass = null;
    }

    public void acceptFuncnode(funcnode n) throws Exception
    {
        String pre = n.getname();
        if(n.geti()) {return;}
        //ArrayList<declaration> a = new ArrayList<>();
        blocknode b = n.getblock();
        for(int i = 0;i < n.getparams().size();i++)
        {
            declaration d = n.getparams().get(i);
            //a.add(d);
            if(!exist(d.gettyp().gettypename())){throw new Exception("error 4 : undefined class");}
            b.accfield().addvar(d.gettyp(), new idnode(d.getid()));
        }
        type cmp2 = n.gettype();
        boolean acc = false;
        if(cmp2.isequal(new type(""))) {acc = true;}
        type cmp1 = new type();
        if(!acc) {cmp1 = acceptBlocknode(b);}
        else {cmp1 = acceptBlocknodeAlter(b);}
        String cp = cmp2.gettypename();
        if(!(cp.equals("int") || cp.equals("void") || cp.equals("String") || cp.equals("") || cp.equals("bool")))
        {
            if(!root.classnames.containsKey(cp))
            {
                throw new Exception("error 4 : undefined class");
            }
        }
        if(cmp2.isequal(new type(""))) {return;}
        if(cmp1.isequal(new type("null")))
        {
            if(cmp2.isequal(new type("int")) || cmp2.isequal(new type("void")) || cmp2.isequal(new type("string")))
            {throw new Exception(("error 3 : wrong return type"));}
        }
        if(cmp1.isequal(new type(""))) {return;}
        else if(!cmp1.isequal(cmp2)) {throw new Exception(("error 3 : wrong return type"));}
    }

    public type acceptBlocknode(blocknode n) throws Exception
    {
        currentscope.push(n.accfield());
        type t = new type();
        for(int i = 0;i < n.getdecls().size();i++)
        {
            declaration dc = n.getdecls().get(i);
            if(!exist(dc.gettyp().gettypename())){throw new Exception("error 4 : undefined class");}
            acceptDeclaration(dc);
            n.accfield().addvar(n.getdecls().get(i).gettyp(), new idnode(n.getdecls().get(i).getid()));

        }
        for(int i = 0;i < n.getnestblock().size();i++)
        {
            type tmp = acceptBlocknode(n.getnestblock().get(i));
            t = examinetype(t, tmp);
        }
        for(int i = 0;i < n.getcalcs().size();i++)
        {acceptCalcnode(n.getcalcs().get(i));}
        for(int i = 0;i < n.getctrls().size();i++)
        {
            type tmp = acceptCtrlnode(n.getctrls().get(i));
            t = examinetype(t, tmp);
        }
        for(int i = 0;i < n.getloops().size();i++)
        {
            type tmp = acceptLoopnode(n.getloops().get(i));
            t = examinetype(t, tmp);
        }
        for(int i = 0;i < n.getcondits().size();i++)
        {
            type tmp = acceptCondnode(n.getcondits().get(i));
            t = examinetype(t, tmp);
        }
        currentscope.pop();
        return t;
    }

    public type acceptBlocknodeAlter(blocknode n) throws Exception
    {
        currentscope.push(n.accfield());
        type t = new type();
        for(int i = 0;i < n.getdecls().size();i++)
        {
            declaration dc = n.getdecls().get(i);
            if(!exist(dc.gettyp().gettypename())){throw new Exception("error 4 : undefined class");}
            acceptDeclaration(dc);
            n.accfield().addvar(n.getdecls().get(i).gettyp(), new idnode(n.getdecls().get(i).getid()));

        }
        for(int i = 0;i < n.getnestblock().size();i++)
        {
            type tmp = acceptBlocknode(n.getnestblock().get(i));
            t = examinetype(t, tmp);
        }
        for(int i = 0;i < n.getcalcs().size();i++)
        {acceptCalcnode(n.getcalcs().get(i));}
        for(int i = 0;i < n.getctrls().size();i++)
        {
            type tmp = acceptCtrlnode(n.getctrls().get(i));
            t = examinetype(t, tmp);
        }
        for(int i = 0;i < n.getloops().size();i++)
        {
            type tmp = acceptLoopnode(n.getloops().get(i));
            t = examinetype(t, tmp);
        }
        for(int i = 0;i < n.getcondits().size();i++)
        {
            type tmp = acceptCondnode(n.getcondits().get(i));
            t = examinetype(t, tmp);
        }
        currentscope.pop();
        if(!t.isequal(new type(""))) {throw new Exception("error3 : return in constructor");}
        return t;
    }

    public void acceptDeclaration(declaration d) throws Exception
    {
        if(d.hasa())
        {
            acceptAssignnodeAlter(d.geta(), d.gettyp());
        }
    }

    public type acceptCondnode(condnode n) throws Exception
    {
        type t = acceptCalcnode(n.getcond());
        type r = new type();
        type tmp = acceptBlocknode(n.getif());
        r = examinetype(r, tmp);
        if(n.getelse() != null) {tmp = acceptBlocknode(n.getelse()); r = examinetype(r, tmp);}
        if(!t.gettypename().equals("bool")){throw new Exception("error 8 : nonbool condition");}
        return r;
    }

    public type acceptLoopnode(loopnode n) throws Exception
    {
        if(n.getinit() != null)
        {
            acceptCalcnode(n.getinit());
        }
        if(n.getquit() != null)
        {
            type t = acceptCalcnode(n.getquit());
            if(!t.gettypename().equals("bool")) {throw new Exception("error 8 : nonbool condition");}
        }
        if(n.getincr() != null)
        {
            acceptCalcnode(n.getincr());
        }
        looplevel++;
        type r = acceptBlocknode(n.getstmt());
        looplevel--;
        return r;
    }

    public type acceptCtrlnode(ctrlnode n) throws Exception
    {
        if(n instanceof retnode)
        {
            if(((retnode) n).getr() != null)
            {
                return acceptCalcnode(((retnode) n).getr());
            }
        }
        else
        {
            if(looplevel == 0){throw new Exception("error 9 : stray break or continue");}
        }
        return new type();
    }

    public type acceptCalcnode(calcnode n) throws Exception
    {
        type t = new type();
        if(n instanceof funccallnode)
        {t = acceptFunccallnode((funccallnode) n);}
        if(n instanceof subscriptnode)
        {t = acceptSubscriptnode((subscriptnode) n);}
        if(n instanceof prefixnode)
        {t = acceptPrefixnode((prefixnode) n);}
        if(n instanceof newnode)
        {t = acceptNewnode((newnode) n);}
        if(n instanceof binarynode)
        {t = acceptBinarynode((binarynode) n);}
        if(n instanceof memaccessnode)
        {t = acceptMemaccessnode((memaccessnode) n);}
        if(n instanceof idnode)
        {t = acceptIdentifier((idnode) n);}
        if(n instanceof assignnode)
        {t = acceptAssignnode((assignnode) n);}
        if(n instanceof constnode)
        {t = acceptConstant((constnode) n);}
        if(n instanceof thisnode)
        {t = acceptThis((thisnode)n );}
        if(n instanceof suffixnode)
        {t = acceptSuffixnode((suffixnode) n);}
        n.settype(t);
        return new type(t);
    }

    public type acceptFunccallnode(funccallnode n) throws Exception
    {
        n.setleft(false);
        calcnode c = n.getf();
        acceptCalcnode(c);
        if(c instanceof memaccessnode)
        {
            //memaccessnode m = (memaccessnode) c;
            //calcnode sc = m.retid();
            //String fn = m.retf().getid();
            //int iter = 0;
            //if(sc instanceof subscriptnode) {sc = ((subscriptnode) sc).retid();iter++;}
            //String s = ((idnode) sc).getid();
            //type t = acceptIdentifier((idnode)sc);
            type t = acceptCalcnode(((memaccessnode) c).retid());
            if(((memaccessnode) c).retf().getid().equals("size"))
            {
                return new type("int");
            }
            for(int i = 0;i < root.retclass().size();i++)
            {
                if(root.retclass().get(i).getclassname().getid().equals(t.gettypename()))
                {
                    ArrayList<declaration> d = readdecl(root.retclass().get(i), ((memaccessnode)c).retf().getid());
                    type r = readtype(root.retclass().get(i), ((memaccessnode)c).retf().getid());
                    for(int j = 0;j < n.getargs().size();j++)
                    {
                        type q = acceptCalcnode(n.getargs().get(j));
                        //q.setiteration(q.getiteration() - iter);
                        if(!d.get(j).gettyp().isequal(q)) {throw new Exception("error 4 : params mismatch");}
                    }
                    return r;
                }
            }
        }
        else
        {
            //idnode m = (idnode) c;
            ArrayList<declaration> d = readdecl(root, ((idnode) c).getid());
            type r = readtype(root, ((idnode) c).getid());
            if(d == null)
            {
                d = readdecl(currentclass, ((idnode) c).getid());
                r = readtype(currentclass, ((idnode) c).getid());
            }
            for(int i = 0;i < n.getargs().size();i++)
            {
                type p = acceptCalcnode(n.getargs().get(i));
                //p.setiteration(p.getiteration() - iter);
                if(!d.get(i).gettyp().isequal(p)) {throw new Exception("error 4 : params mismatch");}
            }
            return r;
        }
        return new type();
    }

    public type acceptSubscriptnode(subscriptnode n) throws Exception
    {
        n.setleft(true);
        type t = acceptCalcnode(n.retid());
        t.decriter();
        acceptCalcnode(n.retdlt());
        return t;
    }

    public type acceptMemaccessnode(memaccessnode n) throws Exception
    {
        String c = acceptCalcnode(n.retid()).gettypename();
        classnode sc = new classnode();
        for(classnode cl : root.retclass())
        {
            if(cl.getclassname().getid().equals(c))
            {
                sc = cl;
            }
        }
        type t = acceptIdentifierAlter(n.retf(), sc);
        if(t.gettypename().equals("id")) {n.setleft(false);}
        else {n.setleft(true);}
        return t;
    }

    public type acceptPrefixnode(prefixnode n) throws Exception
    {
        n.setleft(false);
        type t = acceptCalcnode(n.getexpr());
        if(n.getop() == 0 || n.getop() == 1)
        {if(!n.getexpr().getleft()) {throw new Exception("error 7 : increment nonlvalue");}}
        return t;
    }

    public type acceptSuffixnode(suffixnode n) throws Exception
    {
        n.setleft(false);
        type t = acceptCalcnode(n.getexpr());
        if(n.getop() == 0 || n.getop() == 1)
        {if(!n.getexpr().getleft()) {throw new Exception("error 7 : increment nonlvalue");}}
        return t;
    }

    public type acceptNewnode(newnode n) throws Exception
    {
        n.setleft(false);
        for(int i = 0;i < n.getsz().size();i++)
        {
            acceptCalcnode(n.getsz().get(i));
        }
        type t = new type(n.gettype());
        if(!exist(t.gettypename())){throw new Exception("error 4 : undefined class");}
        t.setiteration(n.getdim());
        return t;
    }

    public type acceptBinarynode(binarynode n) throws Exception
    {
        n.setleft(false);
        type t1 = acceptCalcnode(n.getlval());
        type t2 = acceptCalcnode(n.getrval());
        if(!(t1.isequal(t2) || t2.isequal(new type("null")))) {throw new Exception("error 6 : wrong expression type");}
        switch (n.getop()) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            {
                return new type("bool");
            }
            case 16:
            case 17:
            {
                if(!(t1.isequal(new type("bool")) && t2.isequal(new type("bool")))) {throw new Exception("error 8 : nonbool condition");}
                return new type("bool");
            }
            default:
            {
                return t1;
            }
        }
    }

    public type acceptIdentifier(idnode n) throws Exception
    {
        int pos = n.getl();
        n.setleft(true);
        String s = n.getid();
        if(s.equals("size")) {return new type("int");}
        type t = new type("id");
        boolean flag = false;
        for(int i = currentscope.size() - 1; i >= 0; i--)
        {
            scope sr = currentscope.get(i);
            if(sr.getvar().containsKey(s))
            {
                int x = sr.getline().get(s).getl();
                if(x > pos) {continue;}
                t = new type(sr.getvar().get(s));
                flag = true;
                break;
            }
        }
        if(t.gettypename().equals("void")) {throw new Exception("error 6 : void expression");}
        if(flag) {return t;}
        if(root.classnames.containsKey(s)) {return t;}
        if(currentclass != null)
        {
            for(int i = 0;i < currentclass.retfunc().size();i++)
            {
                if(currentclass.retfunc().get(i).getname().equals(s)) {return currentclass.retfunc().get(i).gettype();}
            }
        }
        if(root.funcnames.contains(s))
        {
            type r = readtype(root, s);
            if(!r.gettypename().equals("")) {return r;}
            else
            {
                r = readtype(currentclass, s);
                return r;
            }
        }
        throw new Exception("error 5 : undefined variable");
    }

    public type acceptIdentifierAlter(idnode n, classnode sc) throws Exception
    {
        //int pos = n.getl();
        n.setleft(true);
        String s = n.getid();
        if(s.equals("size")) {return new type("int");}
        type t = new type("id");
        if(root.classnames.containsKey(s)) {return t;}
        if(currentclass != null)
        {
            for(int i = 0;i < currentclass.retfunc().size();i++)
            {
                if(currentclass.retfunc().get(i).getname().equals(s)) {return currentclass.retfunc().get(i).gettype();}
            }
        }
        if(root.funcnames.contains(s))
        {
            type r = readtype(root, s);
            if(!r.gettypename().equals("")) {return r;}
            else
            {
                r = readtype(sc, s);
                return r;
            }
        }
        boolean flag = false;
        if(sc.accfield().getvar().containsKey(s))
        {
            t = new type(sc.accfield().getvar().get(s));
            flag = true;
            if(t.gettypename().equals("void")) {throw new Exception("error 6 : void expression");}
        }
        else {
            for (int i = 0; i < sc.retfunc().size(); i++)
            {
                if (sc.retfunc().get(i).getname().equals(s))
                {
                    //int x = sc.accfield().getline().get(s).getl();
                    //if(x > pos) {continue;}
                    flag = true;
                    t = sc.retfunc().get(i).gettype();
                }
            }
            if (!flag)
            {
                for (int i = 0; i < sc.retdecl().size(); i++)
                {
                    if(sc.retdecl().get(i).getid().getid().equals(s))
                    {
                        flag = true;
                        t = sc.retdecl().get(i).gettyp();
                    }
                }
            }
        }
        if(!flag) {throw new Exception("error 5 : undefined variable");}
        return t;
    }

    public type acceptConstant(constnode n)
    {
        n.setleft(false);
        return n.totype();
    }

    public type acceptThis(thisnode n)
    {
        n.setleft(false);
        classnode c = (classnode) currentscope.get(1).retptr();
        return new type(c.getclassname().getid());
    }

    public type acceptAssignnode(assignnode n) throws Exception
    {
        n.setleft(false);
        type t1 = acceptCalcnode(n.getlval());
        type t2 = acceptCalcnode(n.getrval());
        if(!n.getlval().getleft()) {throw new Exception("error 7 : assign nonlvalue");}
        if(!(t1.isequal(t2) || (!(t1.isequal(new type("int")) || t1.isequal(new type("string"))) && (t2.isequal(new type("null"))))))
        {throw new Exception("error 6 : wrong expression type");}
        return t1;
    }

    public type acceptAssignnodeAlter(assignnode n, type t1) throws Exception
    {
        n.setleft(false);
        type t2 = acceptCalcnode(n.getrval());
        if(!(t1.isequal(t2) || (!(t1.isequal(new type("int")) || t1.isequal(new type("string"))) && (t2.isequal(new type("null"))))))
        {throw new Exception("error 6 : wrong expression type");}
        return t1;
    }
}
