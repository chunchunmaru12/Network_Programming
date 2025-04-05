package ChapterSeven;
// This is a simple multithreaded server that handles multiple clients concurrently.

// Each client connection is handled in a separate thread, allowing the server to serve multiple clients at the same time.
// The server listens on port 6000 and sends a greeting message to each connected client.
// The server will run indefinitely until manually stopped.z

import java.io.*;
import java.net.*;
import java.util.Date;

// A simple multithreaded server that handles multiple clients concurrently
public class MultiThreadedServer {
    public final static int PORT = 6000; // Changed to 6000 for typical use (port 13 may be restricted)

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Accept client connections forever
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                Thread task = new DaytimeThread(clientSocket);
                task.start(); // Start a new thread for each client connection
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
        }
    }

    // Thread class to handle each client
    public static class DaytimeThread extends Thread {
        private Socket clientSocket;

        public DaytimeThread(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                Date now = new Date();
                String message = "Current date and time: " + now.toString();
                out.println(message);

                System.out.println("Sent to client [" + clientSocket.getInetAddress() + "]: " + message);
            } catch (IOException e) {
                System.out.println("Error in thread: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                    System.out.println("Connection closed with client: " + clientSocket.getInetAddress());
                } catch (IOException e) {
                    System.out.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }
}
