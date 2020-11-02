<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OffDrive</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,700,500,900' rel='stylesheet' type='text/css'>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/skel-panels.min.js"></script>
    <script src="js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="css/skel-noscript.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/style-desktop.css" />
    </noscript>
</head>
<body class="homepage">
<spring:message code="homepage.welcome"/>

<%@ include file="index/home_header.jsp" %>

<%--<!-- Featured -->--%>
<%--<div id="featured">--%>
<%--    <div class="container">--%>
<%--        <header>--%>
<%--            <h2><spring:message code="homepage.not-logged-in"/></h2>--%>
<%--        </header>--%>
<%--        <div class="row">--%>
<%--            <section class="4u">--%>
<%--                <span class="pennant"><span class="fa fa-briefcase"></span></span>--%>
<%--                <h3>Maecenas luctus lectus</h3>--%>
<%--                <p>Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat vel, suscipit in, mattis placerat, nulla. Sed ac leo.</p>--%>
<%--                <a href="#" class="button button-style1">Read More</a>--%>
<%--            </section>--%>
<%--            <section class="4u">--%>
<%--                <span class="pennant"><span class="fa fa-lock"></span></span>--%>
<%--                <h3>Maecenas luctus lectus</h3>--%>
<%--                <p>Donec ornare neque ac sem. Mauris aliquet. Aliquam sem leo, vulputate sed, convallis at, ultricies quis, justo. Donec magna.</p>--%>
<%--                <a href="#" class="button button-style1">Read More</a>--%>
<%--            </section>--%>
<%--            <section class="4u">--%>
<%--                <span class="pennant"><span class="fa fa-globe"></span></span>--%>
<%--                <h3>Maecenas luctus lectus</h3>--%>
<%--                <p>Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat vel, suscipit in, mattis placerat, nulla. Sed ac leo.</p>--%>
<%--                <a href="#" class="button button-style1">Read More</a>--%>
<%--            </section>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%@ include file="index/footer.jsp" %>
</body>
</html>