<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%> 

<div class="w3-container w3-card-4">
	<form:form class="w3-container">
		<c:if test="${error == 'ADMIN_PASS' }">
			<div class="w3-text-red">
				<strong>* 관리자 비번이 틀립니다 Update 할수 없음</strong>
			</div>
		</c:if>
		<label class="w3-text-blue">관리자 PASSWORD</label>
		<div class="w3-text-red">* 관리자의 비번을 입력하세요.</div>
		<input name="password" class="w3-input w3-border">
		
		<label class="w3-text-blue">USERNAME</label>
		<input 
			value='${USER.username}'
			readonly="readonly"  
			class="w3-input w3-border">
		
		<label class="w3-text-blue">E-mail</label>
		<input name="email" class="w3-input w3-border"
		value='${USER.email}'  
		>
		
		<label class="w3-text-blue">실명</label>
		<input name="realname" class="w3-input w3-border"
		value='${USER.realname}'
		>
		
		<label class="w3-text-blue">닉네임</label>
		<input name="nickname" class="w3-input w3-border"
		value='${USER.nickname}'
		>
		
		<label class="w3-text-blue">전화번호</label>
		<input name="tel" class="w3-input w3-border"
		value='${USER.tel}'
		>
		<button class="w3-button w3-blue">수정하기</button>		
	
	</form:form>

</div>   
