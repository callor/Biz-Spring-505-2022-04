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
	form.join {
		width: 70%;
		margin:20px auto;
		padding:20px;
	}
	
	form.join input, form.join button {
		margin:5px;
	}
</style>
<script src="${rootPath}/static/js/join.js?20220609005"></script>
</head>
<body>

<form method="POST" class="w3-container w3-card-4 join">
	
	<h2>회원가입</h2>
	
	<label class="w3-text-blue">User Name(ID)</label>
	<input name="username" id="username" placeholder="USERNAME" class="w3-input w3-border">
	
	<label class="w3-text-blue">비밀번호</label>
	<input name="password" id="password" placeholder="PASSWORD" class="w3-input w3-border">
	
	<label class="w3-text-blue">비밀번호 확인</label>
	<input name="re_password" id="re_password" placeholder="RE_PASSWORD" class="w3-input w3-border">
	
	<label class="w3-text-blue">이메일</label>
	<input name="email" id="email" placeholder="EMAIL" class="w3-input w3-border">
	
	<label class="w3-text-blue">실명</label>
	<input name="name" id="name" placeholder="NAME" class="w3-input w3-border">
	
	<label class="w3-text-blue">필명</label>
	<input name="nickname" id="nickname" placeholder="NICK NAME"  class="w3-input w3-border">
	
	<button class="w3-button w3-blue" id="btn-join" type="button">회원가입</button>

</form>







</body>
</html>