
import java.io.*;
import java.net.*;

public class SocketOptionsDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("google.com", 80);

            socket.setTcpNoDelay(true);
            socket.setSoTimeout(5000);
            socket.setKeepAlive(true);
            socket.setSendBufferSize(8192);
            socket.setReceiveBufferSize(8192);
            socket.setSoLinger(true, 5);

            System.out.println("Connected to google.com");
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
            System.out.println("SO_KEEPALIVE: " + socket.getKeepAlive());
            System.out.println("SO_SNDBUF: " + socket.getSendBufferSize());
            System.out.println("SO_RCVBUF: " + socket.getReceiveBufferSize());
            System.out.println("SO_LINGER: " + socket.getSoLinger());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}