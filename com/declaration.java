package com;

class declaration extends node
{
    private type typ;
    private idnode id;
    private assignnode a;
    public declaration() {}
    public declaration(type t, idnode i) {typ = new type(t); id = new idnode(i); a = null;}
    public declaration(declaration d) {typ = d.typ; id = d.id; a = d.a;}
    public type gettyp() {return typ;}
    public String getid() {return id.getid();}
    public void seta(assignnode b) {a = b;}
    public assignnode geta() {return a;}
    public boolean hasa() {if(a != null) {return true;} {return false;}}
    public void settyp(type s) {typ = s;}
    public void setid(String s) {id = new idnode(s);}
}
