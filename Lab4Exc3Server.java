// Nguyen Van Nhan - B1809272
import java.net.*;
import java.io.*;
import java.util.*;

public class Lab4Exc3Server{
    private final static int PORT = 1025;
    public static void main(String []args){
        try{
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap ten file: "); 
            String filename = sc.nextLine();
            while(true){
             InetAddress address = InetAddress.getByName("230.0.0.1");
             File file = new File(filename);
             if(file.exists() && file.isFile()){
                byte fn[] = filename.getBytes(); 
                socket.send(new DatagramPacket(fn,fn.length,address,PORT));
                 if(file.length()>0){
                    byte b[]=new byte[(int)file.length()+1];
                    FileInputStream fis = new FileInputStream(filename);
				    DataInputStream dis = new DataInputStream(fis);
                    while(dis.available()>0) {
                        dis.read(b);
                    }
                
                DatagramPacket goigui = new DatagramPacket(b,b.length,address,PORT);
                socket.send(goigui);
                fis.close();
                }
                System.out.println("Da gui xong noi dung file");
                Thread.sleep(30000);
             } else{
                 System.out.println("File khong ton tai!");
                 System.out.print("Nhap lai ten file: "); 
                 filename = sc.nextLine();
             }
            
            }
             
        }catch(Exception e){
            System.err.println(e);
        }
    }
}