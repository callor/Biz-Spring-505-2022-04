<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}

section.main {
	flex: 1;
}
</style>

<link rel="stylesheet"
	href="${rootPath}/static/css/modal.css?ver=2022-05-31-004">
<link rel="stylesheet"
	href="${rootPath}/static/css/table.css?ver=2022-05-31-002">
<link rel="stylesheet"
	href="${rootPath}/static/css/input.css?ver=2022-05-31-002">

<script>
	const rootPath = '${rootPath}'
</script>
<script src="${rootPath}/static/js/input.js?ver=2022-05-31-004"></script>

</head>
<body>
	<header>
		<h1>도서정보관리</h1>
	</header>
	<section class="main">
		<form method="POST" action="${rootPath}/naver/books">
			<div>
				<input name="isbn" id="isbn" placeholder="ISBN"> 
				<input name="title" id="title" placeholder="도서명 입력후 Enter">
			</div>
			<div>
				<input name="author" placeholder="저자"> 
				<input name="publisher" placeholder="출판사"> 
				<input name="pubdate" placeholder="출판일"> 
			</div>
			<div>
				<input name="link" placeholder="자세히보기"> <input name="image"
					placeholder="이미지경로">
			</div>
			<textarea rows="10"></textarea>
			<button type="button">저장</button>
		</form>
	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com</address>
	</footer>
	<section class="modal" id="modal_box"></section>
</body>



</html>