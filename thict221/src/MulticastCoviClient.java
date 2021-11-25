import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastCoviClient {
    public static void main(String[] args) {
        final int PORT = 33333;
        try{
            MulticastSocket ms = new MulticastSocket(PORT);
            InetAddress address = InetAddress.getByName("229.1.1.1");
            ms.joinGroup(address);
            while (true){
                DatagramPacket goinhan = new DatagramPacket(new byte[1000],1000);
                ms.receive(goinhan);
                byte b[] = goinhan.getData();
                System.out.println("Chuoi nhan duoc la: " + new String(b,0, goinhan.getLength()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
