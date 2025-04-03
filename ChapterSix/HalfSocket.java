import java.io.*;
import java.net.Socket;

public class HalfSocket {
    public static void main(String[] args) {
        try (Socket connection = new Socket("neverssl.com", 80)) {
            // Send HTTP request
            Writer out = new OutputStreamWriter(connection.getOutputStream(), "ISO-8859-1");
            out.write("GET / HTTP/1.0\r\n");
            out.write("Host: www.google.com\r\n");
            out.write("\r\n"); // Blank line to end headers
            out.flush();

            // Half-close the output stream (signals we're done sending)
            connection.shutdownOutput();

            // Read and print the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "ISO-8859-1"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.err.println("Couldn't connect: " + e.getMessage());
        }
    }
}
