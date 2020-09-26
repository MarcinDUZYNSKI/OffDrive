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
Share Yours Trip <br>
<form:form modelAttribute="tripWithTripCondition" method="post">
    <table>
        <tr>
            <th>Trip Parameter:</th>
            <th>Input Your Trip</th>
        </tr>
        <tr>
            <td>Trip name: </td>
            <td><form:input path="trip.name"/></td>
            <form:errors path="trip.name" cssClass="error"/>
        </tr>
        <tr>
            <td>Trip time: </td>
            <td><form:input path="trip.tripTime"/></td>
            <form:errors path="trip.tripTime" cssClass="error"/>
        </tr>
        <tr>
            <td>Trip length: </td>
            <td><form:input path="trip.length"/></td>
            <form:errors path="trip.length" cssClass="error"/>
        </tr>
        <tr>
            <td>Trip delta of Altitude: </td>
            <td><form:input path="trip.tripAltitude"/></td>
        </tr>
    </table>

    <table>
        <tr>
            <th>Condition on Your trip:</th>
            <th>Input Conditions</th>
        </tr>
        <tr>
            <td>Landscape: </td>
            <td><form:input path="tripCondition.landscape"/></td>
        </tr>
        <tr>
            <td>Ground: </td>
            <td><form:input path="tripCondition.mainGround"/></td>
        </tr>
        <tr>
            <td>Water level:</td>
            <td><form:input path="tripCondition.waterLevel"/></td>
        </tr>
        <tr>
            <td>If there wos mud: </td>
            <td><form:input path="tripCondition.mud"/></td>
        </tr>
        <tr>
            <td>If wos water crossing: </td>
            <td><form:select path="tripCondition.waterCrossing"/></td>
        </tr>
        <tr>
            <td>Description weather condition: </td>
            <td><form:input path="tripCondition.weather"/></td>
        </tr>
        <tr>
            <td>What was the temperature: </td>
            <td><form:select path="tripCondition.temperature"/></td>
        </tr>
        <tr>
            <td>Do You used winch: </td>
            <td><form:select path="tripCondition.useWinch"/></td>
        </tr>
        <tr>
            <td>Do You used Sand Ladder: </td>
            <td><form:select path="tripCondition.useSandLadder"/></td>
        </tr>
    </table>
    <label><input type="submit" value="Save Trip"></label>
</form:form>
</body>
</html>