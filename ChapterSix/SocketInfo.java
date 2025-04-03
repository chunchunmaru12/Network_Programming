import java.net.Socket;
import java.io.IOException;
public class SocketInfo {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                Socket theSocket = new Socket(args[i], 80);
                System.out.println("Connected to " + theSocket.getInetAddress() + 
                " on port " + theSocket.getPort() + 
                " from port " + theSocket.getLocalPort() + " of " + theSocket.getLocalAddress());
                theSocket.close();
            } catch (IOException e) {
                System.err.println("Couldn't connect to " + args[i]);
            }
        }
    }
}