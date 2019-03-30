package com;

import org.antlr.v4.runtime.*;

import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String inFile = null, astOutFile = null, irOutFile = null, nasmOutFile = null;
        InputStream inS;
        PrintStream astOutS, irOutS, nasmOutS;
        //inS = new FileInputStream(inFile);
        inS = System.in;
        //astOutS = new PrintStream(new FileOutputStream(astOutFile));
        //irOutS = new PrintStream(new FileOutputStream(irOutFile));
        //nasmOutS = new PrintStream(new FileOutputStream(nasmOutFile));

        mxCompiler compiler = new mxCompiler();
        try {
            compiler.compile(inS);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
