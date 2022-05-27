<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${LOGIN.message}</h3>
	
	<c:choose>
		<c:when test="${LOGIN_MESSAGE == 'USERNAME FAIL' }">
			<h2>USER NAME(사용자 ID) 가 없습니다</h2>
			<a href="${rootPath}/user/login">로그인 다시 하기</a>
		</c:when>
		<c:when test="${LOGIN_MESSAGE == 'PASSWORD FAIL' }">
			<h2>비밀번호가 잘못되었습니다</h2>
			<a href="${rootPath}/user/login">로그인 다시 하기</a>	
		</c:when>
		<c:otherwise>
			<c:if test="${not empty USER}">
				<h3>로그인 성공!!!</h3>
				<p><strong>USERNAME : </strong>${USER.username}</p>
				<p><b>NAME : </b>${USER.name}</p>
				<p><b>email : </b>${USER.email}</p>
				<a href="${rootPath}/">홈으로</a>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	
	
	
	<a href="${rootPath}">홈으로 가기</a>
</body>
</html>