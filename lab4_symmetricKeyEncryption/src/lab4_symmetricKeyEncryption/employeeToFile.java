package lab4_symmetricKeyEncryption;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class employeeToFile {

	public static void main(String args[]) throws Exception {
		String ALGORITHM = "AES";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();

		writeToFile("data/securityKey", key);
		
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		// Initialize the cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		SealedObject so = new SealedObject(new employee("007", "bt St", "8645641564"), eCipher);
		writeToFile("data/securityKey", key);

	}

	private static void writeToFile(String filename, Object object) throws Exception {
		FileOutputStream fout = new FileOutputStream(new File(filename));
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(object);
		oout.close();
	}

}
