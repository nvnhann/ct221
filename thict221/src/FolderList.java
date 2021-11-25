// Nguyen Van Nhan - B1809272
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class FolderList extends UnicastRemoteObject implements FolderIf {

    public FolderList() throws RemoteException {
        super();
    }

    @Override
    public boolean thumucTonTai(String tenthumuc) throws RemoteException {
        File folder = new File(tenthumuc);
        if (folder.exists() && folder.isDirectory()) return true;
        else return false;
    }

    @Override
    public String[] lietKe(String tenthumuc) throws RemoteException {
        File folder = new File(tenthumuc);
        return folder.list();
    }
}
