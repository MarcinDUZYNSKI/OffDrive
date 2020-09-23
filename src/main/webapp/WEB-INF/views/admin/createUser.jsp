<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateUser</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
Wprowadź dane swojego użytkownika:<br>
<form:form modelAttribute="user" method="post">

    <label>Email : <form:input path="email" maxlength="75" size="11"/><br>
        <form:errors path="email" cssClass="error"/>
    </label>
    <%--    <label>Repet email : <form:input path="email" id="confirmEmail"></label>--%>
    <label>First name : <form:input path="firstName" maxlength="50" size="1"/><br>
        <form:errors path="firstName" cssClass="error"/>
    </label>
    <label>Last name : <form:input path="lastName" maxlength="50" size="1"/><br>
        <form:errors path="lastName" cssClass="error"/>
    </label>
    <label>Nick name (to show others users) : <form:input path="nickName" maxlength="50" size="1"/><br>
        <form:errors path="nickName" cssClass="error"/>
    </label>
    <label>Password : <form:input path="password" size="8" maxlength="50"/><br>
        <form:errors path="password" cssClass="error"/>
    </label>

    <label><input type="submit" value="Sing In"></label>
</form:form>
</body>
</html>
