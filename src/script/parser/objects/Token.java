package script.parser.objects;

import java.util.ArrayList;

import script.parser.StatementType;
import script.parser.Tokenizer;

public class Token {
	private String statements;
	
	public Token(String t){
		statements = t;
	}
	
	public void setToken(String s){
		statements = s;
	}
	
	public String getStatement(){
		return statements;
	}
	
	public Boolean containsSubtokens(){
		return Tokenizer.isFurtherTokenizable(this.statements);
	}
	
	public ArrayList<Token> getSubTokens(){
		if(!containsSubtokens())
			return null;
		
		ArrayList<String>subTokens = Tokenizer.getSubTokens(this.statements);
		ArrayList<Token>ret = new ArrayList<>();
		
		for(String s : subTokens){
			ret.add(new Token(s));
		}
		
		return ret;
	}
	
	@Override
	public String toString(){
		return getStatement();
	}
	
	public static StatementType getType(Token t){
		if(!t.containsSubtokens())
			return StatementType.BASIC;
		String[]parts = t.getStatement().split(" ");
		
		switch(parts[0]){
		case "Class":
			return StatementType.CLASS;
		case "Function":
			return StatementType.FUNCTION;
		default:
			break;
		}
		
		if(parts[0].split("<")[0].startsWith("Method"))
			return StatementType.METHOD;
		else if(parts[0].split("<")[0].startsWith("Function"))
			return StatementType.FUNCTION;
		
		return null;	//Should never happen in final release
	}
	
	public Statement toStatement(){
		switch(getType(this)){
		case BASIC:
			return new BasicStatement(this.statements);
		case BLOCK:
			return new BlockStatement(this.statements);
		case CLASS:
			return new ClassStatement(this.statements);
		case METHOD:
			return new MethodStatement(this.statements);
		default:
			break;
		}
		
		return null;	//Should never happen in final release
	}
}
