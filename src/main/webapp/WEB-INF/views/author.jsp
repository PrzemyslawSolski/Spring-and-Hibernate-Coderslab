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
    <title>Author</title>
</head>
<body>

<form:form method="post" modelAttribute="author">
    <label>First name:
        <form:input path="firstName"></form:input>
        <form:errors path="firstName" element="div" cssStyle="color:red"/>
    </label><br><br>

    <label>Last name:
        <form:input path="lastName"></form:input>
        <form:errors path="lastName" element="div" cssStyle="color:red"/>
    </label><br><br>

    <label>PESEL:
        <form:input path="pesel"></form:input>
        <form:errors path="pesel" element="div" cssStyle="color:red"/>
    </label><br><br>

    <label>Email:
        <form:input path="email"></form:input>
        <form:errors path="email" element="div" cssStyle="color:red"/>
    </label><br><br>

    <label>Year of birth::
        <form:input path="yearOfBirth"></form:input>
        <form:errors path="yearOfBirth" element="div" cssStyle="color:red"/>
    </label><br><br>

    <input type="submit" value="Save">
</form:form>


</body>
</html>
