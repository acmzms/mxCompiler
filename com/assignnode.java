package com;

import java.util.*;

class assignnode extends calcnode
{
    private calcnode lval, rval;
    public assignnode() {super();}
    public assignnode(calcnode l, calcnode r) {super(); lval = new calcnode(l); rval = new calcnode(r);}
    public void setlval(calcnode s) {lval = s;}
    public void setrval(calcnode s) {rval = s;}
    public calcnode getlval() {return lval;}
    public calcnode getrval() {return rval;}
}