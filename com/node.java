package com;

import org.antlr.v4.runtime.ParserRuleContext;

abstract class node implements Comparable<node>
{
    //protected location loc;
    protected Integer line;
    public node() {line = 0;}
    public void setline(int x) {line = x;}
    public int getline() {return line;}
    public int compareTo(node o)
    {
        if(line <= o.getline())
        {
            return -1;
        }
        return 1;
    }
}
