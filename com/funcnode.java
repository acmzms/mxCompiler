package com;

import java.util.*;

class funcnode extends node
{
    private String rettype;
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
    public void settype(String s) {rettype = new String (s);}
    public String gettype() {return rettype;}
    public void addparams(String s1, String s2)
    {
        params.add(new declaration(s1, new idnode(s2)));
    }
    public ArrayList<declaration> getparams() {return params;}
    public scope accfield() {return code.accfield();}
}