package com;

import java.util.*;

class condnode extends node
{
    private calcnode condition;
    private blocknode ifstmt;
    private blocknode elsestmt;
    public condnode(){}
    public condnode(calcnode c, blocknode b) {condition = c; ifstmt = b; elsestmt = null;}
    public condnode(calcnode c, blocknode b1, blocknode b2) {condition = c; ifstmt = b1; elsestmt = b2;}
    public calcnode getcond(){return condition;}
    public blocknode getif(){return ifstmt;}
    public blocknode getelse()
    {
        if(elsestmt != null) {return elsestmt;}
        else return null;
    }
}
