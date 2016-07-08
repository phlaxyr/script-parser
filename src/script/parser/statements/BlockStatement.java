package script.parser.statements;

import java.util.ArrayList;

import script.parser.Token;
import script.parser.enums.StatementType;
import script.parser.utils.Tokenizer;

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
