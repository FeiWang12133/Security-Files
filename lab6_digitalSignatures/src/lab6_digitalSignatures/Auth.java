package lab6_digitalSignatures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class Auth {
	
	static void writeToFile(String filename, Object object) throws Exception {
	    FileOutputStream fout = new FileOutputStream(filename);
	    ObjectOutputStream oout = new ObjectOutputStream(fout);
	    oout.writeObject(object);
	    oout.close();
	  }

	
	public static void main(String [] args) throws Exception {
	
	KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
	SecureRandom random = new SecureRandom();
	random.setSeed(2345);
	keyGen.initialize(1024, random);
	KeyPair pair = keyGen.generateKeyPair();
	PrivateKey privateKey = pair.getPrivate();
	PublicKey publicKey = pair.getPublic();
	
	// sending the data
	String text = "this i s a string";
	byte[] textArray = text.getBytes();
	
	 Signature dsa = Signature.getInstance("SHA1withDSA");
	 dsa.initSign(privateKey);
	 byte[] sendText = "Sending Data".getBytes();
	 dsa.update(sendText);
	 byte[] sig = dsa.sign();
	 // receiving the data and verifying

	 //dsa.initVerify(publicKey);
	 //dsa.update(sendText);
	 //boolean verifies = dsa.verify(sig);
	 //System.out.println("signature verifies: " + verifies);
	 
	 writeToFile("data/sendText.txt",text);
	 writeToFile("data/signirure.txt",sig);
	 writeToFile("data/publicKey.txt",publicKey);
	 
	}
}
