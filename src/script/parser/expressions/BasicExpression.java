package script.parser.expressions;

import java.util.ArrayList;
import java.util.Map;

import script.parser.utils.ExpressionParser;

public class BasicExpression extends Expression {

	private static final long serialVersionUID = 5994162608353948937L;
	
	public String op;
	public ArrayList<String>values=new ArrayList<>();

	public BasicExpression(String lval, String op, String rval){
		this.values.add(lval);
		this.op = op;
		this.values.add(rval);
	}
	
	public BasicExpression(ArrayList<String>val, String op){
		this.values=val;
		this.op = op;
	}
	
	@Deprecated
	@Override
	public String getLval() {
		return values.get(0);
	}

	@Override
	public String getOperator() {
		return op;
	}

	@Deprecated
	@Override
	public String getRval() {
		return values.get(1);
	}

	@Deprecated
	@Override
	public void clearPlaceholders(Map<Integer,String> placeholders) {
		while(this.getLval().contains(ExpressionParser.placeholder)){
			int num = Integer.valueOf(values.get(0).split("\\.")[1].replaceAll("\\D", ""));
			values.set(0,values.get(0).replace(ExpressionParser.placeholder+num,placeholders.get(num)));
		}
		while(this.getRval().contains(ExpressionParser.placeholder)){
			int num = Integer.valueOf(values.get(1).split("\\.")[1].replaceAll("\\D", ""));
			values.set(1,values.get(1).replace(ExpressionParser.placeholder+num,placeholders.get(num)));
		}
	}

	@Override
	public ArrayList<String> getVals() {
		return values;
	}

	@Override
	public String getVal(int index) {
		return values.get(index); //the only time a string.tostring is useful
	}

}
