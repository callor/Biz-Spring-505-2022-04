<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<div class="w3-container">
	<table class="w3-table-all search-result">
		<colgroup>
			<col width="300px">
			<col width="100px">
			<col width="100px">
		</colgroup>
		<thead>
			<tr>
				<th>도서명</th>
				<th>출판사</th>
				<th>저자</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty BOOKS}">
				<tr><td colspan="3">검색결과가 없습니다</td></tr>
			</c:if>
			<c:forEach items="${BOOKS}" var="BOOK">
				<tr data-isbn="${BOOK.isbn}">
					<td>${BOOK.title}</td>
					<td>${BOOK.publisher}</td>
					<td>${BOOK.author}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>



