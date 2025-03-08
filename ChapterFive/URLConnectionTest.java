package ChapterFive;
import java.net.*;
import java.io.*;
import java.net.MalformedURLException;
public class URLConnectionTest {
    public static void main(String[] args) {
        try{
            URL u = new URL("https://run.mocky.io/v3/67de275b-033c-4237-b6cd-a3276c0a1bbf");

            URLConnection uc = u.openConnection();
            System.out.println("Content-Type: " + uc.getContentType());
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
