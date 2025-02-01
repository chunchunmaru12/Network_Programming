package SimpleEchoServer;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {

            Socket socket = new Socket("127.0.0.1", 5344);
            System.out.println(">>connected to server .. .");
            DataOutputStream d = new DataOutputStream(socket.getOutputStream());
            d.writeUTF("Hello, I'm Md Noorullah Khan from client side");
            d.flush();
            d.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}