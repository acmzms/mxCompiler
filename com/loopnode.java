package com;

import java.util.*;

class loopnode extends node {
    private calcnode init;
    private calcnode quit;
    private calcnode incr;
    private blocknode stmt;
    public loopnode() { init = null; quit = null; incr = null; stmt = null; }
    public void setinit(calcnode c) { init = new calcnode(c); }
    public void setquit(calcnode c) { quit = new calcnode(c); }
    public void setincr(calcnode c) { incr = new calcnode(c); }
    public void setstmt(blocknode b) { stmt = new blocknode(b); }
    public calcnode getinit() { return init; }
    public calcnode getquit() { return quit; }
    public calcnode getincr() { return incr; }
    public blocknode getstmt() { return stmt; }
}