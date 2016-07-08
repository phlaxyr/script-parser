package script.parser.statements;

import script.parser.enums.StatementType;

public abstract class BasicStatement extends Statement {

	private static final long serialVersionUID = -2090828772652539299L;

	public BasicStatement(String t) {
		super(t);
	}

	@Override
	public StatementType getType() {
		return StatementType.BASIC;
	}

}
