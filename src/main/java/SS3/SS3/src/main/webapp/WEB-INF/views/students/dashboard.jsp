
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head><title>Dashboard</title></head>
<body>
<h2>Báo cáo tổng quan</h2>
<p>Tổng số sinh viên: ${total}</p>
<p>GPA trung bình: ${avgGpa}</p>

<h3>Tỷ lệ theo trạng thái</h3>
<ul>
  <li>Đang học: ${countHoc} sinh viên</li>
  <li>Bảo lưu: ${countBaoLuu} sinh viên</li>
  <li>Tốt nghiệp: ${countTotNghiep} sinh viên</li>
</ul>

<c:if test="${not empty topStudent}">
  <p>Thủ khoa: ${topStudent.fullName} (GPA: ${topStudent.gpa})</p>
</c:if>

<a href="/students">Quay lại danh sách</a>
</body>
</html>
