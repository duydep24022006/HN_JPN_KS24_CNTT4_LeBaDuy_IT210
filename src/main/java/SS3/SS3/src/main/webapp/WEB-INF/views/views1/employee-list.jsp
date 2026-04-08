<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.ss3.BT45P.model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/7/2026
  Time: 7:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Quản lý nhân sự </title>
</head>
<body>
<H1>Quản lý nhân sự</H1>>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>FullName</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Rating</th>
        </tr>>
        <c:forEach var="employee" items="${employees}" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td><c:out value="${employee.fullName}"/></td>
            <td><c:out value="${employee.department}"/></td>
            <td><c:out value="${employee.salary}"/></td>
            <td>
                <c:choose>
                    <c:when test="${employee.salary>=10000}">Mức lương cao</c:when>
                    <c:otherwise>Mức lương cơ bản</c:otherwise>
                </c:choose>
            </td>
        </tr>
        </c:forEach>
    </table>>

</body>
</html>
