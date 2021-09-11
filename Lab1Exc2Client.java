
// Nguyễn Văn Nhẫn
// B1809272
// Nhóm: 04
import java.io.*;
import java.net.*;

public class Lab1Exc2Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 1025;
        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("Connected!");
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap so nguyen: ");
            String sentence_to_server = inFromUser.readLine();
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToServer.writeBytes(sentence_to_server + '\n');
            String sentence_from_server = inFromServer.readLine();
            System.out.println("FROM SERVER: " + sentence_from_server);
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
