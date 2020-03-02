package lab4_symmetricKeyEncryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class encrypt_decrypt_blowfish {

	public static void main(String args[]) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		String ALGORITHM = "BlowFish";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		// Initialize the cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);
		String s = "This is just an example";
		System.out.println("Clear text: " + s);
		byte[] cleartext = s.getBytes();
		System.out.println("Cipher text cleartext length: " + cleartext.length);
		// Encrypt the cleartext
		byte[] ciphertext = eCipher.doFinal(cleartext);
		System.out.println("Cipher text length: " + ciphertext.length);
		
		String encodeDigest = Base64.getEncoder().encodeToString(ciphertext);
		System.out.println("Base64 digest: " + encodeDigest);
		
		// Decrypt

		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);
		// Decrypt the ciphertext
		byte[] clearText1 = dCipher.doFinal(ciphertext);
		String text = new String(clearText1);
		System.out.println("Decrypted text: " + text);
	}

}
