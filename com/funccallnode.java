package com;

import java.util.*;

class funccallnode extends calcnode
{
    private calcnode funcname;
    private ArrayList<calcnode> args;
    public funccallnode() {args = new ArrayList<>();}
    public funccallnode(calcnode s) {args = new ArrayList<>(); funcname = s;}
    public void addargs(calcnode c) {args.add(c);}
    public calcnode getf() {return funcname;}
    public ArrayList<calcnode> getargs() {return args;}
}
