<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
<h1>관리자 화면</h1>
<sec:authorize access="isAuthenticated() AND hasRole('ROLE_ADMIN')">
	<h3><sec:authentication property="principal.username"/></h3>
	<h3><sec:authentication property="principal.email"/></h3>
	<h3><sec:authentication property="principal.realname"/></h3>
	<h3><sec:authentication property="principal.authorities"/></h3>
</sec:authorize> 




</body>
</html>