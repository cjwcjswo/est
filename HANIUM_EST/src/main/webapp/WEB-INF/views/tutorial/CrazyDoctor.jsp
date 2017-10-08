<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Escape The Site</title>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	type="text/css">

<style>
body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	width: 100%;
}

@font-face {
	font-family: "SPIDER";
	src:
		url("${pageContext.request.contextPath}/resources/font/Spiderfingers.ttf");
}

#cont {
	margin: 0;
	height: 100%;
	width: 100%;
	background-image:
		url("${pageContext.request.contextPath}/resources/image/CrazyDoctor.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#title {
	font-family: "SPIDER";
	color: red;
	text-align: center;
	font-size: 60px;
}

</style>
<script>
	function moveHome(){
		location.href = "${pageContext.request.contextPath}/entrance/home"
	}
	
	setTimeout("moveHome()", 1000*5);
</script>
<body>

	<audio
		src="${pageContext.request.contextPath}/resources/sound/roar.mp3"
		autoplay="autoplay" loop="loop"></audio>
	<div id="cont">
		<br> <br>
		<div id="title">
		FINISH......
		</div>
	</div>
</body>
</html>
