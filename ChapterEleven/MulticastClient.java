package ChapterEleven;

import java.io.IOException;
import java.net.*;

public class MulticastClient {
    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 1234;

    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getByName(INET_ADDR);
        try (DatagramSocket serverSocket = new DatagramSocket()) {
            for (int i = 0; i < 5; i++) {
                String msg = "Hello, this is message number " + i;

                DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), addr, PORT);
                serverSocket.send(packet);

                System.out.println("Sent: " + msg);
                try {
                    Thread.sleep(1000); // Sleep for 1 second between messages
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            System.err.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
