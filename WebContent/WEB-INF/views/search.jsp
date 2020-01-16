<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Haku</title>
</head>
<body>
<div>
	<h2><a href="/Levykauppa/index">Etusivu</a>
	<a href="/Levykauppa/search">Haku</a>
	<a href="/Levykauppa/newartist">Lisää artisti</a></h2>
</div>
<h1>Hae artistia ja/tai albumia nimellä</h1>
<c:if  test = "${ error != null }" >
	<p>HUOM! <c:out value = "${ error }" /></p>
	</c:if>
<form method = "post">
<label>Hae: <input name = "text" /></label>
<input type = "submit" value = "Haku" />
</form><br>
<h3>Artistit</h3>
<ol>
<c:forEach items = "${ artists }" var = "artist" ><li><a href ="/Levykauppa/artist?id=${ artist.getId() }"><c:out value = "${ artist.getName() }" /></a></li></c:forEach>
</ol>
<h3>Albumit</h3>
<ol>
<c:forEach items = "${ albums }" var = "album" ><li><a href ="/Levykauppa/album?id=${ album.getAlbumid() }"><c:out value = "${ album.getTitle() }" /></a></li></c:forEach>
</ol>
</body>
</html>