import java.io.*;
import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.security.cert.CertificateException;

public class SecureOrderTaker {

    public static final int DEFAULT_PORT = 7000;

    public static void main(String[] args) {
        int port = DEFAULT_PORT;

        try {
            // Load server keystore
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = "2andnotafrod".toCharArray();
            ks.load(new FileInputStream("serverkeystore.jks"), password);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, password);

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(kmf.getKeyManagers(), null, null);

            SSLServerSocketFactory factory = context.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(port);

            System.out.println("SecureOrderTaker is running on port " + port);

            while (true) {
                try (Socket connection = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    System.out.println("--- Order Received ---");
                    String input;
                    while ((input = in.readLine()) != null) {
                        System.out.println(input);
                    }
                } catch (IOException e) {
                    System.err.println("Connection error: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
