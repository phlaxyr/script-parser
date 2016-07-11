package script.parser.expressions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public abstract class Expression implements Serializable {
	
	private static final long serialVersionUID = 8601239840329721033L;

	@Deprecated
	public abstract String getLval();
	
	public abstract String getOperator();

	@Deprecated
	public abstract String getRval();
	
	public abstract ArrayList<String> getVals();
	
	@Override
	public String toString(){
		return "("+String.join(getOperator(),getVals())+")";
	}

	@Deprecated
	public abstract void clearPlaceholders(Map<Integer, String> repl);
}
