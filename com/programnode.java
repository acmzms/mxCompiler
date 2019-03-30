package com;

import java.util.*;

class programnode extends node
{
    private ArrayList <classnode> classdecls;
    private ArrayList <funcnode> funcdecls;
    private ArrayList <declaration> declnodes;
    private scope field;
    public scope accfield() {return field;}
    public programnode()
    {
        classdecls = new ArrayList<>();
        funcdecls = new ArrayList<>();
        field = new scope(this);
    }
    public void addclass(classnode c) { classdecls.add(c); }
    public void addfunc(funcnode c) { funcdecls.add(c); }
    public void adddecl(declaration d) { declnodes.add(d); }
    public ArrayList<classnode> retclass() {return classdecls;}
    public ArrayList<funcnode> retfunc() {return funcdecls;}
    public ArrayList<declaration> retdecl() {return declnodes;}
    public void addvar(String t, idnode id) throws Exception { field.addvar(t, id); }
}
