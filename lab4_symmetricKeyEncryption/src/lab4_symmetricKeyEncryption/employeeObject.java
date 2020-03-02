package lab4_symmetricKeyEncryption;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class employeeObject {

	public static void main(String args[]) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException,NoSuchAlgorithmException, NoSuchPaddingException, IOException, ClassNotFoundException {
		String ALGORITHM = "BlowFish";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		// Initialize the cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);
		
		SealedObject so = new SealedObject(new employee("007", "bt St", "8645641564"), eCipher);
		
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);
		
		// Decrypt the ciphertext
		employee o = (employee) so.getObject(dCipher);
		System.out.println("Employee: " + o.getName());
	}

}
