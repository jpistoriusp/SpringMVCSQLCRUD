<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhaina"
	rel="stylesheet">
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Movie</title>
</head>
<body>
	<form method="post" action="removemovie.do">

		<h4>Please input the movie you would like remove from the
			library:</h4>
	
		<label>Movie Title:</label><input type="text" name="name"><br>
	<button class="button" ><span>Remove Movie</span></button>

		<table>
			<c:forEach items="${movies}" var="movie">
				<tr>
				<td><div id="moviePic">
				<img src="${movie.pic}" class="movie" />
				</div></td>
					<td>${movie.name}</td>
					<td>${movie.year}</td>
					<td>${movie.genre}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>