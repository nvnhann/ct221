import java.net.*;
import java.io.*;

public class Lab1Exc2Server {
    public static void main(String[] args) {
        final int PORT = 1025;
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println("Connection from " + connection + "!");
                    // Tạo input stream, nối tới Socket
                    BufferedReader inFromClient = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    // Tạo outputStream, nối tới socket
                    DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
                    // Đọc thông tin từ socket
                    String sentence_from_client = inFromClient.readLine();
                    System.out.println("The message send from socket was: " + sentence_from_client);
                    String sentence_to_client = null;
                    try {
                        sentence_to_client = Integer.toBinaryString(Integer.parseInt(sentence_from_client));
                    } catch (NumberFormatException e) {
                        sentence_to_client = "Khong phai la so nguyen";
                    }
                    // ghi dữ liệu ra socket
                    outToClient.writeBytes(sentence_to_client);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
