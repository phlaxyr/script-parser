package script.parser;

import java.util.ArrayList;

public class Tokenizer {
	private Tokenizer() {}
	
	public static ArrayList<String> tokenize(String program){
		ArrayList<String>ret = new ArrayList<>();
		int pr=0;
		for(int i=0;i<program.length();i++){
			char charat = program.charAt(i);
			if(charat == '{'){
				while(program.charAt(++i) != '}')
					;
				i++;
				String n = program.substring(pr, i).trim();
				ret.add(n.replaceAll("\\r|\\n|\\t", ""));
				pr = i;
			}
			if(charat==';'){
				ret.add(program.substring(pr, i));
				pr = ++i;
			}
		}
		return trimAll(ret);
	}
	
	private static ArrayList<String> trimAll(ArrayList<String>totrim){
		ArrayList<String>ret = new ArrayList<>();
		for(String s : totrim){
			ret.add(s.trim());
		}
		return ret;
	}
	
	public static ArrayList<String> getSubTokens(String token){
		if(!isFurtherTokenizable(token))
			return null;
		token = token.split("\\{",2)[1];
		return tokenize(token.substring(0,token.length()-1));
	}
	
	public static boolean isFurtherTokenizable(String token){
		return token.contains("{") || token.contains("}");
	}
}
