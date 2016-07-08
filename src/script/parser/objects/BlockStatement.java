package script.parser.objects;

import java.util.ArrayList;

import script.parser.StatementType;

public class BlockStatement extends Statement {
	
	public ArrayList<Statement>substatements = new ArrayList<>();
	
	public BlockStatement(String t) {
		super(t);
	}

	@Override
	public StatementType getType() {
		return StatementType.BLOCK;
	}

}
