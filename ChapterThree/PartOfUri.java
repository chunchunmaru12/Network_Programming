import java.net.URI;
import java.net.URISyntaxException;

public class PartOfUri {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.google.com");
            System.out.println("URI: " + uri);
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart());
            System.out.println("Fragment: " + uri.getFragment());
            System.out.println("Raw URI: " + uri.getRawFragment());
            
        } catch (URISyntaxException ex) {
            System.out.println("URI syntax error: " + ex.getMessage());
        }
    }
    
}
