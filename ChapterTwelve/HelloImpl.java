package ChapterTwelve;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Remote object implementation
public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected HelloImpl() throws RemoteException {
        super();
    }

    public void printMsg() throws RemoteException {
        System.out.println("Hello, this is a message from the server!");
    }
}
