package com;

import java.util.*;

class subscriptnode extends calcnode
{
    private calcnode arrayid;
    private calcnode dlt;
    public subscriptnode() {super();}
    public subscriptnode(calcnode i, calcnode d) {arrayid = new calcnode(i); dlt = new calcnode((d));}
    public calcnode retid() {return arrayid;}
    public calcnode retdlt() {return dlt;}
}