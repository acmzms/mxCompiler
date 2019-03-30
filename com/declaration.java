package com;

class declaration extends node
{
    private String typ;
    private idnode id;
    public declaration() {}
    public declaration(String t, idnode i) {typ = new String(t); id = new idnode(i);}
    public String gettyp() {return typ;}
    public String getid() {return id.getid();}
    public void settyp(String s) {typ = s;}
    public void setid(String s) {id = new idnode(s);}
}
