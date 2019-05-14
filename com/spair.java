package com;

class spair
{
    private String lval;
    private String rval;
    public spair()
    {
        lval = "";
        rval = "";
    }
    public spair(String l, String r)
    {
        lval = l;
        rval = r;
    }
    public String getl() {return lval;}
    public String getr() {return rval;}
    public void setl(String l) {lval = l;}
    public void setr(String r) {rval = r;}
}