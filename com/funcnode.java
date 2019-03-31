package com;

import java.util.*;

class funcnode extends node
{
    private type rettype;
    private idnode funcname;
    private ArrayList<declaration> params;
    private blocknode code;
    public funcnode(){params = new ArrayList<>();}
    public funcnode(String s, blocknode n)
    {
        funcname = new idnode(s);
        code = new blocknode(n);
        params = new ArrayList<>();
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
}