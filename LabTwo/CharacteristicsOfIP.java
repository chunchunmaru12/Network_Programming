package LabTwo;

import java.net.*;
import java.net.UnknownHostException;

public class CharacteristicsOfIP {
    public static void main(String[] args) {
         
        try{
            InetAddress add = InetAddress.getByName("192.168.1.1");
            if(add.isAnyLocalAddress()){
                System.out.println(add+" is a wildcard address.");
            }
            if(add.isLoopbackAddress()){
                System.out.println(add+" is a loopback address.");
            }
            if(add.isLinkLocalAddress()){
                System.out.println(add+" is a link-local address.");
            }
            else if(add.isSiteLocalAddress()){
                System.out.println(add+" is a site-local address.");
            }else{
                System.out.println(add+" is a global address.");
            }
            if(add.isMulticastAddress()){
                if(add.isMCGlobal()){
                    System.out.println(add+" is a global multicast address.");
                }else if(add.isMCOrgLocal()){
                    System.out.println(add+" is an organization wide multicast address.");
                }else if(add.isMCSiteLocal()){
                    System.out.println(add+" is a site wide multicast address.");
                }else if(add.isMCLinkLocal()){
                    System.out.println(add+" is a subnet wide multicast address.");
                }else if(add.isMCNodeLocal()){
                    System.out.println(add+" is an interface-local multicast address.");
                }else{
                    System.out.println(add+" is an unknown multicast address.");
                }
            }else{
                System.out.println(add+" is a unicast address.");
            }
        }catch(UnknownHostException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
