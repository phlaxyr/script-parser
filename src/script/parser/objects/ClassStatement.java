package script.parser.objects;

import script.parser.StatementType;

public class ClassStatement extends Statement {
	private String classname;
	
	public ClassStatement(String t) {
		super(t);
	}

	@Override
	public StatementType getType() {
		return StatementType.CLASS;
	}
	
}
