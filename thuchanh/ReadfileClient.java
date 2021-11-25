// Nguyen Van Nhan - B1809272
import java.io.FileOutputStream;
import java.rmi.Naming;
import java.util.Scanner;

public class ReadfileClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Readfileif file = (Readfileif) Naming.lookup("rmi://127.0.0.1/READFILE");
            System.out.println("Da tim duoc doi tuong READFILE");
            System.out.print("Nhap ten file: ");
            String filename = sc.nextLine();
            System.out.println("Do dai file: " + file.getLength(filename));
            if(file.getLength(filename) != 1){
                System.out.print("Nhap ten file can luu: ");
                String tenfileluu = sc.nextLine();
                FileOutputStream fos = new FileOutputStream(tenfileluu);
                fos.write(file.getFile(filename), 0, file.getLength(filename));

            }
        }catch (Exception e){
            System.err.print(e);
        }
    }
}
