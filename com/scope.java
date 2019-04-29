package com;

import java.util.*;

class scope
{
    private node nodeptr;
    private ArrayList <scope> children;
    private HashMap <String, type> vars;
    private HashMap <String, idnode> lines;
    private scope father;
    public scope() {children = new ArrayList<>();vars = new HashMap<>();lines = new HashMap<>();}
    public scope(scope f) {father = f;children = new ArrayList<>();vars = new HashMap<>();lines = new HashMap<>();}
    public scope(node n) {nodeptr = n; children = new ArrayList<>();vars = new HashMap<>();lines = new HashMap<>();}
    public void addchildren(scope s)
    {
        s.father = this;
        this.children.add(s);
    }
    public void addvar(type t, idnode j) throws Exception
    {
        if(!vars.containsKey(j.getid())){vars.put(j.getid(), new type(t));}
        else {throw new Exception("error 1 : redefinition");}
        lines.put(j.getid(), j);
        //if(t)
    }
    public HashMap <String, type> getvar() {return vars;}
    public HashMap <String, idnode> getline() {return lines;}
    public node retptr() {return nodeptr;}
}