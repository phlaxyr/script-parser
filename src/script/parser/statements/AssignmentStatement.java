package script.parser.statements;

import script.parser.Expression;

public class AssignmentStatement extends BasicStatement {
	private static final long serialVersionUID = 6691001676477011939L;
	public String type;	//Only if it's a variable declaration
	public String var;
	public boolean isDeclaration;
	public Expression expression;
	
	public AssignmentStatement(String t) {
		super(t);
		String[]parts=t.split(" +");	//Slice into itty bitty [sic] bite sized pieces
		if(parts[0].contains("=")||parts[1].startsWith("=")){
			isDeclaration = false;
			var = t.split("=",2)[0].trim();
		} else {
			isDeclaration = true;
			var = t.split("=",2)[0].split(" ")[1].trim();
			type = parts[0];
		}
		expression = new Expression(t.split("=",2)[1]);
	}
	
	@Override
	public String toString(){
		return "Var("+(isDeclaration?"Decl":"Set")+")<"+(isDeclaration?type:"")+"> "+var+" = "+expression.exp;
	}
}
