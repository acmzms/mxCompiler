package com;

class retnode extends ctrlnode
{
    private calcnode retval;
    public retnode() {super(); retval = null;}
    public retnode(calcnode c) {super(); retval = c;}
    public calcnode getr() {return retval;}
}