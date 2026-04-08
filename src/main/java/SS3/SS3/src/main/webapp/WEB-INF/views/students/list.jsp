<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head><title>Danh sách sinh viên</title></head>
<body>
<h2>Danh sách sinh viên</h2>

<c:if test="${not empty search}">
    <p>Tìm thấy ${fn:length(students)} sinh viên phù hợp với từ khóa "${search}"</p>
</c:if>

<table border="1">
    <tr>
        <th>STT</th>
        <th><a href="?sortBy=name">Họ tên</a></th>
        <th>Mã SV</th>
        <th>Khoa</th>
        <th>Năm nhập học</th>
        <th><a href="?sortBy=gpa">GPA</a></th>
        <th>Trạng thái</th>
        <th>Chi tiết</th>
    </tr>
    <c:forEach var="s" items="${students}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${s.fullName}</td>
            <td>${s.studentCode}</td>
            <td>${s.faculty}</td>
            <td>${s.enrollmentYear}</td>
            <td>${s.gpa}</td>
            <td>
                <c:choose>
                    <c:when test="${s.status eq 'Đang học'}"><span style="color:green">${s.status}</span></c:when>
                    <c:when test="${s.status eq 'Bảo lưu'}"><span style="color:orange">${s.status}</span></c:when>
                    <c:otherwise><span style="color:blue">${s.status}</span></c:otherwise>
                </c:choose>
            </td>
            <td><a href="students/detail?id=${s.id}">Xem</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
