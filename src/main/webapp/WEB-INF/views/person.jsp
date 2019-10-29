<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: psolski
  Date: 29.10.2019
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>

<form:form action="/persons/add" method="post" modelAttribute="person">
    <label>Login:
        <form:input path="login"/>
    </label>
    <label>Password:
        <form:password path="password"/>
    </label>
    <label>Email:
        <form:input path="email"/>
    </label>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
