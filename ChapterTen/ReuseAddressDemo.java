import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ReuseAddressDemo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(null);
            socket.setReuseAddress(true);
            if(socket.getReuseAddress()) {
                System.out.println("SO_REUSEADDR is enabled.");
                socket.bind(new InetSocketAddress(1022));
            } else {
                System.out.println("SO_REUSEADDR is not enabled.");
            }           
            
            Thread.sleep(100000);

            socket.close();
            System.out.println("Socket closed.");

        } catch (SocketException e) {
            System.err.println("SocketException: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
