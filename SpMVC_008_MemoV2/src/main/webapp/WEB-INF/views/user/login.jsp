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
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	html {
		width: 100vw;
		height: 100vh;
	}
	
	body {
		width: 100%;
		height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	form {
		width: 50%;
		text-align: center;
	}
	
	input {
		padding:1rem;
		width: 100%;
	}
</style>
</head>
<body>
	<form method="POST">
		<input name="username" placeholder="USERNAME 입력후 Enter">
	</form>
</body>
</html>