package ChapterSeven;

import java.net.*;

public class LocalPortScanner {
    public static void main(String[] args) {
        for (int port = 1; port <= 65535; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress("localhost", port));

                serverSocket.close(); // Successfully bound, means port is free (not in use)
            } catch (java.io.IOException e) {
                // If binding fails, that means the port is already in use (open)
                System.out.println("Port " + port + " is open.");
            }
        }
    }
}
