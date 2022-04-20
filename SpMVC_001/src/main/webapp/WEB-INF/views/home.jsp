<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<!--  tag 는 -->
	<h1>${my_name} 님 반갑습니다</h1>
	<h1>30 * 40 = ${ 30 * 40 }</h1>
	<h3>1 &lt; 9 : ${ 1 < 9 }</h3>
	<h3>1 &lt; 9 : ${ 1 lt 9 }</h3>
	
	<h3>1 &gt; 9 : ${ 1 > 9 }</h3>
	<h3>1 &gt; 9 : ${ 1 gt 9 }</h3>
	
	<h3>3 == 3 : ${ 3 == 3 }</h3>
	<h3>3 == 3 : ${ 3 eq 3 }</h3>
	
	<h3>4 != 3 : ${ 4 != 3 }</h3>
	<h3>4 != 3 : ${ 4 ne 3 }</h3>
	
	<h3>1 &gt;= 9 ${ 1 >= 9 }</h3>
	<h3>1 &gt;= 9 ${ 1 ge 9 }</h3>
	
	<h3>1 &lt;= 9 : ${1 >= 9 })</h3>
	<h3>1 &lt;= 9 : ${1 le 9 }</h3>
	
	<h3> 9 나누기 3 : ${9 / 3 }</h3>
	<h3> 9 나누기 3 : ${9 div 3 }</h3>
	
	<h3> 9 나누기 3 후 나머지 : ${9 % 3 }</h3>
	<h3> 9 나누기 3 후 나머지 : ${9 mod 3 }</h3>	
	
	<ul>
		<li>${ ST[0] }</li>
		<li>${ ST[1] }</li>
		<li>${ ST[2] }</li>
	</ul>
	
</body>
</html>