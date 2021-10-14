import java.net.*;
import java.io.*;

public class Lab3Exc1Client{
    private final static int PORT = 1025;
    private final static String HOSTNAME = "127.0.0.1";
    public static void main(String []args){
        DatagramSocket socket = null;
        try{
             socket = new DatagramSocket();
            System.out.println("Client started ");
            InetAddress host = InetAddress.getByName(HOSTNAME);
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
            DatagramPacket respone = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(respone);
            String result = new String(respone.getData(), 0, respone.getLength());
            System.out.println(result);
        }catch(IOException e){
            System.err.println(e);
        }finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}