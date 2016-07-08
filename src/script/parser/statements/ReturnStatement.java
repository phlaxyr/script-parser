package script.parser.statements;

public class ReturnStatement extends BasicStatement {
	private static final long serialVersionUID = 3736525393565830511L;
	public String returnval;
	
	public ReturnStatement(String t) {
		super(t);
		returnval = t.split(" ",2)[1];
	}
	
}
