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
		
		switch(t.getStatement().split(" ")[0]){
		case "Class":
			return StatementType.CLASS;
		default:
			return null;
		}
	}
	
	public Statement toStatement(){
		switch(getType(this)){
		case BASIC:
			break;
		case BLOCK:
			break;
		case CLASS:
			return new ClassStatement(this.statements);
		default:
			break;
		}
		
		return null;
	}
}
