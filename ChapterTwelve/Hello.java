package ChapterTwelve;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface
public interface Hello extends Remote {
    void printMsg() throws RemoteException;
}
