<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>OffDrive</title>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,700,500,900'
          rel='stylesheet' type='text/css'>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

    <script src="../js/skel.min.js"></script>
    <script src="../js/skel-panels.min.js"></script>
    <script src="../js/init.js"></script>
    <link rel="stylesheet" href="../css/skel-noscript.css" type="text/css"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    <link rel="stylesheet" href="../css/style-desktop.css" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
          crossorigin="anonymous">
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/index/home_header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                User data:<br>
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
                    <label>Nick name (visible for other users): <form:input path="nickName"
                                                                            maxlength="50"
                                                                            size="25"/><br>
                        <form:errors path="nickName" cssClass="error"/>
                    </label><br>
<%--                    <c:choose>--%>
<%--                        <c:when test="${empty user.password}">--%>
<%--                            <label>Password: <form:password path="password" size="25"--%>
<%--                                                            maxlength="50"/><br>--%>
<%--                                <form:errors path="password" cssClass="error"/>--%>
<%--                            </label><br>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            --%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>

                        <label>Password: <form:password path="password" size="25"
                                                        maxlength="50"/><br>
                            <form:errors path="password" cssClass="error"/>
                        </label><br>
                        <%--    <label>Password: <form:password path="password" size="25" maxlength="50"/><br>    dodać obsługę w backende walidajc powturzenie passworda  --%>
                        <%--        <form:errors path="password" cssClass="error"/>--%>
                        <%--    </label><br>--%>


                    <label><input type="submit" value="Submit"></label>
                </form:form>
            </div>

        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/index/footer.jsp" %>
</body>
</html>
