package script.parser.expressions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import script.parser.utils.ExpressionParser;

public abstract class Expression implements Serializable {
	public static final String[] OPERATORS = {"+","-","*","/","^"};
	
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
		ArrayList<Operator> ops = new ArrayList<>();
		
		ArrayList<String> vals = new ArrayList<>(Arrays.asList(s.split(getSplitRegex())));
		
		int level = 0;
		Iterator<String> iter = vals.iterator();
		System.out.println(vals);
		while(iter.hasNext()){
			String val = iter.next().replaceAll("(\\(|\\))", "");
			String[]ar=s.split(Pattern.quote(val), 2);
			while(ar[0].contains(")")){
				ar[0]=ar[0].replaceFirst("\\)", "");
				level--;
			}
			if(!ar[0].isEmpty())
				ops.add(new Operator(ar[0].replace("(", ""),level,getPrecendance(ar[0].replace("(", ""))));
			s = ar[1];
			while(ar[0].contains("(")){
				ar[0]=ar[0].replaceFirst("\\(", "");
				level++;
			}
		}
		
		System.out.println(ops + ":" + level + ":" + s);
		
		for(int i=0;i<ops.size();i++){
			Operator op = ops.get(i);
			op.lval = vals.get(i);
			op.rval = vals.get(i+1);
		}
		
		System.out.println(ops + ":" + level + ":" + s);	
		
		//TODO: Convert Operators to Expression
		
		return null;	//Temporary
	}
	
	private static int getPrecendance(String c){
		for(int i=0;i<OPERATORS.length;i++){
			String d = OPERATORS[i];
			if(c.equals(d))
				return i;
		}
		return -1;
	}
}
