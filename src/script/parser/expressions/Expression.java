package script.parser.expressions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

import script.parser.utils.ExpressionParser;

public abstract class Expression implements Serializable {
	private static final String[] OPERATORS = {"+","-","*","/","^"};
	
	private static final long serialVersionUID = 8601239840329721033L;

	@Deprecated
	public abstract String getLval();
	
	public abstract String getOperator();

	@Deprecated
	public abstract String getRval();
	
	public abstract ArrayList<String> getVals();
	
	@Override
	public String toString(){
		return "("+String.join(getOperator(),getVals())+")";
	}

	@Deprecated
	public abstract void clearPlaceholders(Map<Integer, String> repl);
	
	private static String getSplitRegex(){
		String[]regexops = new String[OPERATORS.length];
		for(int i=0;i<OPERATORS.length;i++){
			regexops[i] = Pattern.quote(OPERATORS[i]);
		}
		return "("+String.join("|", regexops)+")";
	}
	
	public static Expression getFromString(String s){
		//TODO: Get ops and vals
		ArrayList<Operator> ops = new ArrayList<>();
		
		ArrayList<String> vals = new ArrayList<>();
		String[]vs=s.replaceAll("(\\(|\\))", "").split(getSplitRegex());
		System.out.println(new ArrayList<String>(Arrays.asList(vs)));
		return null;
	}
	
	private static boolean isOperator(String c){
		for(String d : OPERATORS)
			if(c.equals(d))
				return true;
		return false;
	}
}
