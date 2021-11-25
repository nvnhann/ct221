import java.net.*;
import java.io.*;

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
            String cau_lenh = inFromClient.readLine();
            System.out.println("Cau lenh: " + cau_lenh);
            String thu_muc = cau_lenh.substring(5);
            // System.out.println("Thu muc: " + thu_muc);
            File file = new File(thu_muc);
            int n = -1;
            if (file.exists() && file.isDirectory()) {
                String list[] = file.list();
                n = list.length;
                outToClient.writeBytes(Integer.toString(n) + "\n");
                for (int i = 0; i < n; i++) {
                    File temp = new File(thu_muc + "/" + list[i]);
                    if (temp.isFile()) {
                        outToClient.writeBytes(list[i] + "\n");
                    } else {
                        outToClient.writeBytes("[" + list[i] + "]\n");
                    }
                }
            } else {
                outToClient.writeBytes(Integer.toString(n) + "\n");
            }
            this.s.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

public class Lab2Exc2Server {
    public static void main(String[] args) {
        final int PORT = 1025;

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Listening for connections on port " + PORT);
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
