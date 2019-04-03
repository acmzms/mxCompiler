// Generated from /home/acmzms/MxCompiler/src/com/mx.g4 by ANTLR 4.7.2
package com;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(mxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(mxParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#declclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclclass(mxParser.DeclclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(mxParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(mxParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(mxParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(mxParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#expressionblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionblock(mxParser.ExpressionblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(mxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decls}
	 * labeled alternative in {@link mxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(mxParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declplusassign}
	 * labeled alternative in {@link mxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclplusassign(mxParser.DeclplusassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#declpair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclpair(mxParser.DeclpairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayvars}
	 * labeled alternative in {@link mxParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayvars(mxParser.ArrayvarsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link mxParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(mxParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(mxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link mxParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(mxParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link mxParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(mxParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link mxParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(mxParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code retstmt}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetstmt(mxParser.RetstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(mxParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link mxParser#control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(mxParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(mxParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funccall}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(mxParser.FunccallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefix}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(mxParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewexpr(mxParser.NewexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(mxParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classfunc}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassfunc(mxParser.ClassfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffix}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix(mxParser.SuffixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpr(mxParser.SubexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(mxParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link mxParser#calculation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(mxParser.AssignContext ctx);
}