<!-- @format -->

\*\*Student Management System - Advanced Software Engineering
Dự án được xây dựng trong khuôn khổ môn học Phát triển phần mềm nâng cao tại Đại học Bách Khoa TP.HCM.

1. Thông tin nhóm

Thành viên 1: [Họ tên của bạn] - [MSSV]

Thành viên 2: [Họ tên bạn cùng nhóm - nếu có] - [MSSV]

2. Hướng dẫn chạy dự án

Yêu cầu hệ thống:

Java Development Kit (JDK) 17 hoặc cao hơn.

Build Tool: Maven.

Các bước thực hiện:

Clone repository về máy.

Mở terminal tại thư mục gốc của dự án.

Chạy lệnh: ./mvnw spring-boot:run.

Ứng dụng sẽ khởi chạy và tự động tạo file cơ sở dữ liệu student.db.

3. Trả lời câu hỏi lý thuyết (Bài tập Lab 1)

Câu 1: Tại sao Database lại chặn thao tác chèn trùng ID?

Trả lời: Vì cột id được định nghĩa là PRIMARY KEY (Khóa chính). Ràng buộc này đảm bảo mỗi bản ghi là duy nhất để hệ thống có thể phân biệt, truy vấn và cập nhật chính xác từng sinh viên. Khi chèn trùng, lỗi UNIQUE constraint failed sẽ xuất hiện để bảo vệ tính toàn vẹn của dữ liệu.

Câu 2: Ảnh hưởng của việc cho phép giá trị NULL ở cột Name?

Trả lời: Việc thiếu ràng buộc NOT NULL cho tên sinh viên gây mất an toàn dữ liệu. Khi code Java đọc dữ liệu này lên, đối tượng sẽ mang giá trị null. Nếu chương trình thực hiện các thao tác trên biến này (ví dụ: in tên, xử lý chuỗi) mà không kiểm tra, sẽ dẫn đến lỗi NullPointerException, gây sập ứng dụng.

Câu 3: Tại sao mỗi lần khởi động lại ứng dụng, dữ liệu cũ trong Database bị mất?

Trả lời: Do cấu hình spring.jpa.hibernate.ddl-auto=create trong file application.properties. Chế độ create yêu cầu Hibernate xóa bỏ các bảng cũ (Drop) và tạo lại bảng mới (Create) mỗi khi ứng dụng Spring Boot bắt đầu chạy.
