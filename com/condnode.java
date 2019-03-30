package com;

import java.util.*;

class condnode extends node
{
    private calcnode condition;
    private blocknode ifstmt;
    private blocknode elsestmt;
    public condnode(){}
    public condnode(calcnode c, blocknode b) {condition = new calcnode(c); ifstmt = new blocknode(b); elsestmt = null;}
    public condnode(calcnode c, blocknode b1, blocknode b2) {condition = new calcnode(c); ifstmt = new blocknode(b1); elsestmt = new blocknode(b2);}
    public calcnode getcond(){return condition;}
    public blocknode getif(){return ifstmt;}
    public blocknode getelse()
    {
        if(elsestmt != null) {return elsestmt;}
        else return null;
    }
}
