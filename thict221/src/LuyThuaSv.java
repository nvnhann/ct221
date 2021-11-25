import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandle extends Thread{
    Socket s;

    public ClientHandle(Socket s){
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
                float fl = Float.parseFloat(float_client);
                int in = Integer.parseInt(int_client);
                double rs = Math.pow(fl, in);
                result = Double.toString(rs);
            }catch (NumberFormatException e){
                result = "Sai quy cach";
            }

            sendClient.writeBytes(result + '\n');

        }catch (Exception e){
            System.err.print(e);
        }
    }
}

public class LuyThuaSv {
    public static void main(String[] args) {
        final int PORT = 11333;
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true){
                Socket connection = server.accept();
                ClientHandle client = new ClientHandle(connection);
                client.start();
            }
        }catch (Exception e){
            System.err.print(e);
        }
    }
}
