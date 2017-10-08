<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Escape the Site</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap.min.css"
	type="text/css">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mCustomScrollbar.css" />
<script src="${pageContext.request.contextPath}/resources/mCustomScrollbar.concat.min.js"></script>
<style>
#head {
	width:100%;
	background-color: black;
	padding-bottom: 10px;
}

@font-face {
	font-family: "SPIDER";
	src:
		url("${pageContext.request.contextPath}/resources/font/Spiderfingers.ttf");
}

.menu {
	font-family: "SPIDER";
	color: white;
	font-size: 55px;
}

.menu:hover {
	cursor: pointer;
	color: red;
	text-decoration: none;
}

#tableMenu {
	width: 50%;
	margin: auto;
	text-align: center;
}
</style>
<script>
	function logout() {
		document.getElementById("logoutForm").submit();
	}
	
</script>
<script>
jQuery(function($) {
    $("body").css("display", "none");
    $("body").fadeIn(1000);
    $("a.transition").click(function(event){
        event.preventDefault();
        linkLocation = this.href;
        $(".trans").fadeOut(500, redirectPage);
    });
    function redirectPage() {
    window.location = linkLocation;
    }
});
</script>
</head>
<body>
	<div id="head">
		<table id="tableMenu">
			<tr>
				<td><a class="menu" href="${pageContext.request.contextPath}/entrance/home">H O M E</a></td>
				<td><a class="menu" href="${pageContext.request.contextPath}/entrance/stage">S T A G E</a></td>
				<td><a class="menu" href="${pageContext.request.contextPath}/entrance/rank">R A N K</a></td>
				<td><a class="menu">H E L P</a></td>
				<td><a href="javascript:logout();" class="menu">L O G O U T</a></td>

			</tr>
		</table>
		<!-- end Navigation-->
		<form id="logoutForm"
			action="${pageContext.request.contextPath}/member/logout"
			method="post" style="display: none">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>

</html>
