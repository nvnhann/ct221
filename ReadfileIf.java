// Nguyen Van Nhan - B1809272
import java.rmi.Remote;
import java.rmi.RemoteException;

interface Readfileif extends Remote {
    public int getLength(String filename) throws RemoteException;

    public byte[] getFile(String filename) throws  RemoteException;

}