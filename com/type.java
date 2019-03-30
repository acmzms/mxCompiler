package com;

class type extends node
{
    private String typename;
    private int iteration;
    public type() {typename = ""; iteration = 0;}
    public type(String s) {typename = s; iteration = 0;}
    public type(type t) {typename = t.typename; iteration = t.iteration;}
    public int getiteration() { return iteration; }
    public String gettypename() { return typename; }
    public void setiteration(int i) { iteration = i; }
    public void incriter() {iteration++;}
    public void decriter() {iteration--;}
    public void settypename(String s) { typename = s; }
    public String tostring()
    {
        String s = typename;
        for(int i = 0;i < iteration;i++)
        {
            s = s.concat("[]");
        }
        return s;
    }
    public type totype(String s)
    {
        return new type();
        //todo
    }
    public boolean isequal(type t)
    {
        if(typename.equals(t.typename) && iteration == t.iteration) {return true;}
        return false;
    }
}