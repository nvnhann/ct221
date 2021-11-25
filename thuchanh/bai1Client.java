import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class bai1Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 11333;
        try (Socket socket = new Socket(SERVER, PORT)) {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Nhap so thuc: ");
            String float_to_server = inFromUser.readLine();
            System.out.print("Nhap so nguyen: ");
            String int_to_server = inFromUser.readLine();
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToServer.writeBytes(float_to_server + '\n');
            outToServer.writeBytes(int_to_server+'\n');

            String sentence_from_server = inFromServer.readLine();
            System.out.println("SERVER: " + sentence_from_server);
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }


    }
}

