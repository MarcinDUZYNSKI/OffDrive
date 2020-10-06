
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload GpxFile</title>
</head>
<body>

<form method="post" enctype="multipart/form-data">
    <label for="addFile">Add file:
        <input type="file" name="file" id="addFile">
        <%--        accept="application/xml,gpx"
        "application/vnd.openstreetmap.data+xml"
        "application/vnd.google-earth.kmz"
         accept="application/vnd.google-earth.kml+xml"
         --%>
    </label>
    <label>Name of file to save:
        <input type="text" name="fileName"/>
    </label>

    <button type="submit">Upload File</button>
</form>
</body>
</html>
