package com;

import java.util.*;

class blocknode extends node
{
    private ArrayList <blocknode> nestblock;
    private ArrayList <calcnode> calcs;
    private ArrayList <condnode> condits;
    private ArrayList <loopnode> loops;
    private ArrayList <ctrlnode> ctrls;
    private ArrayList <declaration> decls;
    private scope field;
    public blocknode()
    {nestblock = new ArrayList<>(); calcs = new ArrayList <>(); condits = new ArrayList<>(); loops = new ArrayList<>(); ctrls = new ArrayList<>();
    field = new scope(this);decls = new ArrayList<>();}
    public blocknode(scope s)
    {
        nestblock = new ArrayList<>(); calcs = new ArrayList <>(); condits = new ArrayList<>(); loops = new ArrayList<>(); ctrls = new ArrayList<>();
        field = new scope(this);decls= new ArrayList<>();
        s.addchildren(field);
    }
    public blocknode(blocknode b)
    {
        nestblock = b.getnestblock();
        calcs = b.getcalcs();
        condits = b.getcondits();
        loops = b.getloops();
        ctrls = b.getctrls();
        decls = b.getdecls();
        field = new scope(this);
    }
    public scope accfield() {return field;}
    public ArrayList<blocknode> getnestblock() {return nestblock;}
    public ArrayList<calcnode> getcalcs() {return calcs;}
    public ArrayList<condnode> getcondits() {return condits;}
    public ArrayList<loopnode> getloops() {return loops;}
    public ArrayList<ctrlnode> getctrls() {return ctrls;}
    public ArrayList<declaration> getdecls() {return decls;}
    public void addblock(blocknode b) {nestblock.add(b);}
    public void addcalc(calcnode b) {calcs.add(b);}
    public void addcond(condnode b) {condits.add(b);}
    public void addloop(loopnode b) {loops.add(b);}
    public void addctrl(ctrlnode b) {ctrls.add(b);}
    public void adddecl(declaration d) {decls.add(d);}
    public void addnode(node b)
    {
        if(b instanceof blocknode) {nestblock.add((blocknode)b);}
        if(b instanceof calcnode) {calcs.add((calcnode)b);}
        if(b instanceof condnode) {condits.add((condnode)b);}
        if(b instanceof loopnode) {loops.add((loopnode)b);}
        if(b instanceof ctrlnode) {ctrls.add((ctrlnode)b);}
    }
    public ArrayList<blocknode> retblock() {return nestblock;}
    public void addvar(type t, idnode id) throws Exception {field.addvar(t, new idnode(id));}
}
