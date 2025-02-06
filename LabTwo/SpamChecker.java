package LabTwo;
import java.net.*;

public class SpamChecker {
    // Blackhole list domain used to check for spammer IPs
    public static final String BLACKHOLE = "spamhaus.org/sbl";
    
    /**
     * Checks if the given IP address or hostname is listed in the spam blacklist.
     * @param arg The IP address or hostname to check.
     * @return true if the IP is listed as a spammer, false otherwise.
     */
    private static boolean isSpammer(String arg) {
        try {
            // Convert hostname or IP address to an InetAddress object
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            
            // Convert IP address to a reversed lookup query
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query; 
            }
            
            // Perform DNS lookup to check if the IP is in the blacklist
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        // Iterate through the provided arguments and check if they are spammers
        for (String arg : args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spam");
            } else {
                System.out.println(arg + " is not spam");
            }
        }
    }
}
