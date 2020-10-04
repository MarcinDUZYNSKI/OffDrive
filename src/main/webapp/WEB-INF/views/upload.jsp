<%--
  Created by IntelliJ IDEA.
  User: marci
  Date: 04.10.2020
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload GpxFile</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
    <label for="addFile">Dodaj plik:
        <input type="file" name="file" id="addFile">
        <%--        accept="application/xml,gpx"
         accept="application/vnd.google-earth.kml+xml"
         --%>
    </label>
    <label>Nazwa do zapisania pliku:
        <input type="text" name="fileName"/>
    </label>

    <button type="submit">Upload File</button>
</form>
</body>
</html>
