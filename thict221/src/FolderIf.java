// Nguyen Van Nhan - B1809272

import java.rmi.Remote;
import java.rmi.RemoteException;

interface FolderIf extends Remote {
    public boolean thumucTonTai(String tenthumuc) throws RemoteException;
    public String[] lietKe(String tenthumuc) throws RemoteException;
}
