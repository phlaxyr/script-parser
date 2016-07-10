package script.parser.utils;

import script.parser.expressions.BasicExpression;
import script.parser.expressions.BlockExpression;
import script.parser.expressions.Expression;

public final class ExpressionParser {
	private ExpressionParser() {}
	private static final String[] NUMBEROPERATORS = {"\\+","-","\\*","/","^","=","\\("};
	
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
	
	public static Expression parse(String rawText) {
		String leftVal;
		String rightVal;
		Expression leftExp = null;
		Expression rightExp = null;
		String operator;
		String[] subRawText;
		boolean hasExp=false;
		for(String str:NUMBEROPERATORS) {
			if (rawText.contains(str)) {
				operator=str;
				subRawText=rawText.split(str);
				leftVal=subRawText[0];
				rightVal=subRawText[1];
				if(hasExpression(leftVal)) {
					hasExp=true;
					leftExp = parse(leftVal);
				}
				if(hasExpression(rightVal)) {
					hasExp=true;
					rightExp = parse(rightVal);
				}
				if(hasExp){
					return new BlockExpression(leftExp,operator,rightExp);
				} else return new BasicExpression(leftVal,operator,rightVal);
			}
		} return new BasicExpression(rawText,"","");
		
	}
	
	public static boolean hasExpression(String rawText) {
		boolean hasExp=false;
		for(String str:NUMBEROPERATORS) {
			hasExp|=rawText.contains(str);
			//really inefficient, but I'm too lazy to examine regex today
		}
		return hasExp;

	}
}
