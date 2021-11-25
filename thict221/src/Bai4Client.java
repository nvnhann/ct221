import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Bai4Client {
    public static void main(String[] args) {
        final int PORT = 33433;
        try{
            MulticastSocket ms = new MulticastSocket(PORT);
            InetAddress address = InetAddress.getByName("230.3.3.3");
            ms.joinGroup(address);
            while (true){
                DatagramPacket goinhan = new DatagramPacket(new byte[1000],1000);
                ms.receive(goinhan);
                byte b[] = goinhan.getData();
                System.out.println(goinhan.getAddress()+" : "+ new String(b,0, goinhan.getLength()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
