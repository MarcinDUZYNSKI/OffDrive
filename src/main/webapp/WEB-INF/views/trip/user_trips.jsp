<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <div>
            <h3>All Your Trips</h3><br>
            <table>
                <tr>
                    <th>Trip Data</th>
                    <th>Trip Name</th>
                    <th>Length</th>
                    <th>Time</th>
                </tr>
                <c:forEach items="${allUserTrips}" var="trip">
                    <tr>
                        <td>${trip.tripDate}</td>-+
                        <td>${trip.name}</td>
                        <td>${trip.length}</td>
                        <td>${trip.tripTime}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
