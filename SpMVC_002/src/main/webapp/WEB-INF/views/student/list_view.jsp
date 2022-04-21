<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>
<style>
	section {
		display: flex;
		flex-direction: column;
	}
	
	article {
		width:80%;
		margin:0 auto;
	}
	
	table {
		width:80%;
		margin:0 auto;
		border-top: 1px solid #ddd;
		border-bottom: 1px solid #ddd;
		border-collapse: collapse;
	}
	
	tr {
		border-bottom: 1px solid #ddd;
		border-top: 1px solid #ddd;
	}
	
	th, td {
		padding:5px;
		text-align: left;
		cursor: pointer;
	}
	
	tr:nth-of-type(even) {
		background-color: #eee;
	}
	
	tr:nth-of-type(odd) {
		background-color: #fff;
	}
	
	tr:nth-of-type(n+2):hover {
		background-color: #ddd;
	}
	
	tr:not(:first-of-type):hover {
		background-color: #ddd;	
	}
	
	div.botton-box {
		width:80%;
		margin:5px auto;
		text-align: right;
		padding:5px 0;
	}
	
	div.botton-box a {
		display: inline-block;
		padding:12px 16px;
		text-decoration: none;
		color:white;
		background-color: blue;
		border-radius: 5px;
	}
	
	div.botton-box a:hover {
		box-shadow: 2px 2px 2px rgba(0,0,0,0.6);
	}
	
	
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp" %>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp" %>
	<section>
		<article>학생정보</article>
		<table>
			<tr>
				<th>학번</th><th>이름</th>
				<th>학과</th><th>학년</th>
				<th>주소</th>
			</tr>
			<tr>
				<td>0001</td><td>홍길동</td>
				<td>컴공과</td><td>3</td>
				<td>광주시 북구 중흥동</td>
			</tr>
			<tr>
				<td>0001</td><td>홍길동</td>
				<td>컴공과</td><td>3</td>
				<td>광주시 북구 중흥동</td>
			</tr>
			<tr>
				<td>0001</td><td>홍길동</td>
				<td>컴공과</td><td>3</td>
				<td>광주시 북구 중흥동</td>
			</tr>
			<tr>
				<td>0001</td><td>홍길동</td>
				<td>컴공과</td><td>3</td>
				<td>광주시 북구 중흥동</td>
			</tr>
			<tr>
				<td>0001</td><td>홍길동</td>
				<td>컴공과</td><td>3</td>
				<td>광주시 북구 중흥동</td>
			</tr>
			<tr>
				<td>0001</td><td>홍길동</td>
				<td>컴공과</td><td>3</td>
				<td>광주시 북구 중흥동</td>
			</tr>
		</table>
		<div class="botton-box">
			<a href="${pageContext.request.contextPath}/student/insert">학생정보 등록</a>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
</body>
</html>