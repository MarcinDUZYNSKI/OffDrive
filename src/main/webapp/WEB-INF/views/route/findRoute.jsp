<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<%@ include file="/WEB-INF/views/index/header.jsp" %>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-100">
                <div>
                    <h2>View All Routes</h2>
                    <form method="get">
                        <input type="hidden" name="allRoute">
                        <input type="submit" value="Find">
                    </form>
                </div>
                <div>
                    <h2>View My Routes</h2>
                    <form method="get">
                        <input type="hidden" name="allMyRoute">
                        <input type="submit" value="Find">
                    </form>
                </div>
                <div>
                    <h2>Find Route By Name</h2>
                    <form method="get">
                        <input type="text" name="routeName">
                        <label><input type="submit" value="Find"></label>
                    </form>
                </div>
                <div>
                    <h2>Find Route By User Name</h2>
                    <form method="get">
                        <select name="userName">
                            <c:forEach items="${userMap}" var="entry">
                                <option value="${entry.key}">${entry.value}</option>
                            </c:forEach>
                            <label><input type="submit" value="Find"></label>
                        </select>
                    </form>
                </div>

                <c:if test="${routeList != null}">
                    <div>
                        <h3>Selected Routes</h3><br>
                        <table cellpadding="3px" cellspacing="10px">
                            <tr>
                                <th>Route created Data</th>
                                <th>Route Name</th>
                                <th>Length</th>
                                <th>Delta altitude</th>
                                <th>Description</th>
                                <th>Create Trip from Route</th>

                                    <%--            <th>Edit Route</th>--%>
                                    <%--            <th>Delete Route</th>--%>
                            </tr>
                            <c:forEach items="${routeList}" var="route">
                                <tr>
                                        <%--&lt;%&ndash;                        <td><fmt:formatDate value="${trip.tripDate}" pattern="yyyy-MM-dd HH:mm"/> </td>  &ndash;%&gt;  ta metoda wyświetlała błedy, ze taka conwersja jest niemożliwa--%>
                                    <td>${route.cratedDate}</td>
                                    <td>${route.name}</td>
                                    <td>${route.length}</td>
                                    <td>${route.routeAltitude}</td>
                                    <td>${route.description}</td>

                                    <td>
                                        <a href="/index/createTrip/${route.id}">Create</a>
                                    </td>
                                    <c:if test="${route.user.id==currentUser}">
                                        <td>
                                            <a href="/index/editRoute/${route.id}">Edit</a>
                                        </td>
                                        <td>
                                            <a href="/index/deleteRoute/${route.id}">Delete</a>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </c:if>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/index/footer.jsp" %>
</body>
</html>