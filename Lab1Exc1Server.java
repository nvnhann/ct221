import java.io.*;
import java.net.*;

public class Lab1Exc1Server {
    public static void main(String[] args) {
        final int PORT = 1025;
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println("Co 1 Client " + connection.getInetAddress() + " cong " + connection.getPort()
                            + " noi ket");
                    InputStream is = connection.getInputStream();
                    OutputStream os = connection.getOutputStream();
                    while (true) {
                        int ch = is.read();
                        if (ch == '@')
                            break;
                        String rs = "Khong biet";
                        switch (ch) {
                            case '0':
                                rs = "Khong";
                                break;
                            case '1':
                                rs = "Mot";
                                break;
                            case '2':
                                rs = "Hai";
                                break;
                            case '3':
                                rs = "Ba";
                                break;
                            case '4':
                                rs = "Bon";
                                break;
                            case '5':
                                rs = "Nam";
                                break;
                            case '6':
                                rs = "Sau";
                                break;
                            case '7':
                                rs = "Bay";
                                break;
                            case '8':
                                rs = "Tam";
                                break;
                            case '9':
                                rs = "Chin";
                                break;

                        }
                        os.write(rs.getBytes());
                    }
                    connection.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            // TODO: handle exception
            System.err.println(e);
        }
    }

}
