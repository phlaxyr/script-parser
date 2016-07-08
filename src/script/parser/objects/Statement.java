package script.parser.objects;

import script.parser.StatementType;

public abstract class Statement extends Token {
	public abstract StatementType getType();
	
	public Statement(String t) {
		super(t);
	}

}
