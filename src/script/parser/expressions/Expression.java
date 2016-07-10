package script.parser.expressions;

import java.io.Serializable;

public abstract class Expression implements Serializable {
	
	private static final long serialVersionUID = 8601239840329721033L;
	
	public abstract String getLval();
	public abstract String getOperator();
	public abstract String getRval();
	
	@Override
	public String toString(){
		return getLval() + getOperator() + getRval();
	}
}
