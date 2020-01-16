<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Albumi</title>
</head>
<body>
<div>
	<h2><a href="/Levykauppa/index">Etusivu</a>
	<a href="/Levykauppa/search">Haku</a>
	<a href="/Levykauppa/newartist">Lisää artisti</a></h2>
</div>
     <h1>Artisti: <c:out value="${ artist.getName() }" /></h1>
     <h1>Albumi: <c:out value="${ album.getTitle() }" /></h1>
<ol>
      <c:forEach items="${ tracks }" var="track">
             <li>
     <c:out value="${ track.getName() }" />
            </li>
     </c:forEach>
</ol>
</body>
</html>