<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<style>
	form {
	   width:80%;
	   margin:5px auto;
	}
	
	fieldset {
		border:1px solid blue;
		padding:10px;
		border-radius: 10px;
		margin:20px;
	}
	legend {
		text-align: center;
		padding:10px;
		margin:10px;
	}
	
	form div {
		width:80%;
		margin:0 auto;
	}
	form label, form input {
		display:inline-block;
		padding:8px;
	}
	
	form label {
		width:30%;
		color:blue;
		font-weight: bold;
		text-align: right;
	}
	form input {
		width: 65%;
		margin-left:5px; 
	}
	
	form div:last-of-type {
		text-align: right;
		width:75%;
		margin:10px auto;
	}
	
</style>

<form method="POST">
	<fieldset>
	<legend>학생정보 등록</legend>
	<div>
		<label>학번</label>
		<input type="text" name="st_num">
	</div>
	<div>
		<label>이름</label>
		<input type="text" name="st_num">
	</div>
	<div>
		<label>학과</label>
		<input type="text" name="st_num">
	</div>
	<div>
		<label>학년</label>
		<input type="text" name="st_num">
	</div>
	<div>
		<label>전화번호</label>
		<input type="text" name="st_num">
	</div>
	<div>
		<label>주소</label>
		<input type="text" name="st_num">
	</div>
	<div>
		<button class="btn-blue">저장</button>	
	</div>
	</fieldset>
</form>