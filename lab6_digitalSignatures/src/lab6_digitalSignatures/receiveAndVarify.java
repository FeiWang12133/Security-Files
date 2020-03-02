package lab6_digitalSignatures;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class receiveAndVarify {
	
	static Object readFromFile(String filename) throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream(filename);
	    ObjectInputStream oin = new ObjectInputStream(fin);
	    Object object = oin.readObject();
	    oin.close();
	    return object;
	}
	public static void main(String [] args) throws ClassNotFoundException, IOException, InvalidKeyException, NoSuchAlgorithmException, SignatureException{
		PublicKey publicKey = (PublicKey) readFromFile("data/publicKey");
		byte[] sig = (byte[]) readFromFile("data/signture");
		String sendText = (String) readFromFile("data/sendText.txt");
		Signature dsa = Signature.getInstance("SHA1withDSA");
		 dsa.initVerify(publicKey);
		 
		 byte[] textArray = sendText.getBytes();
		 dsa.update(textArray);
		 
		 
		 
		 
		 
	}
		

}
