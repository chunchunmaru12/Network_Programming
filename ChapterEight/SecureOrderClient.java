import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureOrderClient {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 7000;

        try {
            // Load truststore to trust the server's certificate
            KeyStore trustStore = KeyStore.getInstance("JKS");
            char[] password = "2andnotafrod".toCharArray();
            trustStore.load(new FileInputStream("clienttruststore.jks"), password);

            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(trustStore);

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);

            SSLSocketFactory factory = context.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            System.out.println("Connected securely to server.");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter order (type 'exit' to quit):");
            String order;
            while ((order = userInput.readLine()) != null) {
                if (order.equalsIgnoreCase("exit"))
                    break;
                out.println(order);
            }

            socket.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
