import java.net.*;
import java.util.Scanner;
import java.io.*;

class Cau2_Client {
	public static void main(String[] args) {
		try {
			// Tao noi ket den server thong qua cong 4567
			Socket s = new Socket("127.0.0.1", 4567);
			System.out.println("may client da noi ket thanh cong den Server");
			// Lay ra 2 stream in-out
			InputStream iput = s.getInputStream();
			OutputStream oput = s.getOutputStream();
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("Nhap vao chuoi so nguyen 0-9: ");
				String st = sc.nextLine();
				byte b[] = st.getBytes();
				// Gui yeu cau den may server
				oput.write(b);
				if (st.equals("thoat") == true)
					break;

				// ket qua tu server gui ve
				byte c[] = new byte[1000];
				int n = iput.read(c);
				// hien thi ket qua may server gui ve
				String kq = new String(c, 0, n);
				System.out.println("ket qua la: " + kq);
			}
			// dong noi ket
			s.close();

		} catch (UnknownHostException e) {
			System.out.println("Sai dia chi Server");
		} catch (IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}
}