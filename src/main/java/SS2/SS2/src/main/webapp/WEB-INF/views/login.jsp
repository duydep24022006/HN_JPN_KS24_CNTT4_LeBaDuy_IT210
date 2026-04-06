<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập hệ thống</h2>
<form action="login" method="post">
    <label>Tài khoản: <input type="text" name="username"/></label><br/>
    <label>Mật khẩu: <input type="password" name="password"/></label><br/>
    <button type="submit">Đăng nhập</button>
</form>

<c:if test="${not empty errorMessage}">
    <p style="color:red">${errorMessage}</p>
</c:if>
</body>
</html>
