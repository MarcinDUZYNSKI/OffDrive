<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <div>
            <h3>All Tours Trips</h3><br>
            <table>
                <tr>
                    <th>Trip Data</th>
                    <th>Trip Name</th>
                    <th>Length</th>
                    <th>Time</th>
                    <th>Create Route from Trip</th>
                </tr>
                <c:forEach items="${allUserTrips}" var="trip">
                    <tr>
                            <%--&lt;%&ndash;                        <td><fmt:formatDate value="${trip.tripDate}" pattern="yyyy-MM-dd HH:mm"/> </td>  &ndash;%&gt;  ta metoda wyświetlała błedy, ze taka conwersja jest niemożliwa--%>
                        <td>${trip.createdDate}</td>
                        <td>${trip.name}</td>
                        <td>${trip.length}</td>
                        <td>${trip.tripTime}</td>
                        <td>
                            <a href="/index/createRoute/${trip.id}">Create</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

</body>
</html>
