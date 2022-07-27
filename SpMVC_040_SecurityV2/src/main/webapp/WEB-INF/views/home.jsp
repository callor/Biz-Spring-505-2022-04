<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>  
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다</h1>
	<p>세상에서 가장 심플한 Spring Security Project~~~</p>
	<form:form action="${rootPath}/logout" method="POST">
		<button>로그아웃</button>
	</form:form>
</body>
</html>