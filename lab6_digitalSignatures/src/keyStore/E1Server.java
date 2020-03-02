package keyStore;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class E1Server {

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyStoreException {
		// TODO Auto-generated method stub
		char[] KSPASSWORD = "file".toCharArray();
		char[] PASSWORD = "1234".toCharArray();
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(new FileInputStream("keystore"), KSPASSWORD);
		KeyManagerFactory keyManagerFactory = KeyManagerFactory
		 .getInstance("SunX509");
		keyManagerFactory.init(keyStore, PASSWORD);
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
		ServerSocketFactory ssFactory = sslContext.getServerSocketFactory();
		
		int port = 443;
		ServerSocket ss = ssFactory.createServerSocket(port);
		Socket socket = ss.accept();
		// Create streams to securely send and receive data to the client
		InputStream in = socket.getInputStream();
		BufferedReader r = new BufferedReader(new InputStreamReader(in));
		String name = r.readLine();
		OutputStream o = socket.getOutputStream();
		PrintWriter p = new PrintWriter(o);
		p.println("Hello " + name);
		p.close();
	}

}
