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
</head>
<body>
<%@ include file="/WEB-INF/views/index/header.jsp" %>
<div>
    <h3>All Your Trips</h3><br>
    <table>
        <tr>
            <th>Trip Data</th>
            <th>Trip Name</th>
            <th>Length</th>
            <th>Time</th>
            <th>Create Route from Trip</th>
            <th>Edit Trip</th>
            <th>Delete Trip</th>
        </tr>
        <c:forEach items="${allUserTrips}" var="route">
            <tr>
                <td>${route.createdDate}</td>
                <td>${route.name}</td>
                <td>${route.length}</td>
                <td>${route.tripTime}</td>
                <td>
                    <a href="/index/createRoute/${route.id}">Create</a>
                </td>
                <td>
                    <a href="/index/editTrip/${route.id}">Edit</a>
                </td>
                <td>
                    <a href="/index/deleteTrip/${route.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="/WEB-INF/views/index/footer.jsp" %>
</body>
</html>
