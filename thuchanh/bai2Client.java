import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class bai2Client {
    private final static int PORT = 22333;
    private final static String HOSTNAME = "127.0.0.1";
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        System.out.println("Client Start!");
        InetAddress host = InetAddress.getByName(HOSTNAME);
        DatagramPacket request = new DatagramPacket(new byte[0], 0, host, PORT);
        socket.send(request);
        DatagramPacket respone = new DatagramPacket(new byte[4096], 4096);
        socket.receive(respone);
        System.out.println("Server: "+ new String(respone.getData(), 0, respone.getLength()));
    }

}

