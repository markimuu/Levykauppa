<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Etusivu</title>
<style> table, th, td {
    border: 1px solid black;
} </style>
</head>
<body>
<div>
	<h2><a href="/Levykauppa/index">Etusivu</a>
	<a href="/Levykauppa/search">Haku</a>
	<a href="/Levykauppa/newartist">Lisää artisti</a></h2><br>
</div>
<table>
	<tr>
		<th>Id</th>
		<th>Nimi</th>
	</tr>
<c:forEach items = "${ artists }" var = "artist" >
	<tr>	<td><c:out value = "${ artist.getId() }" /></td>
			<td><a href ="/Levykauppa/artist?id=${ artist.getId() }"><c:out value = "${ artist.getName() }" /></a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>