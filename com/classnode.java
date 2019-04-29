package com;

import java.util.*;

class classnode extends node
{
    private idnode classname;
    private ArrayList <declaration> classvars;
    private ArrayList <funcnode> classfunc;
    private scope field;
    public classnode() {field = new scope(this); classvars = new ArrayList<>(); classfunc = new ArrayList<>();}
    public classnode(String name)
    {
        //p.accfield().addchildren(this.field);
        classname = new idnode();
        classname.setid(name);
        classvars = new ArrayList<>();
        classfunc = new ArrayList<>();
        field = new scope(this);
    }
    public void addvar(type t, idnode id) throws Exception
    {
        field.addvar(t, id);
        classvars.add(new declaration(t, id));
    }
    public void addfunc(funcnode f)
    {
        classfunc.add(f);
    }
    public void adddecl(type a, idnode b) { classvars.add(new declaration(a, new idnode(b))); }
    public ArrayList<funcnode> retfunc() {return classfunc;}
    public ArrayList<declaration> retdecl() {return classvars;}
    public scope accfield() { return field; }
    public idnode getclassname() { return classname; }
}
