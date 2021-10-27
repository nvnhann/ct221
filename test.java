import java.io.*; 
import java.net.*; 
import java.util.*; 
public class test { 
    public static void main(String [] args){ 
    try { 
        Socket s = new Socket("smtp.saix.net", 587); 
        InputStream is = s.getInputStream(); 
        OutputStream os = s.getOutputStream(); 
        PrintWriter pw = new PrintWriter(os); 
        Scanner sc = new Scanner(is); 
        pw.flush(); 
        System.out.println("HELO nhan@saix.net"); 
        String str = sc.nextLine(); 
        System.out.println(str); 
        pw.println("MAIL FROM: <nhan@saix.net>"); 
        pw.flush(); 
        System.out.println("MAIL FROM: <nhan@saix.net>"); 
        str = sc.nextLine(); 
        System.out.println(str); 
        pw.println("RCPT TO: <b1809253@saix.net>"); 
        pw.flush(); 
        System.out.println("RCPT TO: <b1809253@saix.net>"); 
        str = sc.nextLine(); 
        System.out.println(str); 
        pw.println("DATA"); 
        pw.flush(); 
        System.out.println("DATA"); 
        str = sc.nextLine(); 
        System.out.println(str); 
        pw.println("From: nhan@saix.net"); 
        pw.println("To: contact@saix.net"); 
        pw.println("Subject: Test from nhan"); 
        pw.println("Nguyen Van Nhan - B1809272"); 
        pw.println(""); 
        pw.println("."); 
        pw.flush(); 
        System.out.println("From: nhan@saix.net\nTo: contact@saix.net\nSubject: Test from nhan\n\nNguyen Van Nhan - B1809272!!\n\n.\n"); 
        str = sc.nextLine(); 
        System.out.println(str); 
        pw.println("QUIT"); 
        pw.flush(); 
        str = sc.nextLine(); 
        System.out.println(str); 
        System.out.println("send successfully !"); 
        s.close(); 
    } catch (Exception e) {
        System.err.println(e);
    }
 }
}