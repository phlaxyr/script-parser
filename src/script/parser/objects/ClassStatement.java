package script.parser.objects;

import java.util.ArrayList;

import script.parser.StatementType;
import script.parser.Tokenizer;

public class ClassStatement extends BlockStatement {
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
