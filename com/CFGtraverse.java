package com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class CFGtraverse
{
    private ArrayList<CFGnode> cfg;
    public CFGtraverse(ArrayList<CFGnode> c) {cfg = c;}
    public void traverse()
    {
        dfs(cfg.get(0));
    }
    public ArrayList<Integer> dfs(CFGnode c)
    {
        CFGlist n = c.getl().get(c.getl().size() - 1);
        ArrayList<Integer> rt = new ArrayList<>();
        if(n.gettyp().equals("jump"))
        {
            rt = dfs(cfg.get(n.retreg().get(0)));
        }
        if(n.gettyp().equals("br"))
        {
            rt = dfs(cfg.get(n.retreg().get(1)));
            rt.addAll(dfs(cfg.get(n.retreg().get(2))));
        }
        for(int i = c.getl().size() - 2; i >= 0;i--)
        {
            CFGlist j = c.getl().get(i);
            switch(j.gettyp())
            {
                case "add":
                case "sub":
                case "mul":
                case "div":
                case "rem":
                case "shl":
                case "shr":
                case "and":
                case "or":
                case "xor":
                case "slt":
                case "sle":
                case "sgt":
                case "sge":
                case "seq":
                case "sne":
                    int x = j.retreg().get(0);
                    int y = j.retreg().get(1);
                    int z = j.retreg().get(2);
                    Iterator k = rt.iterator();
                    while (k.hasNext())
                    {
                        if (k.next().equals(x)) {k.remove();}
                    }
                    if(!rt.contains(y)) rt.add(y);
                    if(!rt.contains(z)) rt.add(z);
                    n.setlv(rt);
                    break;
                case "neg":
                case "not":
                case "move":
                case "alloc":
                case "addi":
                    x = j.retreg().get(0);
                    y = j.retreg().get(1);
                    k = rt.iterator();
                    while (k.hasNext())
                    {
                        if (k.next().equals(x)) {k.remove();}
                    }
                    if(!rt.contains(y)) rt.add(y);
                    n.setlv(rt);
                    break;
                case "movi":
                    x = j.retreg().get(0);
                    k = rt.iterator();
                    while (k.hasNext())
                    {
                        if (k.next().equals(x)) {k.remove();}
                    }
                    n.setlv(rt);
                    break;
                case "call":
                    x = j.retreg().get(0);
                    for(Integer h : j.retreg())
                    {
                        if(!rt.contains(h)) rt.add(h);
                    }
                    k = rt.iterator();
                    while (k.hasNext())
                    {
                        if (k.next().equals(x)) {k.remove();}
                    }
                    n.setlv(rt);
                    break;
                case "load":
                    x = j.retreg().get(0);
                    y = j.retreg().get(2);
                    k = rt.iterator();
                    while (k.hasNext())
                    {
                        if (k.next().equals(x)) {k.remove();}
                    }
                    if(!rt.contains(y)) rt.add(y);
                    n.setlv(rt);
                    break;
                case "save":
                    y = j.retreg().get(1);
                    z = j.retreg().get(2);
                    if(!rt.contains(y)) rt.add(y);
                    if(!rt.contains(z)) rt.add(z);
                    n.setlv(rt);
                    break;
                default:
                    n.setlv(rt);
                    break;
            }
        }
        return rt;
    }
}