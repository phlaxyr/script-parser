package script.parser.utils;

import script.parser.expressions.BasicExpression;
import script.parser.expressions.BlockExpression;
import script.parser.expressions.Expression;

public final class ExpressionParser {
	private ExpressionParser() {}
	private static final String[] OPERATORS = {"+","-","*","/","^"};
	private static final String[] REGEXOPERATORS = {"\\+","-","\\*","/","^"};
	
	
	/*
	 * To fully parse-ify text, use a combination of hasExpressions and parseLevel().
	 * parseLevel() will parse the text into a leftval and rightval in the order of NUMBEROPERATORS.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static Expression simpleParse(String rawText) {
		System.out.println("ye "+rawText);
		int operatorIndex;
		String lval, operator, rval;
		Expression lexp, rexp = null;
		boolean isFurtherParsible=false;
		for(int i=0;i<OPERATORS.length;i++) {
			if (rawText.contains(OPERATORS[i])) {
				operatorIndex=rawText.indexOf(OPERATORS[i]);
				lval=rawText.substring(0,operatorIndex);
				rval=rawText.substring(operatorIndex+1);
				operator=OPERATORS[i];
				System.out.println(lval+ "   "+rval);
				System.out.println(new BasicExpression("("+lval+")",operator,"("+rval+")"));
				System.out.println("LHasExpr:"+hasExpression(lval));
				System.out.println("RHasExpr:"+hasExpression(rval));

				if(hasExpression(lval)) {
					lexp = simpleParse(lval);
					isFurtherParsible=true;
				} else {
					lexp=new BasicExpression(lval,"","");
				}
				if(hasExpression(rval)) {
					rexp = simpleParse(rval);
					isFurtherParsible=true;
				} else {
					rexp=new BasicExpression(rval,"","");
				}
				if(isFurtherParsible) {
					System.out.println("lexp: "+lexp+"\nrexp: "+rexp);
					return new BlockExpression(lexp,operator,rexp);
				}
				return new BasicExpression("("+lval+")",operator,"("+rval+")");
			}
		}
		return new BasicExpression("6","","");
	}
	
	public static boolean hasExpression(String rawText) {
		boolean hasExp=false;
		for(String str:OPERATORS) {
			hasExp|=rawText.contains(str);
			//really inefficient, but I'm too lazy to examine regex today
		}
		return hasExp;

	}
}
