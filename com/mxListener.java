// Generated from /home/acmzms/MxCompiler/src/com/mx.g4 by ANTLR 4.7.2
package com;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mxParser}.
 */
public interface mxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(mxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(mxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(mxParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(mxParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#declclass}.
	 * @param ctx the parse tree
	 */
	void enterDeclclass(mxParser.DeclclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#declclass}.
	 * @param ctx the parse tree
	 */
	void exitDeclclass(mxParser.DeclclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(mxParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(mxParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(mxParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(mxParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(mxParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(mxParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(mxParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(mxParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#expressionblock}.
	 * @param ctx the parse tree
	 */
	void enterExpressionblock(mxParser.ExpressionblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#expressionblock}.
	 * @param ctx the parse tree
	 */
	void exitExpressionblock(mxParser.ExpressionblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(mxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(mxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decls}
	 * labeled alternative in {@link mxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDecls(mxParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decls}
	 * labeled alternative in {@link mxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDecls(mxParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declplusassign}
	 * labeled alternative in {@link mxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclplusassign(mxParser.DeclplusassignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declplusassign}
	 * labeled alternative in {@link mxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclplusassign(mxParser.DeclplusassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#declpair}.
	 * @param ctx the parse tree
	 */
	void enterDeclpair(mxParser.DeclpairContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#declpair}.
	 * @param ctx the parse tree
	 */
	void exitDeclpair(mxParser.DeclpairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayvars}
	 * labeled alternative in {@link mxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterArrayvars(mxParser.ArrayvarsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayvars}
	 * labeled alternative in {@link mxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitArrayvars(mxParser.ArrayvarsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link mxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterVar(mxParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link mxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitVar(mxParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(mxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(mxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link mxParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(mxParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mxParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(mxParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link mxParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(mxParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link mxParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(mxParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link mxParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(mxParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link mxParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(mxParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code retstmt}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 */
	void enterRetstmt(mxParser.RetstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retstmt}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 */
	void exitRetstmt(mxParser.RetstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 */
	void enterContinue(mxParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 */
	void exitContinue(mxParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 */
	void enterBreak(mxParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 */
	void exitBreak(mxParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterArray(mxParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitArray(mxParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funccall}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(mxParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funccall}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(mxParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(mxParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(mxParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterNewexpr(mxParser.NewexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitNewexpr(mxParser.NewexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterBinary(mxParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitBinary(mxParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classfunc}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterClassfunc(mxParser.ClassfuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classfunc}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitClassfunc(mxParser.ClassfuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffix}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterSuffix(mxParser.SuffixContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffix}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitSuffix(mxParser.SuffixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterSubexpr(mxParser.SubexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitSubexpr(mxParser.SubexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nanewexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterNanewexpr(mxParser.NanewexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nanewexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitNanewexpr(mxParser.NanewexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(mxParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(mxParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void enterAssign(mxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 */
	void exitAssign(mxParser.AssignContext ctx);
}