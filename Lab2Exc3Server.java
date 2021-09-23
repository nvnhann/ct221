
// Nguyen Van Nhan
// B1809272
// Nhom 04
import java.net.*;
import java.io.*;

class HandleClient extends Thread {
    final Socket s;

    // constructor
    public HandleClient(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            System.out.println("Connection from " + this.s + "!");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(this.s.getOutputStream());
            String cau_lenh = inFromClient.readLine();
            System.out.println("Cau lenh: " + cau_lenh);
            String ten_file = cau_lenh.substring(5);
            System.out.println("Ten file: " + ten_file);
            try {
                BufferedReader fileReader = new BufferedReader(new FileReader(ten_file));
                String line;
                outToClient.writeBytes("1\n");
                while ((line = fileReader.readLine()) != null) {
                    outToClient.writeBytes(line);
                }
                fileReader.close();
            } catch (FileNotFoundException e) {
                outToClient.writeBytes("-1\n");

            }

            this.s.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

public class Lab2Exc3Server {
    public static void main(String[] args) {
        final int PORT = 1025;

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Listening for connections on port " + PORT);
            while (true) {
                Socket connection = server.accept();
                HandleClient client = new HandleClient(connection);
                client.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
