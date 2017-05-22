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
<title>List of Movies</title>
</head>
<img src="SpringMVCFileCRUD/WebContent/ku.jpg"/>

<body>
	<h2>List of Movies</h2>
	<img src="Users/Paul/SD/Java/stsworkspace/SpringMVCFileCRUD/WebContent/ku.jpg"/>
	<table>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td><div id="moviePic">
					<%-- <img src="${dao.getMoviePic(movie)}" class="movie" /> --%>
					<img src="SpringMVCFileCRUD/WebContent/pics/1.jpg" class="movie" />
				</div></td>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
				<td>${movie.genre}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="homepage.do" method="get">
		<input type="submit" value="Back to Homepage">
	</form>
</body>
</html>