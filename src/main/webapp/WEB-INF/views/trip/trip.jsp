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
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-100">
                Save Your Trip <br>
                <form:form modelAttribute="tripWithTripCondition" method="post">
                    <form:hidden path="trip.id"/>
                    <form:hidden path="tripCondition.id"/>
                    <table>
                        <tr>
                            <th>Trip Parameter:</th>
                            <th>Input Your Trip</th>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><form:input path="trip.name"/></td>
                            <form:errors path="trip.name" cssClass="error"/>
                        </tr>
                        <tr>
                            <td>Time:</td>
                            <td><form:input path="trip.tripTime"/></td>
                            <form:errors path="trip.tripTime" cssClass="error"/>
                        </tr>
                        <tr>
                            <td>Length:</td>
                            <td><form:input path="trip.length"/></td>
                            <form:errors path="trip.length" cssClass="error"/>
                        </tr>
                        <tr>
                            <td>Delta of Altitude:</td>
                            <td><form:input path="trip.tripAltitude"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><form:input path="trip.description"/></td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <th>Condition on Your trip:</th>
                            <th>Input Conditions</th>
                        </tr>
                        <tr>
                            <td>Landscape:</td>
                            <td><form:input path="tripCondition.landscape"/></td>
                        </tr>
                        <tr>
                            <td>Ground:</td>
                            <td><form:input path="tripCondition.mainGround"/></td>
                        </tr>
                        <tr>
                            <td>Water level:</td>
                            <td><form:input path="tripCondition.waterLevel"/></td>
                        </tr>
                        <tr>
                            <td>Any mud:</td>
                            <td><form:input path="tripCondition.mud"/></td>
                        </tr>
                        <tr>
                            <td>Any water crossing:</td>
                            <td><form:select path="tripCondition.waterCrossing"/></td>
                        </tr>
                        <tr>
                            <td>Weather condition:</td>
                            <td><form:input path="tripCondition.weather"/></td>
                        </tr>
                        <tr>
                            <td>Temperature:</td>
                            <td><form:select path="tripCondition.temperature"/></td>
                        </tr>
                        <tr>
                            <td>Did You use winch:</td>
                            <td><form:select path="tripCondition.useWinch"/></td>
                        </tr>
                        <tr>
                            <td>Did You use Sand Ladder:</td>
                            <td><form:select path="tripCondition.useSandLadder"/></td>
                        </tr>
                    </table>
                    <label><input type="submit" value="Save Trip"></label>
                </form:form>
            </div>
        </div>
    </div>
</section>
</body>
</html>