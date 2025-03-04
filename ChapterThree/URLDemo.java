import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    static void print(URL u) {
            System.out.println("1. URL: " + u);
            System.out.println("2. Protocol: " + u.getProtocol());
            System.out.println("3. Host: " + u.getHost());
            System.out.println("4. Port: " + u.getPort());
            System.out.println("5. File: " + u.getFile());
            System.out.println("6. Authority: " + u.getAuthority());
            System.out.println("7. Query: " + u.getQuery());
            System.out.println("8. Default port: " + u.getDefaultPort());
            // System.out.println("9. Content: " + u.getContent());
            System.out.println("Ref : " + u.getRef());
    }

    static void printUrlMatches(String u1, String u2) {
        System.out.println("Test same URL : " + (u2.equals(u1) ? "Same URL" : "Different URL"));

    }
    static void showDemo(String urlString){
        try {
            URL u = new URL(urlString);
            print(u);
        } catch (MalformedURLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public static void createUrl(String baseUrl,String relativeUrl){
        try {
            URL u = new URL(baseUrl);
            URL u2 = new URL(u, relativeUrl);
            //third way
            URL u3 = new URL("http","facebook.com",8000,"/index.html");
            print(u2);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    } 
    public static void main(String[] args) {
        showDemo("http://www.example.com:8080?key=value#5");
        System.out.println();
        showDemo("https://mail.example.com/mail/u/1/#inbox?compose=new");
        System.out.println();
        createUrl("https://www.example.com/", "index.html");
    }
}