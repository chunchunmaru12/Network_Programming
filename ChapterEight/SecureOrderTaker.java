
/*
 * SecureOrderTaker- demonstrate this procudure with a complete SecureOrderTaker for accepting orders 
 * and printing them on System.out.
 * 
 */
import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.CertificateException;

public class SecureOrderTaker {

    public final static int DEFAULT_PORT = 7000;
    public final static String algorithm = "SSLv3"; // or use "TLS" depending on your JDK support

    public static void main(String[] args) {
        int port = DEFAULT_PORT;

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
                if (port < 1 || port > 65535) {
                    System.out.println("Port must be between 1 and 65535");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid port number.");
                return;
            }
        }

        try {
            // SSL context setup
            SSLContext context = SSLContext.getInstance("TLS");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");

            // Load the keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = "2andnotafrod".toCharArray();
            ks.load(new FileInputStream("jnpe219.keys"), password);
            kmf.init(ks, password);

            // Initialize SSLContext with key managers
            context.init(kmf.getKeyManagers(), null, null);

            // Create SSL server socket
            SSLServerSocketFactory factory = context.getServerSocketFactory();
            SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(port);

            System.out.println("SecureOrderTaker running on port " + port + "...");

            // Accept and handle orders
            while (true) {
                try {
                    Socket theConnection = server.accept(); // Secure connection
                    InputStream in = theConnection.getInputStream();

                    int c;
                    while ((c = in.read()) != -1) {
                        System.out.write(c);
                    }
                    System.out.println("\n--- Order Received ---");
                    System.out.write(c);
                    System.out.flush();

                    theConnection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }
}
