package script.parser.expressions;

public class Operator {
	public String op, lval, rval;
	public int nestlvl, preclvl;
	
	public Operator(String lval, String op, String rval, int nest, int prec){
		this(op,nest,prec);
		this.lval=lval;
		this.rval=rval;
	}
	
	public Operator(String op, int nest, int prec){
		this.op=op;
		nestlvl = nest;
		preclvl = prec;
	}
	
	@Override
	public String toString(){
		return "{"+lval+op+rval+","+getScore()+"}";
	}
	
	public int getScore(){
		return nestlvl*Expression.OPERATORS.length + preclvl;
	}
}
