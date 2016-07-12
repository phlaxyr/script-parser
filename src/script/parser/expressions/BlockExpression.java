package script.parser.expressions;

import java.util.ArrayList;
import java.util.Map;

public class BlockExpression extends Expression {
	
	private static final long serialVersionUID = 5123815753915499326L;
	public String callname; //null or empty for simple order grouping
	public ArrayList<Expression>values=new ArrayList<>();
	public String op;
	
	@Deprecated
	public BlockExpression(Expression lval, String op, Expression rval){
		this(lval, op, rval, null);
	}
	
	@Deprecated
	public BlockExpression(Expression lval, String op, Expression rval, String callname){
		this.values.add(lval);
		this.op = op;
		this.values.add(rval);
		this.callname = callname;
	}
	
	public BlockExpression(ArrayList<Expression> vals, String op, String callname){
		this.values = vals;
		this.op = op;
		this.callname = callname;
	}
	
	@Deprecated
	@Override
	public String getLval() {
		return values.get(0).toString();
	}
	
	@Override
	public String getOperator() {
		return op;
	}
	

	@Deprecated
	@Override
	public String getRval() {
		return values.get(1).toString();
	}

	@Deprecated
	@Override
	public void clearPlaceholders(Map<Integer,String> placeholders) {
		values.get(0).clearPlaceholders(placeholders);
		values.get(1).clearPlaceholders(placeholders);
	}

	@Override
	public ArrayList<String> getVals() {
		ArrayList<String>ret = new ArrayList<>();
		for(Expression e : values){
			ret.add(e.toString());
		}
		return ret;
	}
	
	@Override
	public String getVal(int index) {
		return values.get(index).toString();
	}
}
