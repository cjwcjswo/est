<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Escape The Site</title>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	type="text/css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>

<style>
@font-face {
	font-family: "LASTFONT";
	src:
		url("${pageContext.request.contextPath}/resources/font/LastLine.ttf");
}

body {
background-color: black;
}


h1{
	font-family: "LASTFONT";
	color:red;
}
h2{
	font-family: "LASTFONT";
	color:white;
}
</style>
<body>
<h2 align="center">ERROR</h2>
<h1 align="center">${exception.message}</h1>
<h1 align="center">${errorMessage}</h1>
</body>
</html>
