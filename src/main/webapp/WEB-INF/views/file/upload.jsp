<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie plików</title>
</head>
<body>

<form method="post" enctype="multipart/form-data">
    <label for="addFile"> Dodaj plik:
        <input type="file" name="file" id="addFile" accept="application/pdf,images/*"/>
    </label>
    <button type="submit">Dodaj</button>
</form>

</body>
</html>
