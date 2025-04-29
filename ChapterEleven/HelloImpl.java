package ChapterEleven;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the remote interface
public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected HelloImpl() throws RemoteException {
        super();
    }

    public void printMsg() throws RemoteException {
        System.out.println("Hello, this is a message from the server!");
    }
}
