// Nguyen Van Nhan - B1809272

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Bai1Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 11333;

        try {
            Socket socket = new Socket(SERVER, PORT);
            BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap so thuc: ");
            String a = fromUser.readLine();
            System.out.print("Nhap so nguyen: ");
            String n = fromUser.readLine();
            DataOutputStream sendToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendToServer.writeBytes(a + '\n');
            sendToServer.writeBytes(n+'\n');
            String from_server = inFromServer.readLine();
            System.out.println("SERVER: " + from_server);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
