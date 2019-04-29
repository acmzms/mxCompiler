package com;

import java.util.*;

class idnode extends calcnode
{
    private String id;
    private int line;
    public idnode() {super();}
    public idnode(String s, int l) {super(); id = new String (s);line = l;}
    public idnode(idnode i) {super(); id = new String (i.getid()); line = i.getl();}
    public String getid() { return id; }
    public int getl() {return line;}
    public void setid(String s) { id = s; }
}