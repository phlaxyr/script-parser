package script.parser.statements;

import script.parser.enums.StatementType;

public class FunctionStatement extends BlockStatement{

	private static final long serialVersionUID = 3316282013261557408L;
	private String functionName;
	private String returnType;
	
	public FunctionStatement(String t) {
		super(t);
		String header = t.split("\\(")[0];
		returnType = header.split("<")[1].split(">")[0];
		functionName = header.split(">")[1].trim();
		
	}
	
	@Override
	public String toString(){
		return "Method<"+returnType+"> "+functionName+":"+substatements;
	}
	
	@Override
	public StatementType getType() {
		return StatementType.FUNCTION;
	}
}
