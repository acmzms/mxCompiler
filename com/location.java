package com;

import org.antlr.v4.runtime.ParserRuleContext;

import org.antlr.v4.runtime.Token;

public class location {
    private final int line, column;

    public location(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public location(Token token) {
        this.line = token.getLine();
        this.column = token.getCharPositionInLine();
    }

    static public location fromCtx(ParserRuleContext ctx) {
        return new location(ctx.getStart());
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return String.format("(%d:%d)", line, column);
    }
}