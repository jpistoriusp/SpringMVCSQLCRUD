<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhaina" rel="stylesheet">
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Movie</title>
</head>
<body>
	<form method="post" action="addmovie.do">

<h4>Please input the movie you would like added to the library:</h4>

<label>Movie Id:</label><input type="text" value="${dao.nextId}" name="id"><br>
<label>Movie Title:</label><input type="text" name="name"><br>
<label>Movie Year:</label><input type="text" name="year"><br>
<label>Movie Genre:</label><input type="text" name="genre"><br>

	<button class="button" ><span>Add Movie</span></button>

</form>
</body>
</html>