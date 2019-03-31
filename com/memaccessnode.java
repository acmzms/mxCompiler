package com;



class memaccessnode extends calcnode
{
    private calcnode callid;
    private idnode callfunc;
    public memaccessnode(){super();}
    public memaccessnode(calcnode a, idnode b){callid = a; callfunc = b;}
    public calcnode retid() {return callid;}
    public idnode retf() {return callfunc;}
}