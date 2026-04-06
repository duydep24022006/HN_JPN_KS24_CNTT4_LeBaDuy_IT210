<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Kết quả tìm kiếm</title>
    <style>
        .red { color: red; font-weight: bold; }
        .orange { color: orange; font-weight: bold; }
        .green { color: green; font-weight: bold; }
        .badge { background: #eee; padding: 2px 6px; border-radius: 4px; }
        .disabled { color: gray; pointer-events: none; text-decoration: none; }
    </style>
</head>
<body>
<!-- Header -->
<h2>Kết quả tìm kiếm cho: <c:out value="${keyword}" escapeXml="true"/></h2>
<c:choose>
    <c:when test="${empty events}">
        <p>Không tìm thấy sự kiện nào phù hợp.</p>
    </c:when>
    <c:otherwise>
        <p>Tìm thấy ${fn:length(events)} sự kiện.</p>
    </c:otherwise>
</c:choose>

<!-- Bảng kết quả -->
<c:if test="${not empty events}">
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${event.name}" escapeXml="true"/></td>
                <td>${event.date}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="red">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span class="orange">Sắp hết (còn ${event.remainingTickets} vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span class="green">${event.remainingTickets}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="disabled">Đặt vé</span>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/events/${event.id}/book'/>">Đặt vé</a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<!-- Footer -->
<hr/>
<c:if test="${not empty events}">
    <p>Sự kiện đầu tiên: ${fn:toUpperCase(events[0].name)}</p>
</c:if>
<p>Từ khóa có ${fn:length(keyword)} ký tự.</p>
</body>
</html>
