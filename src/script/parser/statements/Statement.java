package script.parser.statements;

import java.io.Serializable;

import script.parser.Token;
import script.parser.enums.StatementType;

public abstract class Statement extends Token implements Serializable {
	private static final long serialVersionUID = 7644229135155922727L;

	public abstract StatementType getType();
	
	public Statement(String t) {
		super(t);
	}

}
