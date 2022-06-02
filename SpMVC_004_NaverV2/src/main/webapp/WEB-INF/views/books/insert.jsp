<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST">
	<div>
		<input name="isbn" id="isbn" placeholder="ISBN"> 
		<input name="title" id="title" placeholder="도서명 입력후 Enter">
	</div>
	<div>
		<input name="author" placeholder="저자"> 
		<input name="publisher" placeholder="출판사"> 
		<input name="pubdate" placeholder="출판일">
		<input name="price" placeholder="가격" type="number"> 
	</div>
	<div>
		<input name="link" placeholder="자세히보기"> <input name="image"
			placeholder="이미지경로">
	</div>
	<textarea rows="10"></textarea>
	<button type="submit">저장</button>
</form>
