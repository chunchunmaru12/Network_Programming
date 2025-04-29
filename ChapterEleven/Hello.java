package ChapterEleven;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote Interface
public interface Hello extends Remote {
    void printMsg() throws RemoteException;
}
