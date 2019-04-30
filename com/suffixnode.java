package com;

import java.util.*;

class suffixnode extends calcnode
{
    private int op; // ++ 0, -- 1;
    private calcnode expr;
    public suffixnode() {super();}
    public suffixnode(calcnode c) {super(); expr = c;}
    public void setop(int x) {op = x;}
    public int getop() {return op;}
    public calcnode getexpr(){return expr;}
}
