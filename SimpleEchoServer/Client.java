package SimpleEchoServer;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 5344);
            DataOutputStream d = new DataOutputStream(socket.getOutputStream());
            d.writeUTF("Hello from client");
            d.flush();
            d.close();
            socket.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}