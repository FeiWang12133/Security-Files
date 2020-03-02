import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class q1_3 {
	
	static Object readFromFile(String filename) throws Exception { 
		FileInputStream fin = new FileInputStream(filename); 
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject(); 
		oin.close(); 
		return object; 
		}
	
	public static void main(String [] args) throws Exception {
 
		//read secret key
		SecretKey sk = (SecretKey) readFromFile("data/secretKey");
		
		String encodeHmac = (String) readFromFile("data/hmac");
		byte[] sentHmac = Base64.getDecoder().decode(encodeHmac); 
		String sendText = (String) readFromFile("data/sendText.txt");
		
		//calculate hmac
		
		
		Mac mac = Mac.getInstance("HmacSHA256"); 
		mac.init(sk); 
		byte[] myHmac = mac.doFinal(sendText.getBytes()); 
		System.out.println("Check :" + Arrays.equals(sentHmac, myHmac));

			
		}
}
