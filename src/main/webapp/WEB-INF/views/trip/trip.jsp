<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form modelAttribute="trip" method="post">
                    <form:hidden path="id"/>
                    <table>
                        <tr>
                            <th>Trip Parameter:</th>
                            <th>Input Your Trip</th>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><form:input path="name"/></td>
                            <form:errors path="name" cssClass="error"/>
                        </tr>
                        <tr>
                            <td>Time:</td>
                            <td><form:input path="tripTime"/></td>
                            <form:errors path="tripTime" cssClass="error"/>
                        </tr>
                        <tr>
                            <td>Length:</td>
                            <td><form:input path="length"/></td>
                            <form:errors path="length" cssClass="error"/>
                        </tr>
                        <tr>
                            <td>Delta of Altitude:</td>
                            <td><form:input path="tripAltitude"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><form:input path="description"/></td>
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
                            <td>
                                <input type="radio" name="tripCondition.waterCrossing" value="yes">
                                <label>YES</label>

                                <input type="radio" name="tripCondition.waterCrossing" value="no">
                                <label>NO</label>
                            </td>

                        </tr>
                        <tr>
                            <td>Weather condition:</td>
                            <td><form:input path="tripCondition.weather"/></td>
                        </tr>
                        <tr>
                            <td>Temperature:</td>
                            <td>
                                <form:select path="tripCondition.temperature">
<%--                                    <c:forEach begin="0" end="110" var="index">--%>
<%--                                    <form:options  items="${index}" label="${index-50}" value="${index-50}"/>--%>
<%--                                    </c:forEach>--%>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Did You use winch:</td>
                            <td>
                                Yes <form:radiobutton path="tripCondition.useWinch" value="1"/>
                                No <form:radiobutton path="tripCondition.useWinch" value="0"/>
                                    <%--                                <label>--%>
                                    <%--                                    <input type="radio"  name="tripCondition.useWinch" value="yes">--%>
                                    <%--                                </label>--%>
                                    <%--                                <label >YES</label>--%>

                                    <%--                                <label>--%>
                                    <%--                                    <input type="radio"name="tripCondition.useWinch" value="no">--%>
                                    <%--                                </label>--%>
                                    <%--                                <label >NO</label>--%>
                            </td>
                        </tr>
                        <tr>
                            <td>Did You use Sand Ladder:</td>
                            <td>
                                <input type="radio" name="tripCondition.useSandLadder" value="yes">
                                <label>YES</label>

                                <input type="radio" name="tripCondition.useSandLadder" value="no">
                                <label>NO</label>
                            </td>
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