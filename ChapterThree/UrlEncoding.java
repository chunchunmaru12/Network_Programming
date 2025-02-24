import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
public class UrlEncoding{
    public static void main(String[] args) {
        try{
            System.out.println(URLEncoder.encode("this string has spaces", "UTF-16"));
            System.out.println(URLEncoder.encode("this*string*has*asterisks", "UTF-16"));
            System.out.println(URLEncoder.encode("this%string%has%percent%signs", "UTF-16"));
            System.out.println(URLEncoder.encode("this+string+has+pluses", "UTF-16"));
            System.out.println(URLEncoder.encode("this/string/has/slashes", "UTF-16"));
            System.out.println(URLEncoder.encode("this\"string\"has\"quote\"marks", "UTF-16"));
            System.out.println(URLEncoder.encode("this:string:has:colons", "UTF-16"));
            System.out.println(URLEncoder.encode("this~string~has~tildes", "UTF-16"));
            System.out.println(URLEncoder.encode("this(string)has(parentheses)", "UTF-16"));
            System.out.println(URLEncoder.encode("this.string.has.periods", "UTF-16"));
            System.out.println(URLEncoder.encode("this=string=has=equals=signs", "UTF-16"));
            System.out.println(URLEncoder.encode("this&string&has&ampersands", "UTF-16"));   
            System.out.println(URLEncoder.encode("thiséstringéhasénon-ASCII characters", "UTF-16"));

        }catch(UnsupportedEncodingException ex){
            System.out.println("UnsupportedEncodingException: "+ex.getMessage());
        }
    }
}