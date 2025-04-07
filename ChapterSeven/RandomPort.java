package ChapterSeven;
import java.io.*;
import java.net.*;
public class RandomPort {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(0); // 0 means any available port
            System.out.println("Server started on port: " + serverSocket.getLocalPort());

        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
