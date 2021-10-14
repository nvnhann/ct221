import java.net.*;
import java.io.*;

public class Lab3Exc3Client{
    private final static int PORT = 1025;
    private final static String HOSTNAME = "127.0.0.1";

    public static void main(String []args){
        DatagramSocket socket = null;
       try{
            socket = new DatagramSocket();
            System.out.println("Client Start!");
            InetAddress host = InetAddress.getByName(HOSTNAME);
            while(true){
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Client: ");
                String message = inFromClient.readLine();
                byte [] data = message.getBytes();

                DatagramPacket request = new DatagramPacket(data, data.length, host, PORT);
                socket.send(request);

                DatagramPacket respone = new DatagramPacket(new byte[4096], 4096);
                socket.receive(respone);

                System.out.println("Server: "+ new String(respone.getData(), 0, respone.getLength()));

            }
       }catch(IOException e){
           System.err.println(e);
       }finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}