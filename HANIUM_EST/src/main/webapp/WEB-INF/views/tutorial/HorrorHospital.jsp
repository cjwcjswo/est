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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	type="text/css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>
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
		url("${pageContext.request.contextPath}/resources/image/HorrorHospital.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#title {
	font-family: "SPIDER";
	color: red;
	text-align: center;
	font-size: 60px;
}

a {
	color: black;
}

#balloon {
	position: fixed;
	bottom: 100px;
	left: 40%;
}
</style>
<body>

	<audio
		src="${pageContext.request.contextPath}/resources/sound/tutorial.mp3"
		autoplay="autoplay" loop="loop"></audio>
	<div id="cont">
		<br> <br>
		<div id="title">
			정신을 차려보니 어느 폐병원 침대에 누워있었다.<br> 아무런 기억도나지 않는다..<br> 일단 이 방을
			나가야겠다. 방 앞에 자물쇠가있는데.. 비밀번호는..?<br>
			<form action="${pageContext.request.contextPath}/tutorial/two">

				<input type="text" name="answer"> &nbsp; <input
					type="submit" value="확인">

			</form>
		</div>
		<!-- 77581925123 -->
		<div id="balloon" class="alert alert-warning alert-dismissible"
			role="alert">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<strong>경고!</strong> 현재 페이지는 힌트가 주어지지 않습니다.
		</div>
	</div>
</body>
</html>
