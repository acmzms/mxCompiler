package com;


import org.antlr.v4.runtime.tree.ParseTree;


import java.util.ArrayList;


class ASTtraverse extends mxBaseVisitor<node>
{
    public ASTtraverse() {}

    @Override
    public node visitProgram(mxParser.ProgramContext ctx)
    {
        int pos = ctx.start.getLine();
        programnode p = new programnode();
        if(ctx.code() != null)
        {
            for(mxParser.CodeContext c : ctx.code())
            {
                node n = visit(c);
                if(n instanceof funcnode ) {p.addfunc((funcnode)n);}
                if(n instanceof classnode ) {p.addclass((classnode)n);}
                if(n instanceof declaration ) {p.adddecl((declaration)n);}
            }
        }
        p.setline(pos);
        return p;
    }


    @Override
    public node visitCode(mxParser.CodeContext ctx)
    {
        if(ctx.function() != null)
        {
            node n = visit(ctx.function());
            return n;
        }
        if(ctx.declaration() != null)
        {
            node n = visit(ctx.declaration());
            return n;
        }
        if(ctx.declclass() != null)
        {
            node n = visit(ctx.declclass());
            return n;
        }
        return new emptynode();
    }

    @Override
    public node visitDeclclass(mxParser.DeclclassContext ctx)
    {
        int pos = ctx.start.getLine();
        String n1 = ctx.Identifier().getText();
        classnode c = new classnode(n1);
        if(ctx.declpair() != null)
        {
            for (mxParser.DeclpairContext t : ctx.declpair()) {
                declaration n2 = (declaration) visit(t);
                c.adddecl(n2.gettyp(), n2.getid());
            }
            for (mxParser.FunctionContext f : ctx.function()) {
                node n2 = visit(f);
                c.addfunc((funcnode) n2);
            }
            for (mxParser.ConstructorContext f : ctx.constructor()) {
                node n2 = visit(f);
                c.addfunc((funcnode) n2);
            }
        }
        c.setline(pos);
        return c;
    }

    @Override
    public node visitConstructor(mxParser.ConstructorContext ctx)
    {
        int pos = ctx.start.getLine();
        int x = ctx.start.getLine();
        String n1 = ctx.Identifier().getText();
        node n2 = visit(ctx.expressionblock());
        funcnode f = new funcnode(n1, (blocknode)n2);
        f.settype(new type(""));
        if(ctx.params() != null)
        {
            spnode n3 = (spnode) visit(ctx.params());
            for(node n : n3.retlist)
            {
                f.addparams(((declaration) n).gettyp(), new idnode(((declaration) n).getid().getid(), x));
            }
        }
        f.setline(pos);
        return f;
    }

    @Override
    public node visitFunction(mxParser.FunctionContext ctx)
    {
        int pos = ctx.start.getLine();
        int x = ctx.start.getLine();
        String n1 = ctx.Identifier().getText();
        node n2 = visit(ctx.expressionblock());
        funcnode f = new funcnode(n1, (blocknode)n2);
        if(ctx.params() != null)
        {
            spnode n3 = (spnode) visit(ctx.params());
            for(node n : n3.retlist)
            {
                f.addparams(((declaration) n).gettyp(), new idnode(((declaration) n).getid().getid(), x));
            }
        }
        if(ctx.typename() == null)
        {
            f.settype(new type("void"));
        }
        else
        {
            node n4 = visit(ctx.typename());
            f.settype((type) n4);
        }
        f.setline(pos);
        return f;
    }

    @Override
    public node visitParams(mxParser.ParamsContext ctx)
    {
        spnode s = new spnode();
        int l = ctx.start.getLine();
        if(ctx.declpair() != null)
        {
            for(mxParser.DeclpairContext t: ctx.declpair())
            {
                node n = visit(t);
                s.retlist.add(new declaration(((declaration)n).gettyp(), new idnode(((declaration) n).getid())));
            }
        }
        return s;
    }

    @Override
    public node visitCall(mxParser.CallContext ctx)
    {
        spnode s = new spnode();
        if(ctx.calculation() != null)
        {
            for(mxParser.CalculationContext t: ctx.calculation())
            {
                node n = visit(t);
                s.retlist.add((calcnode)n);
            }
        }
        return s;
    }

    @Override
    public node visitExpressionblock(mxParser.ExpressionblockContext ctx)
    {
        int pos = ctx.start.getLine();
        blocknode b = new blocknode();
        if(ctx.expression() != null)
        {
            for(mxParser.ExpressionContext t : ctx.expression())
            {
                node n = visit(t);
                if(n instanceof blocknode) {b.addblock((blocknode)n);}
                if(n instanceof calcnode) {b.addcalc((calcnode)n);}
                if(n instanceof condnode) {b.addcond((condnode)n);}
                if(n instanceof loopnode) {b.addloop((loopnode)n);}
                if(n instanceof ctrlnode) {b.addctrl((ctrlnode)n);}
                if(n instanceof declaration) {b.adddecl((declaration)n);}
            }
        }
        b.setline(pos);
        return b;
    }

    @Override
    public node visitExpression(mxParser.ExpressionContext ctx)
    {
        if(ctx.statement() != null)
        {
            return visit(ctx.statement());
        }
        if(ctx.declaration() != null)
        {
            return visit(ctx.declaration());
        }
        else return new emptynode();
    }

    @Override
    public node visitDecls(mxParser.DeclsContext ctx)
    {
        int pos = ctx.start.getLine();
        node n = visit(ctx.declpair());
        n.setline(pos);
        return n;
    }

    @Override
    public node visitDeclplusassign(mxParser.DeclplusassignContext ctx)
    {
        int pos  = ctx.start.getLine();
        declaration d1 = (declaration) visit(ctx.declpair());
        declaration d2 = new declaration(d1);
        if(ctx.calculation() != null)
        {
            calcnode r = (calcnode)visit(ctx.calculation());
            calcnode c = new idnode(d1.getid());
            assignnode a = new assignnode(c, r);
            d2.seta(a);
        }
        if(ctx.Identifier() != null)
        {
            calcnode l = new idnode(d1.getid());
            calcnode r = new idnode(ctx.Identifier().getText(), pos);
            assignnode a = new assignnode(l, r);
            d2.seta(a);
        }
        if(ctx.Constant() != null)
        {
            calcnode l = new idnode(d1.getid());
            calcnode r = new idnode(ctx.Constant().getText(), pos);
            assignnode a = new assignnode(l, r);
            d2.seta(a);
        }
        d2.setline(pos);
        return d2;
    }

    @Override
    public node visitDeclpair(mxParser.DeclpairContext ctx)
    {
        int l = ctx.start.getLine();
        node n1 = visit(ctx.typename());
        String n2 = ctx.Identifier().getText();
        return new declaration((type) n1, new idnode(n2, l));
    }

    @Override
    public node visitArrayvars(mxParser.ArrayvarsContext ctx)
    {
        type t = (type) visit(ctx.typename());
        t.incriter();
        return t;
    }

    @Override
    public node visitVar(mxParser.VarContext ctx)
    {
        if(ctx.Int() != null)
        {
            String s = ctx.Int().getText();
            return new type(s);
        }
        if(ctx.Bool() != null)
        {
            String s = ctx.Bool().getText();
            return new type(s);
        }
        if(ctx.String() != null)
        {
            String s = ctx.String().getText();
            return new type(s);
        }
        if(ctx.Identifier() != null)
        {
            String s = ctx.Identifier().getText();
            return new type(s);
        }
        else return new emptynode();
        //else throw new rubbishcode();
    }

    @Override
    public node visitStatement(mxParser.StatementContext ctx)
    {
        if(ctx.expressionblock() != null) { return visit(ctx.expressionblock()); }
        if(ctx.calculation() != null) { return visit(ctx.calculation()); }
        if(ctx.condition() != null) { return visit(ctx.condition()); }
        if(ctx.control() != null) { return visit(ctx.control()); }
        if(ctx.loop() != null) {return visit(ctx.loop()); }
        else return new emptynode();
    }

    @Override
    public node visitCondition(mxParser.ConditionContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode c = (calcnode) visit(ctx.calculation());
        condnode r = new condnode();
        if(ctx.lstm != null)
        {
            blocknode b1 = (blocknode)visit(ctx.lstm);
            if(ctx.rstm != null)
            {
                blocknode b2 = (blocknode)visit(ctx.rstm);
                r = new condnode(c, b1, b2);
            }
            else if(ctx.rst != null)
            {
                blocknode b2 = new blocknode();
                b2.addnode(visit(ctx.rst));
                r = new condnode(c, b1, b2);
            }
            else
            {
                r = new condnode(c, b1);
            }
        }
        else if(ctx.lst != null)
        {
            blocknode b1 = new blocknode();
            b1.addnode(visit(ctx.lst));
            if(ctx.rstm != null)
            {
                blocknode b2 = (blocknode)visit(ctx.rstm);
                r = new condnode(c, b1, b2);
            }
            else if(ctx.rst != null)
            {
                blocknode b2 = new blocknode();
                b2.addnode(visit(ctx.rst));
                r = new condnode(c, b1, b2);
            }
            else
            {
                r = new condnode(c, b1);
            }
        }
        r.setline(pos);
        return r;
    }

    @Override
    public node visitForstmt(mxParser.ForstmtContext ctx)
    {
        int pos = ctx.start.getLine();
        loopnode l = new loopnode();
        if(ctx.init != null) {l.setinit((calcnode)visit(ctx.init));}
        if(ctx.incr != null) {l.setincr((calcnode)visit(ctx.incr));}
        if(ctx.quit != null) {l.setquit((calcnode)visit(ctx.quit));}
        if(ctx.expressionblock() != null) {l.setstmt((blocknode) visit(ctx.expressionblock()));}
        else if(ctx.expression() != null) {blocknode b = new blocknode(); b.addnode(visit(ctx.expression())); l.setstmt(b);}
        l.setline(pos);
        return l;
    }

    @Override
    public node visitWhilestmt(mxParser.WhilestmtContext ctx)
    {
        int pos = ctx.start.getLine();
        loopnode l = new loopnode();
        l.setquit((calcnode)visit(ctx.calculation()));
        if(ctx.expressionblock() != null) {l.setstmt((blocknode) visit(ctx.expressionblock()));}
        else if(ctx.expression() != null) {blocknode b = new blocknode(); b.addnode(visit(ctx.expression())); l.setstmt(b);}
        l.setline(pos);
        return l;
    }

    @Override
    public node visitRetstmt(mxParser.RetstmtContext ctx)
    {
        int pos = ctx.start.getLine();
        retnode r = new retnode();
        if(ctx.calculation() != null)
        {
            calcnode c = (calcnode)visit(ctx.calculation());
            r = new retnode(c);
        }
        else {r = new retnode();}
        r.setline(pos);
        return r;
    }

    @Override
    public node visitContinue(mxParser.ContinueContext ctx)
    {
        int pos = ctx.start.getLine();
        ctrlnode d = new ctrlnode();
        d.settype(0);
        d.setline(pos);
        return d;
    }

    @Override
    public node visitBreak(mxParser.BreakContext ctx)
    {
        int pos = ctx.start.getLine();
        ctrlnode d = new ctrlnode();
        d.settype(1);
        d.setline(pos);
        return d;
    }

    @Override
    public node visitFunccall(mxParser.FunccallContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode id = (calcnode)visit(ctx.calculation());
        funccallnode f = new funccallnode(id);
        if(ctx.call() != null)
        {
            spnode n = (spnode)visit(ctx.call());
            for(int i = 0;i < n.retlist.size();i++)
            {
                f.addargs((calcnode)n.retlist.get(i));
            }
        }
        f.setline(pos);
        return f;
    }

    @Override
    public node visitArray(mxParser.ArrayContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode a = (calcnode) visit(ctx.lhs);
        calcnode b = (calcnode) visit(ctx.rhs);
        subscriptnode s = new subscriptnode(a, b);
        s.setline(pos);
        return s;
    }

    @Override
    public node visitPrefix(mxParser.PrefixContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode c = (calcnode) visit(ctx.calculation());
        prefixnode p = new prefixnode(c);
        String op = ctx.op.getText();
        if(op.equals("+")) {p.setop(2);}
        if(op.equals("-")) {p.setop(3);}
        if(op.equals("++")) {p.setop(0);}
        if(op.equals("--")) {p.setop(1);}
        if(op.equals("!")) {p.setop(4);}
        if(op.equals("~")) {p.setop(5);}
        p.setline(pos);
        return p;
    }

    @Override
    public node visitNewexpr(mxParser.NewexprContext ctx)
    {
        int pos = ctx.start.getLine();
        int cnt = 0;
        newnode n = new newnode();
        n.settype(((type) visit(ctx.typename())));
        if(ctx.calculation() != null)
        {
            for (mxParser.CalculationContext t : ctx.calculation())
            {
                n.addsz((calcnode)visit(t));
                cnt++;
            }
        }
        int d = (ctx.getChildCount() - 2 - cnt) / 2;
        n.setdim(d);
        n.setline(pos);
        return n;
    }

    @Override
    public node visitNanewexpr(mxParser.NanewexprContext ctx)
    {
        int pos = ctx.start.getLine();
        newnode n = new newnode();
        n.setdim(0);
        n.settype(((type) visit(ctx.typename())));
        n.setline(pos);
        return n;
    }

    @Override
    public node visitBinary(mxParser.BinaryContext ctx)
    {
        //ctx.start.getLine();
        int pos = ctx.start.getLine();
        calcnode c1 = (calcnode)visit(ctx.lhs);
        calcnode c2 = (calcnode)visit(ctx.rhs);
        binarynode b = new binarynode();
        b.setlval(c1);
        b.setrval(c2);
        String s = ctx.op.getText();
        // 0 / 1 * 2 % 3 + 4 - 5 << 6 >> 7 >= 8 > 9 < 10 <= 11 != 12 == 13 & 14 ^ 15 | 16 && 17 ||
        if(s.equals("/")) {b.setop(0);}
        if(s.equals("*")) {b.setop(1);}
        if(s.equals("%")) {b.setop(2);}
        if(s.equals("+")) {b.setop(3);}
        if(s.equals("-")) {b.setop(4);}
        if(s.equals("<<")) {b.setop(5);}
        if(s.equals(">>")) {b.setop(6);}
        if(s.equals(">=")) {b.setop(7);}
        if(s.equals(">")) {b.setop(8);}
        if(s.equals("<")) {b.setop(9);}
        if(s.equals("<=")) {b.setop(10);}
        if(s.equals("!=")) {b.setop(11);}
        if(s.equals("==")) {b.setop(12);}
        if(s.equals("&")) {b.setop(13);}
        if(s.equals("^")) {b.setop(14);}
        if(s.equals("|")) {b.setop(15);}
        if(s.equals("&&")) {b.setop(16);}
        if(s.equals("||")) {b.setop(17);}
        b.setline(pos);
        return b;
    }

    @Override
    public node visitClassfunc(mxParser.ClassfuncContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode c = (calcnode)visit(ctx.calculation());
        int l = ctx.start.getLine();
        idnode f = new idnode((ctx.Identifier().getText()), l);
        memaccessnode m = new memaccessnode(c, f);
        m.setline(pos);
        return m;
    }

    @Override
    public node visitSuffix(mxParser.SuffixContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode c = (calcnode)visit(ctx.calculation());
        suffixnode p = new suffixnode(c);
        String op = ctx.op.getText();
        if(op.equals("++")) {p.setop(0);}
        if(op.equals("--")) {p.setop(1);}
        p.setline(pos);
        return p;
    }

    @Override
    public node visitSubexpr(mxParser.SubexprContext ctx)
    {
        return visit(ctx.calculation());
    }

    @Override
    public node visitPrimary(mxParser.PrimaryContext ctx)
    {
        int l = ctx.start.getLine();
        if(ctx.Identifier() != null)
        {
            return new idnode(ctx.Identifier().getText(), l);
        }
        if(ctx.This() != null)
        {
            return new thisnode();
        }
        if(ctx.Constant() != null)
        {
            return new constnode(ctx.Constant().getText());
        }
        else return new emptynode();
    }

    @Override
    public node visitAssign(mxParser.AssignContext ctx)
    {
        int pos = ctx.start.getLine();
        calcnode l = (calcnode) visit(ctx.lhs);
        calcnode r = (calcnode) visit(ctx.rhs);
        assignnode a = new assignnode(l, r);
        a.setline(pos);
        return a;
    }
}
