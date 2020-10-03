<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Welcome to our OffDrive app</title>
</head>
<body>
<h1>Welcome ${nickname}, my dear friend</h1>
<ul>
  <#list orders as order>
  <li>${order}</li>
  <#list>
</ul>
</body>
</html>