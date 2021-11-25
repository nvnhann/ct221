import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Bai3Client {
    public static void main(String[] args) {
        int PORT = 33333;
        try{
            DatagramSocket socket = new DatagramSocket();
            MulticastSocket ms = new MulticastSocket(PORT);
            InetAddress address = InetAddress.getByName("229.1.1.1");
            ms.joinGroup(address);
            while (true){
                DatagramPacket goinhan = new DatagramPacket(new byte[1000],1000);
                ms.receive(goinhan);
                System.out.println("da join");
                byte b[] = goinhan.getData();
                String str= new String(b,0, goinhan.getLength());
                System.out.println("Chuoi vua nhan la" + str);
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
