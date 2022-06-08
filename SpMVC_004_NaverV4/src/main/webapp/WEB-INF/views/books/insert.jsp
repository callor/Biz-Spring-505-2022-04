<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST" class="w3-container">
	<div>
		<input name="isbn" id="isbn"  class="w3-input"
			placeholder="ISBN" value="${BOOK.isbn}" 
			<c:if test="${not empty BOOK.isbn }"> 
				readonly="readonly" 
			</c:if>
		> 
		<input name="title" id="title" class="w3-input" placeholder="도서명 입력후 Enter"  value="${BOOK.title}">
	</div>
	<div>
		<input name="author" class="w3-input" placeholder="저자"  value="${BOOK.author}"> 
		<input name="publisher" class="w3-input" placeholder="출판사"  value="${BOOK.publisher}">  
		<input name="pubdate" class="w3-input" placeholder="출판일"  value="${BOOK.pubdate}">
		<input name="price" class="w3-input" placeholder="가격" type="number"  value="${BOOK.price}"> 
	</div>
	<div>
		<input name="link" class="w3-input" placeholder="자세히보기"  value="${BOOK.link}"> 
		<input name="image" class="w3-input" placeholder="이미지경로"  value="${BOOK.image}">
	</div>
	<textarea rows="10" class="w3-input" name="description">${BOOK.description}</textarea>
	<button type="button" class="w3-button w3-indigo book-save">저장</button>
</form>
