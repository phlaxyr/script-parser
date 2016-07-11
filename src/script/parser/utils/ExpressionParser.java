package script.parser.utils;

import java.util.HashMap;
import java.util.Map;

import script.parser.expressions.BasicExpression;
import script.parser.expressions.BlockExpression;
import script.parser.expressions.Expression;

public final class ExpressionParser {
	private ExpressionParser() {}
	private static final String[] OPERATORS = {"+","-","*","/","^"};

	public static Expression parse(String rawText){
		if(rawText.contains(placeholder)){
			//TODO: Make specific Exceptions for different cases 
			throw new RuntimeException("Expression contains reserved keywords");
		}
		Expression ret = simpleParse(rawText);
		System.out.println(ret+":"+repl);
		ret.clearPlaceholders(repl);
		repl_num = 0;
		repl.clear();
		return ret;
	}

	//Thing for ugly fix
	public static Map<Integer,String>repl=new HashMap<>();
	private static int repl_num = 0;
	public static final String placeholder = "__PLACEHOLDER.";


	private static Expression simpleParse(String rawText) {
		System.out.println("ye "+rawText);
		int operatorIndex;
		String lval, operator, rval;
		Expression lexp, rexp = null;
		boolean isFurtherParsible=false;

		//BEGIN Ugly fix for parenthesis bug ~minerguy31
		
		
		//TODO Optimization (cause that's some messy code)
		int start = 0, end = 0;


		
		
		for(int j=0;j<rawText.length();j++){
			int level = 1;
			if(rawText.charAt(j)=='('){
				start = j;
				while(rawText.length()>j && level > 0){
					if(rawText.charAt(j)==')')
						level--;
					if(rawText.charAt(j)=='(')
						level++;
					j++;
				}
				end = j;
				if(rawText.length()>j)
					end++;

				String subexp = rawText.substring(start, end);
				rawText = rawText.replace(subexp, placeholder+repl_num);
				System.out.println(repl_num);
				repl.put(repl_num++,simpleParse(subexp.substring(1,subexp.length()-1)).toString());
				System.out.println("hi");

			}
		}

		//END

		for(int i=0;i<OPERATORS.length;i++) {
			if (rawText.contains(OPERATORS[i])) {
				operatorIndex=rawText.indexOf(OPERATORS[i]);
				lval=rawText.substring(0,operatorIndex);
				rval=rawText.substring(operatorIndex+1);
				operator=OPERATORS[i];

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
					return new BlockExpression(lexp,operator,rexp);
				}
				return new BasicExpression(lval,operator,rval);
			}
		}
		return new BasicExpression(rawText,"","");
	}

	public static boolean hasExpression(String rawText) {
		//TODO: Improve further with regex
		for(String str:OPERATORS) {
			if(rawText.contains(str))
				return true;
		}
		return false;
	}
	
//
	public static Expression parenParse(String rawText) {
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
					return new BlockExpression(lexp,operator,rexp);
				}
				return new BasicExpression(lval,operator,rval);
			}
		}
		return new BasicExpression(rawText,"","");
	}
	
	public static String[] extractParen(String r) {
		if(r.contains("(")&&r.contains(")")) {
			int parenSt=r.indexOf("(");
			int endInd=r.indexOf(")");
			String spliced=r.substring(parenSt+1);
			int stInd=spliced.indexOf("(");
			String[] returnstr= new String[2];
			if(stInd==-1) {
				//runs when there is only 1 paren
				returnstr[0]=r.substring(0, parenSt).concat(r.substring(endInd+1));
				returnstr[1]=r.substring(endInd);
				p("a");
				p(parenSt);
				for(String s:returnstr) {
					p(s);
				}
				return returnstr;
				
			}
			else if(stInd<endInd&&stInd!=-1) {
				//runs when there are nested paren in the paren
				p("b");
			}
			else if(stInd>endInd&&stInd!=-1) {
				//runs when there are no nested paren in the paren
				returnstr[0]=r.substring(0, parenSt).concat(r.substring(endInd));
				returnstr[1]=r.substring(endInd);
				p("c");
				return returnstr;
			} else return returnstr; //should never happen
			
		} return null;
	}
	
	private static void p(Object o) {
		System.out.println(o);
	}
	
}