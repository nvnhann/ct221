// Nguyen Van Nhan - B1809272

import java.net.*;
import java.io.*;

public class Lab4Exc3Client{
    private final static int PORT = 1025;
    public static void main(String []args){
        try{
            DatagramSocket socket = new DatagramSocket();
            MulticastSocket ms = new MulticastSocket(PORT);            
            InetAddress address = InetAddress.getByName("230.0.0.1");
            ms.joinGroup(address);
            DatagramPacket goinhan = new DatagramPacket(new byte[1000],1000);
            ms.receive(goinhan);
            byte b[] = goinhan.getData();
            String filename = new String(b,0, goinhan.getLength());
           if(filename.lastIndexOf("/") > 0){
              filename = filename.substring(filename.lastIndexOf("/") + 1, filename.length());
           }
           
            DatagramPacket goinhanfile = new DatagramPacket(new byte[60000],60000);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            dos.write(goinhanfile.getData(), 0, goinhanfile.getLength());
            dos.close();
			System.out.println("Da ghi file " + filename+" thanh cong");
            ms.leaveGroup(address);
			ms.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
