<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 30.10.2019
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation</title>
</head>
<body>
<c:if test="${empty errors}">
    <c:out value="Nie ma błędów"></c:out>
</c:if>

<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="errorek">
        Pole:
        błąd: ${errorek.message}
        błąd: ${errorek.path}

<%--        </c:out>--%>
    </c:forEach>
</c:if>
</body>
</html>
