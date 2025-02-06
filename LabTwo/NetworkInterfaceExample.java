package LabTwo;
import java.net.*;
import java.util.*;

public class NetworkInterfaceExample {
    public static void main(String[] args) throws SocketException {
        // Get an enumeration of all network interfaces available on the system
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            // Print details of the network interface
            System.out.println(ni);
        }
    }
}
