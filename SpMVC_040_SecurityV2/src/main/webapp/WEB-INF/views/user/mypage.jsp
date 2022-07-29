<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="w3-contaier w3-card-4">
	<h1>My Page</h1>
	
	<ul class="w3-text-blue">
		<li><strong>User Name : </strong><sec:authentication property="principal.username"/></li>
		<li><strong>Email : </strong><sec:authentication property="principal.email"/></li>
		<li><strong>실명 : </strong><sec:authentication property="principal.realname"/></li>
		<li><strong>닉네임 : </strong><sec:authentication property="principal.nickname"/></li>
		<li><strong>전화번호 : </strong><sec:authentication property="principal.tel"/></li>
	</ul>
	<a href="${rootPath}/user/update?username=<sec:authentication property="principal.username"/>">
		수정하기
	</a> 
</div>

