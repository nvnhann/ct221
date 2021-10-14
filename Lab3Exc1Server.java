import java.net.*;
import java.io.*;
import java.util.*;

public class Lab3Exc1Server{
    private final static int PORT = 1025;

    public static void main(String []args){
        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(PORT);
            DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
            while(true){
            socket.receive(request);
            String daytime = new Date().toString();
            byte[] data = daytime.getBytes();
            DatagramPacket respone = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
            socket.send(respone);
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