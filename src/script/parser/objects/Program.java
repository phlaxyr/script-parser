package script.parser.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Program implements Serializable {

	private static final long serialVersionUID = 416477170582420814L;
	ArrayList<ClassStatement> classes = new ArrayList<>();
	public Program(){
		//TODO
	}
	
	public Program addClass(ClassStatement cs){
		classes.add(cs);
		return this;
	}
}
