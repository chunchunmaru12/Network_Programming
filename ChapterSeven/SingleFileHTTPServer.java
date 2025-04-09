//An Http Server that chunks out the same file
package ChapterSeven;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;

public class SingleFileHTTPServer extends Thread {
    private byte[] content;
    private byte[] header;
    private int port = 80;

    public SingleFileHTTPServer(String data, String encoding, String MIMEType, int port)
            throws UnsupportedEncodingException {
        this(data.getBytes(encoding), encoding, MIMEType, port);
    }

    public SingleFileHTTPServer(byte[] data, String encoding, String MIMEType, int port)
            throws UnsupportedEncodingException {
        this.content = data;
        this.port = port;
        String header = "HTTP/1.0 200 OK\r\n"
                + "Server: OneFile 1.0\r\n"
                + "Content-length: " + this.content.length + "\r\n" + "Content-Type: " + MIMEType + "\r\n\r\n";
        this.header = header.getBytes("ASCII");

    }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("Accepting connections on port " + server.getLocalPort());
            System.out.println("Data to be sent: ");
            System.out.write(this.content);
            while (true) {
                Socket connection = null;

                try {
                    connection = server.accept();
                    OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                    InputStream in = new BufferedInputStream(connection.getInputStream());

                    StringBuffer request = new StringBuffer(80);
                    while (true) {
                        int c = in.read();
                        if (c == -1 || c == '\n') {
                            break;
                        }
                        request.append((char) c);
                    }
                    if (request.toString().indexOf("HTTP/") != -1) {
                        out.write(this.header);
                    }
                    out.write(this.content);
                    out.flush();
                } catch (IOException e) {
                    System.out.println("Error in connection: " + e.getMessage());
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            String contentType = "text/plain";
            if (args[0].endsWith(".html") || args[0].endsWith(".htm")) {
                contentType = "text/html";
            }
            InputStream in = new FileInputStream(args[0]);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            byte[] data = out.toByteArray();
            int port;
            try {
                port = Integer.parseInt(args[1]);
                if (port < 1 || port > 65535) {
                    System.err.println("Port number must be between 1 and 65535.");
                    return;
                }
            } catch (NumberFormatException e) {
                port = 80;
            }
            String encoding = "ASCII";
            if (args.length > 2) {
                encoding = args[2];
            }
            Thread t = new SingleFileHTTPServer(data, encoding, contentType, port);
            t.start();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java SingleFileHTTPServer <filename> [port] [encoding]");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}