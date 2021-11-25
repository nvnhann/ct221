// Nguyen Van Nhan - B1809272
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class FolderListSv {

    public static void main(String[] args) {
        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            FolderList folder = new FolderList();
            System.out.println("Da khoi tao xong doi tuong cho phep goi tu xa");
            Naming.rebind("FOLDER", folder);
            System.out.println("Da dang ky");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
