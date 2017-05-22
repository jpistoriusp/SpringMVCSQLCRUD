<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhaina"
	rel="stylesheet">
<link href="https://twitter.com/Dave_Conner" class="btn btn-1">
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Store</title>
</head>
<body>
	<h1>Movie Database</h1>
	<form action="listmovies.do" method="GET">
		<button class="button">
			<span>List Movies</span>
		</button>
	</form>
	<br>
	<form action="addmovie.do" method="GET">
		<button class="button">
			<span>Add Movie</span>
		</button>
	</form>
	<br>
	<form action="removemovie.do" method="GET">
		<button class="button">
			<span>Remove Movie</span>
		</button>
	</form>
	<br>
	<form action="randommovie.do" method="GET">
		<button class="button">
			<span>I'm Feeling Lucky!</span>
		</button>
	</form>
</body>
</html>