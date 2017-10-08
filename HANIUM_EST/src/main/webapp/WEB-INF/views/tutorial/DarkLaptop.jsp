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
		url("${pageContext.request.contextPath}/resources/image/DarkLaptop.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#title {
	color: white;
	text-align: center;
	font-size: 50px;
}

#postIt {
	color: red;
	text-align: center;
	font-size: 40px;
}

input {
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
			진료 기록이 담겨져있을 것 같은 노트북 한대를 발견했다<br> 하지만 노트북이 잠겨있다....<br> 옆에
			포스트잇에 이런 글귀가 적혀있다.<br>
			<div id="postIt">
				<font color="blue">ANSWER</font><br>doctor/;
			</div>
			<br> ...<br> ...<br> ...<br> 키보드 자판이 고장나서 그런가..<br>
			g를 입력하면 d가 입력되고 h를 입력하면 e가 입력된다.
			<form action="${pageContext.request.contextPath}/tutorial/four">

				<input type="text" name="answer"> &nbsp; <input
					type="submit" value="확인">

			</form>
		</div>
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
