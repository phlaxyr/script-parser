package script.parser;

import java.io.Serializable;

public class Expression implements Serializable {
	
	private static final long serialVersionUID = 8601239840329721033L;
	
	//TODO: Improve
	public String exp;
	public Expression(String ex){
		exp = ex;
	}
}
