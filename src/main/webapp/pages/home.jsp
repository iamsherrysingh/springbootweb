<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>SpringBootApp</title>
</head>
<body>

Hello

<h1> ${result} </h1>
addAlien
<form action="addAlien">
    <input type="text" name="aid"><br>
    <input type="text" name="aname"><br>
    <input type="submit"><br>
</form>

<br>
getAlien
<form action="getAlien">
    <input type="text" name="aid"><br>
    <input type="submit"><br>
</form>

<br>
deleteAlien
<form action="deleteAlien">
    <input type="text" name="aid"><br>
    <input type="submit"><br>
</form>

<br>
updateAlien
<form action="updateAlien">
    <input type="text" name="aid"><br>
    <input type="text" name="aname"><br>
    <input type="submit"><br>
</form>

</body>
</html>