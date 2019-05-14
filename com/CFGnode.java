package com;

import java.util.ArrayList;

class CFGnode
{
    private int label;
    private ArrayList<CFGlist> code;
    public CFGnode()
    {
        label = -1;
        code = new ArrayList<>();
    }
    public CFGnode(int i)
    {
        label = i;
        code = new ArrayList<>();
    }
    public void addl(CFGlist l)
    {
        code.add(l);
    }
    public ArrayList<CFGlist> getl()
    {
        return code;
    }
    public int geti() {return label;}
}