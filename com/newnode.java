package com;

import java.util.ArrayList;

class newnode extends calcnode
{
    private int dim;
    private String type;
    private ArrayList<calcnode> sz;
    public newnode() {sz = new ArrayList<>();}
    public void setdim(int x) {dim = x;}
    public void settype(String s) {type = s;}
    public void addsz(calcnode x) {if(x != null) {sz.add(x;}}
    public ArrayList<calcnode> getsz() {return sz;}
    public type rettype() {return new type(type);}
    public int getdim() {return dim;}
}