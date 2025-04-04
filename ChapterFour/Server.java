
package ChapterFour;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5344)) {
            System.out.println(">> Waiting for client connection...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(">> Connected to client");

                DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());
                String clientCookie = dIn.readUTF();

                DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());

                if (clientCookie.isEmpty()) {
                    String newCookie = "sessionId=" + System.currentTimeMillis();
                    System.out.println(">> Sending new cookie: " + newCookie);
                    dOut.writeUTF(newCookie);
                } else {
                    System.out.println(">> Client's cookie: " + clientCookie);
                    dOut.writeUTF("Cookie received. Welcome back!");
                }

                dOut.flush();
                dIn.close();
                dOut.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}