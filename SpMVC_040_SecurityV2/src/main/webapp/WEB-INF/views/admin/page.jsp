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
</head>
<body>
	<h1>여기는 Admin Page</h1>
	<table class="w3-table w3-talble-all">
		<tr>
			<th>USERNAME</th>
			<th>실명</th>
			<th>닉네임</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${USERS}" var="USER">
			<tr>
				<td>${USER.username}</td>
				<td>${USER.realname}</td>
				<td>${USER.nickname}</td>
				<td>${USER.email}</td>
		</c:forEach>
	</table>	
	

</body>
</html>