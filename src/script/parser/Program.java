package script.parser;

import java.io.Serializable;
import java.util.ArrayList;

import script.parser.statements.ClassStatement;

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
	
	@Override
	public String toString(){
		return classes.toString();
	}
}
