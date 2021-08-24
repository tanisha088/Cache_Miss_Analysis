grammar LoopNest;

tests
    : methodDeclaration+
    ;

literal
	:	IntegerLiteral
	|	FloatingPointLiteral
	|	BooleanLiteral
	|	CharacterLiteral
	|	StringLiteral
	;

numericType
	:	integralType
	|	floatingPointType
	;

integralType
	:	'byte'
	|	'short'
	|	'int'
	|	'long'
	|	'char'
	;

floatingPointType
	:	'float'
	|	'double'
	;

dims
	:	'[' ']'
    |   '[' ']' '[' ']'
    |   '[' ']' '[' ']' '[' ']'
	;

methodName
	:	Identifier
	;

methodDeclaration
	:	methodHeader methodBody
	;

methodHeader
	:	'void' methodDeclarator
	;

methodDeclarator
	:	Identifier '(' ')'
	;

methodBody
	:	block
	;

block
	:	'{' blockStatements? '}'
	;

blockStatements
	:	blockStatement+
	;

blockStatement
	:	localVariableDeclarationStatement
	|	statement
	;

localVariableDeclarationStatement
	:	localVariableDeclaration ';'
	;

localVariableDeclaration
	:	(unannType | unannStringType) variableDeclarator
	;

unannType
	:	unannPrimitiveType
	|	unannArrayType
	;

unannStringType
    :   'String'
    ;

unannPrimitiveType
	:	numericType
	|	'boolean'
	;

unannArrayType
	:	unannPrimitiveType dims
	;

variableDeclarator
	:	variableDeclaratorId '=' (literal | arrayCreationExpression)
	;

variableDeclaratorId
	:	Identifier
	;

statement
	:	expressionStatement
	|	forStatement
	;

expressionStatement
	:	assignment ';'
	;

assignment
	:	leftHandSide assignmentOperator expression
	;

simplifiedAssignment
    :   expressionName '+=' (expressionName | IntegerLiteral)
    ;

leftHandSide
	:	expressionName
	|	arrayAccess
	;

expressionName
	:	Identifier
	;

arrayAccess
    :   expressionName '[' expressionName ']'
    |   expressionName '[' expressionName ']' '[' expressionName ']'
    |   expressionName '[' expressionName ']' '[' expressionName ']' '[' expressionName ']'
    ;

assignmentOperator
	:	'='
	|	'*='
	|	'/='
	|	'%='
	|	'+='
	|	'-='
	|	'<<='
	|	'>>='
	|	'>>>='
	|	'&='
	|	'^='
	|	'|='
	;

expression
    :   equalityExpression
    ;

equalityExpression
	:	relationalExpression
	|	equalityExpression '==' relationalExpression
	|	equalityExpression '!=' relationalExpression
	;

relationalExpression
	:	shiftExpression
	|	expressionName '<' (expressionName | IntegerLiteral)
	;

shiftExpression
	:	additiveExpression
	|	shiftExpression '<' '<' additiveExpression
	|	shiftExpression '>' '>' additiveExpression
	|	shiftExpression '>' '>' '>' additiveExpression
	;

additiveExpression
	:	multiplicativeExpression
	|	additiveExpression '+' multiplicativeExpression
	|	additiveExpression '-' multiplicativeExpression
	;

multiplicativeExpression
	:	unaryExpression
	|	multiplicativeExpression '*' unaryExpression
	|	multiplicativeExpression '/' unaryExpression
	|	multiplicativeExpression '%' unaryExpression
	;

unaryExpression
	:	postfixExpression
    |   '-' unaryExpression
	|	'!' unaryExpression
	;

postfixExpression
	:	primary
	|	expressionName
	;

primary
	:	primaryNoNewArray_lfno_primary
    |   arrayCreationExpression
	;

arrayCreationExpression
	:	'new' unannPrimitiveType dimExprs
	;

dimExprs
	:	dimExpr
    |   dimExpr dimExpr
    |   dimExpr dimExpr dimExpr
	;

dimExpr
	:	'[' (expressionName | IntegerLiteral) ']'
	;

primaryNoNewArray_lfno_primary
	:	literal
	|	'(' expression ')'
	|	arrayAccess_lfno_primary
	;

arrayAccess_lfno_primary
	:	expressionName '[' expressionName ']'
    |   expressionName '[' expressionName ']' '[' expressionName ']'
    |   expressionName '[' expressionName ']' '[' expressionName ']' '[' expressionName ']'
	;

forStatement
	:	'for' '(' forInit ';' forCondition ';' forUpdate ')' block
	;

forInit
    :   localVariableDeclaration
    ;

forCondition
    :   relationalExpression
    ;

forUpdate
    :   simplifiedAssignment
    ;


// LEXER


// 3.10.1 Integer Literals

IntegerLiteral
	:	DecimalNumeral
	;

fragment
DecimalNumeral
	:	'0'
	|	NonZeroDigit Digits?
	;

fragment
Digits
	:	Digit+
	;

fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

fragment
NonZeroDigit
	:	[1-9]
	;

// 3.10.2 Floating-Point Literals

FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	;

fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;

fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

fragment
ExponentIndicator
	:	[eE]
	;

fragment
SignedInteger
	:	Sign? Digits
	;

fragment
Sign
	:	[+-]
	;

fragment
FloatTypeSuffix
	:	[fFdD]
	;

fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

fragment
BinaryExponentIndicator
	:	[pP]
	;

// 3.10.3 Boolean Literals

BooleanLiteral
	:	'true'
	|	'false'
	;

// 3.10.4 Character Literals

CharacterLiteral
	:	'\'' SingleCharacter '\''
	|	'\'' EscapeSequence '\''
	;

fragment
SingleCharacter
	:	~['\\\r\n]
	;

// 3.10.5 String Literals

StringLiteral
	:	'"' StringCharacters? '"'
	;

fragment
StringCharacters
	:	StringCharacter+
	;

fragment
StringCharacter
	:	~["\\\r\n]
	|	EscapeSequence
	;

// 3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
	;

// 3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
	:	IdentifierStart IdentifierPart*
	;

fragment IdentifierStart
	: [\u0024] // $ sign
	| [\u0041-\u005A] // A-Z
	| [\u005F] // underscore
	| [\u0061-\u007A] // a-z
	;

fragment IdentifierPart
	: IdentifierStart
	| [\u0030-\u0039] // 0-9
	;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
