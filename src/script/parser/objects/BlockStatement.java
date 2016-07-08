package script.parser.objects;

import java.util.ArrayList;

import script.parser.StatementType;
import script.parser.Tokenizer;

public class BlockStatement extends Statement {
	
	private static final long serialVersionUID = -6368400850935417901L;
	public ArrayList<Statement>substatements = new ArrayList<>();
	
	public BlockStatement(String t) {
		super(t);
		resolveSubStatements(Tokenizer.getSubTokens(t));
	}

	@Override
	public StatementType getType() {
		return StatementType.BLOCK;
	}
	
	public void resolveSubStatements(ArrayList<String>substrings){
		for(String s : substrings){
			Token tok = new Token(s);
			System.out.println(tok);
			substatements.add(tok.toStatement());
		}
	}

}
