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
	<form method="POST">
		<input name="a_seq" type="hidden" 
			value='<c:out value="${ADDR.a_seq}" default="0"/>' />
		<input name="a_name" placeholder="이름" value="${ADDR.a_name}"/>
		<input name="a_tel" placeholder="전화번호"  value="${ADDR.a_tel}"/>
		<input name="a_address" placeholder="주소"  value="${ADDR.a_address}"/>
		<button>저장</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ADDRS}" var="ADDR">
				<tr>
					<td><a href="${rootPath}/detail?seq=${ADDR.a_seq}">${ADDR.a_name}</a></td>
					<td>${ADDR.a_tel}</td>
					<td>${ADDR.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>