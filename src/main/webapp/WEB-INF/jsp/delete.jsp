<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<title>Removing</title>
</head>
<body>
<h4> Delete task: </h4>

<form:form method="POST" commandName="user">
  Login: <form:input path="name"/> <br>
  Password: <form:password path="hashedPassword"/> <br>
  task ID: <form:input path="id"/> <br>
  <input type="submit" value="OK">
</form:form>

<c:out value="${msg}"/>

</body>
</html>