<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Escape The Site</title>
</head>
<style>
body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	width: 100%;
	background-color:black;
}

@font-face {
	font-family: "SPIDER";
	src:
		url("${pageContext.request.contextPath}/resources/font/Spiderfingers.ttf");
}



#title {
	font-family: "SPIDER";
	color: red;
	text-align: center;
	font-size: 60px;
}

a {
	color: white;
}
a:hover{
	cursor:pointer;
	color:blue;
}
</style>
<body>

	

		<div id="title">
			INCORRECT!<br>
			답이 맞지 않습니다<br>
			<a onclick="history.back()">뒤로가기</a>	
		</div>

</body>
</html>
