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
	table {
		width: 80%;
		margin:20px auto;
	}
	
	th, td {
		padding:12px;
		text-align: left;
	}
	
	th {
		background-color: #ddd;
		color:blue;
	}

</style>
</head>
<body>
	<h1>학생정보 자세히 보기</h1>
	<table>
		<tr>
			<th>학번</th><td>${ST.stNum}</td>
			<th>이름</th><td>${ST.stName}</td>
		</tr>
		<tr>
			<th>학과</th><td>${ST.stDept}</td>
			<th>학년</th><td>${ST.intGrade}</td>
		</tr>
		<tr>
			<th>전화번호</th><td>${ST.stTel}</td>
			<th>주소</th><td>${ST.stAddr}</td>
		</tr>
	</table>
	
	
	
	
	
</body>
</html>