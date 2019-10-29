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
        function confirmDelete(id, name) {
            if (confirm("Do you want to delete an author '" + name + "'?")) {
                window.location.href = "/authors/delete/" + id;
            }
        }
    </script>
    <title>Authors</title>
</head>
<body>

<h2>Authors' list</h2>
<table border="2px">
    <tbody>
    <tr>
        <th width="20"> id</th>
        <th width="150">First name</th>
        <th width="150">Last name</th>
        <th  width="170" colspan="2"> Action</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td align="center"><a href="/authors/update/${author.id}">Edit </a></td>
            <td align="center"><a href="#" onclick="confirmDelete(${author.id}, '${author.lastName}')">Delete </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
