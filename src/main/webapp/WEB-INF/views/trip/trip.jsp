<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script src="../../js/skel.min.js"></script>
    <script src="../../js/skel-panels.min.js"></script>
    <script src="../../js/init.js"></script>
    <link rel="stylesheet" href="../css/skel-noscript.css" type="text/css"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>
    <link rel="stylesheet" href="../css/style-desktop.css" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>
    <link rel="stylesheet" href="../../css/skel-noscript.css" type="text/css"/>
    <link rel="stylesheet" href="../../css/style.css" type="text/css"/>
    <link rel="stylesheet" href="../../css/style-desktop.css" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
          crossorigin="anonymous">

    <%--    <meta charset="utf-8">--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--    <title>OffDrive</title>--%>
    <%--    <link rel="stylesheet"--%>
    <%--          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"--%>
    <%--          crossorigin="anonymous">--%>
    <%--    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"--%>
    <%--          rel="stylesheet">--%>
    <%--    <link rel="stylesheet" href="../css/style.css" type="text/css">--%>
    <%--    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"--%>
    <%--          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"--%>
    <%--          crossorigin="anonymous">--%>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>
<%@ include file="/WEB-INF/views/index/header.jsp" %>
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
                            <td><form:select path="tripCondition.landscape">
                                <form:option value="null" label="plesa select"/>
                                <form:option value="mountain" label="mountain"/>
                                <form:option value="forest" label="forest"/>
                                <form:option value="desert" label="desert"/>
                                <form:option value="riverLake" label="rier & lake"/>
                                <form:option value="meadow" label="meadow"/>
                            </form:select></td>
                        </tr>
                        <tr>
                            <td>Ground:</td>
                            <td><form:select path="tripCondition.mainGround">
                                <form:option value="null" label="plesa select"/>
                                <form:option value="rocky" label="rocky"/>
                                <form:option value="tought" label="tought"/>
                                <form:option value="mixt" label="mixt"/>
                                <form:option value="mudy" label="mudy"/>
                                <form:option value="soft" label="soft"/>
                                <form:option value="sand" label="sand"/>
                            </form:select></td>
                        </tr>
                        <tr>
                            <td>Water level:</td>
                            <td><form:select path="tripCondition.waterLevel">
                                <form:option value="null" label="plesa select"/>
                                <form:option value="dontKnown" label="I don't known"/>
                                <form:option value="low" label="low"/>
                                <form:option value="midle" label="midle"/>
                                <form:option value="high" label="high"/>
                            </form:select></td>
                        </tr>
                        <tr>
                            <td>Any mud:</td>
                            <td><form:select path="tripCondition.mud">
                                <form:option value="null" label="plesa select"/>
                                <form:option value="no" label="no"/>
                                <form:option value="litle" label="a litle"/>
                                <form:option value="fewe" label="a fewe"/>
                                <form:option value="much" label="much"/>
                            </form:select></td>
                        </tr>
                        <tr>
                            <td>Any water crossing:</td>
                            <td>
                                Yes <form:radiobutton path="tripCondition.waterCrossing" value="1"/>
                                No <form:radiobutton path="tripCondition.waterCrossing" value="0"/>
                            </td>

                        </tr>
                        <tr>
                            <td>Weather condition:</td>
                            <td><form:select path="tripCondition.weather">
                                <form:option value="null" label="plesa select"/>
                                <form:option value="sunny" label="sunny"/>
                                <form:option value="cloudy" label="cloudy"/>
                                <form:option value="rainy" label="rainy"/>
                                <form:option value="windy" label="windy"/>
                            </form:select></td>
                        </tr>
                        <tr>
                            <td>Temperature:</td>
                            <td>
                                <form:select path="tripCondition.temperature">
                                    <c:if test="${trip.tripCondition.temperature==null}">
                                    <form:option value="null" label="pleas select"/>
                                    </c:if>
                                    <c:forEach begin="0" end="110" var="index">
                                        <form:option items="${index-50}" label="${index-50}" value="${index-50}"/>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Did You use winch:</td>
                            <td>
                                Yes <form:radiobutton path="tripCondition.useWinch" value="1"/>
                                No <form:radiobutton path="tripCondition.useWinch" value="0"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Did You use Sand Ladder:</td>
                            <td>
                                Yes <form:radiobutton path="tripCondition.useSandLadder" value="1"/>
                                No <form:radiobutton path="tripCondition.useSandLadder" value="0"/>
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