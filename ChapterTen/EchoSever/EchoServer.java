package EchoSever;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Echo server is ready on port " + SERVICE_PORT);

            byte[] buffer = new byte[BUFSIZE];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                socket.receive(packet);

                String receivedData = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received from client: " + receivedData);
                DatagramPacket echoPacket = new DatagramPacket(
                        packet.getData(), packet.getLength(),
                        packet.getAddress(), packet.getPort());

                socket.send(echoPacket);
                System.out.println("Echoed back to " + packet.getAddress().getHostAddress() + ":" + packet.getPort());
            }

        } catch (IOException ioe) {
            System.err.println("I/O error: " + ioe.getMessage());
        }
    }
}
