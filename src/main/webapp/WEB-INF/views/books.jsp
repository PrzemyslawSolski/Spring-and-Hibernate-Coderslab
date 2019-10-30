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
    <script>
        function confirmDelete(id, title) {
            if (confirm("Do you want to delete a book '" + title + "'?")) {
                window.location.href = "./delete/" + id;
            }
        }
    </script>
    <title>Books</title>
</head>
<body>
<c:if test="${books.get(0).proposition==true}">
    <h2>Propositions list</h2>
</c:if>
<c:if test="${books.get(0).proposition==false}">
    <h2>Books list</h2>
</c:if>
<%--<h2>Books list</h2>--%>
<table border="2px">
    <tbody>
    <tr>
        <th width="20"> id</th>
        <th width="150"> Title</th>
        <th width="100"> Rating</th>
        <th width="150"> Description</th>
        <th width="120"> Publisher</th>
        <c:if test="${books.get(0).proposition==true}">
            <th width="170" colspan="4"> Action</th>
        </c:if>
        <c:if test="${books.get(0).proposition==false}">
            <th width="170" colspan="2"> Action</th>
        </c:if>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
            <td align="center"><a href="./update/${book.id}">Edit </a></td>
                <%--            <td align="center"><a href="/books/delete/${book.id}">Delete </a></td>--%>
            <td align="center"><a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">Delete </a></td>
            <c:if test="${books.get(0).proposition==true}">
                <td align="center"><a href="../books/update/${book.id}">book </a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
