package script.parser.utils;

import script.parser.expressions.Expression;

public final class ExpressionParser {
	private ExpressionParser() {}
	private static final String[] NUMBEROPERATORS = {"+","-","*","/","^","=","("};
	
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
	public static Expression parseLevel(String rawText) {
		String leftVal;
		String rightVal;
		String operator;
		String[] subRawText;
		for(String str:NUMBEROPERATORS) {
			if (rawText.contains(str)) {
				operator=str;
				subRawText=rawText.split(str);
				leftVal=subRawText[0];
				rightVal=subRawText[1];
			}
		}
		
	}
	
	public static Expression parse(String rawText) {
		String leftVal;
		String rightVal;
		String operator;
		String[] subRawText;
		for(String str:NUMBEROPERATORS) {
			if (rawText.contains(str)) {
				operator=str;
				subRawText=rawText.split(str);
				leftVal=subRawText[0];
				rightVal=subRawText[1];
				if(hasExpression(leftVal)) {
					parse(leftVal);
				}
				if(hasExpression(rightVal)) {
					parse(rightVal);
				}
			}
		}
		
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
