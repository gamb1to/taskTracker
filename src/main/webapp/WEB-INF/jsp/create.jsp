<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<title>Creation</title>
</head>
<body>

<h1>Create a task</h1>

	<form:form method="post" commandName="taskUser">
		Login: <form:input path="userName"/><br><br>
	    Password: <form:password path="userPassword" /><br><br><br>

        Task name: <form:input path="taskName" /><br><br>
        Description: <form:input path="taskDescription" /><br><br>
        Status: <form:input path="taskStatus" /> (0 - NEW, 1 - ACTIVE, 2 - COMPLETED)<br><br>

        <input type="submit" value="Submit" /><br>
	</form:form>

<c:out value = "${msg}"/>




</body>
</html>