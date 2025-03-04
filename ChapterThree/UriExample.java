import java.net.URI;
import java.net.URISyntaxException;

public class UriExample {
    public static void main(String[] args) {
        try{
            URI voice = new URI("tel:+1-111-222-3333");
            URI web = new URI("https://example.com/sta.html#id=abc");
            URI isbn = new URI("isbn:1122334455");
            System.out.println("isbn "+isbn);
            
            URI iso = new URI("iso:0098/4321");
            System.out.println(iso);
            System.out.println(iso.getScheme());
            URI absolute = new URI("http", "//www.example", null);
            URI relative = new URI(null, "//example/index.shtml", "today");
            System.out.println("Voice URI: " + voice);
            System.out.println("Web URI: " + web);
            System.out.println("Absolute URI: " + absolute);
            System.out.println("Relative URI: " + relative);
        }catch (URISyntaxException ex) {
            System.out.println("URI syntax error: " + ex.getMessage());
        }
    }
}