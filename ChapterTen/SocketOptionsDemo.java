import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketOptionsDemo {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(1022);
            System.out.println("Socket created and bound to port " + socket.getLocalPort());

            // Set options
            socket.setSoTimeout(5000);            
            socket.setReceiveBufferSize(4096);    
            socket.setSendBufferSize(4096);  
            socket.setReuseAddress(false);
        
            
            int timeout = socket.getSoTimeout();
            int rcvBufSize = socket.getReceiveBufferSize();
            int sndBufSize = socket.getSendBufferSize();
            boolean reuseAddress = socket.getReuseAddress();
            

            System.out.println("SO_TIMEOUT (Receive Timeout): " + timeout + " ms");
            System.out.println("SO_RCVBUF (Receive Buffer Size): " + rcvBufSize + " bytes");
            System.out.println("SO_SNDBUF (Send Buffer Size): " + sndBufSize + " bytes");
            System.out.println("SO_REUSEADDR (Reuse Address): " + reuseAddress);

        } catch (SocketException e) {
            System.err.println("SocketException: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
