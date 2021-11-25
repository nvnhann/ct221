// Nguyen Van Nhan - B1809272
import java.rmi.Naming;
import java.util.Scanner;

public class FolderListClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FolderIf folder = (FolderIf) Naming.lookup("rmi://127.0.0.1/FOLDER");
            System.out.print("Nhap ten thu muc can liet ke: ");
            String foldername = sc.nextLine();
            if (folder.thumucTonTai(foldername)){
                String list[] = folder.lietKe(foldername);
                System.out.println("Noi dung thu muc "+ foldername+": ");
                for(int i=0; i<list.length; i++){
                    System.out.println(list[i]);
                }

            } else {
                System.out.println("Thu muc yeu cau khong ton khong tai tren server");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
