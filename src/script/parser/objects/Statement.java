package script.parser.objects;

import java.io.Serializable;

import script.parser.StatementType;

public abstract class Statement extends Token implements Serializable {
	public abstract StatementType getType();
	
	public Statement(String t) {
		super(t);
	}

}
