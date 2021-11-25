import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MulticastCoviSv {
    public static void main(String[] args) {
        final int PORT = 33333;
        try{
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            Scanner sc = new Scanner(System.in);
            System.out.print("Ho ten cua ban la gi: ");
            String hoten = sc.nextLine();
            System.out.print("Ban da duoc tiem bao nhieu mui vaccine ngua Covi-19: ");
            int num = sc.nextInt();

            String strgui = hoten + " da tiem " + num + " mui vaccine";
            while (true){
                InetAddress address = InetAddress.getByName("229.1.1.1");
                DatagramPacket goigui = new DatagramPacket(strgui.getBytes(),strgui.getBytes().length, address, PORT);
                socket.send(goigui);
                System.out.println("Da gui : " + hoten + " - " + num);
                Thread.sleep(3000);
            }

        }catch (Exception e){
            System.err.print(e);
        }
    }
}
