<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
	div.w3-card-4 {
		width:70%;
		margin:20px  auto;
	}
</style>
</head>
<body>
	<div class="w3-container w3-card-4">
		<h1 class="w3-text-blue">LOGIN USER</h1>
		<h3 class="w3-text-blue">USER NAME : ${USER.username}</h3>
		<h3 class="w3-text-blue">E-mail : ${USER.email}</h3>
		<h3 class="w3-text-blue">NAME : ${USER.name}</h3>
		<h3 class="w3-text-blue">NICK NAME : ${USER.nickname}</h3>
		<h3 class="w3-text-blue">ROLE : ${USER.role}</h3>
	</div>
	<select name="buydate" class="buydate">
		<c:forEach items="${BUY_DATES}" var="DATE">
			<option value="${DATE}">${DATE}</option>
		</c:forEach>
	</select>
	<script>
	const buydate = document.querySelector("select.buydate")
	buydate?.addEventListener("change",(e)=>{
		const current = e.currentTarget
		document.location.href = `${rootPath}/user/mypage?buydate=${current.value}`
	})	
	</script>
	<ul>
		<c:forEach items="${BUY_BOOKS}" var="BOOK">
			<li>${BOOK.book.isbn}, &nbsp; &nbsp; ${BOOK.book.title},&nbsp; &nbsp; ${BOOK.book.author} 
		</c:forEach>
	</ul>
	
</body>
</html>







