package ChapterEleven;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
    public static void main(String[] args) throws IOException {
        String msg = "Hello World!";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8989);

        DatagramChannel client = DatagramChannel.open();
        client.bind(null); // let system pick a free port

        client.send(buffer, serverAddress);

        buffer.clear();
        client.receive(buffer);

        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);

        System.out.println("Received from server: " + new String(bytes));

        client.close();
    }
}
