<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 29.10.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

<h2>Books list</h2>
<table border="2px">
    <tbody>
    <tr>
        <th width="20"> id</th>
        <th width="150"> Title</th>
        <th width="100"> Rating</th>
        <th width="150"> Description</th>
        <th width="120"> Publisher</th>
        <th  width="170" colspan="2"> Action</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td align="center"><a href="/books/edit/${book.id}">Edit </a></td>
            <td align="center"><a href="/books/delete/${book.id}">Delete </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
