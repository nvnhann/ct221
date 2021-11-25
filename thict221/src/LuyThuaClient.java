import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class LuyThuaClient {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 11333;

        try {
            Socket socket = new Socket(SERVER, PORT);
            BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap so thuc: ");
            String float_to_server = fromUser.readLine();
            System.out.print("Nhap so nguyen: ");
            String int_to_server = fromUser.readLine();
            DataOutputStream sendToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendToServer.writeBytes(float_to_server + '\n');
            sendToServer.writeBytes(int_to_server+'\n');
            String from_server = inFromServer.readLine();
            System.out.println("SERVER: " + from_server);
        }catch (Exception e){
            System.err.print(e);
        }

    }
}
