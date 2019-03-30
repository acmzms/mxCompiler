package com;

import org.antlr.v4.runtime.ParserRuleContext;

abstract class node
{
    //protected location loc;
    public node() {}
    private String nodeid;
    public String getval() { return nodeid; }
    public void setval(String s) { nodeid = s; }
    private String info;
    public String getinfo() { return info; }
    public void setinfo(String s) { info = s; }
    //abstract void accept(ASTVisitor visitor)
}
