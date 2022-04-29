<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>
<style>
	section {
		display: flex;
		flex-direction: column;
	}
	article {
		width:80%;
		margin:0 auto;
	}
	
	label, input {
		display: inline-block;
		padding:8px;
		margin:5px 3px;
	}
	
	label {
		width: 30%;
		text-align: right;
	}
	input {
		width:60%;
	}
	
	fieldset {
		border:1px solid blue;
		padding:5px;
		border-radius: 10px;
	}
	
	legend {
		color:blue;
		margin:0 30px;
		padding:5px;
	}
	
	form div {
		width:90%;
		text-align: right;
	}
	
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp" %>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp" %>
	<section>
		<article>
			<form method="POST">
				<fieldset>
					<legend>학생정보 등록</legend>
					
					<label>학번</label>
					<input type="text" placeholder="학번"/>

					<label>이름</label>
					<input type="text" placeholder="이름"/>

					<label>학과</label>
					<input type="text" placeholder="학과"/>

					<label>학년</label>
					<input type="text" placeholder="학년"/>

					<label>주소</label>
					<input type="text" placeholder="주소"/>
					
					<div>
						<button>저장</button>
						<button type="button">리스트로</button>
						<button type="reset">다시작성</button>
					</div>
				</fieldset>
			</form>
		</article>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
</body>
</html>