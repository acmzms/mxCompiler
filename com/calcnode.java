package com;

import java.util.*;

class calcnode extends node
{
    private type typename;
    private boolean isleft;
    public calcnode() {typename = new type("undefined"); isleft = true;}
    public String getname() {return typename.gettypename();}
    public type gettype() {return typename;}
    public boolean getleft() {return isleft;}
    public void setleft(boolean b) {isleft = b;}
    public void setname(String t) {typename = new type(t);}
    public void settype(type t) {typename = new type(t);}
    public calcnode(calcnode c){typename = c.gettype(); isleft = getleft();}
}
