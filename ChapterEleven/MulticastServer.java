package ChapterEleven;

import java.io.IOException;
import java.net.*;

public class MulticastServer {
    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 1234;

    public static void main(String[] args) {
        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(INET_ADDR);

            // Join the multicast group
            socket.joinGroup(group);

            System.out.println("Listening for multicast messages on " + INET_ADDR + ":" + PORT);

            byte[] buffer = new byte[1024];

            for (int i = 0; i < 5; i++) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + msg);
            }

            // Leave the group
            socket.leaveGroup(group);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
