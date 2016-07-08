package script.parser.objects;

import script.parser.StatementType;

public class MethodStatement extends BlockStatement{
	private String methodname;
	private String returntype;
	
	public MethodStatement(String t) {
		super(t);
		String header = t.split("\\(")[0];
		String[] har = header.split(" ");
		returntype = har[0].split("<")[1].split(">")[0];
		methodname = har[har.length - 1];
		
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
