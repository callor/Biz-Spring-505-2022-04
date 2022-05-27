<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/student.js?ver2022-05-27-010"></script>
</head>
<body>
	<table class="stlist" border="1">
		<tr>
			<th>학번</th>
			<th>이름</th>
		<tr>
		<c:forEach items="${STLIST}" var="VO">
			<tr data-stnum="${VO.st_num}">
				<td>${VO.st_num}</td>
				<td>${VO.st_name}</td>
			</tr>
		</c:forEach>
	</table>


	<div class="std num"><b>학번 : </b><input name="st_num"/></div>
	<div class="std name"><b>이름 : </b><span></span></div>
	<div class="std grade"><b>학년 : </b><span></span></div>
	<div class="std tel"><b>전화번호 : </b><span></span></div>
	<div class="std addr"><b>주소 : </b><span></span></div>
</body>
</html>