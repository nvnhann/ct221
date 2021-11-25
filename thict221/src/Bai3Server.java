// Nguyen Van Nhan - B1809272

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Bai3Server {
    public static void main(String[] args) {
        final int PORT = 22444;
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            while (true){
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                socket.receive(request);
                String ip = new String(request.getData(), 0, request.getData().length);
                //System.out.println("IP: " + ip);
                String firstIP =ip.substring(0,ip.indexOf('.'));
                String rs = null;
                if (Integer.parseInt(firstIP) < 128) {
                    System.out.println("Noi dung ban gui la mot dia chi thuoc lop A");
                    rs = "Noi dung ban gui la mot dia chi thuoc lop A";
                } else if (Integer.parseInt(firstIP) < 192) {
                    System.out.println("Noi dung ban gui la mot dia chi thuoc lop B");
                    rs = "Noi dung ban gui la mot dia chi thuoc lop B";
                } else if ((Integer.parseInt(firstIP) < 224)){
                    System.out.println("Noi dung ban gui la mot dia chi thuoc lop C");
                    rs = "Noi dung ban gui la mot dia chi thuoc lop C";
                }
                else {
                    rs = "Noi dung ban gui la mot dia chi khong thuoc lop A,B,C";
                }

                byte [] data = rs.getBytes();
                DatagramPacket respone = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
                socket.send(respone);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
