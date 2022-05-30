<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="${rootPath}/favicon.ico" type="image/x-icon" />
<style>
	header {
		padding:2rem;
		text-align: center;
	}
	nav {
	 background-color: black;
	 color:white;
	}
	nav ul {
		list-style-type: none;
		display: flex;
	}
	nav li {
		padding:12px 1rem;
	}
	nav li:nth-of-type(4) {
		margin-left:auto;
	}
	
	nav li:hover {
		background-color: #333;
		cursor: pointer;
	}
	
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/home.js?ver2022-05-30-001"></script>

</head>
<body>
	<header>
		<h1>반갑습니다</h1>
	</header>
	<nav class="main_nav">
		<ul>
			<li>Home</li>
			<li>공지사항</li>
			<li>자유게시판</li>

			<c:choose>
				<c:when test="${empty USER}">
					<li>로그인</li>
					<li>회원가입</li>
				</c:when>
				<c:otherwise>
					<li>로그아웃</li>
				</c:otherwise>
			</c:choose>			
		</ul>
	</nav>

</body>
</html>



