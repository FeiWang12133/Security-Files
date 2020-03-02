import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class q1_1 {
	
	public class createSign{
		 void writeToFile(String filename, Object object) throws IOException {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(object);
			oout.close();
		}
	}
	
	public static void main(String [] args) throws NoSuchAlgorithmException, InvalidKeyException {
		KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256"); 
		SecretKey sk = kg.generateKey();
		Mac mac = Mac.getInstance("HmacSHA256"); 
		mac.init(sk); 
		byte[] result = mac.doFinal("Hi There".getBytes()); 
		System.out.println(result.length);    
		/// Receiver 
		Mac mac2 = Mac.getInstance("HmacSHA256"); 
		mac2.init(sk); 
		byte[] result2 = mac.doFinal("Hi There".getBytes());    
		System.out.println("Check: " + Arrays.equals(result, result2));
	}

}
