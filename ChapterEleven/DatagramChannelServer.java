package ChapterEleven;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel server = DatagramChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 8989);
        server.bind(address);

        System.out.println("Server Started: " + address);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Receive buffer from client
        SocketAddress remoteAddress = server.receive(buffer);

        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes, 0, buffer.limit());

        String msg = new String(bytes);
        System.out.println("Client @ " + remoteAddress + " sent: " + msg);

        // Echo back
        buffer.flip();
        server.send(buffer, remoteAddress);

        server.close();
    }
}
