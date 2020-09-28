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
Insert user data:<br>
<form:form modelAttribute="user" method="post">

    <label>Email: <form:input path="email" maxlength="75" size="25"/><br>
        <form:errors path="email" cssClass="error"/>
    </label><br>
    <%--    <label>Repet email : <form:input path="email" id="confirmEmail"></label>--%>
    <label>First name: <form:input path="firstName" maxlength="50" size="25"/><br>
        <form:errors path="firstName" cssClass="error"/>
    </label><br>
    <label>Last name: <form:input path="lastName" maxlength="50" size="25"/><br>
        <form:errors path="lastName" cssClass="error"/>
    </label><br>
    <label>Nick name (visible for other users): <form:input path="nickName" maxlength="50" size="25"/><br>
        <form:errors path="nickName" cssClass="error"/>
    </label><br>
    <label>Password: <form:password path="password" size="25" maxlength="50"/><br>
        <form:errors path="password" cssClass="error"/>
    </label><br>
<%--    <label>Password: <form:password path="password" size="25" maxlength="50"/><br>    dodać obsługę w backende walidajc powturzenie passworda  --%>
<%--        <form:errors path="password" cssClass="error"/>--%>
<%--    </label><br>--%>

    <label><input type="submit" value="Submit"></label>
</form:form>
</body>
</html>
