<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 13.09.2020
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<sec:authorize access="isAuthenticated()">
<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    MAM ROLE ADMIN
</sec:authorize>

<sec:authorize url="/home">
    MAM DOSTĘP DO TEGO URL
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>


</body>
</html>
