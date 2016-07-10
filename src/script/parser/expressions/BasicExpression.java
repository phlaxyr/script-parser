package script.parser.expressions;

import java.util.ArrayList;

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
	public void clearPlaceholders(ArrayList<String> placeholders) {
		System.out.println(lval+":"+rval);
		if(this.getLval().startsWith(ExpressionParser.placeholder)){
			int num = Integer.valueOf(lval.split("\\.")[1]);
			lval = placeholders.get(num);
		}else if(this.getRval().startsWith(ExpressionParser.placeholder)){
			int num = Integer.valueOf(rval.split("\\.")[1]);
			rval = placeholders.get(num);
		}
	}


}
