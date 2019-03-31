package com;

import java.util.*;

class binarynode extends calcnode
{
    private calcnode lval;
    private calcnode rval;
    private int op;// 0 / 1 * 2 % 3 + 4 - 5 << 6 >> 7 >= 8 > 9 < 10 <= 11 != 12 == 13 & 14 ^ 15 | 16 && 17 ||
    public binarynode() {super();}
    public void setlval(calcnode c) {lval = c;}
    public void setrval(calcnode c) {rval = c;}
    public calcnode getlval() {return lval;}
    public calcnode getrval() {return rval;}
    public void setop(int x) {op = x;}
    public int getop() {return op;}
}
