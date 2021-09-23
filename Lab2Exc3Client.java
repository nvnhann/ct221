import java.net.*;
import java.io.*;
import java.util.*;

public class Lab2Exc3Client {
    public static void main(String[] args) {
        final String SERVER = "127.0.0.1";
        final int PORT = 1025;

        try (Socket socket = new Socket(SERVER, PORT)) {
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            System.out.print("Nhap ten file can READ: ");
            String ten_file = inFromClient.readLine();
            outToServer.writeBytes("READ " + ten_file + "\n");
            int rs = Integer.parseInt(inFromServer.readLine());
            if (rs == -1) {
                System.out.println("File Khong ton tai!");
            } else {
                Date d = new Date();
                String filename = "file" + d.getTime() + ten_file;
                BufferedWriter writeFile = new BufferedWriter(new FileWriter(filename));
                String line;
                while ((line = inFromServer.readLine()) != null) {
                    writeFile.write(line);
                }
                writeFile.close();
                System.out.println("File da duoc luu voi ten: " + filename);

            }

        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
