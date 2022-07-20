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
	<h1>반갑습니다</h1>
	<%// form에 한개의 input box 만 있을 경우 input box text 를 입력한 후 
	  // Enter를 누르면 input box 담긴 문자열을 서버로 전송하는 기능이
	  // 활성화 된다.
	%>
	<form>
		<input name="search" placeholder="검색어 입력 후 Enter..."/>
	</form>
	<table>
		<thead>
			<tr>
				<th>SEQ</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ADDRS}" var="ADDR">
				<tr>
					<td>${ADDR.a_seq}</td>
					<td><a href="${rootPath}/detail?seq=${ADDR.a_seq}">${ADDR.a_name}</a></td>
					<td>${ADDR.a_tel}</td>
					<td>${ADDR.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/views/pagination.jsp" %>
	<a href="${rootPath}/insert">주소 추가하기</a>

</body>
</html>