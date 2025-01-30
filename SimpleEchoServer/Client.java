package SimpleEchoServer;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            
        
            Socket socket = new Socket("127.0.0.1", 5344);
            DataOutputStream d = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the message to send to server: ");
            String message = scanner.nextLine();
            d.writeUTF(message);
            d.flush();
            d.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}