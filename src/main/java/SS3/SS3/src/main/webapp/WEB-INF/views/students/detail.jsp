<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Chi tiết sinh viên</title></head>
<body>
<h2>Thông tin sinh viên</h2>
<p>Mã SV: ${student.studentCode}</p>
<p>Họ tên: ${student.fullName}</p>
<p>Khoa: ${student.faculty}</p>
<p>Năm nhập học: ${student.enrollmentYear}</p>
<p>GPA: ${student.gpa}</p>
<p>Trạng thái: ${student.status}</p>
<a href="/students">Quay lại danh sách</a>
</body>
</html>
