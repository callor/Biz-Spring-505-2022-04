<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>

</head>
<body>
	<form:form class="w3-container w3-card-4">
	
		<c:choose>
			<c:when test="${error =='LOGIN_NEED' }">
				<c:set var="message" value="* 로그인이 필요한 서비스 입니다"/>
			</c:when>
		</c:choose>
	
		<c:if test="${not empty exception}">
			<div class="w3-text-red w3-padding-16">${exception}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="w3-text-red w3-padding-16">${message}</div>
		</c:if>
	
		<label class="w3-text-blue"><strong>USER NAME</strong></label>
		<input name="username" class="w3-input w3-border">
	
		<label class="w3-text-blue"><strong>PASSWORD</strong></label>
		<input name="password" class="w3-input w3-border" type="password">
		
		<button class="w3-button w3-green">로그인</button>
		
		<label>로그인 계정이 없으면 
		<a href="${rootPath}/user/join">회원가입</a>을 해 주세요
		</label>
	</form:form>

</body>
</html>