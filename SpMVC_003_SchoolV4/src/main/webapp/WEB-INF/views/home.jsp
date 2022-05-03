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
	form {
		width:80%;
		margin:20px auto;
	}
	fieldset {
		border : 1px solid blue;
		padding:1rem;
	}
	
	form div {
		width: 80%;
		margin:0px auto;
	}
	
	form label, form input {
		display: inline-block;
		padding:8px;
		margin:5px;
	}
	form label {
		width: 30%;
		text-align: left; 
	}
	form input {
		width: 60%;
		border-radius: 5px;
	}
</style>
</head>
<body>
	<h1>안녕하세요</h1>
	<form method="POST">
		<fieldset>
			<div><input name="username" placeholder="USERNAME"/></div>
			<div><input name="tel" placeholder="전화번호"/></div>
			<button>서버로 전송</button>
			<div><h2>${username}, ${tel}</h2></div>
		</fieldset>
	</form>
</body>
</html>