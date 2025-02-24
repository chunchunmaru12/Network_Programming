import java.net.*;
import java.io.*;

public class ContentGetter {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                URL url = new URL(args[0]);
                Object o = url.getContent();
                System.out.println("I got a " + o.getClass().getName());
            } catch (IOException ex) {
                System.out.println("An error occurred: " + ex.getMessage());
            }
        } else {
            System.out.println("Please provide a URL");
        }
    }
}