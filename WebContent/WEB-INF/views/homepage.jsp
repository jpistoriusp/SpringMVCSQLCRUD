<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhaina" rel="stylesheet">
<link rel="stylesheet" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Store</title>
</head>
<body>			

	<form action="listmovies.do" method="GET">
		<input type="submit" class ="homebutton" value="Browse Movies" />
	</form><br>
	<form action="addmovie.do" method="GET">
		<input type="submit" class ="homebutton" value="Add Movie" />
	</form><br>
	<form action="removemovie.do" method="GET">
		<input type="submit" class ="homebutton" value="Remove Movie" />
	</form>
	<!-- <form action="randommovie.do" method="GET">
		<input type="submit" value="Suggest Me A Random Movie!" />
	</form> -->
</body>
</html>