import java.io.*;
import java.net.*;

public class PacketReceiveDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Binding to local port 1022");
            DatagramSocket socket = new DatagramSocket(1022);
            System.out.println("Bound to local port" + socket.getLocalPort());
            DatagramPacket packet = new DatagramPacket(new byte[256], 256);
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

            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
