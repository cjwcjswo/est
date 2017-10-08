<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

a {
	font-family: "LASTFONT";
	color: white;
}

a:hover {
	color: red;
	text-decoration: none;
	cursor: pointer;
}

h2 {
	font-family: "LASTFONT";
	color: white;
}

table {
	width: 400px;
	margin-top: 50px;
}

td:NTH-CHILD(1) {
	width: 40%;
	height: 100px;
	font-family: "LASTFONT";
	color: white;
}
</style>
<script>
	function emailcheck(strValue) {
		var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;

		//이메일 형식에 맞지않으면
		if (!strValue.match(regExp)) {
			return false;
		}
		return true;
	}

	function checkValid() {
		var email = document.f.email.value;
		var name = document.f.name.value;
		var password = document.f.password.value;
		if (email.trim() == "" || !emailcheck(email.trim())) {
			alert("check email!");
			return false;
		}
		if (name.trim() == "") {
			alert("check name!");
			return false;
		}
		if (password.trim() == "") {
			alert("check password!");
			return false;
		}
		return true;
	}

	function signup() {
		if (checkValid()) {
			document.f.submit();
		}
	}
</script>
<body>
	<div id="main" align="center">
		<h2>Sign Up</h2>
		<form action="${pageContext.request.contextPath}/member/insert"
			method="post" name="f">
			<table>
				<tr>
					<td>EMAIL</td>
					<td><input type="email" class="form-control" name="email"></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" class="form-control" name="name"></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="PASSWORD" class="form-control"
						name="password"></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
		</form>
		<br> <br> <a onclick="signup();">OK</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/">BACK</a>
	</div>
</body>
</html>
