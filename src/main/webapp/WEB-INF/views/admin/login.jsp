<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<%@ include file="/WEB-INF/views/index/home_header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-50">
                <form class="padding-small text-center" action="/perform_login" method="post">
                    <h1 class="text-color-darker">LOGIN</h1>
                    <div><label> Email: <input type="text" name="username"/> </label></div>
                    <div><label> Password: <input type="password" name="password"/> </label></div>
                    <div><input type="submit" value="Login"/></div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</section>
<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/perform_login"/>" method="post">
        <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    MAM ROLE ADMIN
</sec:authorize>

<%--<sec:authorize url="/home">--%>
<%--    MAM DOSTĘP DO TEGO URL--%>
<%--</sec:authorize>--%>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>


<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
<%--        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"--%>
<%--        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"--%>
<%--        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"--%>
<%--        crossorigin="anonymous"></script>--%>
<%@ include file="/WEB-INF/views/index/footer.jsp" %>
</body>
</html>
