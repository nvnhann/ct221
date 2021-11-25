import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Bai4Server {
    public static void main(String[] args) {
        final int PORT = 33433;
        try{
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap chuoi: ");
            String str = sc.nextLine();
            while (true){
                InetAddress address = InetAddress.getByName("230.3.3.3");
                DatagramPacket goigui = new DatagramPacket(str.getBytes(),str.getBytes().length, address, PORT);
                socket.send(goigui);
                System.out.println("Da gui: " + str);
                Thread.sleep(1000);
            }

        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
