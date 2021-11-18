// Nguyen Van Nhan - B1809272
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
public class ReadfileServer {
    public static void main(String [] args){
        try {
            if(System.getSecurityManager() == null){
                System.setSecurityManager(new RMISecurityManager());
            }
            Readfile file = new Readfile();
            System.out.println("Da khoi tao xong doi tuong cho phep goi tu xa");
            Naming.rebind("READFILE", file);
            System.out.println("Da dang ky xong doi tuong tu xa");
        }catch (Exception e){
            System.err.print(e);
        }
    }
}
