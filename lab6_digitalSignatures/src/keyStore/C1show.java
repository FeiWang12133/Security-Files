package keyStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class C1show {
	public static void main(String [] orgs) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException {
		String keystoreFilename = "keyStore";
		char[] password = "file".toCharArray();
		String alias = "Fei";
		FileInputStream fIn = new
		FileInputStream(keystoreFilename);
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(fIn, password);
		Certificate cert = keystore.getCertificate(alias);
		System.out.println(cert);
	}

}
