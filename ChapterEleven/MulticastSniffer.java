package ChapterEleven;

import java.net.*;
import java.io.*;

public class MulticastSniffer {
    public static void main(String[] args) {
        InetAddress group = null;
        int port = 0;
        try {
            group = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);

        } catch (Exception e) {
            System.err.println("Usage: java MulticastSniffer <multicast-group> <port>");
            System.exit(1);
        }
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);
            System.out.println("Listening on " + group + ":" + port);
            byte[] buffer = new byte[8192];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            while (true) {
                ms.receive(dp);
                String s = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Received: " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ms != null && !ms.isClosed()) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
