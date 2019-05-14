package com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

class Regalloc
{
    private ArrayList<CFGnode> cfg;
    private HashMap<Integer, ArrayList<Integer>> bm;
    private HashMap<Integer, ArrayList<Integer>> cl;
    private HashMap<Integer, Integer> deg;
    private ArrayList<varlistmem> va;
    private Stack<Integer> sp;
    private ArrayList<Integer> rp;
    private Stack<Integer> mp;
    private int REGN;
    public Regalloc()
    {
        cfg = new ArrayList<>();
        bm = new HashMap<>();
        va = new ArrayList<>();
        sp = new Stack<>();
        rp = new ArrayList<>();
        deg = new HashMap<>();
        cl = new HashMap<>();
        mp = new Stack<>();
        REGN = 12;
    }
    public Regalloc(ArrayList<CFGnode> a, ArrayList<varlistmem> c)
    {
        cfg = a;
        bm = new HashMap<>();
        va = c;
        sp = new Stack<>();
        rp = new ArrayList<>();
        deg = new HashMap<>();
        cl = new HashMap<>();
        mp = new Stack<>();
        REGN = 12;
    }
    public varlistmem find(int x)
    {
        for(varlistmem v : va)
        {
            if(v.retc() == x)
            {
                return v;
            }
        }
        return null;
    }
    public void run()
    {
        build(cfg.get(0));
        simplify();
        select();
    }
    public void build(CFGnode c)
    {
        bm = new HashMap<>();
        rp = new ArrayList<>();
        deg = new HashMap<>();
        cl = new HashMap<>();
        sp = new Stack<>();
        mp = new Stack<>();
        CFGlist n = c.getl().get(c.getl().size() - 1);
        if (n.gettyp().equals("jump"))
        {
            build(cfg.get(n.retreg().get(0)));
        }
        if (n.gettyp().equals("br"))
        {
            build(cfg.get(n.retreg().get(1)));
            build(cfg.get(n.retreg().get(2)));
        }
        for(CFGlist d : c.getl())
        {
            for(int i : d.getlv())
            {
                if(!bm.containsKey(i)) {bm.put(i, new ArrayList<>());}
                for(int j : d.getlv())
                {
                    if(i != j && !bm.get(i).contains(j))
                    {
                        bm.get(i).add(j);
                    }
                }
            }
        }
        for(int i : bm.keySet())
        {
           deg.put(i, bm.get(i).size());
           cl.put(i, new ArrayList<>());
        }
    }
    public void simplify()
    {
        rp.addAll(bm.keySet());
        boolean flag = true;
        while(rp.size() > 1)
        {
            flag = false;
            Iterator j = rp.iterator();
            while(j.hasNext())
            {
                int x = (int)j.next();
                if(deg.get(x) <= REGN)
                {
                    sp.push(x);
                    j.remove();
                    flag = true;
                    for(int k : bm.get(x))
                    {
                        deg.put(x, deg.get(x) - 1);
                    }
                }
            }
            if(!flag)
            {
                int x = 0;
                int l = 999;
                for(int y : rp)
                {
                    int z = find(y).retf();
                    if(z <= l)
                    {
                        x = y;
                        l = z;
                    }
                }
                mp.push(x);
                j.remove();
                flag = true;
                for(int k : bm.get(x))
                {
                    deg.put(x, deg.get(x) - 1);
                }
            }
        }
        sp.push(rp.get(0));
    }
    public void select()
    {
        while(sp.size() > 0)
        {
            int x = sp.pop();
            if(find(x).retd() == 2)
            {
                find(x).setr(-find(x).rete());
                continue;
            }
            for(int i = 0;i < REGN;i++)
            {
                if(!cl.get(x).contains(i))
                {
                    find(x).setr(i);
                    for(int j : bm.keySet())
                    {
                        if(bm.get(j).contains(x))
                        {
                            cl.get(j).add(i);
                        }
                    }
                }
            }
        }
        while(mp.size() > 0)
        {
            int x = sp.pop();
            if(find(x).retd() == 2)
            {
                find(x).setr(-find(x).rete());
                continue;
            }
            boolean flag = false;
            for(int i = 0;i < REGN;i++)
            {
                if(!cl.get(x).contains(i))
                {
                    find(x).setr(i);
                    for(int j : bm.keySet())
                    {
                        if(bm.get(j).contains(x))
                        {
                            cl.get(j).add(i);
                        }
                    }
                    flag = true;
                }
            }
            if(!flag)
            {
                find(x).setr(-1);
            }
        }
    }
}