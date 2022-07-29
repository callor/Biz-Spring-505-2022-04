<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%> 

<div class="w3-container w3-card-4">
	<form:form class="w3-container">
		<c:if test="${error == 'PASS_FAIL'}">
			<div class="w3-text-red">
				* 비밀번호가 일치하지 않아 사용자 정보를 업데이트 할수 없습니다
			</div>
		</c:if>
		<label class="w3-text-blue">USERNAME</label>
		<input value='<sec:authentication property="principal.username"/>'
			readonly="readonly"  
			class="w3-input w3-border">
		
		<label class="w3-text-blue">PASSWORD</label>
		<div class="w3-text-red">* 입력한 비번은 확인용도이며 변경되지 않습니다.</div>
		<input name="password" class="w3-input w3-border">
		
		<label class="w3-text-blue">E-mail</label>
		<input name="email" class="w3-input w3-border"
		value='<sec:authentication property="principal.email"/>'  
		>
		
		<label class="w3-text-blue">실명</label>
		<input name="realname" class="w3-input w3-border"
		value='<sec:authentication property="principal.realname"/>'
		>
		
		<label class="w3-text-blue">닉네임</label>
		<input name="nickname" class="w3-input w3-border"
		value='<sec:authentication property="principal.nickname"/>'
		>
		
		<label class="w3-text-blue">전화번호</label>
		<input name="tel" class="w3-input w3-border"
		value='<sec:authentication property="principal.tel"/>'
		>
		<button class="w3-button w3-blue">수정하기</button>		
	
	</form:form>

</div>   
