package com;

import java.util.*;

class idnode extends leafnode
{
    private String id;
    public idnode() {super();}
    public idnode(String s) {super(); id = new String (s);}
    public idnode(idnode i) {super(); id = new String (i.getid());}
    public String getid() { return id; }
    public void setid(String s) { id = s; }
}