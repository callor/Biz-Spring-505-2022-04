<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="userVO">
		<h1>회원가입</h1>
		<p>회원가입을 위하여 Email 을 입력한 후 인증하여 주세요</p>
		<form:input path="email" type="email" />
		<form:errors path="email"/>
		<button>이메일 인증</button>
	</form:form>
</body>
</html>


