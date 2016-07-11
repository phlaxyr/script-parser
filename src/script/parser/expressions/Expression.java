package script.parser.expressions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

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
	
	public static Expression getFromString(String s){
		//TODO: Get ops and vals
		ArrayList<Operator> ops;
		ArrayList<String> vals;
	}
	
	private static boolean isOperator(String c){
		for(String d : OPERATORS)
			if(c.equals(d))
				return true;
		return false;
	}
}
