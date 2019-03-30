package com;

import static java.lang.Character.isDigit;

class constnode extends leafnode
{
    private int type; // 0 int 1 bool 2 String 3 Null
    private String val;
    public constnode(String v){val = new String(v);analysis();}
    public void analysis()
    {
        if(isDigit(val.charAt(0))) {type = 0;}
        if(val.charAt(0) == '"') {type = 2;}
        if(val.charAt(0) == 'T') {type = 1;}
        if(val.charAt(0) == 'F') {type = 1;}
        if(val.charAt(0) == 'N') {type = 3;}
    }
    public String getconst() {return val;}
    public type totype()
    {
        if(type == 0) return new type("int");
        if(type == 1) return new type("bool");
        if(type == 2) return new type("String");
        else return new type("null");
    }
}