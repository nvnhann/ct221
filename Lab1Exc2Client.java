import java.io.*;
import java.net.*;

public class Lab1Exc2Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 1025;
        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("Connected!");
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            // Lấy chuỗi ký tự nhập từ bàn phím
            System.out.print("Nhap so nguyen: ");
            String sentence_to_server = inFromUser.readLine();
            // Tạo OutputStream nối với Socket
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            // Tạo inputStream nối với Socket
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Gửi chuỗi ký tự tới Server thông qua outputStream đã nối với Socket
            outToServer.writeBytes(sentence_to_server + '\n');
            // Đọc tin từ Server thông qua InputSteam đã nối với socket
            String sentence_from_server = inFromServer.readLine();
            // print kết qua ra màn hình
            System.out.println("FROM SERVER: " + sentence_from_server);
            // Đóng liên kết socket
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
