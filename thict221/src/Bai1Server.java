// Nguyen Van Nhan - B1809272
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class ClientLuyThua extends Thread{
         Socket s;

    public ClientLuyThua(Socket s){
        this.s = s;
    }

    public void run(){
        try {
            System.out.println("Connection: " + this.s);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            DataOutputStream sendClient = new DataOutputStream(this.s.getOutputStream());
            String float_client = fromClient.readLine();
            String int_client = fromClient.readLine();
            System.out.println("So thuc: " + float_client);
            System.out.println("So nguyen: " + int_client);
            String result = null;
            try{
                float a = Float.parseFloat(float_client);
                int n = Integer.parseInt(int_client);
                double rs = Math.pow(a, n);
                result = Double.toString(rs);
            }catch (NumberFormatException e){
                result = "Sai quy cach";
            }
            sendClient.writeBytes(result + '\n');

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

public class Bai1Server {
    public static void main(String[] args) {
        final int PORT = 11333;
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true){
                Socket connection = server.accept();
                ClientLuyThua client = new ClientLuyThua(connection);
                client.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
