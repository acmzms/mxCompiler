package com;

import java.util.*;

class funcnode extends node
{
    private type rettype;
    private idnode funcname;
    private ArrayList<declaration> params;
    private blocknode code;
    private boolean isinternal;
    public funcnode(){params = new ArrayList<>();isinternal = false;}
    public funcnode(String s, blocknode n)
    {
        funcname = new idnode(s);
        if(n == null) {code = new blocknode();}
        else {code = new blocknode(n);}
        params = new ArrayList<>();
        isinternal = false;
    }
    public blocknode getblock() {return code;}
    public void setname(String s) {funcname = new idnode(s);}
    public String getname() {return funcname.getid();}
    public void settype(type s) {rettype = new type (s);}
    public type gettype() {return rettype;}
    public void addparams(type s1, idnode s2)
    {
        params.add(new declaration(s1, s2));
    }
    public ArrayList<declaration> getparams() {return params;}
    public scope accfield() {return code.accfield();}
    public boolean geti() {return isinternal;}
    public void seti(boolean b) {isinternal = b;}
}