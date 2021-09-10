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
				int ch = System.in.read();
				os.write(ch);
				System.in.skip(2);
				if (ch == '@')
					break;
				byte b[] = new byte[1000];
				int ch1 = is.read(b);
				System.out.println("From server: " + new String(b));
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
