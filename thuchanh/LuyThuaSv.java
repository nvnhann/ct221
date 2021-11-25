import java.net.ServerSocket;
import java.net.Socket;

public class LuyThuaSv {
    public static void main(String[] args) {
        final int PORT = 11333;
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true){
                Socket connection = server.accept();
                System.out.println(connection);

            }
        }catch (Exception e){
            System.err.print(e);
        }
    }
}
