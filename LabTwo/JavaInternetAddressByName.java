package LabTwo;

import java.net.*;

public class JavaInternetAddressByName {
   public static void PrintIPAddress(String host) {
      try {
         InetAddress address = InetAddress.getByName(host);
         // Display the hostname
         System.out.println("Host Name: " + address.getHostName());
         // Display the canonical hostname
         System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
         System.out.println("Host Address: " + address.getHostAddress());
         System.out.print("Raw IP Address (Byte Format): ");
         // Get the raw IP address in byte array
         byte[] ipBytes = address.getAddress();
         for (byte b : ipBytes) {
            System.out.print((b & 0xFF) + ".");
         }
         System.out.println();
      } catch (UnknownHostException e) {
         System.out.println("Error: " + e.getMessage());
      }
   }

   // public static void PrintHost(String ipAddress) {
   //    try {
   //       InetAddress address = InetAddress.getByName(ipAddress);
   //       System.out.println("Host Name: " + address.getHostName());
   //       System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
   //       System.out.println("Host Address: " + address.getHostAddress());
   //    } catch (UnknownHostException e) {
   //       System.out.println("Error: " + e.getMessage());
   //    }
   // }

   public static void main(String[] args) {
      String facebook = "www.facebook.com";
      String localhost = "localhost";
      String google = "www.google.com";
      PrintIPAddress(google);
      PrintIPAddress(facebook);
      PrintIPAddress(localhost);
     // PrintHost("163.70.143.35");
   }
}
