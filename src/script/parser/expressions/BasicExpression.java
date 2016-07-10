package script.parser.expressions;

import java.util.Map;

import script.parser.utils.ExpressionParser;

public class BasicExpression extends Expression {

	private static final long serialVersionUID = 5994162608353948937L;
	
	public String lval, op, rval;
	
	public BasicExpression(String lval, String op, String rval){
		this.lval = lval;
		this.op = op;
		this.rval = rval;
	}

	@Override
	public String getLval() {
		return lval;
	}

	@Override
	public String getOperator() {
		return op;
	}

	@Override
	public String getRval() {
		return rval;
	}

	@Override
	public void clearPlaceholders(Map<Integer,String> placeholders) {
		while(this.getLval().contains(ExpressionParser.placeholder)){
			int num = Integer.valueOf(lval.split("\\.")[1].replaceAll("\\D", ""));
			lval = lval.replace(ExpressionParser.placeholder+num,placeholders.get(num));
			System.out.println("LV "+lval);
		}
		while(this.getRval().contains(ExpressionParser.placeholder)){
			int num = Integer.valueOf(rval.split("\\.")[1].replaceAll("\\D", ""));
			rval = rval.replace(ExpressionParser.placeholder+num,placeholders.get(num));
		}
	}


}
