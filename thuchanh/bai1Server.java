import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class bai1Server {
    public static void main(String[] args) {
        final int PORT = 11333;
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true){
                try {
                    Socket connection = server.accept();
                    System.out.println(connection);
                    BufferedReader inFromClient = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
                    String float_client = inFromClient.readLine();
                    String int_client = inFromClient.readLine();
                    System.out.println("So thuc: " + float_client);
                    System.out.println("So nguyen: " + int_client);
                    String sentence_to_client;
                    try {
                        float fl = Float.parseFloat(float_client);
                        int in = Integer.parseInt(int_client);
                        double result = Math.pow(fl, in);
                        sentence_to_client = Double.toString(result);

                    } catch (NumberFormatException e) {
                       sentence_to_client = "Sai quy cach";
                    }
                    outToClient.writeBytes(sentence_to_client + '\n');
                }catch (Exception e){
                    System.out.print(e);
                }
            }

        } catch (IOException e) {
            System.out.print(e);
        }


    }
}
