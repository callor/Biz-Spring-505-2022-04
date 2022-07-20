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
	<h1>주소 자세히 보기</h1>
	<h3>이름 : ${ADDR.a_name}</h3>
	<h3>전화번호 : ${ADDR.a_tel}</h3>
	<h3>주소 : ${ADDR.a_address}</h3>
	<div>
		<a href="${rootPath}/update?seq=${ADDR.a_seq}">수정하기</a>
		<a href="${rootPath}/delete?seq=${ADDR.a_seq}">삭제하기</a>
		<a href="${rootPath}/">처음으로</a>
	</div>
	
</body>
</html>