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
    <title>Student</title>
</head>
<body>

<form:form action="/students/add" method="post" modelAttribute="student">
    <label>First name:
        <form:input path="firstName"/>
    </label><br>
    <label>Last name:
        <form:input path="lastName"/>
    </label><br>
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    <label>Country:
        <form:select path="country">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${countries}"/>
        </form:select><br>
    </label><br>
    <label>Note:
        <form:textarea path="notes" cols="20" rows="5"/>
    </label><br>
    <label>Mailing list:
        <form:checkbox path="mailingList"/>
    </label><br>
    <label>Programming Skills:
        <form:select path="programmingSkills" items="${skills}" multiple="true"/>
    </label><br>
    <label>hobbies:
        <form:checkboxes items="${hobbies}" path="hobbies"/>
    </label><br>


    <input type="submit" value="Save">
</form:form>

</body>
</html>
