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
<title>List of Movies</title>
</head>
<body>
	<h3>List of Movies</h3>
	<form method="get" action="filtermovie.do">
	<label>Filter Movies:</label><input type="text" name="filtername"><br>
		<button class="button">
			<span>Filter Movies</span>
		</button>
	</form>
	<table>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td><div id="moviePic">
						<img src="${movie.pic}" class="movie" />
					</div></td>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
				<td>${movie.genre}</td>
				<td><form method="post" action="removemovie.do">
				<input type="hidden" name="name" value="${movie.name}" />
				<button class="smallbutton">
				<span>Remove</span>
				</button>
				</form><form method="get" action="updatemovie.do">
				<input type="hidden" name="id" value="${movie.id}" />
				<input type="hidden" name="name" value="${movie.name}" />
				<input type="hidden" name="year" value="${movie.year}" />
				<input type="hidden" name="genre" value="${movie.genre}" />
				<input type="hidden" name="pic" value="${movie.pic}" />
				<button class="smallbutton">
				<span>Edit</span>
				</button>
				</form></td>
			</tr>
		</c:forEach>
	</table>
	<form action="homepage.do" method="get">
		<button class="button">
			<span>Go to Homepage</span>
		</button>
	</form>
</body>
</html>