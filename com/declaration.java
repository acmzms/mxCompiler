package com;

class declaration extends node
{
    private type typ;
    private idnode id;
    public declaration() {}
    public declaration(type t, idnode i) {typ = new type(t); id = new idnode(i);}
    public type gettyp() {return typ;}
    public String getid() {return id.getid();}
    public void settyp(type s) {typ = s;}
    public void setid(String s) {id = new idnode(s);}
}
