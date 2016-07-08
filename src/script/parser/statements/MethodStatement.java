package script.parser.statements;

import script.parser.enums.StatementType;

public class MethodStatement extends BlockStatement{

	private static final long serialVersionUID = -7553320075240785551L;
	private String methodname;
	private String returntype;
	
	public MethodStatement(String t) {
		super(t);
		String header = t.split("\\(")[0];
		returntype = header.split("<")[1].split(">")[0];
		methodname = header.split(">")[1].trim();
		
	}
	
	@Override
	public String toString(){
		return "Method<"+returntype+"> "+methodname+":"+substatements;
	}
	
	@Override
	public StatementType getType() {
		return StatementType.METHOD;
	}
}
