import java.net.*;
import java.io.*;

public class RetrieveDataFromUrl {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com/");
            // InputSteam in = url.openStream();
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            int i;
            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
    }
}
