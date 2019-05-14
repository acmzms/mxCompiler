package com;

class varlistmem
{
    private String id;
    private int rareg;
    private scope pos;
    private int n_reg;
    private int s_typ;
    private int hsize;
    private int loopl;
    public varlistmem()// s = 0 global 1 stack 2 heap
    {
        id = null;
        pos = null;
        rareg = -1;
        n_reg = -1;
        s_typ = 0;
        hsize = 0;
        loopl = 0;
    }
    public varlistmem(String a, scope b, int c, int d, int e, int f)
    {
        id = a;
        rareg = -1;
        pos = b;
        n_reg = c;
        s_typ = d;
        hsize = e;
        loopl = f;
    }
    public String reta() {return id;}
    public scope retb() {return pos;}
    public int retc() {return n_reg;}
    public int retd() {return s_typ;}
    public int rete() {return hsize;}
    public void sete(int x) {hsize = x;}
    public int retf() {return loopl;}
    public void setr(int s) {rareg = s;}
    public int retr() {return rareg;}
}