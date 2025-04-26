import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class PacketReceiveTimeout {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            System.out.println("Binding to local port 1022");
            socket = new DatagramSocket(1022);
            System.out.println("Bound to local port " + socket.getLocalPort());

            socket.setSoTimeout(3000);
            if(socket.getSoTimeout() == 3000) {
                System.out.println("SO_TIMEOUT is set to 3 seconds.");
            } else {
                System.out.println("SO_TIMEOUT is not set to 3 seconds.");
            }
            DatagramPacket packet = new DatagramPacket(new byte[256], 256);

            System.out.println("Waiting to receive a packet...");
            socket.setReceiveBufferSize(3);

            socket.receive(packet);

            System.out.println("Packet Received!!");
            InetAddress remote_addr = packet.getAddress();
            System.out.println("Sent By " + remote_addr.getHostAddress());
            System.out.println("Sent From " + packet.getPort());

            ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
            for (int i = 0; i < packet.getLength(); i++) {
                int data = bin.read();
                if (data == -1)
                    break;
                System.out.print((char) data);
            }

        } catch (SocketTimeoutException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Illegal Argument: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
