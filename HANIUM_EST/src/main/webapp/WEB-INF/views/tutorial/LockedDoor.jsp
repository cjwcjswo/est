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
		url("${pageContext.request.contextPath}/resources/image/LockedDoor.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

#title {
	font-family: "SPIDER";
	color: white;
	text-align: center;
	font-size: 50px;
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
<script>
	function checkValid() {
		var id = document.f.id.value.trim();
		var pw = document.f.pw.value.trim();
		if (id == "") {
			alert("input the ID!");
			return false;
		}
		if (pw == "") {
			alert("input the PW!");
			return false;
		}
		if (id != "1234" || pw != "1234") {
			alert("Incorrect ID or PW!");
			return false;
		}
		if (id == "1234" && pw == "1234") {
			alert("보안장치로 잠겨있다.");
			return false;
		}
		return true;
	}

	function submitAnswer() {
		if (checkValid()) {
			document.f.submit();
		}
	}
</script>
<body>

	<audio
		src="${pageContext.request.contextPath}/resources/sound/tutorial.mp3"
		autoplay="autoplay" loop="loop"></audio>
	<div id="cont">
		<br> <br>
		<div id="title">
			방 안을 나왔더니 정신없이 어질러져있는 복도가 눈에 띄었다.<br> 내가 왜 이런 병원에서 깨어났는지 진료 내역을
			알아보려고 원장실을<br> 조사하려는데 역시 잠겨있다 옆에는 이러한 메모가 적혀져 있다<br> <font
				color="red">id: 1234 / pw: 1234</font>

			<form action="${pageContext.request.contextPath}/tutorial/three"
				name="f">
				ID: <input type="text" name="id"> <br> PW: <input
					type="text" name="pw"> <br> <input type="button"
					value="확인" onclick="submitAnswer()">
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
