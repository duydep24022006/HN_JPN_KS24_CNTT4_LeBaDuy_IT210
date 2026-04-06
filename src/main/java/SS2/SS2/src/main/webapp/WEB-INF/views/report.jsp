<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="com.example.ss2.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/7/2026
  Time: 4:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
          %>

<%!
    // Biến đếm toàn cục — dùng chung cho tất cả request
    private int requestCounter = 0;
%>

<html>
<head>
    <!-- Tiêu đề trang báo cáo -->
    <title>Báo cáo điểm</title>
</head>
<body>

<%
    requestCounter++;
    List<Student> list = (List<Student>) request.getAttribute("studentList");
    String title = (String) request.getAttribute("reportTitle");
%>

<h1>${reportTitle}</h1>
<p>Lượt xem trang (LỖI tiềm ẩn): <%= requestCounter %></p>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>
    <c:forEach var="sv" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
        <td><c:out value="${sv.fullName}"/></td>>
        <td>${sv.score}</td>
        <td>
        <c:choose>
            <c:when test="${sv.score >= 90}">Xuất sắc</c:when>
            <c:when test="${sv.score >= 80}">Giỏi</c:when>
            <c:when test="${sv.score >= 70}">Khá</c:when>
            <c:when test="${sv.score >= 60}">Trung bình khá</c:when>
            <c:when test="${sv.score >= 50}">Trung bình</c:when>
            <c:otherwise>Yếu</c:otherwise>
        </c:choose>
        </td>
        </tr>>
    </c:forEach>>
</table>

</body>
</html>

