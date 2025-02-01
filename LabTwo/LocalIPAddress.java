package LabTwo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalIPAddress {
    public static int getVersion(InetAddress ia){
            
            byte[] address = ia.getAddress();
            
            System.out.println(address);
            if(address.length == 4){
                return 4;
            }else if(address.length == 16){
                return 6;
            }else{
                return -1;
            }
        
    }
    public static void main(String[] args) {
        try{
            
            InetAddress ia6 = InetAddress.getByName("ff06:0:0:0:0:0:0:c3");
            InetAddress ia4 = InetAddress.getByName("127.0.0.1");
            int res = getVersion(ia6);
            System.out.println("IP version: v"+res);
        }catch(UnknownHostException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
