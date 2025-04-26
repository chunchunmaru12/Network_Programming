import java.io.*;
import java.net.*;

public class PacketSendDemo {
    public static void main(String[] args) {
        try {
            String message = "Hello World";
            byte[] buffer = message.getBytes();
            InetAddress receiverAddress = InetAddress.getByName("localhost");
            int receiverPort = 1022;
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, receiverPort);
            socket.send(packet);
            System.out.println("Packet Sent to " + receiverAddress.getHostAddress() + " on port " + receiverPort);
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
