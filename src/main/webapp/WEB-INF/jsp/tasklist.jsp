<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<title>TaskList</title>
</head>
<body>
<h4> Tasks: </h4>

<c:forEach var="task" items="${tasks}">
    Id: <c:out value="${task.getId()}"/><br>
    Name: <c:out value="${task.getName()}"/><br>
    Description: <c:out value="${task.getDescription()}"/><br>
    Status: <c:out value="${task.getStatus()}"/><br>
    <br><br>
</c:forEach>

<a href="/index.html">Back to main page </a>
</body>
</html>