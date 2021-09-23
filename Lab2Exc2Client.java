import java.net.*;
import java.io.*;

public class Lab2Exc2Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 1025;
        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("Connected!");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

            System.out.print("Nhap ten thu muc can LIST: ");
            String ten_thu_muc = inFromClient.readLine();
            outToServer.writeBytes("LIST " + ten_thu_muc + "\n");

            String so_luong = inFromServer.readLine();
            int n = Integer.parseInt(so_luong);

            if (n == -1)
                System.out.println("Thu muc " + ten_thu_muc + " khong ton tai");
            else if (n == 0)
                System.out.println("Thu muc " + ten_thu_muc + " rong!");
            else {
                System.out.println(ten_thu_muc + " bao gom: ");
                for (int i = 0; i < n; i++) {
                    String kq = inFromServer.readLine();
                    System.out.println(kq);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
