<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%--<p>--%>
<%--    <a href="findRoute.jsp">Find Route by Name </a>--%>
<%--    --%>
<%--</p>--%>
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
    <select name="userName" >
        <c:forEach items="${userMap}" var="entry">
            <option  value="${entry.key}">${entry.value}</option>
        </c:forEach>
        <label><input type="submit" value="Find"></label>
    </select>
    </form>
    name="userName"
<%--    <form:form method="get" name="userName">--%>
<%--        <c:forEach items="${userMap}" var="userMap">--%>
<%--            <option value="${userMap.key}"> ${userMap.value}</option>--%>
<%--        </c:forEach>--%>
<%--        <label><input type="submit" value="Find" id="userName"/></label>--%>
<%--    </form:form>--%>

<%--    <form method="get">--%>
<%--        <input type="text" name="userName">--%>
<%--        <label><input type="submit" value="Find"></label>--%>
<%--    </form>--%>
</div>

<c:if test="${routeList != null}">
<div>
    <h3>All Your Routes</h3><br>
    <table>
        <tr>
            <th>Route created Data</th>
            <th>Route Name</th>
            <th>Length</th>
            <th>Delta altitude</th>
            <th>Description</th>
            <th>Create Trip from Route</th>
            <th>Edit Route</th>
            <th>Delete Route</th>
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
                <td>
                    <a href="/index/editRoute/${route.id}">Edit</a>
                </td>
                <td>
                    <a href="/index/deleteRoute/${route.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</c:if>
</body>
</html>