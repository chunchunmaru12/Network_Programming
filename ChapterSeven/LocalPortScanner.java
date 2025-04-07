package ChapterSeven;

import java.net.*;

public class LocalPortScanner {
    public static void main(String[] args) {
        for (int port = 1; port <= 6000; port++) {
            try {
                // Attempt to connect to the port
                ServerSocket socket = new ServerSocket(port);
                socket.close(); // Close the socket immediately if it was opened successfully
            } catch (java.net.ConnectException e) {
                // Port is closed or not reachable
            } catch (java.io.IOException e) {
                // Port is closed or not reachable
                System.out.println("Port " + port + " is open.");
            }
        }
    }

}
