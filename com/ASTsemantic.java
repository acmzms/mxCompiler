package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class ASTsemantic {
    private int looplevel;
    private Stack<scope> currentscope;

    public ASTsemantic() {
        looplevel = 0;
        currentscope = new Stack<>();
    }

    private programnode root;
    private ArrayList<String> funcnames;
    private HashMap<String, ArrayList<String>> classnames;

    public boolean exist(String s)
    {
        if (s.equals("int") || s.equals("bool") || s.equals("string") || s.equals("void"))
        {
            return true;
        }
        if (classnames.containsKey(s))
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
        return new ArrayList<>();
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

    public void acceptProgramnode(programnode n) throws Exception
    {
        currentscope.push(n.accfield());
        funcnames = new ArrayList<>();
        classnames = new HashMap<>();
        root = n;
        boolean b = false;
        for(int i = 0;i < n.retclass().size();i++)
        {
            acceptClassnode(n.retclass().get(i));
        }
        for(int i = 0;i < n.retfunc().size();i++)
        {
            acceptFuncnode(n.retfunc().get(i));
            if(n.retfunc().get(i).getname().equals("main")) {b = true;}
        }
        for(int i = 0;i < n.retdecl().size();i++)
        {
            if(!exist(n.retdecl().get(i).gettyp().gettypename())){throw new Exception("Error 4 : undefined class");}
            n.accfield().addvar(n.retdecl().get(i).gettyp(), new idnode(n.retdecl().get(i).getid()));
        }
        if(!b) {throw new Exception("error 0 : no main");}
        currentscope.pop();
    }

    public void acceptClassnode(classnode n) throws Exception
    {
        currentscope.push(n.accfield());
        ArrayList<String> a = new ArrayList<>();
        for(int i = 0;i < n.retfunc().size();i++)
        {
            acceptFuncnode(n.retfunc().get(i));
            a.add(n.retfunc().get(i).getname());
            if(n.retfunc().get(i).gettype().gettypename().equals(""))
            {if(!n.retfunc().get(i).getname().equals(n.getclassname().getid())){throw new Exception("error 2 : wrong constructor name");}}
        }
        classnames.put(n.getclassname().getid(), a);
        for(int i = 0;i < n.retdecl().size();i++)
        {
            declaration d = n.retdecl().get(i);
            if(!exist(d.gettyp().gettypename())){throw new Exception("Error 4 : undefined class");}
            n.accfield().addvar(d.gettyp(), new idnode (d.getid()));
        }
        for(int i = 0;i < n.retdecl().size();i++)
        {
            if(!exist(n.retdecl().get(i).gettyp().gettypename())){throw new Exception("Error 4 : undefined class");}
            n.accfield().addvar(n.retdecl().get(i).gettyp(), new idnode(n.retdecl().get(i).getid()));
        }
        currentscope.pop();
    }

    public void acceptFuncnode(funcnode n) throws Exception
    {
        //ArrayList<declaration> a = new ArrayList<>();
        blocknode b = n.getblock();
        for(int i = 0;i < n.getparams().size();i++)
        {
            declaration d = n.getparams().get(i);
            //a.add(d);
            if(!exist(d.gettyp().gettypename())){throw new Exception("Error 4 : undefined class");}
            b.accfield().addvar(d.gettyp(), new idnode(d.getid()));
        }
        type cmp1 = acceptBlocknode(b);
        type cmp2 = n.gettype();
        if(cmp1.isequal(new type("null")))
        {
            if(cmp2.isequal(new type("int")) || cmp2.isequal(new type("void")) || cmp2.isequal(new type("string")))
            {throw new Exception(("error 3 : wrong return type"));}
        }
        if(cmp1.isequal(new type("")))
        {
            if(!(cmp2.isequal(new type("int")) || cmp2.isequal(new type("void"))))
            {throw new Exception(("error 3 : wrong return type"));}
        }
        else if(!cmp1.isequal(cmp2)) {throw new Exception(("error 3 : wrong return type"));}
        //currentscope.peek().getf().put(n.getname(), a);
        funcnames.add(n.getname());
    }

    public type acceptBlocknode(blocknode n) throws Exception
    {
        currentscope.push(n.accfield());
        type t = new type();
        for(int i = 0;i < n.getnestblock().size();i++)
        {acceptBlocknode(n.getnestblock().get(i));}
        for(int i = 0;i < n.getcalcs().size();i++)
        {acceptCalcnode(n.getcalcs().get(i));}
        for(int i = 0;i < n.getctrls().size();i++)
        {
            type tmp = acceptCtrlnode(n.getctrls().get(i));
            if(t.isequal(new type(""))) {t = tmp;}
            if(t.isequal(new type("null")))
            {
                if(tmp.isequal(new type("int")) || tmp.isequal(new type("void"))) {throw new Exception(("error 3 : wrong return type"));}
                else {t = tmp;}
            }
            if(t.isequal(new type("int")))
            {
                if(!(tmp.isequal(new type("int")) || tmp.isequal(new type("")))) {throw new Exception(("error 3 : wrong return type"));}
            }
            if(t.isequal(new type("string")))
            {
                if(!(tmp.isequal(new type("string")))) {throw new Exception(("error 3 : wrong return type"));}
            }
            else if(!tmp.isequal(new type("null")))
            {
                if(!t.isequal(tmp)) {throw new Exception(("error 3 : wrong return type"));}
            }
        }
        for(int i = 0;i < n.getloops().size();i++)
        {acceptLoopnode(n.getloops().get(i));}
        for(int i = 0;i < n.getcondits().size();i++)
        {acceptCondnode(n.getcondits().get(i));}
        for(int i = 0;i < n.getdecls().size();i++)
        {
            if(!exist(n.getdecls().get(i).gettyp().gettypename())){throw new Exception("Error 4 : undefined class");}
            n.accfield().addvar(n.getdecls().get(i).gettyp(), new idnode(n.getdecls().get(i).getid()));
        }
        currentscope.pop();
        return t;
    }

    public void acceptCondnode(condnode n) throws Exception
    {
        type t = acceptCalcnode(n.getcond());
        acceptBlocknode(n.getif());
        if(n.getelse() != null) {acceptBlocknode(n.getelse());}
        if(!t.gettypename().equals("bool")){throw new Exception("error 8 : nonbool condition");}
    }

    public void acceptLoopnode(loopnode n) throws Exception
    {
        if(n.getinit() != null)
        {
            type t = acceptCalcnode(n.getinit());
            if(!t.gettypename().equals("bool")) {throw new Exception("error 8 : nonbool condition");}
        }
        if(n.getquit() != null)
        {
            type t = acceptCalcnode(n.getquit());
            if(!t.gettypename().equals("bool")) {throw new Exception("error 8 : nonbool condition");}
        }
        if(n.getincr() != null)
        {
            type t = acceptCalcnode(n.getincr());
            if(!t.gettypename().equals("bool")) {throw new Exception("error 8 : nonbool condition");}
        }
        looplevel++;
        acceptBlocknode(n.getstmt());
        looplevel--;
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
        return t;
    }

    public type acceptFunccallnode(funccallnode n) throws Exception
    {
        n.setleft(false);
        calcnode c = n.getf();
        type t = acceptCalcnode(c);
        if(c instanceof memaccessnode)
        {
            memaccessnode m = (memaccessnode) c;
            String s = ((idnode) m.retid()).getid();
            for(int i = 0;i < root.retclass().size();i++)
            {
                if(root.retclass().get(i).getclassname().getid().equals(s))
                {
                    ArrayList<declaration> d = readdecl(root.retclass().get(i), t.gettypename());
                    type r = readtype(root.retclass().get(i), t.gettypename());
                    for(int j = 0;j < n.getargs().size();j++)
                    {
                        type q = acceptCalcnode(n.getargs().get(j));
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
            for(int i = 0;i < n.getargs().size();i++)
            {
                type p = acceptCalcnode(n.getargs().get(i));
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
        if(n.retid() instanceof idnode)
        {
            String id = ((idnode) n.retid()).getid();
            if(!classnames.containsKey(id)) {throw new Exception("error 4 : undefined class");}
        }
        acceptCalcnode(n.retid());
        type t = acceptIdentifier(n.retf());
        if(t.gettypename().equals("id")) {n.setleft(false);}
        else {n.setleft(true);}
        return t;
    }

    public type acceptPrefixnode(prefixnode n) throws Exception
    {
        n.setleft(false);
        if(!n.getexpr().getleft()) {throw new Exception("Error 7 : increment nonlvalue");}
        return acceptCalcnode(n.getexpr());
    }

    public type acceptSuffixnode(suffixnode n) throws Exception
    {
        n.setleft(false);
        if(!n.getexpr().getleft()) {throw new Exception("Error 7 : increment nonlvalue");}
        return acceptCalcnode(n.getexpr());
    }

    public type acceptNewnode(newnode n) throws Exception
    {
        n.setleft(false);
        for(int i = 0;i < n.getsz().size();i++)
        {
            acceptCalcnode(n.getsz().get(i));
        }
        type t = new type(n.gettype());
        t.setiteration(n.getdim());
        return t;
    }

    public type acceptBinarynode(binarynode n) throws Exception
    {
        n.setleft(false);
        type t1 = acceptCalcnode(n.getlval());
        type t2 = acceptCalcnode(n.getrval());
        if(!t1.isequal(t2)) {throw new Exception("Error 6 : wrong expression type");}
        switch (n.getop()) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 16:
            case 17:
            {
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
        n.setleft(true);
        String s = n.getid();
        type t = new type("id");
        if(classnames.containsKey(s) || funcnames.contains(s)) {return t;}
        boolean flag = false;
        for(scope sr : currentscope)
        {
            if(sr.getvar().containsKey(s)) {t = currentscope.peek().getvar().get(s); flag = true;}
        }
        if(!flag){throw new Exception("Error 5 : undefined variable");}
        if(t.gettypename().equals("void")) {throw new Exception("Error 6 : void expression");}
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
        classnode c = (classnode) currentscope.peek().retptr();
        return new type(c.getclassname().getid());
    }

    public type acceptAssignnode(assignnode n) throws Exception
    {
        n.setleft(false);
        type t1 = acceptCalcnode(n.getlval());
        type t2 = acceptCalcnode(n.getrval());
        if(!n.getlval().getleft()) {throw new Exception("Error 7 : assign nonlvalue");}
        if(!t1.isequal(t2)) {throw new Exception("Error 6 : wrong expression type");}
        return t1;
    }
}
