package Mxstar;
import java.io.*;
import Mxstar.AST.*;
import Mxstar.IR.*;
import Mxstar.Parser.*;
import Mxstar.Symbol.*;
import Mxstar.Worker.*;
import Mxstar.Worker.BackEnd.*;
import Mxstar.Worker.FrontEnd.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import static java.lang.System.exit;
public class MxstarCompiler {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("a.mxs");
        ANTLRInputStream ais = new ANTLRInputStream(is);
        MxstarLexer mxstarLexer = new MxstarLexer(ais);
        CommonTokenStream tokens = new CommonTokenStream(mxstarLexer);
        MxstarParser parser = new MxstarParser(tokens);
        ErrorRecorder errorRecorder = new ErrorRecorder();
        parser.removeErrorListeners();
        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener(errorRecorder);
        parser.addErrorListener(syntaxErrorListener);
        ParseTree parseTree = parser.compilationUnit();
       	if(errorRecorder.errorOccured()) {
            System.err.println("Compile Error.");
            exit(1);
        }
        System.err.println("Parser Done.");
        AstBuilder astBuilder = new AstBuilder(errorRecorder);
        astBuilder.visit(parseTree);
        if(errorRecorder.errorOccured()) {
            System.err.println("Compile Error.");
            exit(1);
        }
        System.err.println("ASTBuilder Done.");
        CompilationUnit compilationUnit = astBuilder.getCompilationUnit();
        SymbolTableBuilder symbolTableBuilder = new SymbolTableBuilder(errorRecorder);
        compilationUnit.accept(symbolTableBuilder);
        if(errorRecorder.errorOccured()) {
            System.err.println("Compile Error.");
            exit(1);
        }
        System.err.println("SymbolTableBuilder Done.");
        GlobalSymbolTable globalSymbolTable = symbolTableBuilder.globalSymbolTable;
        SemanticChecker semanticChecker = new SemanticChecker(globalSymbolTable, errorRecorder);
        compilationUnit.accept(semanticChecker);
        if(errorRecorder.errorOccured()) {
            System.err.println("Compile Error.");
            exit(1);
        }
        System.err.println("SemanticChecker Done.");
		
		RegisterSet.init();
        IRBuilder irBuilder = new IRBuilder(globalSymbolTable);
        compilationUnit.accept(irBuilder);
        IRProgram irProgram = irBuilder.irProgram;
        System.err.println("IRBuilder Done.");
        
        {
        	IRPrinter irPrinter = new IRPrinter();
        	irPrinter.visit(irProgram);
        	irPrinter.printTo(System.err);
       	}

        IRCorrector irCorrector = new IRCorrector();
        irProgram.accept(irCorrector);
        System.err.println("IRCorrector Done.");
        
        {
            IRPrinter irPrinter = new IRPrinter();
            irPrinter.visit(irProgram);
            irPrinter.printTo(System.err);
        }
        
        SimpleGraphAllocator simpleGraphAllocator = new SimpleGraphAllocator(irProgram);
        simpleGraphAllocator.run();
        System.err.println("Allocator Done.");
        
        {
            IRPrinter irPrinter = new IRPrinter();
            irPrinter.visit(irProgram);
            irPrinter.printTo(System.err);
        }
        
        StackFrameBuilder stackFrameBuilder = new StackFrameBuilder(irProgram);
        stackFrameBuilder.run();
        System.err.println("StackFrameBuilder Done.");
        
        {
        	IRPrinter irPrinter = new IRPrinter();
            irPrinter.showNasm = true;
            irPrinter.showHeader = false;
            irPrinter.visit(irProgram);
            irPrinter.printTo(System.err);
        }

		IRPrinter irPrinter = new IRPrinter();
        irPrinter.showNasm = true;
        irPrinter.showHeader = true;
        irPrinter.visit(irProgram);
        irPrinter.printTo(new PrintStream("a.asm"));

        exit(0);
    }
}
