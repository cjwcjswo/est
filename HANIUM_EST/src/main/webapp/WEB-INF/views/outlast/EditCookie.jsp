<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Escape The Site</title>
</head>
<style>
html {
	margin: 0;
}

body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	width: 100%;
	background-color: black;
}

#visual {
	position: relative;
	height: 60%;
	text-align: center;
	overflow: hidden;
}

#video-bg, #visual-content {
	position: absolute;
	top: 50%;
	left: 50%;
	webkit-transform: translateX(-50%) translateY(-50%);
	transform: translateX(-50%) translateY(-50%);
	width: 100%;
}

#video-bg {
	height: 100%;
	background: #000; /* 배경 이미지로 대체 가능 */
	background-size: cover;
	z-index: -100;
}

#video-bg iframe {
	border: none;
	width: 100%;
	height: 100%;
}

#self {
	text-align: center;
	font-size: 20px;
	color: white;
}
</style>
<body>

	<div id="visual">
		<div id="video-bg">
			<iframe
				src="https://youtube.com/embed/DvkGSYniJT8?autoplay=1&controls=0&showinfo=0&wmode=opaque&autohide=1&end=41&rel=0">
			</iframe>
		</div>
	</div>
	<div style="margin: auto; text-align: center">
		<span id="self">당신은 마일즈 업셔라는 부정부패 폭로 전문기자로서 비밀을 캐낼 수 있다면 불구덩이라도
			뛰어들 야욕있는 인물입니다.<br> 다른 기자들은 엄두도 못 낼 기사거리들도 위험을 무릎쓰고 파고듭니다. <br>
			매시브산 정신병원 중심부에서 어두운 비밀들을 캐내게 될 겁니다.<br> <br>
		<br> 게임을 시작하려면 [level] 을 <font color="red">ok</font>로 설정한뒤 다음
			페이지를 누르세요. 
		</span><br><br><br>
		<button onclick="javascript:location.href='${pageContext.request.contextPath}/outlast/levelcheck';">다음</button>
	</div>
</body>
</html>
