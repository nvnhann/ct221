// Nguyen Van Nhan - B1809272
import java.net.*;
import java.io.*;

public class Lab3Exc3Server{
    private final static int PORT = 1025;
    public static void main(String []args){
        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(PORT);
            while(true){
                DatagramPacket request = new DatagramPacket(new byte[4096], 4096);
                socket.receive(request);

                System.out.println("Client: "+ new String(request.getData(), 0, request.getLength()));

                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Server: ");
                String message = inFromServer.readLine();
                byte [] data = message.getBytes();
                DatagramPacket respone = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
                socket.send(respone);
            }
        }catch(IOException e){
            System.err.println(e);
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}