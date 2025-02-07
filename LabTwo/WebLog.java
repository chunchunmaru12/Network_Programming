package LabTwo;
import java.io.*;
import java.net.*;
public class WebLog {
    public static void main(String[] args) {
        try(FileInputStream fin = new FileInputStream(args[0]);
            Reader in =new InputStreamReader(fin);
            BufferedReader bin = new BufferedReader(in);){
                for(String entry = bin.readLine() ;entry != null ;entry = bin.readLine()){
                    //separte out the IP address
                    int index = entry.indexOf(' ');
                    String ip = entry.substring(0, index);
                    String theRest = entry.substring(index);
                    //ask dns for the hostname and print it out
                    try{
                        InetAddress address = InetAddress.getByName(ip);
                        System.out.println(address.getHostName() + theRest);
                    }catch(UnknownHostException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }
            
            
    }
}
