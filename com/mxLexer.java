// Generated from /home/acmzms/MxCompiler/src/com/mx.g4 by ANTLR 4.7.2
package com;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mxLexer extends Lexer {
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
		Identifier=47, Constant=48, Spaces=49, Newline=50, Linecomment=51, Blockcomment=52;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "Bool", 
			"Int", "String", "Null", "Void", "True", "False", "If", "Else", "For", 
			"While", "Break", "Continue", "Return", "New", "Class", "This", "Identifier", 
			"Constant", "Spchar", "Char", "Strchar", "Digit", "Spaces", "Newline", 
			"Linecomment", "Blockcomment"
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
			"Return", "New", "Class", "This", "Identifier", "Constant", "Spaces", 
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


	public mxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u016e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3"+
		"/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\7\63\u0123\n\63\f\63\16\63\u0126\13"+
		"\63\3\64\3\64\7\64\u012a\n\64\f\64\16\64\u012d\13\64\3\64\3\64\3\64\7"+
		"\64\u0132\n\64\f\64\16\64\u0135\13\64\3\64\3\64\3\64\3\64\5\64\u013b\n"+
		"\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\5\67\u0144\n\67\38\38\39\69\u0149"+
		"\n9\r9\169\u014a\39\39\3:\5:\u0150\n:\3:\3:\3:\3:\3;\3;\3;\3;\7;\u015a"+
		"\n;\f;\16;\u015d\13;\3;\3;\3<\3<\3<\3<\7<\u0165\n<\f<\16<\u0168\13<\3"+
		"<\3<\3<\3<\3<\3\u0166\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I\2K&M\2O\2Q\'S(U)W*Y+[,]-_.a/c\60"+
		"e\61g\62i\2k\2m\2o\2q\63s\64u\65w\66\3\2\n\3\2\63;\3\2\62;\4\2C\\c|\5"+
		"\2C\\aac|\6\2\f\f\17\17$$^^\5\2$$^^pp\4\2\13\13\"\"\4\2\f\f\17\17\2\u0174"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2K\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3y\3\2\2\2\5{\3\2\2"+
		"\2\7}\3\2\2\2\t\177\3\2\2\2\13\u0081\3\2\2\2\r\u0083\3\2\2\2\17\u0085"+
		"\3\2\2\2\21\u0087\3\2\2\2\23\u0089\3\2\2\2\25\u008b\3\2\2\2\27\u008e\3"+
		"\2\2\2\31\u0091\3\2\2\2\33\u0093\3\2\2\2\35\u0095\3\2\2\2\37\u0097\3\2"+
		"\2\2!\u0099\3\2\2\2#\u009b\3\2\2\2%\u009d\3\2\2\2\'\u009f\3\2\2\2)\u00a1"+
		"\3\2\2\2+\u00a4\3\2\2\2-\u00a7\3\2\2\2/\u00aa\3\2\2\2\61\u00ac\3\2\2\2"+
		"\63\u00ae\3\2\2\2\65\u00b1\3\2\2\2\67\u00b4\3\2\2\29\u00b7\3\2\2\2;\u00b9"+
		"\3\2\2\2=\u00bb\3\2\2\2?\u00bd\3\2\2\2A\u00c0\3\2\2\2C\u00c3\3\2\2\2E"+
		"\u00c8\3\2\2\2G\u00cc\3\2\2\2I\u00d3\3\2\2\2K\u00d8\3\2\2\2M\u00dd\3\2"+
		"\2\2O\u00e2\3\2\2\2Q\u00e8\3\2\2\2S\u00eb\3\2\2\2U\u00f0\3\2\2\2W\u00f4"+
		"\3\2\2\2Y\u00fa\3\2\2\2[\u0100\3\2\2\2]\u0109\3\2\2\2_\u0110\3\2\2\2a"+
		"\u0114\3\2\2\2c\u011a\3\2\2\2e\u011f\3\2\2\2g\u013a\3\2\2\2i\u013c\3\2"+
		"\2\2k\u013e\3\2\2\2m\u0143\3\2\2\2o\u0145\3\2\2\2q\u0148\3\2\2\2s\u014f"+
		"\3\2\2\2u\u0155\3\2\2\2w\u0160\3\2\2\2yz\7}\2\2z\4\3\2\2\2{|\7=\2\2|\6"+
		"\3\2\2\2}~\7\177\2\2~\b\3\2\2\2\177\u0080\7*\2\2\u0080\n\3\2\2\2\u0081"+
		"\u0082\7+\2\2\u0082\f\3\2\2\2\u0083\u0084\7.\2\2\u0084\16\3\2\2\2\u0085"+
		"\u0086\7?\2\2\u0086\20\3\2\2\2\u0087\u0088\7]\2\2\u0088\22\3\2\2\2\u0089"+
		"\u008a\7_\2\2\u008a\24\3\2\2\2\u008b\u008c\7-\2\2\u008c\u008d\7-\2\2\u008d"+
		"\26\3\2\2\2\u008e\u008f\7/\2\2\u008f\u0090\7/\2\2\u0090\30\3\2\2\2\u0091"+
		"\u0092\7\60\2\2\u0092\32\3\2\2\2\u0093\u0094\7-\2\2\u0094\34\3\2\2\2\u0095"+
		"\u0096\7/\2\2\u0096\36\3\2\2\2\u0097\u0098\7#\2\2\u0098 \3\2\2\2\u0099"+
		"\u009a\7\u0080\2\2\u009a\"\3\2\2\2\u009b\u009c\7\61\2\2\u009c$\3\2\2\2"+
		"\u009d\u009e\7,\2\2\u009e&\3\2\2\2\u009f\u00a0\7\'\2\2\u00a0(\3\2\2\2"+
		"\u00a1\u00a2\7>\2\2\u00a2\u00a3\7>\2\2\u00a3*\3\2\2\2\u00a4\u00a5\7@\2"+
		"\2\u00a5\u00a6\7@\2\2\u00a6,\3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\u00a9\7"+
		"?\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab\60\3\2\2\2\u00ac\u00ad\7"+
		">\2\2\u00ad\62\3\2\2\2\u00ae\u00af\7>\2\2\u00af\u00b0\7?\2\2\u00b0\64"+
		"\3\2\2\2\u00b1\u00b2\7#\2\2\u00b2\u00b3\7?\2\2\u00b3\66\3\2\2\2\u00b4"+
		"\u00b5\7?\2\2\u00b5\u00b6\7?\2\2\u00b68\3\2\2\2\u00b7\u00b8\7(\2\2\u00b8"+
		":\3\2\2\2\u00b9\u00ba\7`\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7~\2\2\u00bc>"+
		"\3\2\2\2\u00bd\u00be\7(\2\2\u00be\u00bf\7(\2\2\u00bf@\3\2\2\2\u00c0\u00c1"+
		"\7~\2\2\u00c1\u00c2\7~\2\2\u00c2B\3\2\2\2\u00c3\u00c4\7d\2\2\u00c4\u00c5"+
		"\7q\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7n\2\2\u00c7D\3\2\2\2\u00c8\u00c9"+
		"\7k\2\2\u00c9\u00ca\7p\2\2\u00ca\u00cb\7v\2\2\u00cbF\3\2\2\2\u00cc\u00cd"+
		"\7u\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7k\2\2\u00d0"+
		"\u00d1\7p\2\2\u00d1\u00d2\7i\2\2\u00d2H\3\2\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\u00d5\7w\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7n\2\2\u00d7J\3\2\2\2\u00d8"+
		"\u00d9\7x\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7f\2\2"+
		"\u00dcL\3\2\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7w\2"+
		"\2\u00e0\u00e1\7g\2\2\u00e1N\3\2\2\2\u00e2\u00e3\7h\2\2\u00e3\u00e4\7"+
		"c\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7u\2\2\u00e6\u00e7\7g\2\2\u00e7P"+
		"\3\2\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7h\2\2\u00eaR\3\2\2\2\u00eb\u00ec"+
		"\7g\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7g\2\2\u00ef"+
		"T\3\2\2\2\u00f0\u00f1\7h\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7t\2\2\u00f3"+
		"V\3\2\2\2\u00f4\u00f5\7y\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7\7k\2\2\u00f7"+
		"\u00f8\7n\2\2\u00f8\u00f9\7g\2\2\u00f9X\3\2\2\2\u00fa\u00fb\7d\2\2\u00fb"+
		"\u00fc\7t\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7m\2\2"+
		"\u00ffZ\3\2\2\2\u0100\u0101\7e\2\2\u0101\u0102\7q\2\2\u0102\u0103\7p\2"+
		"\2\u0103\u0104\7v\2\2\u0104\u0105\7k\2\2\u0105\u0106\7p\2\2\u0106\u0107"+
		"\7w\2\2\u0107\u0108\7g\2\2\u0108\\\3\2\2\2\u0109\u010a\7t\2\2\u010a\u010b"+
		"\7g\2\2\u010b\u010c\7v\2\2\u010c\u010d\7w\2\2\u010d\u010e\7t\2\2\u010e"+
		"\u010f\7p\2\2\u010f^\3\2\2\2\u0110\u0111\7p\2\2\u0111\u0112\7g\2\2\u0112"+
		"\u0113\7y\2\2\u0113`\3\2\2\2\u0114\u0115\7e\2\2\u0115\u0116\7n\2\2\u0116"+
		"\u0117\7c\2\2\u0117\u0118\7u\2\2\u0118\u0119\7u\2\2\u0119b\3\2\2\2\u011a"+
		"\u011b\7v\2\2\u011b\u011c\7j\2\2\u011c\u011d\7k\2\2\u011d\u011e\7u\2\2"+
		"\u011ed\3\2\2\2\u011f\u0124\5i\65\2\u0120\u0123\5k\66\2\u0121\u0123\5"+
		"o8\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125f\3\2\2\2\u0126\u0124\3\2\2\2"+
		"\u0127\u012b\t\2\2\2\u0128\u012a\t\3\2\2\u0129\u0128\3\2\2\2\u012a\u012d"+
		"\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u013b\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012e\u013b\7\62\2\2\u012f\u0133\7$\2\2\u0130\u0132\5m"+
		"\67\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u013b\7$"+
		"\2\2\u0137\u013b\5I%\2\u0138\u013b\5M\'\2\u0139\u013b\5O(\2\u013a\u0127"+
		"\3\2\2\2\u013a\u012e\3\2\2\2\u013a\u012f\3\2\2\2\u013a\u0137\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013bh\3\2\2\2\u013c\u013d\t\4\2\2"+
		"\u013dj\3\2\2\2\u013e\u013f\t\5\2\2\u013fl\3\2\2\2\u0140\u0144\n\6\2\2"+
		"\u0141\u0142\7^\2\2\u0142\u0144\t\7\2\2\u0143\u0140\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0144n\3\2\2\2\u0145\u0146\t\3\2\2\u0146p\3\2\2\2\u0147\u0149"+
		"\t\b\2\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\b9\2\2\u014dr\3\2\2\2\u014e"+
		"\u0150\7\17\2\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3"+
		"\2\2\2\u0151\u0152\7\f\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b:\2\2\u0154"+
		"t\3\2\2\2\u0155\u0156\7\61\2\2\u0156\u0157\7\61\2\2\u0157\u015b\3\2\2"+
		"\2\u0158\u015a\n\t\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e"+
		"\u015f\b;\2\2\u015fv\3\2\2\2\u0160\u0161\7\61\2\2\u0161\u0162\7,\2\2\u0162"+
		"\u0166\3\2\2\2\u0163\u0165\13\2\2\2\u0164\u0163\3\2\2\2\u0165\u0168\3"+
		"\2\2\2\u0166\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0169\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0169\u016a\7,\2\2\u016a\u016b\7\61\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\b<\2\2\u016dx\3\2\2\2\r\2\u0122\u0124\u012b\u0133\u013a"+
		"\u0143\u014a\u014f\u015b\u0166\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}