package LabTwo;

import java.net.*;
import java.net.UnknownHostException;

public class CharacteristicsOfIP {
    public static void main(String[] args) {
         
        try{
            InetAddress address = InetAddress.getByName("localhost");
            if(address.isAnyLocalAddress()){
                System.out.println(address+" is a wildcard address.");
            }
            if(address.isLoopbackAddress()){
                System.out.println(address+" is a loopback address.");
            }
            if(address.isLinkLocalAddress()){
                System.out.println(address+" is a link-local address.");
            }
            else if(address.isSiteLocalAddress()){
                System.out.println(address+" is a site-local address.");
            }else{
                System.out.println(address+" is a global address.");
            }
            if(address.isMulticastAddress()){
                if(address.isMCGlobal()){
                    System.out.println(address+" is a global multicast address.");
                }else if(address.isMCOrgLocal()){
                    System.out.println(address+" is an organization wide multicast address.");
                }else if(address.isMCSiteLocal()){
                    System.out.println(address+" is a site wide multicast address.");
                }else if(address.isMCLinkLocal()){
                    System.out.println(address+" is a subnet wide multicast address.");
                }else if(address.isMCNodeLocal()){
                    System.out.println(address+" is an interface-local multicast address.");
                }else{
                    System.out.println(address+" is an unknown multicast address.");
                }
            }else{
                System.out.println(address+" is a unicast address.");
            }
        }catch(UnknownHostException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
