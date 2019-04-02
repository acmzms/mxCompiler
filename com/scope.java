package com;

import java.util.*;

class scope
{
    private node nodeptr;
    private ArrayList <scope> children;
    private HashMap <String, type> vars;
    private scope father;
    public scope() {children = new ArrayList<>();vars = new HashMap<>();}
    public scope(scope f) {father = f;children = new ArrayList<>();vars = new HashMap<>();}
    public scope(node n) {nodeptr = n; children = new ArrayList<>();vars = new HashMap<>();}
    public void addchildren(scope s)
    {
        s.father = this;
        this.children.add(s);
    }
    public void addvar(type t, idnode j) throws Exception
    {
        String a = j.getid();
        if(!vars.containsKey(a)){vars.put(a, new type(t));}
        else {throw new Exception("error 1 : redefinition");}
        //if(t)
    }
    public HashMap <String, type> getvar() {return vars;}
    public node retptr() {return nodeptr;}
}