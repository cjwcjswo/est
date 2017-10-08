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
	background: url("${pageContext.request.contextPath}/resources/image/entrance.jpg") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

@font-face {
	font-family: "HORROR";
	src: url("${pageContext.request.contextPath}/resources/font/horrh.ttf");
}

#cont {
	height: 100%;
	width: 100%;
}

table {
	width: 100%;
	text-align: center;
	border-spacing: 20px;
	text-align: center;
}

#homeTable {
	height: 500px;
}

tr:NTH-CHILD(1) {
	font-family: "HORROR";
	color: white;
	font-size: 60px;
}

tr:NTH-CHILD(2) {
	height: 300px;
}

.inner {
	width: 80%;
	height: 500px;
	margin: 25px;
	background-color: rgba(255, 255, 255, 0.3);
	margin: auto;
	overflow: auto;
}

#space {
	width: 80%;
	margin: auto;
}

.boardDay, .boardContent {
	font-family: serif;
}

.boardDay {
	color: skyblue;
	font-weight: bold;
	font-size: 12px;
}

.boardContent {
	font-size: 15px;
	text-align: left;
	color: white;
}
</style>
<script>
	function checkBoardValid() {
		var content = document.boardForm.content.value;
		if (content.trim() == "") {
			alert("input the content");
			return false;
		}
		return true;
	}

	function writeBoard() {
		if (checkBoardValid()) {
			document.boardForm.submit();
		}
	}
</script>
<body>
	<div id="cont">
		<br> <br>
		<table id="homeTable">
			<tr>
				<td>BOARD</td>
				<td>NOTICE</td>
			</tr>
			<tr>
				<td width="50%">
					<div class="inner" style="text-align: left">
						<c:forEach items="${boardList}" var="board">
							<span class="boardDay">[${board.writeDay}]</span>
							<span class="boardContent">&lt;${board.name}&gt;</span>
							<span class="boardContent">${board.content}</span>
							<br>
						</c:forEach>
					</div> <br>
					<div id="space">
						<form name="boardForm"
							action="${pageContext.request.contextPath}/entrance/insertBoard">
							<div class="container-fluid">
								<div class="col-xs-9">
									<input type="text" class="form-control" name="content">
								</div>
								<div class="col-xs-3">
									<input type="button" class="btn btn-default" value="SEND"
										onclick="writeBoard()">
								</div>
							</div>
						</form>
					</div>
				</td>
				<td width="50%">
					<div class="inner">
						<c:forEach items="${noticeList}" var="notice">
							<span class="boardContent">${notice}</span>
							<br>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
<script>
	$(".inner").mCustomScrollbar();
	$(".inner").mCustomScrollbar("scrollTo", "bottom", {
		scrollInertia : 0
	});
</script>
</html>
