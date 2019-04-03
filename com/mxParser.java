// Generated from /home/acmzms/MxCompiler/src/com/mx.g4 by ANTLR 4.7.2
package com;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, Bool=33, Int=34, String=35, Void=36, If=37, Else=38, For=39, 
		While=40, Break=41, Continue=42, Return=43, New=44, Class=45, This=46, 
		Constant=47, Identifier=48, Spaces=49, Newline=50, Linecomment=51, Blockcomment=52;
	public static final int
		RULE_program = 0, RULE_code = 1, RULE_declclass = 2, RULE_constructor = 3, 
		RULE_function = 4, RULE_params = 5, RULE_call = 6, RULE_expressionblock = 7, 
		RULE_expression = 8, RULE_declaration = 9, RULE_declpair = 10, RULE_typename = 11, 
		RULE_statement = 12, RULE_condition = 13, RULE_loop = 14, RULE_control = 15, 
		RULE_calculation = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "code", "declclass", "constructor", "function", "params", 
			"call", "expressionblock", "expression", "declaration", "declpair", "typename", 
			"statement", "condition", "loop", "control", "calculation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "';'", "'}'", "'('", "')'", "','", "'='", "'['", "']'", 
			"'++'", "'--'", "'.'", "'+'", "'-'", "'!'", "'~'", "'/'", "'*'", "'%'", 
			"'<<'", "'>>'", "'>='", "'>'", "'<'", "'<='", "'!='", "'=='", "'&'", 
			"'^'", "'|'", "'&&'", "'||'", "'bool'", "'int'", "'string'", "'void'", 
			"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
			"'new'", "'class'", "'this'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Bool", "Int", 
			"String", "Void", "If", "Else", "For", "While", "Break", "Continue", 
			"Return", "New", "Class", "This", "Constant", "Identifier", "Spaces", 
			"Newline", "Linecomment", "Blockcomment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(mxParser.EOF, 0); }
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(34);
				code();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public DeclclassContext declclass() {
			return getRuleContext(DeclclassContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				declclass();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				declaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclclassContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(mxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public List<DeclpairContext> declpair() {
			return getRuleContexts(DeclpairContext.class);
		}
		public DeclpairContext declpair(int i) {
			return getRuleContext(DeclpairContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
		}
		public DeclclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterDeclclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitDeclclass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitDeclclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclclassContext declclass() throws RecognitionException {
		DeclclassContext _localctx = new DeclclassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declclass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(Class);
			setState(48);
			match(Identifier);
			setState(49);
			match(T__0);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(50);
					declpair();
					setState(51);
					match(T__1);
					}
					break;
				case 2:
					{
					setState(53);
					function();
					}
					break;
				case 3:
					{
					setState(54);
					constructor();
					}
					break;
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public ExpressionblockContext expressionblock() {
			return getRuleContext(ExpressionblockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(Identifier);
			setState(63);
			match(T__3);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(64);
				params();
				}
			}

			setState(67);
			match(T__4);
			setState(68);
			expressionblock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public ExpressionblockContext expressionblock() {
			return getRuleContext(ExpressionblockContext.class,0);
		}
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public TerminalNode Void() { return getToken(mxParser.Void, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Identifier:
				{
				setState(70);
				typename(0);
				}
				break;
			case Void:
				{
				setState(71);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(74);
			match(Identifier);
			setState(75);
			match(T__3);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(76);
				params();
				}
			}

			setState(79);
			match(T__4);
			setState(80);
			expressionblock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<DeclpairContext> declpair() {
			return getRuleContexts(DeclpairContext.class);
		}
		public DeclpairContext declpair(int i) {
			return getRuleContext(DeclpairContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(82);
					declpair();
					setState(83);
					match(T__5);
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(90);
			declpair();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_call);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					calculation(0);
					setState(93);
					match(T__5);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(100);
			calculation(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionblockContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterExpressionblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitExpressionblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitExpressionblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionblockContext expressionblock() throws RecognitionException {
		ExpressionblockContext _localctx = new ExpressionblockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressionblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__0);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
				{
				{
				setState(103);
				expression();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				declaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclsContext extends DeclarationContext {
		public DeclpairContext declpair() {
			return getRuleContext(DeclpairContext.class,0);
		}
		public DeclsContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclplusassignContext extends DeclarationContext {
		public DeclpairContext declpair() {
			return getRuleContext(DeclpairContext.class,0);
		}
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(mxParser.Constant, 0); }
		public DeclplusassignContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterDeclplusassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitDeclplusassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitDeclplusassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaration);
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new DeclsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				declpair();
				setState(116);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new DeclplusassignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				declpair();
				setState(119);
				match(T__6);
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(120);
					calculation(0);
					}
					break;
				case 2:
					{
					setState(121);
					match(Identifier);
					}
					break;
				case 3:
					{
					setState(122);
					match(Constant);
					}
					break;
				}
				setState(125);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclpairContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public DeclpairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declpair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterDeclpair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitDeclpair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitDeclpair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclpairContext declpair() throws RecognitionException {
		DeclpairContext _localctx = new DeclpairContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declpair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			typename(0);
			setState(130);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenameContext extends ParserRuleContext {
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	 
		public TypenameContext() { }
		public void copyFrom(TypenameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayvarsContext extends TypenameContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ArrayvarsContext(TypenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterArrayvars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitArrayvars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitArrayvars(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends TypenameContext {
		public TerminalNode Int() { return getToken(mxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(mxParser.Bool, 0); }
		public TerminalNode String() { return getToken(mxParser.String, 0); }
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public VarContext(TypenameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		return typename(0);
	}

	private TypenameContext typename(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypenameContext _localctx = new TypenameContext(_ctx, _parentState);
		TypenameContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_typename, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(133);
				match(Int);
				}
				break;
			case Bool:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(Bool);
				}
				break;
			case String:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(String);
				}
				break;
			case Identifier:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayvarsContext(new TypenameContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typename);
					setState(139);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(140);
					match(T__7);
					setState(141);
					match(T__8);
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ExpressionblockContext expressionblock() {
			return getRuleContext(ExpressionblockContext.class,0);
		}
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ControlContext control() {
			return getRuleContext(ControlContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				expressionblock();
				}
				break;
			case T__3:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case New:
			case This:
			case Constant:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				calculation(0);
				setState(149);
				match(T__1);
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				condition();
				}
				break;
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				loop();
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(153);
				control();
				setState(154);
				match(T__1);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionblockContext lstm;
		public ExpressionContext lst;
		public ExpressionblockContext rstm;
		public ExpressionContext rst;
		public TerminalNode If() { return getToken(mxParser.If, 0); }
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public List<ExpressionblockContext> expressionblock() {
			return getRuleContexts(ExpressionblockContext.class);
		}
		public ExpressionblockContext expressionblock(int i) {
			return getRuleContext(ExpressionblockContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Else() { return getToken(mxParser.Else, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(If);
			setState(160);
			match(T__3);
			setState(161);
			calculation(0);
			setState(162);
			match(T__4);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(163);
				((ConditionContext)_localctx).lstm = expressionblock();
				}
				break;
			case 2:
				{
				setState(164);
				((ConditionContext)_localctx).lst = expression();
				}
				break;
			}
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(167);
				match(Else);
				setState(170);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(168);
					((ConditionContext)_localctx).rstm = expressionblock();
					}
					break;
				case 2:
					{
					setState(169);
					((ConditionContext)_localctx).rst = expression();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhilestmtContext extends LoopContext {
		public TerminalNode While() { return getToken(mxParser.While, 0); }
		public ExpressionblockContext expressionblock() {
			return getRuleContext(ExpressionblockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public WhilestmtContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForstmtContext extends LoopContext {
		public CalculationContext init;
		public CalculationContext quit;
		public CalculationContext incr;
		public TerminalNode For() { return getToken(mxParser.For, 0); }
		public ExpressionblockContext expressionblock() {
			return getRuleContext(ExpressionblockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public ForstmtContext(LoopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_loop);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case For:
				_localctx = new ForstmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(For);
				setState(175);
				match(T__3);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
					{
					setState(176);
					((ForstmtContext)_localctx).init = calculation(0);
					}
				}

				setState(179);
				match(T__1);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
					{
					setState(180);
					((ForstmtContext)_localctx).quit = calculation(0);
					}
				}

				setState(183);
				match(T__1);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
					{
					setState(184);
					((ForstmtContext)_localctx).incr = calculation(0);
					}
				}

				setState(187);
				match(T__4);
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(188);
					expressionblock();
					}
					break;
				case 2:
					{
					setState(189);
					expression();
					}
					break;
				}
				}
				break;
			case While:
				_localctx = new WhilestmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(While);
				setState(193);
				match(T__3);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
					{
					setState(194);
					calculation(0);
					}
				}

				setState(197);
				match(T__4);
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(198);
					expressionblock();
					}
					break;
				case 2:
					{
					setState(199);
					expression();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlContext extends ParserRuleContext {
		public ControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control; }
	 
		public ControlContext() { }
		public void copyFrom(ControlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RetstmtContext extends ControlContext {
		public TerminalNode Return() { return getToken(mxParser.Return, 0); }
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public RetstmtContext(ControlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterRetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitRetstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitRetstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakContext extends ControlContext {
		public TerminalNode Break() { return getToken(mxParser.Break, 0); }
		public BreakContext(ControlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueContext extends ControlContext {
		public TerminalNode Continue() { return getToken(mxParser.Continue, 0); }
		public ContinueContext(ControlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitContinue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlContext control() throws RecognitionException {
		ControlContext _localctx = new ControlContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_control);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Return:
				_localctx = new RetstmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(Return);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
					{
					setState(205);
					calculation(0);
					}
				}

				}
				break;
			case Continue:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(Continue);
				}
				break;
			case Break:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(Break);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculationContext extends ParserRuleContext {
		public CalculationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculation; }
	 
		public CalculationContext() { }
		public void copyFrom(CalculationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayContext extends CalculationContext {
		public CalculationContext lhs;
		public CalculationContext rhs;
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public ArrayContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunccallContext extends CalculationContext {
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public FunccallContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitFunccall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixContext extends CalculationContext {
		public Token op;
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public PrefixContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewexprContext extends CalculationContext {
		public TerminalNode New() { return getToken(mxParser.New, 0); }
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public NewexprContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterNewexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitNewexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitNewexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends CalculationContext {
		public CalculationContext lhs;
		public Token op;
		public CalculationContext rhs;
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public BinaryContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClassfuncContext extends CalculationContext {
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public ClassfuncContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterClassfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitClassfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitClassfunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixContext extends CalculationContext {
		public Token op;
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public SuffixContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitSuffix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubexprContext extends CalculationContext {
		public CalculationContext calculation() {
			return getRuleContext(CalculationContext.class,0);
		}
		public SubexprContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterSubexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitSubexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitSubexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryContext extends CalculationContext {
		public TerminalNode Constant() { return getToken(mxParser.Constant, 0); }
		public TerminalNode This() { return getToken(mxParser.This, 0); }
		public TerminalNode Identifier() { return getToken(mxParser.Identifier, 0); }
		public PrimaryContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends CalculationContext {
		public CalculationContext lhs;
		public CalculationContext rhs;
		public List<CalculationContext> calculation() {
			return getRuleContexts(CalculationContext.class);
		}
		public CalculationContext calculation(int i) {
			return getRuleContext(CalculationContext.class,i);
		}
		public AssignContext(CalculationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mxListener ) ((mxListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mxVisitor ) return ((mxVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculationContext calculation() throws RecognitionException {
		return calculation(0);
	}

	private CalculationContext calculation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CalculationContext _localctx = new CalculationContext(_ctx, _parentState);
		CalculationContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_calculation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
				{
				_localctx = new PrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				((PrefixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
					((PrefixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				calculation(17);
				}
				break;
			case New:
				{
				_localctx = new NewexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(New);
				setState(216);
				typename(0);
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(217);
						match(T__7);
						setState(218);
						calculation(0);
						setState(219);
						match(T__8);
						}
						} 
					}
					setState(225);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(226);
						match(T__7);
						setState(227);
						match(T__8);
						}
						} 
					}
					setState(232);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
				break;
			case T__3:
				{
				_localctx = new SubexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				match(T__3);
				setState(234);
				calculation(0);
				setState(235);
				match(T__4);
				}
				break;
			case Constant:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(Constant);
				}
				break;
			case This:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(This);
				}
				break;
			case Identifier:
				{
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(242);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(243);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						((BinaryContext)_localctx).rhs = calculation(16);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(245);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(246);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						((BinaryContext)_localctx).rhs = calculation(15);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(248);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(249);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						((BinaryContext)_localctx).rhs = calculation(14);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(251);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(252);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						((BinaryContext)_localctx).rhs = calculation(13);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(254);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(255);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(256);
						((BinaryContext)_localctx).rhs = calculation(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(257);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(258);
						((BinaryContext)_localctx).op = match(T__27);
						setState(259);
						((BinaryContext)_localctx).rhs = calculation(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(260);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(261);
						((BinaryContext)_localctx).op = match(T__28);
						setState(262);
						((BinaryContext)_localctx).rhs = calculation(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(263);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(264);
						((BinaryContext)_localctx).op = match(T__29);
						setState(265);
						((BinaryContext)_localctx).rhs = calculation(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(266);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(267);
						((BinaryContext)_localctx).op = match(T__30);
						setState(268);
						((BinaryContext)_localctx).rhs = calculation(8);
						}
						break;
					case 10:
						{
						_localctx = new BinaryContext(new CalculationContext(_parentctx, _parentState));
						((BinaryContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(269);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(270);
						((BinaryContext)_localctx).op = match(T__31);
						setState(271);
						((BinaryContext)_localctx).rhs = calculation(7);
						}
						break;
					case 11:
						{
						_localctx = new AssignContext(new CalculationContext(_parentctx, _parentState));
						((AssignContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(272);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(273);
						match(T__6);
						setState(274);
						((AssignContext)_localctx).rhs = calculation(5);
						}
						break;
					case 12:
						{
						_localctx = new SuffixContext(new CalculationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(275);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(276);
						((SuffixContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((SuffixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 13:
						{
						_localctx = new ClassfuncContext(new CalculationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(277);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(278);
						match(T__11);
						setState(279);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ArrayContext(new CalculationContext(_parentctx, _parentState));
						((ArrayContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(280);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(281);
						match(T__7);
						setState(282);
						((ArrayContext)_localctx).rhs = calculation(0);
						setState(283);
						match(T__8);
						}
						break;
					case 15:
						{
						_localctx = new FunccallContext(new CalculationContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calculation);
						setState(285);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(286);
						match(T__3);
						setState(288);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << New) | (1L << This) | (1L << Constant) | (1L << Identifier))) != 0)) {
							{
							setState(287);
							call();
							}
						}

						setState(290);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return typename_sempred((TypenameContext)_localctx, predIndex);
		case 16:
			return calculation_sempred((CalculationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typename_sempred(TypenameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean calculation_sempred(CalculationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 21);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 19);
		case 15:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u012b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\3\4\3\5\3\5\3\5\5\5"+
		"D\n\5\3\5\3\5\3\5\3\6\3\6\5\6K\n\6\3\6\3\6\3\6\5\6P\n\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\7\7X\n\7\f\7\16\7[\13\7\3\7\3\7\3\b\3\b\3\b\7\bb\n\b\f\b\16"+
		"\be\13\b\3\b\3\b\3\t\3\t\7\tk\n\t\f\t\16\tn\13\t\3\t\3\t\3\n\3\n\5\nt"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13~\n\13\3\13\3\13\5\13"+
		"\u0082\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u008c\n\r\3\r\3\r\3\r"+
		"\7\r\u0091\n\r\f\r\16\r\u0094\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00a0\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a8"+
		"\n\17\3\17\3\17\3\17\5\17\u00ad\n\17\5\17\u00af\n\17\3\20\3\20\3\20\5"+
		"\20\u00b4\n\20\3\20\3\20\5\20\u00b8\n\20\3\20\3\20\5\20\u00bc\n\20\3\20"+
		"\3\20\3\20\5\20\u00c1\n\20\3\20\3\20\3\20\5\20\u00c6\n\20\3\20\3\20\3"+
		"\20\5\20\u00cb\n\20\5\20\u00cd\n\20\3\21\3\21\5\21\u00d1\n\21\3\21\3\21"+
		"\5\21\u00d5\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00e0"+
		"\n\22\f\22\16\22\u00e3\13\22\3\22\3\22\7\22\u00e7\n\22\f\22\16\22\u00ea"+
		"\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f3\n\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\5\22\u0123\n\22\3\22\7\22\u0126\n\22\f\22\16\22\u0129\13\22\3"+
		"\22\2\4\30\"\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\t\4\2\f\r"+
		"\17\22\3\2\23\25\3\2\17\20\3\2\26\27\3\2\30\33\3\2\34\35\3\2\f\r\2\u0156"+
		"\2\'\3\2\2\2\4/\3\2\2\2\6\61\3\2\2\2\b@\3\2\2\2\nJ\3\2\2\2\fY\3\2\2\2"+
		"\16c\3\2\2\2\20h\3\2\2\2\22s\3\2\2\2\24\u0081\3\2\2\2\26\u0083\3\2\2\2"+
		"\30\u008b\3\2\2\2\32\u009f\3\2\2\2\34\u00a1\3\2\2\2\36\u00cc\3\2\2\2 "+
		"\u00d4\3\2\2\2\"\u00f2\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2"+
		"\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\2\2\3+\3\3\2\2\2,\60\5\6\4\2-\60"+
		"\5\n\6\2.\60\5\24\13\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\62"+
		"\7/\2\2\62\63\7\62\2\2\63;\7\3\2\2\64\65\5\26\f\2\65\66\7\4\2\2\66:\3"+
		"\2\2\2\67:\5\n\6\28:\5\b\5\29\64\3\2\2\29\67\3\2\2\298\3\2\2\2:=\3\2\2"+
		"\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\5\2\2?\7\3\2\2\2@A\7\62"+
		"\2\2AC\7\6\2\2BD\5\f\7\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\7\2\2FG\5\20"+
		"\t\2G\t\3\2\2\2HK\5\30\r\2IK\7&\2\2JH\3\2\2\2JI\3\2\2\2KL\3\2\2\2LM\7"+
		"\62\2\2MO\7\6\2\2NP\5\f\7\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\7\2\2RS"+
		"\5\20\t\2S\13\3\2\2\2TU\5\26\f\2UV\7\b\2\2VX\3\2\2\2WT\3\2\2\2X[\3\2\2"+
		"\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\5\26\f\2]\r\3\2\2\2^_\5"+
		"\"\22\2_`\7\b\2\2`b\3\2\2\2a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df"+
		"\3\2\2\2ec\3\2\2\2fg\5\"\22\2g\17\3\2\2\2hl\7\3\2\2ik\5\22\n\2ji\3\2\2"+
		"\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\5\2\2p\21\3\2"+
		"\2\2qt\5\32\16\2rt\5\24\13\2sq\3\2\2\2sr\3\2\2\2t\23\3\2\2\2uv\5\26\f"+
		"\2vw\7\4\2\2w\u0082\3\2\2\2xy\5\26\f\2y}\7\t\2\2z~\5\"\22\2{~\7\62\2\2"+
		"|~\7\61\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\177\3\2\2\2\177\u0080\7\4\2"+
		"\2\u0080\u0082\3\2\2\2\u0081u\3\2\2\2\u0081x\3\2\2\2\u0082\25\3\2\2\2"+
		"\u0083\u0084\5\30\r\2\u0084\u0085\7\62\2\2\u0085\27\3\2\2\2\u0086\u0087"+
		"\b\r\1\2\u0087\u008c\7$\2\2\u0088\u008c\7#\2\2\u0089\u008c\7%\2\2\u008a"+
		"\u008c\7\62\2\2\u008b\u0086\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u0089\3"+
		"\2\2\2\u008b\u008a\3\2\2\2\u008c\u0092\3\2\2\2\u008d\u008e\f\7\2\2\u008e"+
		"\u008f\7\n\2\2\u008f\u0091\7\13\2\2\u0090\u008d\3\2\2\2\u0091\u0094\3"+
		"\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\31\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u00a0\5\20\t\2\u0096\u0097\5\"\22\2\u0097\u0098\7"+
		"\4\2\2\u0098\u00a0\3\2\2\2\u0099\u00a0\5\34\17\2\u009a\u00a0\5\36\20\2"+
		"\u009b\u009c\5 \21\2\u009c\u009d\7\4\2\2\u009d\u00a0\3\2\2\2\u009e\u00a0"+
		"\7\4\2\2\u009f\u0095\3\2\2\2\u009f\u0096\3\2\2\2\u009f\u0099\3\2\2\2\u009f"+
		"\u009a\3\2\2\2\u009f\u009b\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\33\3\2\2"+
		"\2\u00a1\u00a2\7\'\2\2\u00a2\u00a3\7\6\2\2\u00a3\u00a4\5\"\22\2\u00a4"+
		"\u00a7\7\7\2\2\u00a5\u00a8\5\20\t\2\u00a6\u00a8\5\22\n\2\u00a7\u00a5\3"+
		"\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ae\3\2\2\2\u00a9\u00ac\7(\2\2\u00aa"+
		"\u00ad\5\20\t\2\u00ab\u00ad\5\22\n\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3"+
		"\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\35\3\2\2\2\u00b0\u00b1\7)\2\2\u00b1\u00b3\7\6\2\2\u00b2\u00b4\5\"\22"+
		"\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\7\4\2\2\u00b6\u00b8\5\"\22\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00bb\7\4\2\2\u00ba\u00bc\5\"\22\2\u00bb\u00ba"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\7\7\2\2\u00be"+
		"\u00c1\5\20\t\2\u00bf\u00c1\5\22\n\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3"+
		"\2\2\2\u00c1\u00cd\3\2\2\2\u00c2\u00c3\7*\2\2\u00c3\u00c5\7\6\2\2\u00c4"+
		"\u00c6\5\"\22\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00ca\7\7\2\2\u00c8\u00cb\5\20\t\2\u00c9\u00cb\5\22\n\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00b0\3\2"+
		"\2\2\u00cc\u00c2\3\2\2\2\u00cd\37\3\2\2\2\u00ce\u00d0\7-\2\2\u00cf\u00d1"+
		"\5\"\22\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d5\3\2\2\2"+
		"\u00d2\u00d5\7,\2\2\u00d3\u00d5\7+\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5!\3\2\2\2\u00d6\u00d7\b\22\1\2\u00d7"+
		"\u00d8\t\2\2\2\u00d8\u00f3\5\"\22\23\u00d9\u00da\7.\2\2\u00da\u00e1\5"+
		"\30\r\2\u00db\u00dc\7\n\2\2\u00dc\u00dd\5\"\22\2\u00dd\u00de\7\13\2\2"+
		"\u00de\u00e0\3\2\2\2\u00df\u00db\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e8\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e5\7\n\2\2\u00e5\u00e7\7\13\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3"+
		"\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f3\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00eb\u00ec\7\6\2\2\u00ec\u00ed\5\"\22\2\u00ed\u00ee\7"+
		"\7\2\2\u00ee\u00f3\3\2\2\2\u00ef\u00f3\7\61\2\2\u00f0\u00f3\7\60\2\2\u00f1"+
		"\u00f3\7\62\2\2\u00f2\u00d6\3\2\2\2\u00f2\u00d9\3\2\2\2\u00f2\u00eb\3"+
		"\2\2\2\u00f2\u00ef\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u0127\3\2\2\2\u00f4\u00f5\f\21\2\2\u00f5\u00f6\t\3\2\2\u00f6\u0126\5"+
		"\"\22\22\u00f7\u00f8\f\20\2\2\u00f8\u00f9\t\4\2\2\u00f9\u0126\5\"\22\21"+
		"\u00fa\u00fb\f\17\2\2\u00fb\u00fc\t\5\2\2\u00fc\u0126\5\"\22\20\u00fd"+
		"\u00fe\f\16\2\2\u00fe\u00ff\t\6\2\2\u00ff\u0126\5\"\22\17\u0100\u0101"+
		"\f\r\2\2\u0101\u0102\t\7\2\2\u0102\u0126\5\"\22\16\u0103\u0104\f\f\2\2"+
		"\u0104\u0105\7\36\2\2\u0105\u0126\5\"\22\r\u0106\u0107\f\13\2\2\u0107"+
		"\u0108\7\37\2\2\u0108\u0126\5\"\22\f\u0109\u010a\f\n\2\2\u010a\u010b\7"+
		" \2\2\u010b\u0126\5\"\22\13\u010c\u010d\f\t\2\2\u010d\u010e\7!\2\2\u010e"+
		"\u0126\5\"\22\n\u010f\u0110\f\b\2\2\u0110\u0111\7\"\2\2\u0111\u0126\5"+
		"\"\22\t\u0112\u0113\f\7\2\2\u0113\u0114\7\t\2\2\u0114\u0126\5\"\22\7\u0115"+
		"\u0116\f\27\2\2\u0116\u0126\t\b\2\2\u0117\u0118\f\26\2\2\u0118\u0119\7"+
		"\16\2\2\u0119\u0126\7\62\2\2\u011a\u011b\f\25\2\2\u011b\u011c\7\n\2\2"+
		"\u011c\u011d\5\"\22\2\u011d\u011e\7\13\2\2\u011e\u0126\3\2\2\2\u011f\u0120"+
		"\f\24\2\2\u0120\u0122\7\6\2\2\u0121\u0123\5\16\b\2\u0122\u0121\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\7\7\2\2\u0125\u00f4"+
		"\3\2\2\2\u0125\u00f7\3\2\2\2\u0125\u00fa\3\2\2\2\u0125\u00fd\3\2\2\2\u0125"+
		"\u0100\3\2\2\2\u0125\u0103\3\2\2\2\u0125\u0106\3\2\2\2\u0125\u0109\3\2"+
		"\2\2\u0125\u010c\3\2\2\2\u0125\u010f\3\2\2\2\u0125\u0112\3\2\2\2\u0125"+
		"\u0115\3\2\2\2\u0125\u0117\3\2\2\2\u0125\u011a\3\2\2\2\u0125\u011f\3\2"+
		"\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"#\3\2\2\2\u0129\u0127\3\2\2\2$\'/9;CJOYcls}\u0081\u008b\u0092\u009f\u00a7"+
		"\u00ac\u00ae\u00b3\u00b7\u00bb\u00c0\u00c5\u00ca\u00cc\u00d0\u00d4\u00e1"+
		"\u00e8\u00f2\u0122\u0125\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}