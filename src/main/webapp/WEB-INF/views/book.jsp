<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 29.10.2019
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>

<form:form method="post" modelAttribute="book">
    <label>Tytuł:
        <form:input path="title"></form:input>
    </label><br><br>
    <label>Rating:
        <form:select path="rating">
            <c:forEach begin="1" end="10" var="number">
                <form:option value="${number}"></form:option>
            </c:forEach>
        </form:select>
    </label><br><br>
    <label>Description:
        <form:input path="description"></form:input>
    </label><br><br>
    <label>
        <form:select path="publisher.id" items="${publishers}"
                     itemValue="id" itemLabel="name"/>
    </label><br><br>
    <label>Authors:
        <form:select path="authors" items="${authors}"
                     itemValue="id" itemLabel="fullName">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${authors.id}"/>
        </form:select>
    </label><br>
    <input type="submit" value="Save">
</form:form>


</body>
</html>
