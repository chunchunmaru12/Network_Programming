package ChapterFour;

import java.io.*;
import java.net.Socket;
public class Client {
    private static final String COOKIE_FILE = "client_cookie.txt";
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5344);
            System.out.println("Connected to server");

            String storedCookie = readCookie();

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(storedCookie);
            dOut.flush();

            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String serverResponse = dIn.readUTF();
            System.out.println(">> Server Response: " + serverResponse);

            if (serverResponse.startsWith("sessionId=")) {
                saveCookie(serverResponse);
            }

            dOut.close();
            dIn.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveCookie(String cookie) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COOKIE_FILE))) {
            writer.write(cookie);
        } catch (IOException e) {
            System.out.println("Error saving cookie: " + e.getMessage());
        }
    }

    private static String readCookie() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COOKIE_FILE))) {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }
}