<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Escape The Site</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	type="text/css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>
</head>
<style>
body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	width: 100%;
	background-color: black;
}

@font-face {
	font-family: "SPIDER";
	src:
		url("${pageContext.request.contextPath}/resources/font/Spiderfingers.ttf");
}

#title {
	font-family: "SPIDER";
	color: white;
	text-align: center;
	font-size: 60px;
}

a {
	color: black;
}

#balloon{
	position: fixed;
	bottom: 100px;
	left: 40%;
}
</style>
<body>

	<audio
		src="${pageContext.request.contextPath}/resources/sound/tutorial.mp3"
		autoplay="autoplay" loop="loop"></audio>
	<br>
	<br>
	<br>
	<br>
	<div id="title">
		주변이 너무 깜깜해서 아무것도 보이지 않는다...<br> 이 근처에 어디 스위치가 있을텐데.....?
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/tutorial/HorrorHospital">[]</a>
	<div id="balloon" class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
		<strong>경고!</strong> 현재 페이지는 힌트가 주어지지 않습니다.
	</div>
</body>
</html>
