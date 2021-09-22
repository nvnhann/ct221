import java.io.*;
import java.net.*;

class ClientHandle extends Thread {
    final Socket s;

    // constructor
    public ClientHandle(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            System.out.println("Connection from " + this.s + "!");
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(this.s.getOutputStream());
            String ho_va_ten = inFromClient.readLine();
            System.out.println("Ho va ten: " + ho_va_ten);
            int last_space = ho_va_ten.lastIndexOf(' ');
            outToClient.writeBytes(ho_va_ten.substring(last_space + 1) + "\n");
            this.s.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

public class Lab2Exc1Server {
    public static void main(String[] args) {
        final int PORT = 1025;
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket connection = server.accept();
                ClientHandle client = new ClientHandle(connection);
                client.start();
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
