package lab4_symmetricKeyEncryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class employeeReadFromFile {
	
	private static Object readFromFile(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(new File(filename));
		ObjectInputStream iot = new ObjectInputStream(fin);
		Object object = iot.readObject();
		iot.close();
		return object;
		
	}
}
