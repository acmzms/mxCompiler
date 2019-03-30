package com;


import org.antlr.v4.runtime.tree.ParseTree;


import java.util.ArrayList;


class ASTtraverse extends mxBaseVisitor<node>
{
    public ASTtraverse() {}

    @Override
    public node visitProgram(mxParser.ProgramContext ctx)
    {
        programnode p = new programnode();
        if(ctx.code() != null)
        {
            for(mxParser.CodeContext c : ctx.code())
            {
                node n = visit(c);
                if(n instanceof funcnode ) {p.addfunc((funcnode)n);}
                if(n instanceof classnode ) {p.addclass((classnode)n);}
                if(n instanceof declaration ){p.adddecl((declaration)n);}
            }
        }
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
        String n1 = ctx.Identifier().getText();
        classnode c = new classnode(n1);
        if(ctx.declpair() != null)
        {
            for (mxParser.DeclpairContext t : ctx.declpair()) {
                node n2 = visit(t);
                c.adddecl(n2.getval(), n2.getinfo());
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
        return c;
    }

    @Override
    public node visitConstructor(mxParser.ConstructorContext ctx)
    {
        node n1 = visit(ctx.Identifier());
        node n2 = visit(ctx.expressionblock());
        funcnode f = new funcnode(n1.getval(), (blocknode)n2);
        f.settype("");
        f.settype("");
        if(ctx.params() != null)
        {
            spnode n3 = (spnode) visit(ctx.params());
            for(node n : n3.retlist)
            {
                f.addparams(n.getval(), n.getinfo());
            }
        }
        return f;
    }

    @Override
    public node visitFunction(mxParser.FunctionContext ctx)
    {
        node n1 = visit(ctx.Identifier());
        node n2 = visit(ctx.expressionblock());
        funcnode f = new funcnode(n1.getval(), (blocknode)n2);
        if(ctx.params() != null)
        {
            spnode n3 = (spnode) visit(ctx.params());
            for(node n : n3.retlist)
            {
                f.addparams(n.getval(), n.getinfo());
            }
        }
        if(ctx.typename() == null)
        {
            f.settype("Void");
        }
        else
        {
            node n4 = visit(ctx.typename());
            f.settype(n4.getval());
        }
        return f;
    }

    @Override
    public node visitParams(mxParser.ParamsContext ctx)
    {
        spnode s = new spnode();
        if(ctx.declpair() != null)
        {
            for(mxParser.DeclpairContext t: ctx.declpair())
            {
                node n = visit(t);
                s.retlist.add(new declaration(n.getval(), new idnode(n.getinfo())));
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
                s.retlist.add(new calcnode((calcnode)n));
            }
        }
        return s;
    }

    @Override
    public node visitExpressionblock(mxParser.ExpressionblockContext ctx)
    {
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
        return visit(ctx.declpair());
    }

    @Override
    public node visitDeclplusassign(mxParser.DeclplusassignContext ctx)
    {
        spnode s = new spnode();
        node d1 = visit(ctx.declpair());
        s.retlist.add(d1);
        if(ctx.calculation() != null)
        {
            calcnode c = (calcnode)visit(ctx.calculation());
            s.retlist.add(c);
        }
        if(ctx.Identifier() != null)
        {
            String str = ctx.Identifier().getText();
            calcnode r = new idnode(((declaration)d1).getid());
            calcnode l = new idnode(ctx.Identifier().getText());
            assignnode a = new assignnode(l, r);
            s.retlist.add(a);
        }
        if(ctx.Constant() != null)
        {
            String str = ctx.Identifier().getText();
            calcnode r = new idnode(((declaration)d1).getid());
            calcnode l = new idnode(ctx.Constant().getText());
            assignnode a = new assignnode(l, r);
            s.retlist.add(a);
        }
        return s;
    }

    @Override
    public node visitDeclpair(mxParser.DeclpairContext ctx)
    {
        node n = visit(ctx.typename());
        String s1 = ((type) n).tostring();
        String s2 = ctx.Identifier().getText();
        return new declaration(s1, new idnode(s2));
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
        calcnode c = (calcnode) visit(ctx.calculation());
        if(ctx.lstm != null)
        {
            blocknode b1 = (blocknode)visit(ctx.lstm);
            if(ctx.rstm != null)
            {
                blocknode b2 = (blocknode)visit(ctx.rstm);
                return new condnode(c, b1, b2);
            }
            else if(ctx.rst != null)
            {
                blocknode b2 = new blocknode();
                b2.addnode(visit(ctx.rst));
                return new condnode(c, b1, b2);
            }
            else
            {
                return new condnode(c, b1);
            }
        }
        else if(ctx.lst != null)
        {
            blocknode b1 = new blocknode();
            b1.addnode(visit(ctx.lst));
            if(ctx.rstm != null)
            {
                blocknode b2 = (blocknode)visit(ctx.rstm);
                return new condnode(c, b1, b2);
            }
            else if(ctx.rst != null)
            {
                blocknode b2 = new blocknode();
                b2.addnode(visit(ctx.rst));
                return new condnode(c, b1, b2);
            }
            else
            {
                return new condnode(c, b1);
            }
        }
        else return new emptynode();
    }

    @Override
    public node visitForstmt(mxParser.ForstmtContext ctx)
    {
        loopnode l = new loopnode();
        if(ctx.init != null) {l.setinit((calcnode)visit(ctx.init));}
        if(ctx.incr != null) {l.setincr((calcnode)visit(ctx.incr));}
        if(ctx.quit != null) {l.setquit((calcnode)visit(ctx.quit));}
        if(ctx.expressionblock() != null) {l.setstmt((blocknode) visit(ctx.expressionblock()));}
        else if(ctx.expression() != null) {blocknode b = new blocknode(); b.addnode(visit(ctx.expression())); l.setstmt(b);}
        return l;
    }

    @Override
    public node visitWhilestmt(mxParser.WhilestmtContext ctx)
    {
        loopnode l = new loopnode();
        l.setquit((calcnode)visit(ctx.calculation()));
        if(ctx.expressionblock() != null) {l.setstmt((blocknode) visit(ctx.expressionblock()));}
        else if(ctx.expression() != null) {blocknode b = new blocknode(); b.addnode(visit(ctx.expression())); l.setstmt(b);}
        return l;
    }

    @Override
    public node visitRetstmt(mxParser.RetstmtContext ctx)
    {
        if(ctx.calculation() != null) {calcnode c = new calcnode((calcnode)visit(ctx.calculation())); return new retnode(c);}
        else return new retnode();
    }

    @Override
    public node visitContinue(mxParser.ContinueContext ctx)
    {
        ctrlnode d = new ctrlnode();
        d.settype(0);
        return d;
    }

    @Override
    public node visitBreak(mxParser.BreakContext ctx)
    {
        ctrlnode d = new ctrlnode();
        d.settype(1);
        return d;
    }

    @Override
    public node visitFunccall(mxParser.FunccallContext ctx)
    {
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
        return f;
    }

    @Override
    public node visitArray(mxParser.ArrayContext ctx)
    {
        idnode a = (idnode) visit(ctx.lhs);
        calcnode b = (calcnode) visit(ctx.rhs);
        return new subscriptnode(a, b);
    }

    @Override
    public node visitPrefix(mxParser.PrefixContext ctx)
    {
        calcnode c = new calcnode((calcnode) visit(ctx.calculation()));
        prefixnode p = new prefixnode(c);
        String op = ctx.op.getText();
        if(op.equals("+")) {p.setop(2);}
        if(op.equals("-")) {p.setop(3);}
        if(op.equals("++")) {p.setop(0);}
        if(op.equals("--")) {p.setop(1);}
        if(op.equals("!")) {p.setop(4);}
        if(op.equals("~")) {p.setop(5);}
        return p;
    }

    @Override
    public node visitNewexpr(mxParser.NewexprContext ctx)
    {
        int d = (ctx.getChildCount() - 1) / 2;
        newnode n = new newnode();
        n.setdim(d);
        n.settype(((type) visit(ctx.typename())).tostring());
        if(ctx.calculation() != null)
        {
            for (mxParser.CalculationContext t : ctx.calculation())
            {
                n.addsz((calcnode)visit(t));
            }
        }
        return n;
    }

    @Override
    public node visitBinary(mxParser.BinaryContext ctx)
    {
        calcnode c1 = new calcnode((calcnode)visit(ctx.lhs));
        calcnode c2 = new calcnode((calcnode)visit(ctx.rhs));
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
        return b;
    }

    @Override
    public node visitClassfunc(mxParser.ClassfuncContext ctx)
    {
        idnode c = new idnode((idnode)visit(ctx.calculation()));
        idnode f = new idnode((idnode)visit(ctx.Identifier()));
        return new memaccessnode(c, f);
    }

    @Override
    public node visitSuffix(mxParser.SuffixContext ctx)
    {
        calcnode c = new calcnode((calcnode) visit(ctx.calculation()));
        suffixnode p = new suffixnode(c);
        String op = ctx.op.getText();
        if(op.equals("++")) {p.setop(0);}
        if(op.equals("--")) {p.setop(1);}
        return p;
    }

    @Override
    public node visitSubexpr(mxParser.SubexprContext ctx)
    {
        return new calcnode((calcnode)visit(ctx.calculation()));
    }

    @Override
    public node visitPrimary(mxParser.PrimaryContext ctx)
    {
        if(ctx.Identifier() != null)
        {
            idnode i = new idnode(ctx.Identifier().getText());
            i.setval(i.getid());
            return i;
        }
        if(ctx.This() != null)
        {
            return new thisnode();
        }
        if(ctx.Constant() != null)
        {
            constnode c =  new constnode(ctx.Constant().getText());
            c.setval(c.getconst());
            return c;
        }
        else return new emptynode();
    }

    @Override
    public node visitAssign(mxParser.AssignContext ctx)
    {
        calcnode l = new calcnode((calcnode) visit(ctx.lhs));
        calcnode r = new calcnode((calcnode) visit(ctx.rhs));
        return new assignnode(l, r);
    }
}