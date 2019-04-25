package com;

import static java.lang.Character.isDigit;

class constnode extends calcnode
{
    private int type; // 0 int 1 bool 2 String 3 Null
    private String val;
    public constnode(String v){val = new String(v);analysis();}
    public void analysis()
    {
        if(isDigit(val.charAt(0))) {type = 0;}
        if(val.charAt(0) == '"') {type = 2;}
        if(val.charAt(0) == 't') {type = 1;}
        if(val.charAt(0) == 'f') {type = 1;}
        if(val.charAt(0) == 'n') {type = 3;}
    }
    public String getconst() {return val;}
    public type totype()
    {
        if(type == 0) return new type("int");
        if(type == 1) return new type("bool");
        if(type == 2) return new type("string");
        else return new type("null");
    }
}