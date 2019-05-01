package com;

import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.*;

class mxCompiler
{
    private ASTscope astscope;
    private ASTsemantic astsemantic;
    private ASTtraverse asttraverse;
    public mxCompiler() {astscope = new ASTscope(); astsemantic = new ASTsemantic(); asttraverse = new ASTtraverse();}
    public void compile(InputStream inS) throws Exception//PrintStream astOutS, PrintStream irOutS, PrintStream nasmOutS) throws Exception
    {
        astscope = new ASTscope();
        astsemantic = new ASTsemantic();
        asttraverse = new ASTtraverse();
        ANTLRInputStream input = new ANTLRInputStream(inS);
        mxLexer lexer = new mxLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mxParser parser = new mxParser(tokens);
        //parser.setErrorHandler(new BailErrorStrategy());
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());
        ParseTree tree = parser.program();
        System.out.println("semantic:");
        ASTtraverse evalByVisitor = new ASTtraverse();
        node n = evalByVisitor.visit(tree);
        astscope.visitProgramnode((programnode) n);
        astsemantic.acceptProgramnode((programnode) n);
        System.out.println("IR traverse:");
    }
}