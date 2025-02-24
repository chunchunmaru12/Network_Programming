import java.net.URI;
import java.net.URISyntaxException;

public class UriExample {
    public static void main(String[] args) {
        try{
            URI voice = new URI("tel:+1-800-555-1212");
            URI web = new URI("https://xml.com/pub/a/2003/09/17/stax.html#id=_hbc");
            URI tutorial = new URI("urn:oasis:names:specification:docbook:dtd:xml:4.1.2");
            URI isbn = new URI("isbn:8956231025");
            System.out.println("isbn "+isbn);
            
            URI iso = new URI("iso:9001/2000");
            System.out.println(iso);
            System.out.println(iso.getScheme());
            URI absolute = new URI("http", "//www.ibiblio.org", null);
            URI relative = new URI(null, "//javafag/index.shtml", "today");
            System.out.println("Voice URI: " + voice);
            System.out.println("Web URI: " + web);
            System.out.println("Absolute URI: " + absolute);
            System.out.println("Relative URI: " + relative);
        }catch (URISyntaxException ex) {
            System.out.println("URI syntax error: " + ex.getMessage());
        }
    }
}