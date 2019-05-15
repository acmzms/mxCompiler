package com;

import java.util.*;
//import javax.util.Pair;

class IRvisitor
{
    public ArrayList<CFGnode> cfglist;
    public ArrayList<varlistmem> varmap;
    private int curnodenum;
    private int curvarnum;
    private String curfunc;
    public HashMap<spair, CFGnode> funcmap;
    private HashMap<String, ArrayList<String>> classmap;
    private programnode root;
    private Stack<Integer> brkpos;
    private Stack<Integer> ctnpos;
    private Stack<scope> currentscope;
    private int looplevel;
    private int curlabnum;
    private int MAXN;
    public IRvisitor()
    {
        cfglist = new ArrayList<>();
        cfglist.add(new CFGnode(0));
        cfglist.add(new CFGnode(1));
        funcmap = new HashMap<>();
        classmap = new HashMap<>();
        varmap = new ArrayList<>();
        curfunc = null;
        curnodenum = 2;
        curvarnum = 0;
        curlabnum = 0;
        brkpos = new Stack<>();
        ctnpos = new Stack<>();
        currentscope = new Stack<>();
        looplevel = 0;
        MAXN = 2147483600;
    }

    public void travProgramnode(programnode n)
    {
        root = n;
        currentscope.push(n.accfield());
        CFGnode cn = new CFGnode(0);
        cfglist.set(0, cn);
        varmap.add(new varlistmem("#retval", n.accfield(), curvarnum, 0, 8, looplevel));
        curvarnum++;
        for(int i = 0;i < n.retdecl().size();i++)
        {
            if(n.retdecl().get(i).gettyp().getiteration() >= 1)
            {
                varmap.add(new varlistmem(n.retdecl().get(i).getid().getid(), n.accfield(), curvarnum ,1, 8, looplevel));
            }
            else
            {
                type t = n.retdecl().get(i).gettyp();
                if(t.isequal(new type("int")))
                {
                    varmap.add(new varlistmem(n.retdecl().get(i).getid().getid(), n.accfield(), curvarnum ,0, 8, looplevel));
                }
                if(t.isequal(new type("bool")))
                {
                    varmap.add(new varlistmem(n.retdecl().get(i).getid().getid(), n.accfield(), curvarnum ,0, 1, looplevel));
                }
                if(t.isequal(new type("string")))
                {
                    varmap.add(new varlistmem(n.retdecl().get(i).getid().getid(), n.accfield(), curvarnum ,2, 8, looplevel));
                }
                else
                {
                    for(int j = 0;j < n.retclass().size();j++)
                    {
                        if(n.retclass().get(j).getclassname().getid().equals(t.gettypename()))
                        {
                            int sz = n.retclass().get(j).retdecl().size();
                            varmap.add(new varlistmem(n.retdecl().get(j).getid().getid(), n.accfield(), curvarnum ,0, 8 * sz, looplevel));
                        }
                    }
                }
            }
            if(n.retdecl().get(i).hasa())
            {
                travAssignnode(n.retdecl().get(i).geta(), cn);
            }
            curvarnum++;
        }
        for(int i = 0;i < n.retclass().size();i++)
        {
            travClassnode(n.retclass().get(i));
        }
        for(int i = 0;i < n.retfunc().size();i++)
        {
            travFuncnode(n.retfunc().get(i), "");
        }
        CFGlist cfg = new CFGlist("jump");
        cfg.addreg(1);
        cfglist.get(0).addl(cfg);
        currentscope.pop();
    }

    public void travClassnode(classnode c)
    {
        if(c.getclassname().getid().equals("string")) {return;}
        currentscope.push(c.accfield());
        ArrayList<String> tmp = new ArrayList<>();
        for(int i = 0;i < c.retdecl().size();i++)
        {
            tmp.add(c.retdecl().get(i).getid().getid());
        }
        classmap.put(c.getclassname().getid(), tmp);
        for(int i = 0;i < c.retfunc().size();i++)
        {
            travFuncnode(c.retfunc().get(i), c.getclassname().getid());
        }
        currentscope.pop();
    }

    public void travFuncnode(funcnode f, String s)
    {
        if(f.geti()) {return;}
        curfunc = f.getname();
        spair sp = new spair(s,f.getname());
        if(f.getname().equals("main"))
        {
            CFGnode n = new CFGnode(1);
            funcmap.put(sp, n);
            cfglist.set(1, n);
            travBlocknode(f.getblock(), n);
        }
        else
        {
            CFGnode n = new CFGnode(curnodenum);
            curnodenum++;
            funcmap.put(sp, n);
            cfglist.add(n);
            travBlocknode(f.getblock(), n);
        }
    }

    public CFGnode travBlocknode(blocknode b, CFGnode c)
    {
        currentscope.push(b.accfield());
        for(int i = 0;i < b.getdecls().size();i++)
        {
            if(b.getdecls().get(i).gettyp().getiteration() >= 1)
            {
                varmap.add(new varlistmem(b.getdecls().get(i).getid().getid(), b.accfield(), curvarnum ,2, 8, looplevel));
            }
            else
            {
                type t = b.getdecls().get(i).gettyp();
                if(t.isequal(new type("int")))
                {
                    varmap.add(new varlistmem(b.getdecls().get(i).getid().getid(), b.accfield(), curvarnum ,1, 8, looplevel));
                }
                else if(t.isequal(new type("bool")))
                {
                    varmap.add(new varlistmem(b.getdecls().get(i).getid().getid(), b.accfield(), curvarnum ,1, 1, looplevel));
                }
                else if(t.isequal(new type("string")))
                {
                    varmap.add(new varlistmem(b.getdecls().get(i).getid().getid(), b.accfield(), curvarnum ,2, 8, looplevel));
                }
                else
                {
                    for(int j = 0;j < root.retclass().size();j++)
                    {
                        if(root.retclass().get(j).getclassname().getid().equals(t.gettypename()))
                        {
                            int sz = root.retclass().get(j).retdecl().size();
                            varmap.add(new varlistmem(b.getdecls().get(j).getid().getid(), b.accfield(), curvarnum ,1, 8 * sz, looplevel));
                        }
                    }
                }
            }
            if(b.getdecls().get(i).hasa())
            {
                travAssignnode(b.getdecls().get(i).geta(), c);
            }
            curvarnum++;
        }
        ArrayList<node> nodes = new ArrayList<>();
        nodes.addAll(b.getnestblock());
        nodes.addAll(b.getcalcs());
        nodes.addAll(b.getcondits());
        nodes.addAll(b.getctrls());
        nodes.addAll(b.getloops());
        Collections.sort(nodes);
        CFGnode cur = c;
        for(node n : nodes)
        {
            if(n instanceof blocknode) {cur = travBlocknode((blocknode) n, cur);}
            if(n instanceof calcnode) {travCalcnode((calcnode) n, cur);}
            if(n instanceof condnode) {cur = travCondnode((condnode) n, cur);}
            if(n instanceof ctrlnode) {cur = travCtrlnode((ctrlnode) n, cur);}
            if(n instanceof loopnode) {cur = travLoopnode((loopnode) n, cur);}
        }
        currentscope.pop();
        return cur;
    }

    public CFGnode travCondnode(condnode n, CFGnode c)
    {
        CFGnode r = new CFGnode(curnodenum);
        cfglist.add(r);
        curnodenum++;
        CFGnode c1 = new CFGnode(curnodenum);
        cfglist.add(r);
        curnodenum++;
        CFGnode c2 = new CFGnode(curnodenum);
        cfglist.add(r);
        curnodenum++;
        int rx = travCalcnodeAlter(n.getcond(), c, null);
        CFGnode r1 = travBlocknode(n.getif(), c1);
        CFGnode r2 = null;
        if(n.getelse() != null)
        {
            r2 = travBlocknode(n.getelse(), c2);
        }
        CFGlist cf = new CFGlist("br");
        cf.addreg(rx);
        cf.addreg(r1.geti());
        if(r2 != null) {cf.addreg(r2.geti());}
        else {cf.addreg(r.geti());}
        CFGlist tl = new CFGlist("jump");
        tl.addreg(r.geti());
        r1.addl(tl);
        if(r2 != null) {r2.addl(tl);}
        return r;
    }

    public int travCalcnodeAlter(calcnode n, CFGnode c, CFGnode d)
    {

        if(n instanceof binarynode)
        {
            CFGnode t = new CFGnode(curnodenum);
            cfglist.add(t);
            curnodenum++;
            CFGlist l = new CFGlist("br");
            //int z = 0;
            CFGnode v = new CFGnode(curnodenum);
            cfglist.add(v);
            curnodenum++;
            int x1 = travCalcnodeAlter(((binarynode) n).getlval() ,c, t);
            int x2 = travCalcnodeAlter(((binarynode) n).getrval() ,v, t);
            l.addreg(x1);
            if(((binarynode) n).getop() == 16)
            {
                l.addreg(v.geti());
                l.addreg(t.geti());
                c.addl(l);
                CFGlist r = new CFGlist("and");
                r.addreg(0);
                r.addreg(x1);
                r.addreg(x2);
                t.addl(r);
            }
            if(((binarynode) n).getop() == 17)
            {
                l.addreg(t.geti());
                l.addreg(v.geti());
                c.addl(l);
                CFGlist r = new CFGlist("or");
                r.addreg(0);
                r.addreg(x1);
                r.addreg(x2);
                t.addl(r);
            }
            return 0;
        }
        else
        {
            int x = travCalcnode(n, c);
            if(d != null)
            {
                CFGlist r = new CFGlist("jump");
                r.addreg(d.geti());
                c.addl(r);
            }
            CFGlist u = new CFGlist("move");
            u.addreg(0);
            u.addreg(x);
            c.addl(u);
            return 0;
        }
    }

    public CFGnode travLoopnode(loopnode n, CFGnode c)
    {
        if(n.getinit() != null) {travCalcnode(n.getinit(), c);}
        CFGlist x1 = new CFGlist("jump");
        x1.addreg(curnodenum);
        c.addl(x1);
        CFGnode c1 = new CFGnode(curnodenum);
        cfglist.add(c1);
        curnodenum++;
        CFGnode r = new CFGnode(curnodenum);
        varmap.add(new varlistmem("#brk", currentscope.peek(), curvarnum, 1, 8, looplevel));
        brkpos.push(curvarnum);
        CFGlist q2 = new CFGlist("move");
        q2.addreg(r.geti());
        q2.addreg(curvarnum);
        c1.addl(q2);
        curvarnum++;
        brkpos.push(r.geti());
        looplevel++;
        CFGnode c2 = travBlocknode(n.getstmt(), c1);
        looplevel--;
        cfglist.add(c2);
        curnodenum++;
        CFGnode f = null;
        if(n.getincr() != null)
        {
            f = new CFGnode(curnodenum);
            cfglist.add(f);
            curnodenum++;
            travCalcnode(n.getincr(), f);
            //CFGlist x2 = new CFGlist("jump");
            //x2.addreg(c1.geti());
            //f.addl(x2);
            varmap.add(new varlistmem("#ctn", currentscope.peek(), curvarnum, 1, 8, looplevel));
            ctnpos.push(curvarnum);
            CFGlist q1 = new CFGlist("move");
            q1.addreg(f.geti());
            q1.addreg(curvarnum);
            c2.addl(q1);
            curvarnum++;

        }
        else
        {
            varmap.add(new varlistmem("#ctn", currentscope.peek(), curvarnum, 1, 8, looplevel));
            ctnpos.push(curvarnum);
            CFGlist q1 = new CFGlist("move");
            q1.addreg(c1.geti());
            q1.addreg(curvarnum);
            c2.addl(q1);
            curvarnum++;
        }

        int t = travCalcnodeAlter(n.getquit(), c2, null);
        CFGlist tmp = new CFGlist("br");
        tmp.addreg(t);
        if(f != null) {tmp.addreg(f.geti());}
        else {tmp.addreg(c1.geti());}
        tmp.addreg(r.geti());
        c2.addl(tmp);
        brkpos.pop();
        ctnpos.pop();
        return r;
    }

    public CFGnode travCtrlnode(ctrlnode n, CFGnode c)
    {
        if(n.gettype() == 0)
        {
            if(((retnode) n).getr() != null)
            {
                int rc = travCalcnode(((retnode) n).getr(), c);
                CFGlist x2 = new CFGlist("move");
                x2.addreg(0);
                x2.addreg(rc);
                c.addl(x2);
                CFGlist x3 = new CFGlist("ret");
                c.addl(x3);
            }
        }
        if(n.gettype() == 1)
        {
            CFGlist x1 = new CFGlist("jump");
            x1.addreg(ctnpos.peek());
            c.addl(x1);
            return cfglist.get(ctnpos.peek());
        }
        if(n.gettype() == 2)
        {
            CFGlist x1 = new CFGlist("jump");
            x1.addreg(brkpos.peek());
            c.addl(x1);
            return cfglist.get(brkpos.peek());
        }
        return null;
    }

    public int travCalcnode(calcnode n, CFGnode c)
    {
        if(n instanceof funccallnode)
        {return travFunccallnode((funccallnode)n, c);}
        if(n instanceof subscriptnode)
        {return travSubscriptnode((subscriptnode)n, c);}
        if(n instanceof prefixnode)
        {return travPrefixnode((prefixnode)n, c);}
        if(n instanceof newnode)
        {return travNewnode((newnode)n, c, -1);}
        if(n instanceof binarynode)
        {return travBinarynode((binarynode) n, c);}
        if(n instanceof memaccessnode)
        {return travMemaccessnode((memaccessnode)n, c);}
        if(n instanceof assignnode)
        {return travAssignnode((assignnode)n, c);}
        if(n instanceof suffixnode)
        {return travSuffixnode((suffixnode)n, c);}
        if(n instanceof idnode)
        {return travIdnode((idnode)n, c); }
        if(n instanceof constnode)
        {return travConstnode((constnode)n, c);}
        if(n instanceof thisnode)
        {return travThisnode((thisnode)n, c);}
        return -1;
    }

    public int travFunccallnode(funccallnode f, CFGnode c)
    {
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        int rt = curvarnum;
        curvarnum++;
        calcnode fn = f.getf();
        if(fn instanceof idnode)
        {
            spair s = new spair(((idnode) fn).getid(), "");
            CFGlist ls = new CFGlist("call");
            ls.seti(s);
            ls.addreg(rt);
            for(calcnode cl : f.getargs())
            {
                int xz = travCalcnode(cl, c);
                ls.addreg(xz);
            }
            c.addl(ls);
        }
        else
        {
            spair s = new spair(((memaccessnode) fn).retf().getid(), ((memaccessnode) fn).retid().gettype().gettypename());
            CFGlist ls = new CFGlist("call");
            ls.seti(s);
            ls.addreg(rt);
            for(calcnode cl : f.getargs())
            {
                int xz = travCalcnode(cl, c);
                ls.addreg(xz);
            }
            c.addl(ls);
        }
        return rt;
    }

    public int travSubscriptnode(subscriptnode s, CFGnode c)
    {
        int id = travCalcnode(s.retid(), c);
        int d = travCalcnode(s.retdlt(), c);
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        int tmp = curvarnum;
        curvarnum++;
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        int u = curvarnum;
        curvarnum++;
        CFGlist r1 = new CFGlist("add");
        r1.addreg(tmp);
        r1.addreg(id);
        r1.addreg(d);
        c.addl(r1);
        CFGlist r2 = new CFGlist("load");
        r2.addreg(u);
        r2.addreg(8);
        r2.addreg(tmp);
        r2.addreg(0);
        c.addl(r2);
        return u;
    }

    public int travPrefixnode(prefixnode p, CFGnode c)
    {
        int x = travCalcnode(p.getexpr(), c);
        CFGlist u;
        switch (p.getop())
        {
            case 0:
                u = new CFGlist("addi");
                u.addreg(x);
                u.addreg(1);
                c.addl(u);
                break;
            case 1:
                u = new CFGlist("addi");
                u.addreg(x);
                u.addreg(-1);
                c.addl(u);
                break;
            case 2:
                break;
            case 3:
                u = new CFGlist("neg");
                u.addreg(x);
                c.addl(u);
                break;
            case 4:
            case 5:
                u = new CFGlist("not");
                u.addreg(x);
                c.addl(u);
                break;
        }
        return x;
    }

    public int travNewnode(newnode n, CFGnode c, int p)
    {
        if(p == -1)
        {
            varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
            int r = curvarnum;
            curvarnum++;
            if(n.getdim() > 0 && n.getsz().size() > 0)
            {
                int x1 = travCalcnode(n.getsz().get(0), c);
                CFGlist y1 = new CFGlist("alloc");
                y1.addreg(r);
                y1.addreg(x1);
                c.addl(y1);
                if(n.getsz().size() > 1)
                {
                    CFGlist y2 = new CFGlist("movi");
                    varmap.add(new varlistmem("#init", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int x2 = curvarnum;
                    curvarnum++;
                    varmap.add(new varlistmem("#tmpc", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int x3 = curvarnum;
                    curvarnum++;
                    y2.addreg(x2);
                    y2.addreg(0);
                    CFGlist y3 = new CFGlist("move");
                    y3.addreg(r);
                    y3.addreg(x3);
                    CFGnode tmp = new CFGnode(curnodenum);
                    cfglist.add(tmp);
                    int z = curnodenum;
                    curnodenum++;
                    travNewnode(n.recur(), tmp, x3);
                    CFGlist y4 = new CFGlist("slt");
                    varmap.add(new varlistmem("#tmpd", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int x4 = curvarnum;
                    curvarnum++;
                    y4.addreg(x4);
                    y4.addreg(x2);
                    y4.addreg(x1);
                    tmp.addl(y4);
                    CFGlist y5 = new CFGlist("br");
                    y5.addreg(x4);
                    y5.addreg(z);
                    y5.addreg(c.geti());
                    tmp.addl(y5);
                }
            }
            return r;
        }
        else
        {
            varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
            int r = curvarnum;
            curvarnum++;
            if(n.getdim() > 0 && n.getsz().size() > 0)
            {
                int x1 = travCalcnode(n.getsz().get(0), c);
                CFGlist y1 = new CFGlist("alloc");
                y1.addreg(r);
                y1.addreg(x1);
                c.addl(y1);
                if(n.getsz().size() > 1)
                {
                    CFGlist y2 = new CFGlist("movi");
                    varmap.add(new varlistmem("#init", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int x2 = curvarnum;
                    curvarnum++;
                    varmap.add(new varlistmem("#tmpc", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int x3 = curvarnum;
                    curvarnum++;
                    y2.addreg(x2);
                    y2.addreg(0);
                    CFGlist y3 = new CFGlist("move");
                    y3.addreg(r);
                    y3.addreg(x3);
                    CFGnode tmp = new CFGnode(curnodenum);
                    cfglist.add(tmp);
                    int z = curnodenum;
                    curnodenum++;
                    travNewnode(n.recur(), tmp, x3);
                    CFGlist y4 = new CFGlist("slt");
                    varmap.add(new varlistmem("#tmpd", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int x4 = curvarnum;
                    curvarnum++;
                    y4.addreg(x4);
                    y4.addreg(x2);
                    y4.addreg(x1);
                    tmp.addl(y4);
                    CFGlist y5 = new CFGlist("br");
                    y5.addreg(x4);
                    y5.addreg(z);
                    y5.addreg(c.geti());
                    tmp.addl(y5);
                }
            }
            CFGlist z0 = new CFGlist("store");
            z0.addreg(8);
            z0.addreg(p);
            z0.addreg(r);
            z0.addreg(0);
            return -1;
        }
    }

    public int travBinarynode(binarynode b, CFGnode c)
    {
        CFGlist cmd;
        switch (b.getop())
        {
            case 0:
                cmd = new CFGlist("div");
                break;
            case 1:
                cmd = new CFGlist("mul");
                break;
            case 2:
                cmd = new CFGlist("rem");
                break;
            case 3:
                if(b.getlval().gettype().isequal(new type("string")))
                {
                    cmd = new CFGlist("call");
                    cmd.seti(new spair("str_concat", ""));
                    int xz = travCalcnode(b.getlval(), c);
                    int yz = travCalcnode(b.getrval(), c);
                    varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int zz = curvarnum;
                    curvarnum++;
                    cmd.addreg(zz);
                    cmd.addreg(xz);
                    cmd.addreg(yz);
                    c.addl(cmd);
                    return zz;
                }
                else {cmd = new CFGlist("add");}
                break;
            case 4:
                cmd = new CFGlist("sub");
                break;
            case 5:
                cmd = new CFGlist("shl");
                break;
            case 6:
                cmd = new CFGlist("shr");
                break;
            case 7:
                cmd = new CFGlist("sge");
                break;
            case 8:
                cmd = new CFGlist("sgt");
                break;
            case 9:
                if(b.getlval().gettype().isequal(new type("string")))
                {
                    cmd = new CFGlist("call");
                    cmd.seti(new spair("str_less", ""));
                    int xz = travCalcnode(b.getlval(), c);
                    int yz = travCalcnode(b.getrval(), c);
                    varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int zz = curvarnum;
                    curvarnum++;
                    cmd.addreg(zz);
                    cmd.addreg(xz);
                    cmd.addreg(yz);
                    c.addl(cmd);
                    return zz;
                }
                else {cmd = new CFGlist("slt");}
                break;
            case 10:
                if(b.getlval().gettype().isequal(new type("string")))
                {
                    cmd = new CFGlist("call");
                    cmd.seti(new spair("str_lte", ""));
                    int xz = travCalcnode(b.getlval(), c);
                    int yz = travCalcnode(b.getrval(), c);
                    varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int zz = curvarnum;
                    curvarnum++;
                    cmd.addreg(zz);
                    cmd.addreg(xz);
                    cmd.addreg(yz);
                    c.addl(cmd);
                    return zz;
                }
                else {cmd = new CFGlist("sle");}
                break;
            case 11:
                if(b.getlval().gettype().isequal(new type("string")))
                {
                    cmd = new CFGlist("call");
                    cmd.seti(new spair("str_not_equal", ""));
                    int xz = travCalcnode(b.getlval(), c);
                    int yz = travCalcnode(b.getrval(), c);
                    varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int zz = curvarnum;
                    curvarnum++;
                    cmd.addreg(zz);
                    cmd.addreg(xz);
                    cmd.addreg(yz);
                    c.addl(cmd);
                    return zz;
                }
                else {cmd = new CFGlist("sne");}
                break;
            case 12:
                if(b.getlval().gettype().isequal(new type("string")))
                {
                    cmd = new CFGlist("call");
                    cmd.seti(new spair("str_equal", ""));
                    int xz = travCalcnode(b.getlval(), c);
                    int yz = travCalcnode(b.getrval(), c);
                    varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
                    int zz = curvarnum;
                    curvarnum++;
                    cmd.addreg(zz);
                    cmd.addreg(xz);
                    cmd.addreg(yz);
                    c.addl(cmd);
                    return zz;
                }
                else {cmd = new CFGlist("seq");}
                break;
            case 13:
            case 16:
                cmd = new CFGlist("and");
                break;
            case 14:
                cmd = new CFGlist("xor");
                break;
            case 15:
            case 17:
                cmd = new CFGlist("or");
                break;
            default:
                cmd = new CFGlist("nop");
        }
        int xz = travCalcnode(b.getlval(), c);
        int yz = travCalcnode(b.getrval(), c);
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        int zz = curvarnum;
        curvarnum++;
        cmd.addreg(zz);
        cmd.addreg(xz);
        cmd.addreg(yz);
        c.addl(cmd);
        return zz;
    }

    public int travMemaccessnode(memaccessnode m, CFGnode c)
    {
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        int x = curvarnum;
        curvarnum++;
        ArrayList<String> k = classmap.get(m.retid().gettype().gettypename());
        String v = m.retf().getid();
        int q = travIdnode(m.retf(), c);
        for(int i = 0;i < k.size();i++)
        {
            if(k.get(i).equals(v))
            {
                CFGlist p = new CFGlist("load");
                p.addreg(x);
                p.addreg(8);
                p.addreg(q);
                p.addreg(0);
                c.addl(p);
            }
        }
        return x;
    }

    public int travAssignnode(assignnode a, CFGnode c)
    {
        int xz = travCalcnode(a.getlval(), c);
        int yz = travCalcnode(a.getrval(), c);
        CFGlist u = new CFGlist("move");
        u.addreg(yz);
        u.addreg(xz);
        c.addl(u);
        return xz;
    }

    public int travSuffixnode(suffixnode s, CFGnode c)
    {
        int x = travCalcnode(s.getexpr(), c);
        CFGlist u = new CFGlist("addi");
        u.addreg(x);
        if(s.getop() == 0) {u.addreg(1);}
        else {u.addreg(-1);}
        c.addl(u);
        return x;
    }

    public int travConstnode(constnode b, CFGnode c)
    {
        int xz;
        CFGlist x1 = new CFGlist("movi");
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        xz = curvarnum;
        x1.addreg(xz);
        curvarnum++;
        if(b.totype().gettypename().equals("int"))
        {
            int v = Integer.parseInt(b.getconst());
            x1.addreg(v);
        }
        if(b.totype().gettypename().equals("bool"))
        {
            int v;
            if(b.getconst().equals("true")) {v = 1;}
            else {v = 0;}
            x1.addreg(v);
        }
        if(b.totype().gettypename().equals("string"))
        {
            String src = b.getconst();
            CFGlist d = new CFGlist("db");
            d.seti(new spair(src, "@" + curlabnum));
            varmap.get(xz).sete(curlabnum);
            curlabnum++;
            c.addl(d);
            return xz;
        }
        else
        {
            int v = MAXN;
            x1.addreg(v);
        }
        c.addl(x1);
        return xz;
    }

    public int travIdnode(idnode i, CFGnode c)
    {
        for(varlistmem v : varmap)
        {
            if(v.reta().equals(i.getid()) && v.retb().equals(currentscope.peek()))
            {
                return v.retc();
            }
        }
        varmap.add(new varlistmem(i.getid(), currentscope.peek(), curvarnum, 1, 8, looplevel));
        curvarnum++;
        return curvarnum - 1;
    }

    public int travThisnode(thisnode t, CFGnode c)
    {
        varmap.add(new varlistmem("#tmp", currentscope.peek(), curvarnum, 1, 8, looplevel));
        int r = curvarnum;
        curvarnum++;
        int l = classmap.get(t.gettype().gettypename()).size();
        CFGlist q = new CFGlist("alloc");
        q.addreg(r);
        q.addreg(l);
        c.addl(q);
        return r;
    }
}