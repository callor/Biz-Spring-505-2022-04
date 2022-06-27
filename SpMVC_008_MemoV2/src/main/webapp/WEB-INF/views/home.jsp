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
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/memo.js?20220627002"></script>
</head>
<body>
	<h1>${USERNAME} 님 반갑습니다</h1>
	<table class="memo">
		<tr>
			<th>SEQ</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>메모</th>
		</tr>
		<c:if test="${empty MEMOS}">
			<tr><td colspan="4">메모가 없습니다</td></tr>
		</c:if>
		<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
			<tr data-seq="${MEMO.m_seq}">
				<td>${INDEX.count}</td>
				<td>${MEMO.m_date}</td>
				<td>${MEMO.m_time}</td>
				<td>${MEMO.m_memo}</td>
			</tr>
		</c:forEach>	
	</table>
	<a href="${rootPath}/memo/insert">메모작성하기</a>
	<c:if test="${empty USERNAME}">
		<a href="${rootPath}/user/login">로그인하기</a>
	</c:if>
	<c:if test="${not empty USERNAME}">
		<a href="${rootPath}/user/logout">로그아웃하기</a>
	</c:if>
</body>
</html>


