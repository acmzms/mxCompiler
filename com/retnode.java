package com;

class retnode extends ctrlnode
{
    private calcnode retval;
    public retnode() {super(); retval = null;}
    public retnode(calcnode c) {super(); retval = new calcnode((c));}
    public calcnode getr() {return retval;}
}