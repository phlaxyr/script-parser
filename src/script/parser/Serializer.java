package script.parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import script.parser.objects.Program;

public class Serializer {
	private Serializer() {}

	public static void serialize(Program p, File f){
		try{

			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(p);
			oos.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
