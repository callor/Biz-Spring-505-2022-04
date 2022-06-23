<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<style>
	section.main {
		width: 70%;
		margin:10px auto;
	}
	
	form#emsVO input, form#emsVO button {
		width: 90%;
	}
	
	span {
		color:red;
	}

</style>
</head>
<body>
	<section class="main">
		<form:form modelAttribute="emsVO" encType="multipart/form-data">
		
			<form:input path="e_to_email" placeholder="받는 Email"/><br/>
			<form:errors path="e_to_email"/>
			
			<form:input path="e_from_name"  placeholder="보내는 사람 이름"/><br/>
			<form:errors path="e_from_name"/>
			
			<form:input path="e_to_name"  placeholder="받는 사람 이름"/><br/>
			<form:errors path="e_to_name"/>
			
			<form:input path="e_subject"  placeholder="제목"/><br/>
			<form:errors path="e_subject"/>
			
			<form:input path="e_content"  placeholder="내용"/>
			<input type="file" name="file"/>
			<button>보내기</button>
			
		</form:form>
		
	
	
	</section>





</body>
</html>