<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>moja galeria </title>
</head>
<body>
<c:forEach items="${files}" var="files">
    <img src="/files/${files.id}"/>
    <a href="/files/"
</c:forEach>
</body>
</html>
