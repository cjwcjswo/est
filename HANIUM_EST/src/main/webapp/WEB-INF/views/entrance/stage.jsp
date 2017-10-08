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
	background: url("${pageContext.request.contextPath}/resources/image/stage.png") no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
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
}

#title {
	font-family: "SPIDER";
	color: white;
	text-align: center;
	font-size: 60px;
	text-align: center;
}

#stageTable {
border-spacing: 10px;
border-collapse: separate;
	margin: auto;
}
img:HOVER {
	cursor: pointer;
	box-sizing: border-box;
	border: 3px groove red;
}
</style>
<script>
	function startStage(stage, exp) {
		var isExp;
		if (exp == 0) {
			isExp = confirm(stage + " 스테이지를 처음으로 시작하시겠습니까?");
		} else if (exp == 1) {
			isExp = confirm(stage + " 스테이지를 중간부터 시작하시겠습니까?");
		} else {
			isExp = confirm(stage + " 스테이지를 이미 완료하셨습니다. 다시 시작하시겠습니까?");
		}
		if (isExp) {
			location.href = "${pageContext.request.contextPath}/" + stage + "/";
		}
	}
</script>
<body>
	<div id="cont">
		<div id="title">S T A G E</div>
		<br> <br>
		<table id="stageTable">
			<!-- 튜토리얼 스테이지 -->
			<tr>
				<td><c:choose>
						<c:when test="${TUTORIAL == null}">
							<img
								src="${pageContext.request.contextPath}/resources/image/tutorial.jpg"
								onclick="startStage('tutorial', 0)">
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${TUTORIAL.endDay == null}">
									<img
										src="${pageContext.request.contextPath}/resources/image/tutorial_playing.jpg"
										onclick="startStage('tutorial', 1)">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/resources/image/tutorial_finish.jpg"
										onclick="startStage('tutorial', 2)">
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<!-- 튜토리얼 스테이지 끝 -->
			<!-- 아웃라스트 스테이지 -->
			<tr>
				<td><c:choose>
						<c:when test="${OUTLAST == null}">
							<img
								src="${pageContext.request.contextPath}/resources/image/outlast.jpg"
								onclick="startStage('outlast', 0)">
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${OUTLAST.endDay == null}">
									<img
										src="${pageContext.request.contextPath}/resources/image/outlast_playing.jpg"
										onclick="startStage('outlast', 1)">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/resources/image/outlast_finish.jpg"
										onclick="startStage('outlast', 2)">
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<!-- 아웃라스트 스테이지 끝 -->
		</table>

	</div>
</body>
</html>
