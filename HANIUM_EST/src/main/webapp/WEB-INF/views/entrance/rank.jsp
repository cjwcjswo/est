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
		 background: url("${pageContext.request.contextPath}/resources/image/rank.png") no-repeat center center fixed; 
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

#title, #myPoint {
	font-family: "SPIDER";
	color: white;
}

#title {
	color: skyblue; text-align : center;
	font-size: 60px;
	text-align: center;
}

#myPoint {
	text-align: right;
	font-size: 30px;
}

#rank {
	margin: auto;
	width: 60%;
}

#rankTable {
	width: 100%;
}

th {
	font-size: 30px;
	text-align: center; color : white;
	font-family: "SPIDER";
	color: white;
}

td {
	font-size: 30px;
	text-align: center;
	color: white;
}
</style>
<body>
	<div id="cont">
		<div id="title">T O P 50</div>
		<div id="myPoint">M y &nbsp; P o i n t: ${myPoint.point}</div>
		<div id="rank">
			<table id="rankTable">
				<tr>
					<th>R A N K</th>
					<th>N A M E</th>
					<th>P O I N T</th>
				</tr>
				<c:forEach items="${rankList}" var="rank" varStatus="status">
					<tr>
					<td>${status.count}</td>
					<td>${rank.name}</td>
					<td>${rank.point}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
