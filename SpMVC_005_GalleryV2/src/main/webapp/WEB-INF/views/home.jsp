<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다</h1>
	<a href="${rootPath}/bbs/write">게시판 글쓰기</a>
	<a href="${rootPath}/file/fileups">여러이미지 업로드</a>
	<div class="images">
		<c:forEach items="${FILES}" var="FILE">
			<img src="${rootPath}/upload/${FILE.i_imageName}" width="100px" alt="${FILE}">
		</c:forEach>	
	</div>
</body>
</html>



