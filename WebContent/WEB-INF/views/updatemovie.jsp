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
	<form method="post" action="updatemovie.do">

<h4>Update Movie:</h4>
<input type="hidden" value="${id}" name="id"><br>
<label>Movie Title:</label><input value="${name}" type="text" name="name"><br>
<label>Movie Year:</label><input value="${year}" type="text" name="year"><br>
<label>Movie Genre:</label><input value="${genre}" type="text" name="genre"><br>
<label>Movie Picture URL:</label><input value="${pic}" type="text" name="pic"><br>

	<button class="button" ><span>Update Movie</span></button>

</form>
</body>
</html>