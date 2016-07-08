package script.parser.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Program implements Serializable {
	ArrayList<ClassStatement> classes = new ArrayList<>();
	public Program(){
		//TODO
	}
	
	public Program addClass(ClassStatement cs){
		classes.add(cs);
		return this;
	}
}
