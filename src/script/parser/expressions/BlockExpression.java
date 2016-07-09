package script.parser.expressions;

public class BlockExpression extends Expression {
	
	private static final long serialVersionUID = 5123815753915499326L;
	public String callname; //null or empty for simple order grouping
	public Expression lval;
	public String op;
	public Expression rval;
	
	public BlockExpression(Expression lval, String op, Expression rval){
		this(lval, op, rval, null);
	}
	
	public BlockExpression(Expression lval, String op, Expression rval, String callname){
		this.lval = lval;
		this.op = op;
		this.rval = rval;
		this.callname = callname;
	}
}
