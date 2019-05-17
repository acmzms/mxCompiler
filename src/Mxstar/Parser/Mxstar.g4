grammar Mxstar;
compilationUnit
    :    translationUnit* EOF
    ;
translationUnit
    :    classDeclaration
    |    functionDeclaration
    |    variableDeclaration
    ;
classDeclaration
    :    Class Identifier '{' (variableDeclaration | constructorDeclaration | functionDeclaration)* '}'
    ;
functionDeclaration
    :    type Identifier '(' parameterList? ')' '{' statementList '}'
    ;
variableDeclaration
    :    type variableDeclarators ';'
    ;
constructorDeclaration
    :    Identifier '(' parameterList? ')' '{' statementList '}'
    ;
type
    :    atomType ('[' empty ']')*
    ;
parameterList
    :    parameter (',' parameter)*
    ;
statementList
    :    statement*
    ;
variableDeclarators
    :    variableDeclarator (',' variableDeclarator)*
    ;
atomType
    :    primitiveType
    |    classType
    ;
empty
    :
    ;
parameter
    :    type Identifier
    ;
statement
    :    variableDeclaration
    #    variableDeclarationStatement
    |    expression ';'
    #    expressionStatement
    |    If '(' expression ')' statement (Else statement)?
    #    ifStatement
    |    While '(' expression ')' statement
    #    whileStatement
    |    For '(' forInit=expression? ';' forCondition=expression? ';' forUpdate=expression? ')' statement
    #    forStatement
    |    Return expression? ';'
    #    returnStatement
    |    Break ';'
    #    breakStatement
    |    Continue ';'
    #    continueStatement
    |    '{' statementList '}'
    #    blockStatement
    |    ';'
    #    emptyStatement
    ;
variableDeclarator
    :    Identifier ('=' expression)?
    ;
primitiveType
    :    token=Bool
    |    token=Int
    |    token=Void
    ;
classType
    :    token=Identifier
    |    token=String
    ;
expression
    :    '(' expression ')'
    #    primaryExpression
    |    token=This
    #    primaryExpression
    |    token=Intliteral
    #    primaryExpression
    |    token=Stringliteral
    #    primaryExpression
    |    token=Boolliteral
    #    primaryExpression
    |    token=Null
    #    primaryExpression
    |    token=Identifier
    #    primaryExpression
    |    expression bop='.' (Identifier | functionCall)
    #    memberExpression
    |    expression '[' expression ']'
    #    arrayExpression
    |    functionCall
    #    funcCallExpression
    |    New creator
    #    newExpression
    |    expression postfix=('++' | '--')
    #    unaryExpression
    |    prefix=('+' | '-' | '++' | '--') expression
    #    unaryExpression
    |    prefix=('~' | '!') expression
    #    unaryExpression
    |    expression bop=('*'|'/'|'%') expression
    #    binaryExpression
    |    expression bop=('+'|'-') expression
    #    binaryExpression
    |    expression bop=('<<'|'>>') expression
    #    binaryExpression
    |    expression bop=('<='|'>='|'<'|'>') expression
    #    binaryExpression
    |    expression bop=('=='|'!=') expression
    #    binaryExpression
    |    expression bop='&' expression
    #    binaryExpression
    |    expression bop='^' expression
    #    binaryExpression
    |    expression bop='|' expression
    #    binaryExpression
    |    expression bop='&&' expression
    #    binaryExpression
    |    expression bop='||' expression
    #    binaryExpression
    |    expression bop='=' expression
    #    assignExpression
    ;
creator
    :   atomType (('[' expression ']')* ('[' empty ']')* | ('(' ')'))
    ;
functionCall
    :   Identifier '(' (expression (',' expression)*)? ')'
    ;
Bool:'bool';
Int:'int';
String:'string';
Null:'null';
Void:'void';
Boolliteral:'true' | 'false';
If:'if';
For:'for';
While:'while';
Break:'break';
Continue:'continue';
Return:'return';
New:'new';
Class:'class';
This:'this';
Else:'else';
Intliteral:[0-9][0-9]*;
Stringliteral:'"' ('\\"' | '\\\\' | .)*?  '"';
Identifier:[a-zA-Z][a-zA-Z0-9_]*;
LINE_COMMENT:'//'~[\n]* -> skip;
BLOCK_COMMENT:'/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;
