package script.parser.utils;

import java.util.ArrayList;
import java.util.Map;

import script.parser.expressions.BasicExpression;
import script.parser.expressions.BlockExpression;
import script.parser.expressions.Expression;

public final class ExpressionParser {
	private ExpressionParser() {}
	private static final String[] OPERATORS = {"+","-","*","/","^"};
	private static final String[] REGEXOPERATORS = {"\\+","-","\\*","/","^"};
	
	public static Expression parse(String rawText){
		Expression ret = simpleParse(rawText);
		ret.clearPlaceholders(repl);
		repl_num = 0;
		repl.clear();
		return ret;
	}
	
	//Thing for ugly fix
	public static ArrayList<String>repl=new ArrayList<>();
	private static int repl_num = 0;
	public static final String placeholder = "__PLACEHOLDER.";
	
	
	private static Expression simpleParse(String rawText) {
		System.out.println("ye "+rawText);
		int operatorIndex;
		String lval, operator, rval;
		Expression lexp, rexp = null;
		boolean isFurtherParsible=false;
		
		//BEGIN Ugly fix for parenthesis bug ~minerguy31
		int start = 0, end = 0;
		
		
		for(int j=0;j<rawText.length();j++){
			if(rawText.charAt(j)=='('){
				start = j;
				while(rawText.length()>j && rawText.charAt(j)!=')')
					j++;
				end = j;
				if(rawText.length()>j)
					end++;
				
				String subexp = rawText.substring(start, end);
				rawText = rawText.replace(subexp, placeholder+repl_num);
				repl.add(simpleParse(subexp.split("\\(")[1].split("\\)")[0]).toString());
				repl_num++;
				
			}
		}
		
		//END
		
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
				return new BasicExpression(lval,operator,rval);
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