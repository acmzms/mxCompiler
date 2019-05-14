package com;

class ipair
{
    private int intv;
    private String strv;
    public boolean t;//t = 0 int 1 string
    public ipair()
    {
        intv = 0;
        strv = "";
        t = false;
    }
    public ipair(int x)
    {
        intv = x;
        t = false;
        strv = "";
    }
    public ipair(String x)
    {
        strv = new String(x);
        t = true;
        intv = 0;
    }
    public boolean gett() {return t;}
    public int getv() {return intv;}
    public String gets() {return strv;}
}