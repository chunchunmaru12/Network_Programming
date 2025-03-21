import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;;

public class QueryString {
    private StringBuffer query = new StringBuffer();

    public QueryString(String name, String value) {
        encode(name, value);
    }

    public synchronized void add(String name, String value) {
        query.append('&');
        encode(name, value);
    }

    private synchronized void encode(String name, String value) {
        try {
            query.append(URLEncoder.encode(name, "UTF-8"));
            query.append('=');
            query.append(URLEncoder.encode(value, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }

    public String getQuery() {
        return query.toString();
    }

    public String toString() {
        return getQuery();
    }

    public static void main(String[] args) {
        QueryString qs = new QueryString("name", "Md Noorullah khan");
        qs.add("city", "Dhobighat");
        System.out.println(qs);

    }
}
