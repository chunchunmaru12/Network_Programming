package LabTwo;

import java.net.*;

public class JavaInternetAddressByName {
   public static void PrintIPAddress(String host) {
      try {
         InetAddress address = InetAddress.getByName("localhost");
         System.out.println(address);
      } catch (UnknownHostException e) {
         System.out.println("Error: " + e.getMessage());
      }

   }

   public static void main(String[] args) {
      String facebook = "www.facebook.com";
      String google = "wwww.google.com";
      String localhost = "localhost";
      PrintIPAddress(facebook);
      PrintIPAddress(google);
      PrintIPAddress(localhost);

   }
}
