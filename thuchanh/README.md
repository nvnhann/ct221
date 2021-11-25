# CT221 - Lập trình mạng

## Buổi 1: Socket TCP

**Bài 1:** Viết chương trình theo mô hình Client-Server sử dụng TCP Socket. Trong đó:

- Server làm nhiệm vụ đọc 1 ký tự số từ ký tự '0' đến ký tự '9'.
  Ví dụ : nhận ký tự 0 : trả về chuỗi "khong" ,
  ký tự 1 : trả về chuỗi "mot" ;
  …
  ký tự 9 : trả về chuỗi "chin"
  nhận ký tự khác số thì trả về chuỗi "Không phải số nguyên" .
- Client sẽ nhập vào từ bàn phím 1 ký tự, gửi qua Server, nhận kết quả trả về từ Server (là 1 chuỗi các ký tự) và hiển thị lên màn hình. Kết thúc khi nhập vào ký tự ‘@’.

**Bài 2:**  Viết chương trình theo mô hình Client-Server sử dụng TCP Socket. Trong đó:

- Client: nhập vào từ bàn phím 1 chuỗi số nguyên và gửi cho Server.
- Server làm nhiệm vụ đổi chuỗi số nguyên nhận được thành chuỗi số nhị phân và gửi trả lại cho Client. Nếu Server nhận được chuỗi không phải là số nguyên thì gửi trả lại câu thông báo “Không phải là số nguyên”.

## Buổi 2: Socket TCP – Server phục vụ song song

**Bài 1 :**  Viết chương trình theo mô hình Client-Server sử dụng TCP Socket. Trong đó:

- Client: nhập vào từ bàn phím 1 chuỗi họ và tên và gửi cho Server.
- Server làm nhiệm vụ tách tên của chuỗi vừa nhận và gửi trả lại cho Client.
  **Lưu ý:** thiết kế Server phục vụ song song.

**Bài 2:**  Viết chương trình theo mô hình Client-Server sử dụng TCP Socket. Trong đó:

- Server sẽ nhận từ Client câu lệnh dạng sau: “LIST Tênthưmục”
  Server sẽ gửi cho Client danh sách các file và thư mục con hiện có trong thư mục yêu cầu (trên Server), nếu thư mục tồn tại.
- Client sẽ cho phép người dùng nhập câu lệnh, gửi qua Server, nhận kết quả từ Server và hiển thị ra màn hình.

**Bài 3:** Viết chương trình theo mô hình Client-Server sử dụng TCP Socket. Trong đó:

- Server sẽ nhận từ Client câu lệnh dạng sau: “READ Tênfile”
- Server sẽ đọc nội dung file được yêu cầu trên Server và gửi cho Client nội dung đó.
- Client sẽ nhận dữ liệu từ Server và lưu lại thành 1 file kết quả tại Client.

## Buổi 3: Socket UDP

**Bài 1 :** Cài đặt dịch vụ DATETIME (RFC 867) sử dụng Socket UDP cổng 13. Trong đó:

- Client sẽ gửi cho Server 1 gói tin UDP với nội dung là rỗng. Chờ nhận phản hồi từ Server và hiển thị lên màn hình nội dung đó.
- Server nhận được yêu cầu từ Client, sẽ trả lời lại “Ngày và giờ hệ thống”.

**Bài 2 :**  Viết chương trình theo mô hình Client-Server sử dụng UDP Socket. Trong đó:

- Server sẽ nhận từ Client 1 gói có nội dung như sau: “READUDP Tênfile”
  Server sẽ gửi cho Client nội dung file theo yêu cầu nếu file nhỏ hơn 64KB. Nếu file không tồn tại thì gửi gói có chiều dài là 0.
- Client sẽ cho phép người dùng nhập tên file, nhận kết quả từ Server và lưu lại thành 1 file khác tại Client.

**Bài 3 :** Viết chương trình Talk theo chế độ không nối kết cho phép hai người trên hai máy tính trò chuyện với nhau.

## Buổi 4: Socket TCP với các dịch vụ Internet, Multicast Socket

**Bài 1 :**  Viết chương trình nhận đối số là một URL dạng Web. Nối kết đến Web Server trong URL để lấy trang web về và hiển thị nội dung file HTML đó ra màn hình.

**Bài 2 :**  Viết chương trình gửi 1 email (nội dung bất kỳ) đến 1 địa chỉ mail khi biết địa chỉ của 1 SMTP Server.

Có thể thử SMTP Server: smtp.saix.net (địa chỉ nhận contact@saix.net)

**Bài 3:** Viết chương trình UDP Server định kỳ 30s gửi 1 file cho trước đến 1 địa chỉ lớp D.
Xây dựng Client sử dụng Multicast Socket gia nhập vào nhóm địa chỉ đó để nhận file.

## Buổi 5: RMI

**Bài 1:** Xây dựng lớp DiemRMI:

- Thuộc tính x và y: kiểu integer
- Phương thức cục bộ: hàm xây dựng, hàm nhập giá trị từ bàn phím, hàm hiển thị
- Các phương thức cho phép gọi từ xa: lấy chuỗi tọa độ, gán điểm, dời điểm.
  Viết Server tạo ra 3 điểm A, B và C cho phép truy cập từ xa.
  Viết Client: sử dụng 3 điểm A, B, C trên Server. Thử nghiệm các hàm gọi từ xa.

**Bài 2:** Xây dựng một ứng dụng phục vụ việc bán vé máy bay cho các đại lý phân tán ở các tỉnh thành khác nhau. Ứng dụng này có các lớp sau:

- Lớp chuyến bay: đại diện cho một chuyến bay
  - Có các thuộc tính: Số hiệu chuyến bay, Ngày giờ bay, Nơi đi, Nơi đến, Thời gian bay, Tổng số ghế, Số lượng ghế đã bán, Số lượng ghế còn trống.
  - Các phương thức trên một chuyến bay: xem thông tin về chuyến bay, phương thức mua vé, phương thức trả vé. Để phục vụ cho nhiều đại lý, các phương thức trên thuộc loại được gọi từ xa.
  - Server: tạo ra nhiều chuyến bay  và duy trì nó để cho phép các đại lý thực hiện các giao dịch trên chuyến bay cụ thể.
  - Client là chương trình cho phép mỗi đại lý được quyền xem thông tin về chuyến bay, mua vé, trả vé theo yêu cầu.
