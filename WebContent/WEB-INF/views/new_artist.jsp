<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uusi artisti</title>
</head>
<body>
<div>
	<h2><a href="/Levykauppa/index">Etusivu</a>
	<a href="/Levykauppa/search">Haku</a>
	<a href="/Levykauppa/newartist">Lisää artisti</a></h2>
</div>
<h1>Luo uusi artisti</h1>
<c:if  test = "${ error != null }" >
	<p> Error: <c:out value = "${ error }" /></p>
	</c:if>
<form method = "post">
<label>Nimi: <input name = "artistName" /></label>
<input type = "submit" value = "Tallenna" />
</form>
</body>
</html>