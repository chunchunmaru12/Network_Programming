package LabTwo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressVersionChecker {
    public static int getVersion(InetAddress ia) {
        // Retrieve the raw IP address as a byte array
        byte[] address = ia.getAddress();

        // Check the length of the address to determine the IP version
        if (address.length == 4) {
            return 4; // IPv4
        } else if (address.length == 16) {
            return 6; // IPv6
        } else {
            return -1; // Unknown format
        }
    }

    public static void main(String[] args) {
        try {
            // Create an IPv6 address instance
            InetAddress ia6 = InetAddress.getByName("ff06:0:0:0:0:0:0:c3");

            // Create an IPv4 address instance
            InetAddress ia4 = InetAddress.getByName("127.0.0.1");

            // Determine and print the IP version for IPv6 address
            int res6 = getVersion(ia6);
            System.out.println(ia6+"IP version: v" + res6);

            // Determine and print the IP version for IPv4 address
            int res4 = getVersion(ia4);
            System.out.println(ia4+"IP version: v" + res4);

        } catch (UnknownHostException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
