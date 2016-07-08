package script.parser.objects;

import java.io.Serializable;

import script.parser.StatementType;

public abstract class Statement extends Token implements Serializable {
	private static final long serialVersionUID = 7644229135155922727L;

	public abstract StatementType getType();
	
	public Statement(String t) {
		super(t);
	}

}
