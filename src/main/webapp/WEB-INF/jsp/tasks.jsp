<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<title>Show tasks</title>
</head>
<body>
<h4> Input parameters to see TASKS list </h4>

<form:form method="POST" commandName="user">
  Login: <form:input path="name"/> <br>
  Password: <form:password path="hashedPassword"/> <br>
  Status: <form:input path="id"/> (0 - NEW, 1 - ACTIVE, 2 - COMPLETED) <br>
  <input type="submit" value="OK">
</form:form>

<c:out value="${msg}"/>

</body>
</html>