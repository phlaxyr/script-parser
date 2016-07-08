package script.parser.objects;

public class AssignmentStatement extends BasicStatement {
	public String type;	//Only if it's a variable declaration
	public String var;
	public Expression expression;
	
	public AssignmentStatement(String t) {
		super(t);
		
		//TODO: Extract type, variable, and expression
	}
}
