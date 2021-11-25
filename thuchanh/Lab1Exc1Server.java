
// Nguyễn Văn Nhẫn
// B1809272
// Nhóm: 04
import java.io.*;
import java.net.*;

public class Lab1Exc1Server {
    public static void main(String[] args) {
        final int PORT = 1025;
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println("Connection from " + connection + "!");
                    InputStream inFromClient = connection.getInputStream();
                    OutputStream outToClient = connection.getOutputStream();
                    while (true) {
                        int sentence_from_client = inFromClient.read();
                        if (sentence_from_client == '@')
                            break;
                        String sentence_to_client = "Khong biet";
                        switch (sentence_from_client) {
                            case '0':
                                sentence_to_client = "Khong";
                                break;
                            case '1':
                                sentence_to_client = "Mot";
                                break;
                            case '2':
                                sentence_to_client = "Hai";
                                break;
                            case '3':
                                sentence_to_client = "Ba";
                                break;
                            case '4':
                                sentence_to_client = "Bon";
                                break;
                            case '5':
                                sentence_to_client = "Nam";
                                break;
                            case '6':
                                sentence_to_client = "Sau";
                                break;
                            case '7':
                                sentence_to_client = "Bay";
                                break;
                            case '8':
                                sentence_to_client = "Tam";
                                break;
                            case '9':
                                sentence_to_client = "Chin";
                                break;

                        }
                        outToClient.write(sentence_to_client.getBytes());
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
