package com;

import java.util.*;

class subscriptnode extends calcnode
{
    private idnode arrayid;
    private calcnode dlt;
    public subscriptnode() {super();}
    public subscriptnode(idnode i, calcnode d) {arrayid = new idnode(i); dlt = new calcnode((d));}
    public idnode retid() {return arrayid;}
    public calcnode retdlt() {return dlt;}
}