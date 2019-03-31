package com;

import java.util.*;

class prefixnode extends calcnode
{
    private int op; // ++ 0, -- 1, + 2, - 3, ! 4, ~ 5;
    private calcnode expr;
    public prefixnode() {super();}
    public prefixnode(calcnode c) {super(); expr = c;}
    public void setop(int x) {op = x;}
    public calcnode getexpr(){return expr;}
}