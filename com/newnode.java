package com;

import java.util.ArrayList;

class newnode extends calcnode
{
    private int dim;
    private type type;
    private ArrayList<calcnode> sz;
    public newnode() {sz = new ArrayList<>();}
    public void setdim(int x) {dim = x;}
    public void settype(type s) {type = s;}
    public void addsz(calcnode x) {if(x != null) {sz.add(x);}}
    public ArrayList<calcnode> getsz() {return sz;}
    //public type rettype() {return new type(type);}
    public int getdim() {return dim;}
    public type gettype() {type t = new type(type); t.setiteration(dim); return t;}
    public newnode recur()
    {
        newnode r = new newnode();
        r.setdim(dim - 1);
        r.settype(type);
        for(int i = 1;i < sz.size();i++)
        {
            r.addsz(sz.get(i));
        }
        return r;
    }
}