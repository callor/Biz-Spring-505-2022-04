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
div.main {
	width: 50vw;
	margin: 10px auto;
}

div.main input {
	border: 1px solid rgba(255, 255, 255, 0.5);
	background-color: transparent;
	min-height: 10rem;
	height: 2.5rem;
	line-height: 2.5rem;
	display: none;
}

label {
	display: inline-block;
	background-color: white;
	padding: 12px 16px;
	cursor: pointer;
}

#begin-box:checked ~ .begin-box, #middle-box:checked ~ .middle-box,
	#adv-box:checked ~ .adv-box {
	background-color: #aaa;
	font-weight: 900;
	display: inline-block;
}

ol {
	list-style-type: decimal;
	display: none;
}

	#begin-box:checked ~ .begin-list, 
	#middle-box:checked ~ .middle-list,
	#adv-box:checked ~ .adv-list {
		border:1px solid blue;
		display: block ;
	}
	
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<div class="main">
		<input type="radio" id="begin-box" name="level-box"> 
		<label for="begin-box" class="begin-box">초급</label>
		<input type="radio" id="middle-box" name="level-box"> 
		<label for="middle-box" class="middle-box">중급</label>
		<input type="radio" id="adv-box" name="level-box"> 
		<label for="adv-box" class="adv-box">상급</label>

		<ol class="begin-list">
			<c:forEach items="${MENUMAPS.BEGIN}" var="MENU">
				<li><a href="${rootPath}/workout/dayset/${MENU.sc_num}">주당 ${MENU.sc_division} 루틴</a></li>
			</c:forEach>
		</ol>

		<ol class="middle-list">
			<c:forEach items="${MENUMAPS.MIDDLE}" var="MENU">
				<li><a href="${rootPath}/workout/dayset/${MENU.sc_num}">주당 ${MENU.sc_division} 루틴</a></li>
			</c:forEach>
		</ol>

		<ol class="adv-list">
			<c:forEach items="${MENUMAPS.ADV}" var="MENU">
				<li><a href="${rootPath}/workout/dayset/${MENU.sc_num}">${MENU.sc_division} 루틴</a></li>
			</c:forEach>
		</ol>
	</div>

</body>
</html>