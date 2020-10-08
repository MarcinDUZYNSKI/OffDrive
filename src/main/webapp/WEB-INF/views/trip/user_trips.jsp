<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>OffDrive</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
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
                    <%--&lt;%&ndash;                        <td><fmt:formatDate value="${trip.tripDate}" pattern="yyyy-MM-dd HH:mm"/> </td>  &ndash;%&gt;  ta metoda wyświetlała błedy, ze taka conwersja jest niemożliwa--%>
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

</body>
</html>
