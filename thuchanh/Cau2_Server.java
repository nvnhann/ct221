import java.net.*;
import java.io.*;

public class Cau2_Server {
	public static void main(String[] args) {
		try {
			// Tao ra Server Socket co cong 4567 de lang nghe
			ServerSocket ss = new ServerSocket(4567);
			System.out.println("May server da duoc khoi tao xong");
			while (true) {

				Socket s = ss.accept(); // Chap nhan mot ket noi den tu may client
				System.out.println("may client " + s.getInetAddress() + " co cong " + s.getPort() + " noi ket");
				// Lay ra 2 stream in-out
				InputStream iput = s.getInputStream();
				OutputStream oput = s.getOutputStream();

				while (true) {
					// nhan yeu cau tu client
					byte b[] = new byte[1000];
					int n = iput.read(b);
					String kq = new String(b, 0, n);
					System.out.println("ket qua" + kq);
					// check dieu kien vong lap while
					if (kq.equals("thoat") == true)
						break;
					String st = null;
					try {
						int number = Integer.parseInt(kq);
						st = String.valueOf(Integer.toBinaryString(number));
						// tra ket qua cho may client
					} catch (java.lang.NumberFormatException e) {
						st = "khong phai so nguyen";
					}
					byte c[] = st.getBytes();
					oput.write(c);

				}

				s.close();
			}
			// ss.close();
		} catch (IOException e) {
			System.out.println("Khong khoi tao duoc Server");
		}
	}
}
