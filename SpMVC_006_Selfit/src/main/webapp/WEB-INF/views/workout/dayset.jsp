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
	.dayset {
		width: 50%;
		margin:10px auto;
	}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/dayset.js?20220615004"></script>

</head>
<body>
	<div class="dayset">
		<select name="dayset" class="dayset" data-sc_num="${sc_num}">
			<c:forEach items="${DAYS}" var="DAY">
				<option value="${DAY.sc_id}">${DAY.sc_day}) ${DAY.sc_part}</option>
			</c:forEach>		
		</select>
	</div>
	<table class="dayset">
		<tr>
			<th>종목</th>
			<th>세트</th>
			<th>무게</th>
			<th>횟수</th>
		</tr>
		<c:forEach items="${WORKS}" var="WORK">
			<tr data-list_id="${WORK.sl_listid}" data-sc_id="${WORK.sl_scid}">
				<td>${WORK.list_name}</td>
				<td>${WORK.sl_set}</td>
				<td>${WORK.sl_weight}</td>
				<td>${WORK.sl_rep}</td>
			</tr>
		</c:forEach>
		
				
				
	
	</table>
</body>
</html>


