// Nguyen Van Nhan - B1809272

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Bai3Client {
    public static void main(String[] args) {
        final int PORT = 22444;
        final String HOSTNAME = "127.0.0.1";
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress host = InetAddress.getByName(HOSTNAME);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap dia chi IP: ");
            String ip = sc.nextLine();
            DatagramPacket request = new DatagramPacket(ip.getBytes(), ip.getBytes().length, host, PORT);
            socket.send(request);
            DatagramPacket respone = new DatagramPacket(new byte[4096], 4096);
            socket.receive(respone);
            System.out.println("Server: "+ new String(respone.getData(), 0, respone.getLength()));
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
