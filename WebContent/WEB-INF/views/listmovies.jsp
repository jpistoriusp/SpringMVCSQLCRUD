<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Movies</title>
</head>
<body>
	<h2>List of Movies</h2>

	<label>List of Movies:</label>

	<table>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="homepage.do" method="get">
		<input type="submit" value="Back to Homepage">
	</form>
</body>
</html>