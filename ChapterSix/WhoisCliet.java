import java.io.*;
import java.net.*;

public class WhoisCliet {
    public final static int DEFAULT_PORT = 443;
    public final static String DEFAULT_HOST = "lookup.icann.org";

    public static void main(String[] args) {
        InetAddress server;
        try {
            server = InetAddress.getByName((args.length == 0) ? DEFAULT_HOST : args[0]);
        } catch (UnknownHostException ex) {
            System.err.println("Error: Unknown host: " + ex.getMessage());
            return;
        }
        int port = DEFAULT_PORT;
        try {
            Socket socket = new Socket(server, port);
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "8859_1");
            for (int i = 0; i < args.length; i++) {
                out.write(args[i] + " ");
            }
            out.write("\r\n");
            out.flush();
            InputStream raw = socket.getInputStream();
            InputStream in = new BufferedInputStream(socket.getInputStream());
            int c;
            while ((c = in.read()) != -1) {
                System.out.write(c);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
