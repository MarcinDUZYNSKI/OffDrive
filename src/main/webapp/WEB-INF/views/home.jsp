<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Witamy na stronie startowej<br>
<spring:message code="homepage.welcome"/><br>
<a href="/admin/createUser">Creat User</a><br>,
<a href="/login">Login</a><br>
</body>
</html>