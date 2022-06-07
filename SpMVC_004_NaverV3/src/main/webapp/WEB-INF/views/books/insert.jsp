<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<form method="POST">
	<div>
		<input name="isbn" id="isbn" 
			placeholder="ISBN" value="${BOOK.isbn}" 
			<c:if test="${not empty BOOK.isbn }"> 
				readonly="readonly" 
			</c:if>
		> 
		<input name="title" id="title" placeholder="도서명 입력후 Enter"  value="${BOOK.title}">
	</div>
	<div>
		<input name="author" placeholder="저자"  value="${BOOK.author}"> 
		<input name="publisher" placeholder="출판사"  value="${BOOK.publisher}">  
		<input name="pubdate" placeholder="출판일"  value="${BOOK.pubdate}">
		<input name="price" placeholder="가격" type="number"  value="${BOOK.price}"> 
	</div>
	<div>
		<input name="link" placeholder="자세히보기"  value="${BOOK.link}"> 
		<input name="image" placeholder="이미지경로"  value="${BOOK.image}">
	</div>
	<textarea rows="10" name="description">${BOOK.description}</textarea>
	<button type="submit">저장</button>
</form>
