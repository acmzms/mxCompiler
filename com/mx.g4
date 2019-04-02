grammar mx;
//options{output = AST;}

Bool                : 'bool';
Int                 : 'int';
String              : 'string';
fragment Null       : 'null';
Void                : 'void';
fragment True       : 'true';
fragment False      : 'false';
If                  : 'if';
Else                : 'else';
For                 : 'for';
While               : 'while';
Break               : 'break';
Continue            : 'continue';
Return              : 'return';
New                 : 'new';
Class               : 'class';
This                : 'this';

program
    :code* EOF
    ;

code
    :declclass | function | declaration
    ;
//.......................................class.............................................

declclass
    :Class Identifier '{' (declpair ';' | function | constructor)* '}'
    ;

constructor
    : Identifier '(' params? ')' expressionblock
    ;

//.....................................function...........................................

function
    :(typename | Void) Identifier '(' params? ')' expressionblock
    ;

params
    :(declpair ',')* declpair
    ;

call
    :(calculation ',')* calculation
    ;

expressionblock
    :'{' expression* '}'
    ;

expression
    : statement
    | declaration
    ;

//.......................................declaration.........................................

declaration
    : declpair ';'                                                        # decls
    | declpair '=' (calculation | Identifier | Constant) ';'              # declplusassign
    ;

declpair
    : typename Identifier
    ;

typename
    : typename '[' ']'                      # arrayvars
    | Int                                   # var
    | Bool                                  # var
    | String                                # var
    | Identifier                            # var
    ;

Identifier
    :Spchar (Char | Digit)*
    ;

Constant
    : [1-9][0-9]*
    | '0'
    | '"' Strchar* '"'
    | Null
    | True
    | False
    ;


fragment Spchar
    :[a-zA-Z]
    ;

fragment Char
    :[a-zA-Z_]
    ;

fragment Strchar
    : ~["\\\r\n] | '\\' ["n\\]
    ;

fragment Digit
    :[0-9]
    ;

//..........................................statement...........................................

statement
    : expressionblock
    | calculation ';'
    | condition
    | loop
    | control ';'
    | ';'
    ;

condition
    :If '(' calculation ')' (lstm = expressionblock | lst = expression) (Else (rstm = expressionblock | rst = expression))?
    ;

loop
    : For '(' init = calculation? ';' quit = calculation? ';' incr = calculation? ')' (expressionblock | expression)       # forstmt
    | While '(' calculation? ')' (expressionblock | expression)                                                            # whilestmt
    ;

control
    : Return calculation?            # retstmt
    | Continue                       # covisitntinue
    | Break                          # break
    ;

calculation
    : calculation op = ('++' | '--')                                              # suffix
    | calculation '.' Identifier                                                  # classfunc
    | lhs = calculation '[' rhs = calculation ']'                                 # array
    | calculation '(' call? ')'                                                   # funccall
    | <assoc = right> op = ('+' | '-' | '++' | '--' | '!' | '~') calculation      # prefix
    | <assoc = right> New typename ('[' calculation ']')* ('[' ']')*              # newexpr
    | lhs = calculation op = ('/' | '*' | '%') rhs = calculation                  # binary
    | lhs = calculation op = ('+' | '-') rhs = calculation                        # binary
    | lhs = calculation op = ('<<' | '>>') rhs = calculation                      # binary
    | lhs = calculation op = ('>=' | '>' | '<' | '<=') rhs = calculation          # binary
    | lhs = calculation op = ('!=' | '==') rhs = calculation                      # binary
    | lhs = calculation op = '&' rhs = calculation                                # binary
    | lhs = calculation op = '^' rhs = calculation                                # binary
    | lhs = calculation op = '|' rhs = calculation                                # binary
    | lhs = calculation op = '&&' rhs = calculation                               # binary
    | lhs = calculation op = '||' rhs = calculation                               # binary
    | <assoc = right> lhs = calculation '=' rhs = calculation                     # assign
    | '(' calculation ')'                                                         # subexpr
    | Constant                                                                    # primary
    | This                                                                        # primary
    | Identifier                                                                  # primary
    ;

//.............................................skip.........................................
Spaces
    :   [ \t]+ -> skip
    ;

Newline
    :   '\r'? '\n' -> skip
    ;

Linecomment
    :   '//' ~[\r\n]* -> skip
    ;

Blockcomment
    :   '/*' .*? '*/' -> skip
    ;

