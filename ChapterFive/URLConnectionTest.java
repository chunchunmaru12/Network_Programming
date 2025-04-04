package ChapterFive;
import java.net.*;
import java.io.*;
import java.net.MalformedURLException;
public class URLConnectionTest {
    public static void main(String[] args) {
        try{
            URL u = new URL("https://run.mocky.io/v3/41b047a5-54bd-4688-9baa-1bc910f9ee13");

            URLConnection uc = u.openConnection();
            System.out.println("Content-Type: " + uc.getContentType());
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
