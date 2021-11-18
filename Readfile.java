// Nguyen Van Nhan - B1809272
import java.io.File;
import java.io.FileInputStream;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

class Readfile extends UnicastRemoteObject implements Readfileif {


    public  Readfile() throws RemoteException {
        super();
    }

    public int getLength(String filename) throws RemoteException {
        File file = new File(filename);
        if(file.isFile()) return (int) file.length();
        else return -1;
    }

    public byte[] getFile(String filename) throws RemoteException  {
        File file = new File(filename);

        if (file.isFile()){
            int len = (int) file.length();
            byte b[] = new byte[len];
            try {
                FileInputStream fis = new FileInputStream(filename);
                fis.read(b);
                fis.close();
            }catch (Exception e){
                System.out.print(e);
            }
            return b;
        } else return new byte[0];
    }
}