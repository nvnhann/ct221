
// Nguyen Van Nhan B1809272 CT221'04
import java.net.*;
import java.io.*;

public class Lab2Exc1Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 1025;

        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("Connected!");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inFromSever = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

            System.out.print("Nhap ho va ten: ");
            String ho_va_ten = inFromClient.readLine();
            outToServer.writeBytes(ho_va_ten + "\n");
            String ten = inFromSever.readLine();
            System.out.println("Ten cua ban la: " + ten);

        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
