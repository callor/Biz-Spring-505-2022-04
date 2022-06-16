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
	<h2>작성자 : ${BBS.b_writer}</h2>
	<h2>작성일자 : ${BBS.b_date}</h2>
	<h2>작성시각 : ${BBS.b_time}</h2>
	<h2>제목 : ${BBS.b_subject}</h2>
	<h2>내용 : ${BBS.b_content}</h2>	
	
	<c:forEach items="${BBS.images}" var="IMAGE">
		<img src="${rootPath}/upload/${IMAGE.i_imageName}">
	</c:forEach>
	
</body>
</html>

