import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class bai3Server {
    public static void main(String[] args) {
        int PORT = 33333;
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap chuoi: ");
            String str = sc.nextLine();
            while (true) {
                InetAddress address = InetAddress.getByName("229.1.1.1");
                byte b[] = str.getBytes();
                socket.send(new DatagramPacket(b, b.length, address, PORT));
                System.out.println("Da gui xong noi dung!");
                Thread.sleep(1000);
            }
        } catch (SocketException socketException) {
            socketException.printStackTrace();
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
