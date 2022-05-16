<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사관리</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html, body {
	width: 100vw;
	height: 100vh;
}

body {
	display: flex;
	flex-direction: column;
}

header {
	/* important 어떤 tag 속성보다 우선적으로 강제 적용 */
	background-color: green !important;
	padding: 2rem;
	font-weight: 900;
	/*
			header tag 에 속성을 지정하면
			header 가 감싸고 있는 tag 들에게
			속성이 상속되어 공통으로 적용된다
			*/
	text-align: center;
	text-shadow: 1px 1px 1px black;
	color: white;
}

/*
		a tag 의 color 속성은
		부모 tag 의 color 속성을 상속받지 않는다
		만약 a tag 에 부모의 color 속성을 상속받고자 한다면
		color:inherit 속성을 부여하면 된다
		*/
header a {
	color: inherit;
}

nav {
	background-color: blue;
	color: white;
}

nav ul {
	list-style: none;
	display: flex;
}

nav li {
	padding: 12px 16px;
}

nav li:hover {
	cursor: pointer;
	color: yellow;
	font-weight: 900;
}

nav li:nth-of-type(4) {
	margin-left: auto;
}

section.main {
	flex: 1;
	padding: 5px;
	display: flex;
}

section.main article {
	flex: 1; margin : 0 5px;
	border: 1px solid blue;
	margin: 0 5px;
}

footer {
	background-color: blue;
	color: white;
	text-align: center;
	padding: 0.9rem;
}

button {
	border: none;
	outline: none;
	padding: 12px 16px;
	border-radius: 5px;
}

button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}

button.btn-blue {
	background-color: blue;
	color: white;
}

button.btn-green {
	background-color: green;
	color: white;
}

button.btn-red {
	background-color: red;
	color: white;
}

button.btn-orange {
	background-color: orange;
	color: white;
}

article.st-list {
	overflow: hidden;
	max-height: 65vh;
}
</style>
<script>
	// jsp 의 속성(변수)값을 JS 로 보내기 위해
	// JS 변수로 선언
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/nav.js?ver=2022-05-10-001"></script>
</head>
<body>
	<header>
		<h1>학사관리 시스템</h1>
		<p>대한고교 학사관리 시스템 2022</p>
	</header>
	<nav>
		<ul>
			<li>HOME</li>
			<li>학생정보</li>
			<li>성적정보</li>
			<li>로그인</li>
			<li>회원가입</li>
		</ul>
	</nav>
	<section class="main">

		<%
		/*
				주석은 여기에
				
				*/
		%>
		<c:choose>
			<c:when test="${LAYOUT == 'ST_LIST'}">
				<article>
					<%@ include file="/WEB-INF/views/student/list.jsp"%>
				</article>
			</c:when>
			<c:when test="${LAYOUT eq 'ST_INPUT'}">
				<article>
					<%@ include file="/WEB-INF/views/student/input.jsp"%>
				</article>
			</c:when>
			<c:otherwise>
				<article class="st-list">
					<%@ include file="/WEB-INF/views/student/list.jsp"%>
				</article>
				<article></article>
				<article></article>
			</c:otherwise>
		</c:choose>

	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com</address>
	</footer>
</body>
</html>