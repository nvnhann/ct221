// Nguyen Van Nhan - B1809272
import java.io.*;
import java.net.*;
import java.util.*;

public class Lab4Exc2Client {
    public static void main(String [] args){
        try {
            
            Socket s = new Socket("smtp.saix.net", 587);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            Scanner sc = new Scanner(is);
            pw.println("HELO nhan@saix.nett");
            pw.flush();
            System.out.println("HELO nhan@saix.net");
            String str = sc.nextLine();
            System.out.println(str);
            pw.println("MAIL FROM: nhan@saix.net");
            pw.flush();
            System.out.println("MAIL FROM: nhan@saix.net");
            str = sc.nextLine();
            System.out.println(str);
            pw.println("RCPT TO: contact@saix.net");
            pw.flush();
            System.out.println("RCPT TO: contact@saix.net");
            str = sc.nextLine();
            System.out.println(str);
            pw.println("DATA");
            pw.flush();
            System.out.println("DATA");
            str = sc.nextLine();
            System.out.println(str);
            pw.println("From: nhan@saix.net");
            pw.println("To: contact@saix.net");
            pw.println("Subject: Test from Nhan");
            pw.println("Nguyen Van Nhan - B1809272");
            pw.println("");
            pw.println(".");
            pw.flush();
            System.out.println("From: nhan@saix.net\nTo: contact@saix.net\nSubject: Test from Nhan\n\nNguyen Van Nhan - B1809272\n\n.\n");
            str = sc.nextLine();
            System.out.println(str);
            pw.println("QUIT");
            pw.flush();
            str = sc.nextLine();
            System.out.println(str);
            System.out.println("send mail successfully!");
            s.close();

        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
}
