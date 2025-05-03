package ChapterEleven;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1"; // Must be in 224.0.0.0 – 239.255.255.255
        int port = 4446;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);

            String[] messages = {
                    "Hello from multicast sender!",
                    "Meow Meow`.",
                    "multicast is fun.",
                    "Goodbye!"
            };

            for (String message : messages) {
                byte[] buffer = message.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
                socket.send(packet);
                System.out.println("Sent: " + message);
            }

            System.out.println("All messages sent.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
