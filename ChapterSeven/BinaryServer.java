package ChapterSeven;
import java.io.*;
import java.net.*;

public class BinaryServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started. Waiting for connection...");

        Socket clientSocket = serverSocket.accept();
        OutputStream out = clientSocket.getOutputStream();
        byte[] data = { 97, 2, 3, 4, 5 }; // example binary data
        out.write(data);
        out.flush();

        out.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Binary data sent and connection closed.");
    }
}
