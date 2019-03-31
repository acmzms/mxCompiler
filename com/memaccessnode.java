package com;



class memaccessnode extends calcnode
{
    private calcnode callid;
    private idnode callfunc;
    public memaccessnode(){super();}
    public memaccessnode(calcnode a, idnode b){callid = new calcnode(a); callfunc = new idnode(b);}
    public calcnode retid() {return callid;}
    public idnode retf() {return callfunc;}
}