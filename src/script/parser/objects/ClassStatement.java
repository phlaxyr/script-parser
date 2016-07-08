package script.parser.objects;

import script.parser.StatementType;

public class ClassStatement extends BlockStatement {

	private static final long serialVersionUID = 7243754548818286899L;
	private String classname;
	
	public ClassStatement(String t) {
		super(t);
		classname = t.split("\\{")[0].split(" ")[1];
	}

	@Override
	public StatementType getType() {
		return StatementType.CLASS;
	}
	
	public String getClassname(){
		return classname;
	}
	
	@Override
	public String toString(){
		return classname+":"+substatements;
	}
}
