<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form,div.login_info {
		width: 60%;
		margin:20px auto;
	}
	fieldset {
		border:1px solid green;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	legend {
		text-align: center;
		padding:10px;
	}
	
	form input, form button{
		width: 80%;
		padding:8px;
		margin:5px;
	}
	
</style>
</head>
<body>
<form method="POST" autocomplete="off">
	<fieldset>
		<legend>로그인</legend>
		<input name="username" placeholder="USER NAME"/>
		<input name="password" type="password" placeholder="PASSWORD" />
		<button>로그인</button>
	</fieldset>
</form>
<a href="${rootPath}/user/join">회원가입 바로가기</a>
<div class="login_info">
	<c:if test="${not empty USER }">
		<div><b>아이디 : </b>${USER.username}</div>
		<div><b>이름 : </b>${USER.name}</div>
		<div><b>권한 : </b>${USER.role}</div>
		<div><b>email : </b>${USER.email}</div>
		<div><a href="${rootPath}/user/logout">로그아웃</a></div>
	</c:if>
	<c:if test="${empty USER }">
		<div>로그인 정보가 없습니다</div>	
	</c:if>
</div>

</body>
</html>