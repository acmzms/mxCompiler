package com;

import java.util.ArrayList;

class CFGlist
{
    private String type;
    private spair inf;
    private ArrayList<Integer> regs;
    private ArrayList<Integer> live;
    public CFGlist()
    {
        type = "";
        inf = null;
        regs = new ArrayList<>();
        live = new ArrayList<>();
    }
    public CFGlist(String t)
    {
        type = t;
        inf = null;
        regs = new ArrayList<>();
        live = new ArrayList<>();
    }
    public void seti(spair s)
    {
        inf = s;
    }
    public spair geti()
    {
        return inf;
    }
    public String gettyp() {return type;}
    public void addreg(int a)
    {
        regs.add(a);
    }
    public ArrayList<Integer> retreg()
    {
        return regs;
    }
    public void addlv(int a) {live.add(a);}
    public void setlv(ArrayList<Integer> a) { live = a; }
    public ArrayList<Integer> getlv() { return live; }
}