package ChapterFive;

import java.net.*;
import java.io.*;

public class AllMIMEHeaders {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                URLConnection uc = u.openConnection();
                for (int j = 1;; j++) {
                    String header = uc.getHeaderField(j);
                    if (header == null)
                        break;
                    System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
                }
            } catch (MalformedURLException e) {
                System.err.println(args[i] + " is not a parseable URL");
            }
            System.out.println();

        }
    }
}