package script.parser;

import java.io.File;
import java.util.ArrayList;

import script.parser.statements.ClassStatement;
import script.parser.utils.Serializer;
import minerguy31.nativelib.FileIO;

/*
 * Completely temporary class, just for testing
 */
public class TestMain {
	public static void main(String[]args) throws Exception{
		Token file = new Token(FileIO.readFileIntoString("test.txt"));
		System.out.println(file);
		ArrayList<Token>subtokens=file.getSubTokens();
		System.out.println(subtokens);
		System.out.println(file.toStatement());
		Program p = new Program().addClass((ClassStatement) file.toStatement());
		Serializer.serialize(p, new File("output.txt"));
	}
}
