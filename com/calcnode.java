package com;

import java.util.*;

class calcnode extends node
{
    private boolean isleft;
    private type ctype;
    public calcnode() {isleft = true;}
    public boolean getleft() {return isleft;}
    public void setleft(boolean b) {isleft = b;}
    public calcnode(calcnode c){isleft = getleft();}
    public type gettype() {return ctype;}
    public void settype(type t) {ctype = t;}
}
