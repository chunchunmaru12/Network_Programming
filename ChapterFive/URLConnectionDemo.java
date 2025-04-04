package ChapterFive;
import java.net.*;
import java.io.*;
import java.util.Date;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URL("https://run.mocky.io/v3/0b863e9e-dce2-4a75-8a06-97e0eacf21ee");
        URLConnection hpCon = hp.openConnection();
        //get date
        long d = hpCon.getDate();
        if(d == 0)
            System.out.println("No date information.");
        else
            System.out.println("Date: " + new Date(d));
        //get content type
        System.out.println("Content-Type: " + hpCon.getContentType());
        //get expiration date
        d = hpCon.getExpiration();
        if(d == 0)
            System.out.println("No expiration information.");
        else
            System.out.println("Expires: " + new Date(d));
        //get last-modified date
        d = hpCon.getLastModified();
        if(d == 0)
            System.out.println("No last-modified information.");
        else
            System.out.println("Last-Modified: " + new Date(d));
        //get content length
        long len = hpCon.getContentLengthLong();
        if(len == -1)
            System.out.println("Content length unavailable.");
        else
            System.out.println("Content-Length: " + len);
        
        if(len >= 0) {
            System.out.println("=== Content ===");
            try{
            InputStream input = hpCon.getInputStream();
            while(((c = input.read()) != -1)) {
                System.out.print((char) c);
            }
            input.close();
        }catch(IOException e) {
                System.out.println("Error:" + e.getMessage());
            }
            
        } else {
            System.out.println("No content available.");
        }
    }
}
