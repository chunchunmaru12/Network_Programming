import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureOrderClient {

    public static void main(String[] args) {
        String host = "localhost"; // or IP of the server
        int port = 7000;

        try {
            // Load the truststore (to trust the server's certificate)
            KeyStore ts = KeyStore.getInstance("JKS");
            char[] password = "2andnotafrod".toCharArray(); // same password used in keystore
            ts.load(new FileInputStream("jnpe219.keys"), password); // same file if it's self-signed

            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ts);

            SSLContext context = SSLContext.getInstance("SSL");
            context.init(null, tmf.getTrustManagers(), null);

            SSLSocketFactory factory = context.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            System.out.println("Connected securely to server!");

            // Send a sample order
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
