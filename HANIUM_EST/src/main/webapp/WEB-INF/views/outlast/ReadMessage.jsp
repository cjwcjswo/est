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
html{
	margin: 0;
}
body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	width: 100%;
		background: url("${pageContext.request.contextPath}/resources/image/CellPhone.jpg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}



#title {
	color: white;
	text-align: center;
	font-size: 35px;
}

input{
	color:black;
	font-size: 15px;
}

</style>
<body>
<audio
		src="${pageContext.request.contextPath}/resources/sound/outlast_bell.mp3"
		autoplay="autoplay" loop="loop"></audio>
<div id="cont">
	<br><br><br><br><br><br><br><br><br><br><br>
	<div id="title">
	
		핸드폰으로 문자 한 통이 왔다.. 비밀번호를 입력해 확인해보자..<br><br><br><br>
		
		<form name="f" action="${pageContext.request.contextPath}/outlast/two">
		PASSWORD: <input type="text" name="password"> <input type="submit" value="확인">
		</form>
	</div>
</div>
</body>
</html>
