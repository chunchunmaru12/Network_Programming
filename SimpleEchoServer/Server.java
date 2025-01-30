package SimpleEchoServer;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5344)) {
            System.out.println(">> Waiting for connection...");
            // establish connection
            Socket clienSocket = serverSocket.accept();
            System.out.println(">> Connection established to client...");
            DataInputStream d = new DataInputStream(clienSocket.getInputStream());
            String str = (String) d.readUTF();
            System.out.println("Message from client: " + str);
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}