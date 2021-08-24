// Generated from LoopNest.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LoopNestParser}.
 */
public interface LoopNestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#tests}.
	 * @param ctx the parse tree
	 */
	void enterTests(LoopNestParser.TestsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#tests}.
	 * @param ctx the parse tree
	 */
	void exitTests(LoopNestParser.TestsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(LoopNestParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(LoopNestParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(LoopNestParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(LoopNestParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(LoopNestParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(LoopNestParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(LoopNestParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(LoopNestParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(LoopNestParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(LoopNestParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(LoopNestParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(LoopNestParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(LoopNestParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(LoopNestParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(LoopNestParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(LoopNestParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(LoopNestParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(LoopNestParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(LoopNestParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(LoopNestParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LoopNestParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LoopNestParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(LoopNestParser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(LoopNestParser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(LoopNestParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(LoopNestParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(LoopNestParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(LoopNestParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(LoopNestParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(LoopNestParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(LoopNestParser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(LoopNestParser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#unannStringType}.
	 * @param ctx the parse tree
	 */
	void enterUnannStringType(LoopNestParser.UnannStringTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#unannStringType}.
	 * @param ctx the parse tree
	 */
	void exitUnannStringType(LoopNestParser.UnannStringTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(LoopNestParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(LoopNestParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(LoopNestParser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(LoopNestParser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(LoopNestParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(LoopNestParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(LoopNestParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(LoopNestParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LoopNestParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LoopNestParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(LoopNestParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(LoopNestParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LoopNestParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LoopNestParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#simplifiedAssignment}.
	 * @param ctx the parse tree
	 */
	void enterSimplifiedAssignment(LoopNestParser.SimplifiedAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#simplifiedAssignment}.
	 * @param ctx the parse tree
	 */
	void exitSimplifiedAssignment(LoopNestParser.SimplifiedAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(LoopNestParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(LoopNestParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(LoopNestParser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(LoopNestParser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(LoopNestParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(LoopNestParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(LoopNestParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(LoopNestParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LoopNestParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LoopNestParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(LoopNestParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(LoopNestParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(LoopNestParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(LoopNestParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(LoopNestParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(LoopNestParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(LoopNestParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(LoopNestParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(LoopNestParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(LoopNestParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(LoopNestParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(LoopNestParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(LoopNestParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(LoopNestParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(LoopNestParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(LoopNestParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(LoopNestParser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(LoopNestParser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(LoopNestParser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(LoopNestParser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(LoopNestParser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(LoopNestParser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary(LoopNestParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary(LoopNestParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lfno_primary(LoopNestParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lfno_primary(LoopNestParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(LoopNestParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(LoopNestParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(LoopNestParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(LoopNestParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(LoopNestParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(LoopNestParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LoopNestParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(LoopNestParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LoopNestParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(LoopNestParser.ForUpdateContext ctx);
}