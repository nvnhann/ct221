// Nguyễn Văn Nhẫn
// B1809272
// Nhóm: 04

import java.net.*;
import java.io.*;

public class Lab1Exc1Client {
	public static void main(String[] args) {
		final String SERVER = "127.0.0.1";
		final int PORT = 1025;
		try {
			Socket socket = new Socket(SERVER, PORT);
			System.out.println("Connected!");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			while (true) {
				System.out.print("Nhap 1 ky tu so: ");
				int sentence_to_server = System.in.read();
				os.write(sentence_to_server);
				System.in.skip(2);
				if (sentence_to_server == '@')
					break;
				byte sentence_from_server[] = new byte[1000];
				is.read(sentence_from_server);
				System.out.println("From server: " + new String(sentence_from_server));
			}
			socket.close();

		} catch (UnknownHostException e) {
			// TODO: handle exceptione
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}

	}
}
