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

<%--    ------------------------------------------------------------------------------------------------------------%>
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js">
    </script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
    <script src="../../../js/loadgpx.js" type="text/javascript"></script>
    <script type="text/javascript">
        //<![CDATA[

        function loadGPXFileIntoGoogleMap(map, filename) {
            $.ajax({url: filename,
                dataType: "xml",
                success: function(data) {
                    var parser = new GPXParser(data, map);
                    parser.setTrackColour("#ff0000");     // Set the track line colour
                    parser.setTrackWidth(5);          // Set the track line width
                    parser.setMinTrackPointDelta(0.001);      // Set the minimum distance between track points
                    parser.centerAndZoom(data);
                    parser.addTrackpointsToMap();         // Add the trackpoints
                    parser.addRoutepointsToMap();         // Add the routepoints
                    parser.addWaypointsToMap();           // Add the waypoints
                }
            });
        }

        $(document).ready(function() {
            var mapOptions = {
                zoom: 8,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            let map = new google.maps.Map(document.getElementById("map"),
                mapOptions);
            loadGPXFileIntoGoogleMap(map, "trip.xml");
        });

        //]]>
    </script>

<%--    ------------------------------------------------------------------------------------------------------------------%>

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
<%--                    <form:hidden path="tripCondition.id"/>--%>
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
            <div>
                <h4>Upload file with Yous trip</h4><br>
                Accepted formats: GPX KML KMZ TCX CRS LOC
                <%@ include file="../upload.jsp" %>
<%--                //to chyba nie odnosisię do upload controlera???--%>

                <%--                        <form method="post" enctype="multipart/form-data">--%>
                <%--                            <label for="addFile">Add file:--%>
                <%--                                <input type="file" name="file" id="addFile">--%>
                <%--                                    &lt;%&ndash;        accept="application/xml,gpx"--%>
                <%--                                    "application/vnd.openstreetmap.data+xml"--%>
                <%--                                    "application/vnd.google-earth.kmz"--%>
                <%--                                     accept="application/vnd.google-earth.kml+xml"--%>
                <%--                                     &ndash;%&gt;--%>
                <%--                            </label>--%>
                <%--                            <label>Name of file to save:--%>
                <%--                                <input type="text" name="fileName"/>--%>
                <%--                            </label>--%>

                <%--                            <button type="submit">Upload File</button>--%>
                <%--                        </form>--%>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/index/footer.jsp" %>


<%-----------------------------------------------------------------------------------------------------------------%>
<%--<section>--%>


<%--                <div id="map" id="trip" style="width: 50%; height: 50%;"></div>--%>

<%--</section>--%>


</body>
</html>