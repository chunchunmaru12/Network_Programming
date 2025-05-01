package EchoSever;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Instantiate the implementation class
            HelloImpl obj = new HelloImpl();

            // No need to export again manually
            Registry registry = LocateRegistry.createRegistry(1099); // Start internal registry
            registry.bind("Hello", obj); 

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
