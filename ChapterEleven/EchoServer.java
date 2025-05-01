package ChapterEleven;
import java.net.*;
import java.io.*;

public class EchoServer {
    // UDP port to listen on (port 7 is traditionally the echo service)
    public static final int SERVICE_PORT = 7;

    // Maximum size of a datagram packet
    public static final int BUFSIZE = 256;

    public static void main(String[] args) {
        try {
            // Create a UDP socket and bind it to the echo service port
            DatagramSocket socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Echo server is ready on port " + SERVICE_PORT);

            byte[] buffer = new byte[BUFSIZE];

            while (true) {
                // Create a packet to receive data into
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                // Wait for a UDP packet
                socket.receive(packet);

                // Print info about received packet
                String receivedData = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received from client: " + receivedData);

                // Echo the same data back to the client
                DatagramPacket echoPacket = new DatagramPacket(
                    packet.getData(), packet.getLength(),
                    packet.getAddress(), packet.getPort()
                );

                socket.send(echoPacket);
                System.out.println("Echoed back to " + packet.getAddress().getHostAddress() + ":" + packet.getPort());
            }

        } catch (IOException ioe) {
            System.err.println("I/O error: " + ioe.getMessage());
        }
    }
}
