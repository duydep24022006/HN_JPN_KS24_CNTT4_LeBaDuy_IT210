<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Tìm kiếm sự kiện</title>
</head>
<body>
<h2>Nhập từ khóa để tìm sự kiện</h2>
<form action="<c:url value='/events/search'/>" method="get">
  <input type="text" name="keyword" placeholder="Nhập từ khóa..."/>
  <button type="submit">Tìm kiếm</button>
</form>
</body>
</html>
