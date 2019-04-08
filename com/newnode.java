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
    public type rettype() {return new type(type);}
    public int getdim() {return dim;}
    public type gettype() {return new type(type);}
}