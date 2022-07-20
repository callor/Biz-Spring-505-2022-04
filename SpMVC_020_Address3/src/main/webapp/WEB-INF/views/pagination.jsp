<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
<style>
.page-box {
	width: 90%;
	margin:15px auto;
	padding:16px;
	border : 1px solid blue;
}

.page-body {
	list-style: none;
	display: flex;
	justify-content: center;
	align-items: center;
}

.page-item {
	margin:2px;
}

.page-link {
	padding:0.5rem 0.7rem;
	line-height: 1.25;
	color:#007bff;
	background-color: #fff;
	border:1px solid #DEE2E6;
	text-decoration: none;
}

.page-link:hover {
	color:#0056B3;
	background-color: #E9ECF;
	border-color: #DEE2EF;
}

.page-link:focus {
	z-index: 3;
	outline: 0;
	box-shadow: 0 0 0 0.2rem rgba(0,123,255,0.25);
}


.page-item.active .page-link {
	color:#fff;
	background-color: #007BFF;
	border-color:#007BFF;
}


</style>   
<div class="page-box">
	<ul class="page-body">
		
		<c:if test="${PAGE.startPageNo >1 }">
			<li class="page-item"><a href="${rootPath}?pageno=1" class="page-link">1</a></li>
			
			<li class="page-item">
			<a href="${rootPath}?pageno=${PAGE.currentPageNo -1}" 
				class="page-link">&lt;</a></li>
				
		<li>
			<a class="page-link">&middot;&middot;&middot;&middot;</a>
		</li>
				
			
		</c:if>
		
		<c:forEach begin="${PAGE.startPageNo}" end="${PAGE.endPageNo}" var="page">
			<li  
			class="page-item <c:if test="${PAGE.currentPageNo == page}">active</c:if>">
			<a href="${rootPath}?pageno=${page}"  class="page-link">${page}</a>
			</li>
		</c:forEach>
		
		<c:if test="${PAGE.endPageNo != PAGE.finalPageNo }">

		<li class="page-item">
			<a href="${rootPath}?pageno=${PAGE.currentPageNo + 1}"  
					class="page-link">&gt;</a>
		</li>
		<li>
			<a class="page-link">&middot;&middot;&middot;&middot;</a>
		</li>
		
		<li class="page-item">
			<a href="${rootPath}?pageno=${PAGE.finalPageNo}"  
					class="page-link">${PAGE.finalPageNo}</a>
		</li>
		</c:if>
	</ul>
</div>

