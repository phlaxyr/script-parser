package script.parser.expressions;

public class BasicExpression extends Expression {

	private static final long serialVersionUID = 5994162608353948937L;
	
	public String lval, op, rval;
	
	public BasicExpression(String lval, String op, String rval){
		this.lval = lval;
		this.op = op;
		this.rval = rval;
	}

}
