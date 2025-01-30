package LabTwo;

import java.net.*;

public class JavaInternetAddressByName {
   public static void PrintIPAddress(String host) {
      try {
         InetAddress address = InetAddress.getByName(host);
         System.out.println(address);
      } catch (UnknownHostException e) {
         System.out.println("Error: " + e.getMessage());
      }

   }

   public static void PrintHost(String ipAddress) {
      try {
         InetAddress address = InetAddress.getByName(ipAddress);
         System.out.println(address.getHostName());
      } catch (UnknownHostException e) {
         System.out.println("Error: " + e.getMessage());
      }
   }

   public static void main(String[] args) {
      String facebook = "www.facebook.com";
      String localhost = "localhost";
      String google = "www.google.com";
      PrintIPAddress(google);
      PrintIPAddress(facebook);
      PrintIPAddress(localhost);
      PrintHost("163.70.143.35");
   }
}
