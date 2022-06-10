<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
section.main-view {
	display: flex;
	max-height: 100%;
	overflow: auto;
	flex-wrap: wrap;
}

section.main-view article {
	flex: 1 500px;
	margin: 0 5px;
	box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.3);
	border-radius: 5px;
}

section.main-view .article-title {
	display: flex;
	flex-direction: column;
}

div.header {
	display: flex;
	margin:5px 10px 5px 5px;
	padding:8px;
	cursor: pointer;
	color:#777;
	
	transition : 0.5s;
}

div.header p {
	margin:5px 1rem 5px auto;
	font-weight: 100;
	opacity: 0;
}

div.header:hover {
	background-color: #eee;
}

div.header:hover > p {
	opacity: 1;
}


</style>
<section class="main-view">
	<article>
		<div class="article-title">
			<div class="header">
				<h3>도서목록</h3>
				<p>더보기 &#43;</p>			
			</div>
			<hr/>
		</div>
	</article>
	<article>
		<div class="article-title">
			<div class="header">
				<h3>오늘의 뉴스</h3>
				<p>더보기 &#43;</p>			
			</div>
			<hr/>
		</div>
	</article>
	<article>
			<div class="article-title">
			<div class="header">
				<h3>영화목록</h3>
				<p>더보기 &#43;</p>			
			</div>
			<hr/>
		</div>
	</article>
</section>