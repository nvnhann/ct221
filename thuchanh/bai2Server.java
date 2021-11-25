import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class bai2Server {
    private final static int PORT = 22333;
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(PORT);
        while (true) {
            DatagramPacket request = new DatagramPacket(new byte[0], 0);
            socket.receive(request);
            String ip = request.getAddress().toString().replace("/", "");
            InetAddress address = InetAddress.getByName(ip);
            String firstTriplet = address.getHostAddress().
                    substring(0,address.getHostAddress().indexOf('.'));
            String rs= null;
            if (Integer.parseInt(firstTriplet) < 128) {
                System.out.println("Class A IP");
                rs = "Class A IP";
            } else if (Integer.parseInt(firstTriplet) < 192) {
                System.out.println("Class B IP");
                rs = "Class B IP";

            } else {
                System.out.println("Class C IP");
                rs = "Class C IP";
            }

            byte [] data = rs.getBytes();
            DatagramPacket respone = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
            socket.send(respone);

        }
    }
}




