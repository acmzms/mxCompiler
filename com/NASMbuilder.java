package com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class NASMbuilder
{
    private ArrayList<CFGnode> cfg;
    private ArrayList<varlistmem> va;
    private HashMap<spair, CFGnode> fn;
    private ArrayList<String> oc;
    private ArrayList<String> ed;
    private HashMap<varlistmem, Integer> ml;
    private int sl;
    private int vn;
    private Builtin bt;
    public NASMbuilder(ArrayList<CFGnode> a, ArrayList<varlistmem> b, HashMap<spair, CFGnode> c)
    {
        cfg = a; va = b; fn = c; vn = 0; sl = 0;
        oc = new ArrayList<>();
        ed = new ArrayList<>();
        ml = new HashMap<>();
        bt = new Builtin();
    }
    public varlistmem find(int x)
    {
        for(varlistmem v : va)
        {
            if(v.retc() == x)
            {
                return v;
            }
        }
        return null;
    }
    public void printcmd()
    {
        System.out.println(bt.info);
        oc.add("SECTION .data   align=4 noexecute");
        for(String i : oc) {System.out.println(i);}
        for(String i : ed) {System.out.println(i);}
        System.out.println(bt.ed);
    }
    public String allocreg(varlistmem v)
    {
        if(v.retc() == 0) return "rax";
        if(v.retd() == 2) return "@ [" + v.rete() + "]";
        else
        {
            switch(v.retr())
            {
                case 0:
                    return "rcx";
                case 1:
                    return "rdx";
                case 2:
                    return "rbx";
                case 3:
                    return "rsi";
                case 4:
                    return "rdi";
                case 5:
                    return "r8";
                case 6:
                    return "r9";
                case 7:
                    return "r10";
                case 8:
                    return "r11";
                case 9:
                    return "r12";
                case 10:
                    return "r13";
                case 11:
                    return "r14";
                default:
                    return null;
            }
        }
    }
    public int allocmem()
    {
        vn = vn + 8;
        oc.add("\tpush 0");
        sl++;
        //oc.add("\tsub rsp 8");
        return vn;
    }
    private void binary(CFGlist d, String s)
    {
        String x1 = allocreg(find(d.retreg().get(0)));
        String x2 = allocreg(find(d.retreg().get(1)));
        String x3 = allocreg(find(d.retreg().get(2)));
        if(x1 == null)
        {
            oc.add("\tmove r15 0");
            if(x2 == null)
            {
                int y2;
                if(ml.containsKey(find(d.retreg().get(1)))) {y2 = ml.get(find(d.retreg().get(1)));}
                else {y2 = allocmem(); ml.put(find(d.retreg().get(1)), y2);}
                oc.add("\t" + s + " r15 qword [rbp - " + y2 + "]");
            }
            else
            {
                oc.add("\t" + s + " r15 " + x2);
            }
            if(x3 == null)
            {
                int y3;
                if(ml.containsKey(find(d.retreg().get(2)))) {y3 = ml.get(find(d.retreg().get(2)));}
                else {y3 = allocmem(); ml.put(find(d.retreg().get(2)), y3);}
                oc.add("\t" + s + " r15 qword [rbp - " + y3 + "]");
            }
            else
            {
                oc.add("\t" + s + " r15 " + x3);
            }
            int y1;
            if(ml.containsKey(find(d.retreg().get(1)))) {y1 = ml.get(find(d.retreg().get(1)));}
            else {y1 = allocmem(); ml.put(find(d.retreg().get(1)), y1);}
            oc.add("\tmove qword [rbp - " + y1 + "] r15");
        }
        else
        {
            oc.add("\tmove " + x1 + " 0");
            if(x2 == null)
            {
                int y2;
                if(ml.containsKey(find(d.retreg().get(1)))) {y2 = ml.get(find(d.retreg().get(1)));}
                else {y2 = allocmem(); ml.put(find(d.retreg().get(1)), y2);}
                oc.add("\t" + s + " " + x1 + " qword [rbp - " + y2 + "]");
            }
            else
            {
                oc.add("\t" + s + " " + x1 + " " + x2);
            }
            if(x3 == null)
            {
                int y3;
                if(ml.containsKey(find(d.retreg().get(2)))) {y3 = ml.get(find(d.retreg().get(2)));}
                else {y3 = allocmem(); ml.put(find(d.retreg().get(2)), y3);}
                oc.add("\t" + s + " " + x1 + " qword [rbp - " + y3 + "]");
            }
            else
            {
                oc.add("\t" + s + " " + x1 + " " + x3);
            }
        }
    }
    private void fill(String x, String f, int i)
    {
        if(x == null)
        {
            int y;
            if(ml.containsKey(find(i))) {y = ml.get(find(i));}
            else {y = allocmem(); ml.put(find(i), y);}
            oc.add("\tmove " + f +" qword [rbp - " + y + "]");
        }
        else
        {
            oc.add("\tmove " + f + " " + x);
        }
    }
    public void generate()
    {
        for(CFGnode c : cfg)
        {

            String s = "%" + c.geti() + ":";
            oc.add(s);
            for(CFGlist d : c.getl())
            {
                boolean flag = false;
                Stack<String> pt = new Stack<>();
                if(fn.values().contains(c))
                {
                    flag = true;
                    for (int i : d.getlv())
                    {
                        switch (i)
                        {
                            case 2:
                                oc.add("\tpush rbx");
                                pt.push("rbx");
                                break;
                            case 9:
                                oc.add("\tpush r12");
                                pt.push("r12");
                                break;
                            case 10:
                                oc.add("\tpush r13");
                                pt.push("r13");
                                break;
                            case 11:
                                oc.add("\tpush r14");
                                pt.push("r14");
                                break;
                        }
                    }
                    oc.add("\tpush rbp");
                    pt.push("rbp");
                }
                switch (d.gettyp())
                {
                    case "ret":
                        oc.add("\tret");
                        break;
                    case "jump":
                        int l = d.retreg().get(0);
                        oc.add("\tjmp %" + l);
                        break;
                    case "br":
                        String r = allocreg(find(d.retreg().get(0)));
                        int r1 = d.retreg().get(1);
                        int r2 = d.retreg().get(2);
                        oc.add("\tcmp " + r + 0);
                        oc.add("\tjnz %" + r1);
                        oc.add("\tjmp %" + r2);
                    case "store":
                        String p1 = allocreg(find(d.retreg().get(2)));
                        String p2 = allocreg(find(d.retreg().get(1)));
                        if(p1 == null) {
                            int q1;
                            if(ml.containsKey(find(d.retreg().get(2)))) {q1 = ml.get(find(d.retreg().get(2)));}
                            else {q1 = allocmem(); ml.put(find(d.retreg().get(2)), q1);}
                            oc.add("\tmove r15 qword [rbp - " + q1 + "]");
                            if (p2 == null)
                            {
                                int q2;
                                if(ml.containsKey(find(d.retreg().get(1)))) {q2 = ml.get(find(d.retreg().get(1)));}
                                else {q2 = allocmem(); ml.put(find(d.retreg().get(1)), q2);}
                                oc.add("\tmove rax qword [rbp - " + q2 + "]");
                                oc.add("\tmove qword [rax] r15");
                            }
                            else
                            {
                                oc.add("\tmove qword [" + p2 + "] r15");
                            }
                        }
                        else
                        {
                            if (p2 == null)
                            {
                                int q2;
                                if(ml.containsKey(find(d.retreg().get(1)))) {q2 = ml.get(find(d.retreg().get(1)));}
                                else {q2 = allocmem(); ml.put(find(d.retreg().get(1)), q2);}
                                oc.add("\tmove rax qword [rbp - " + q2 + "]");
                                oc.add("\tmove qword [rax] " + p1);
                            }
                            else
                            {
                                oc.add("\tmove qword [" + p2 + "]" + p1);
                            }
                        }
                        break;
                    case "load":
                        p1 = allocreg(find(d.retreg().get(0)));
                        p2 = allocreg(find(d.retreg().get(2)));
                        if(p1 == null)
                        {
                            int q1;
                            if(ml.containsKey(find(d.retreg().get(0)))) {q1 = ml.get(find(d.retreg().get(0)));}
                            else {q1 = allocmem(); ml.put(find(d.retreg().get(0)), q1);}
                            if(p2 == null)
                            {
                                int q2;
                                if(ml.containsKey(find(d.retreg().get(2)))) {q2 = ml.get(find(d.retreg().get(2)));}
                                else {q2 = allocmem(); ml.put(find(d.retreg().get(2)), q2);}
                                oc.add("\tmove rax qword [rbp - " + q2 + "]");
                                oc.add("\tmove r15 qword [rax]");
                            }
                            else
                            {
                                oc.add("\tmove r15 qword [" + p2 + "]");
                            }
                            oc.add("\tmove qword [rbp - " + q1 + "] r15");
                        }
                        else
                        {
                            if(p2 == null)
                            {
                                int q2;
                                if(ml.containsKey(find(d.retreg().get(2)))) {q2 = ml.get(find(d.retreg().get(2)));}
                                else {q2 = allocmem(); ml.put(find(d.retreg().get(2)), q2);}
                                oc.add("\tmove rax qword [rbp - " + q2 + "]");
                                oc.add("\tmove r15 qword [rax]");
                            }
                            else
                            {
                                oc.add("\tmove r15 qword [" + p2 + "]");
                            }
                            oc.add("\tmove" + p1 + "r15");
                        }
                    case "alloc":
                        oc.add("\tpush rdi");
                        String m1 = allocreg(find(d.retreg().get(1)));
                        if(m1 == null)
                        {
                            int n;
                            if(ml.containsKey(find(d.retreg().get(1)))) {n = ml.get(find(d.retreg().get(1)));}
                            else {n = allocmem(); ml.put(find(d.retreg().get(1)), n);}
                            oc.add("\tmove rdi qword[rbp - " + n + "]");
                        }
                        else
                        {
                            oc.add("\tmove rdi " + m1);
                        }
                        oc.add("\tcall malloc");
                        String m2 = allocreg(find(d.retreg().get(0)));
                        if(m2 == null)
                        {
                            int n;
                            if(ml.containsKey(find(d.retreg().get(0)))) {n = ml.get(find(d.retreg().get(0)));}
                            else {n = allocmem(); ml.put(find(d.retreg().get(0)), n);}
                            oc.add("\tmove qword [rbp - " + n + "] rax");
                        }
                        else
                        {
                            oc.add("\tmove " + m2 + " rax");
                        }
                        oc.add("\tpop");
                        break;
                    case "call":
                        Stack<String> ps = new Stack<>();
                        for(int i : d.getlv())
                        {
                            switch (i)
                            {
                                case 0:
                                    oc.add("\tpush rcx");
                                    ps.push("rcx");
                                    break;
                                case 1:
                                    oc.add("\tpush rdx");
                                    ps.push("rdx");
                                    break;
                                case 3:
                                    oc.add("\tpush rsi");
                                    ps.push("rsi");
                                    break;
                                case 4:
                                    oc.add("\tpush rdi");
                                    ps.push("rdi");
                                    break;
                                case 5:
                                    oc.add("\tpush r8");
                                    ps.push("r8");
                                    break;
                                case 6:
                                    oc.add("\tpush r9");
                                    ps.push("r9");
                                    break;
                                case 7:
                                    oc.add("\tpush r10");
                                    ps.push("r10");
                                    break;
                                case 8:
                                    oc.add("\tpush r11");
                                    ps.push("r11");
                                    break;
                            }
                        }
                        int sw = 0;
                        int rtp = -1;
                        for(int i : d.retreg())
                        {
                            String x = allocreg(find(i));
                            if (sw == 0)
                            {
                                rtp = i;
                                sw++;
                                continue;
                            }
                            switch (sw) {
                                case 1:
                                    fill(x, "rdi", i);
                                    break;
                                case 2:
                                    fill(x, "rsi", i);
                                    break;
                                case 3:
                                    fill(x, "rdx", i);
                                    break;
                                case 4:
                                    fill(x, "rcx", i);
                                    break;
                                case 5:
                                    fill(x, "r8", i);
                                    break;
                                case 6:
                                    fill(x, "r9", i);
                                    break;
                                default:
                                    if (x == null) {
                                        int y;
                                        if (ml.containsKey(find(i))) {
                                            y = ml.get(find(i));
                                        } else {
                                            y = allocmem();
                                            ml.put(find(i), y);
                                        }
                                        oc.add("\tmove r15 qword [rbp - " + y + "]");
                                        oc.add("\tpush r15");
                                    } else {
                                        oc.add("\tpush " + x);
                                    }
                            }
                            sw++;
                        }
                        String tmq = d.geti().getl();
                        switch (tmq)
                        {
                            case "getString":
                            case "getInt":
                            case "length":
                            case "parseInt":
                            case "print":
                            case "println":
                            case "toString":
                            case "substring":
                            case "ord":
                            case "str_concat":
                            case "str_lte":
                            case "str_less":
                            case "string_not_equal":
                            case "string_equal":
                                oc.add("\tcall " + tmq);
                                break;
                            default:
                                int tmp = fn.get(d.geti()).geti();
                                oc.add("\tcall %" + tmp);
                        }
                        String rg = allocreg(find(rtp));
                        if(rg == null)
                        {
                            int y;
                            if(ml.containsKey(find(rtp))) {y = ml.get(find(rtp));}
                            else {y = allocmem(); ml.put(find(rtp), y);}
                            oc.add("\tmove qword [rbp - " + y + "] rax");
                        }
                        else
                        {
                            oc.add("\tmove " + rg + " rax");
                        }
                        while(ps.size() > 0)
                        {
                            String tmd = ps.pop();
                            oc.add("\tpop " + tmd);
                        }
                        break;
                    case "neg":
                    case "not":
                        String x = allocreg(find(d.retreg().get(0)));
                        if (x != null)
                        {
                            oc.add("\t" + d.gettyp() + " " + x);
                        }
                        else
                        {
                            int y;
                            if(ml.containsKey(find(d.retreg().get(0)))) {y = ml.get(find(d.retreg().get(0)));}
                            else {y = allocmem(); ml.put(find(d.retreg().get(0)), y);}
                            oc.add("\tmove r15 qword [rbp - " + y + "]");
                            oc.add("\tneg r15");
                            oc.add("\tmove qword [rbp - " + y + "] r15");
                        }
                        break;
                    case "add":
                    case "sub":
                    case "mul":
                    case "div":
                    case "rem":
                    case "shl":
                    case "shr":
                    case "and":
                    case "xor":
                    case "or":
                    case "slt":
                    case "sgt":
                    case "sle":
                    case "sge":
                    case "seq":
                    case "sne":
                        binary(d, d.gettyp());
                        break;
                    case "addi":
                        String x1 = allocreg(find(d.retreg().get(0)));
                        int x3 = d.retreg().get(1);
                        if(x1 == null)
                        {
                            int y1;
                            if(ml.containsKey(find(d.retreg().get(0)))) {y1 = ml.get(find(d.retreg().get(0)));}
                            else {y1 = allocmem(); ml.put(find(d.retreg().get(0)), y1);}
                            oc.add("\tmove r15 qword [rbp - " + y1 + "]");
                            oc.add("\tadd r15 " + x3);
                            oc.add("\tmove qword [rbp - " + y1 + "] r15");
                        }
                        break;
                    case "move":
                        x1 = allocreg(find(d.retreg().get(0)));
                        String x2 = allocreg(find(d.retreg().get(1)));
                        if (x1 == null) {
                            int y1;
                            if(ml.containsKey(find(d.retreg().get(0)))) {y1 = ml.get(find(d.retreg().get(0)));}
                            else {y1 = allocmem(); ml.put(find(d.retreg().get(0)), y1);}
                            if (x2 == null)
                            {
                                int y2;
                                if(ml.containsKey(find(d.retreg().get(1)))) {y2 = ml.get(find(d.retreg().get(1)));}
                                else {y2 = allocmem(); ml.put(find(d.retreg().get(1)), y2);}
                                oc.add("\tmove r15 qword [rbp - " + y1 + "]");
                                oc.add("\tmove qword [rbp - " + y2 + "] r15");
                            }
                            else
                            {
                                oc.add("\tmove qword [rbp - " + y1 + "] " + x2);
                            }
                        }
                        else
                        {
                            if (x2 == null)
                            {
                                int y2;
                                if(ml.containsKey(find(d.retreg().get(1)))) {y2 = ml.get(find(d.retreg().get(1)));}
                                else {y2 = allocmem(); ml.put(find(d.retreg().get(1)), y2);}
                                oc.add("\tmove " + x1 + " qword [rbp - " + y2 + "]");
                            }
                            else
                            {
                                oc.add("\tmove " + x1 + " " + x2);
                            }
                        }
                        break;
                    case "db":
                        String data = d.geti().getl();
                        ed.add(d.geti().getr());
                        ed.add("\tdb" + data);
                        break;
                }
                if(flag)
                {
                    while(pt.size() > 0)
                    {
                        String tmr = pt.pop();
                        oc.add("\tpop " + tmr);
                    }
                    for(;sl > 0;sl--)
                    {
                        oc.add("\tpop");
                    }
                }
            }
        }
    }
}