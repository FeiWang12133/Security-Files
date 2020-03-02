import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class q1_2 {
		 static void writeToFile(String filename, Object object) throws IOException {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(object);
			oout.close();
		}
	
	public static void main(String [] args) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
		
		String message = "This is a string message.";
				
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256"); 
		SecretKey sk = kg.generateKey();
		writeToFile("data/secretKey", sk);
		byte[] testArray =message.getBytes();
		
		Mac mac = Mac.getInstance("HmacSHA256"); 
		mac.init(sk); 
		byte[] hmac = mac.doFinal(testArray); 
		String encodedHmac = Base64.getEncoder().encodeToString(hmac); 
		writeToFile("data/hmac", sk);
		System.out.println("Based64 encoded message digest :" + encodedHmac);

		System.out.println(hmac.length);    
		
		
		
	}

}
	
