package script.parser.objects;

import script.parser.StatementType;

public class BasicStatement extends Statement {

	public BasicStatement(String t) {
		super(t);
	}

	@Override
	public StatementType getType() {
		return StatementType.BASIC;
	}

}
