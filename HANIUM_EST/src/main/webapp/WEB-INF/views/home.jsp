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

table {
	background-color: black;
}

td {
	margin: 5px;
	padding: 5px;
}

td:NTH-CHILD(1) {
	width: 30%;
	font-family: "LASTFONT";
	color: white;
}

input {
	text-align: right;
}

#main {
	width: 500px;
	position: absolute;
	top: 27.5%;
	margin: 0 auto;
	left: 0;
	right: 0;
	height: 300px;
	margin-top: -150px;
	background-color: black;
}

a {
	font-family: "LASTFONT";
	color: skyblue;
}

a:hover {
	cursor: pointer;
	color: red;
	text-decoration: none;
}

#moveSign {
	position: absolute;
	left: 15px;
	top: 15px;
}
</style>
<script>
	function checkValid() {
		var email = document.f.email.value;
		var password = document.f.password.value;
		if (email.trim() == "") {
			alert("check email!");
			return false;
		}
		if (password.trim() == "") {
			alert("check password!");
			return false;
		}
		return true;
	}

	function login() {
		if (checkValid()) {
			document.f.submit();
		}
	}

	function moveSign() {
		var resultX = Math.floor(Math.random() * 500) + 1;
		var resultY = Math.floor(Math.random() * 400) + 1;
		N.style.top = resultX + "px";
		N.style.left = resultY + "px";

	}
</script>
<body>
	<audio
		src="${pageContext.request.contextPath}/resources/sound/zephie.mp3"
		autoplay="autoplay" loop="loop"></audio>
	<div id="main">
		<img
			src="${pageContext.request.contextPath}/resources/image/banner.png">
		<form name="f"
			action="${pageContext.request.contextPath}/member/login"
			method="post">
			<table>
				<tr>
					<td>EMAIL</td>
					<td><input type="email" class="form-control" name="email"></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="password" class="form-control"
						name="password"></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
		</form>
		<br> <br>
		<div align="center">
			<a onclick="login();">LOG IN</a> <br>
			<div id="moveSign" onMouseover="moveSign()">
				<a href="${pageContext.request.contextPath}/member/signup">SIGN
					UP</a>
			</div>
		</div>
	</div>
</body>
<script>
	var N = document.getElementById("moveSign");
</script>
</html>
