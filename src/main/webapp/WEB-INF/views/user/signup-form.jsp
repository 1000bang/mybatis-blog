<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<br>
<div class="container">

	<h2>회원가입하기</h2>
	<p>우리의 친구가 되어주세요</p>
	<br />
	<form action="/user/signup-proc" method="post">

		<div class="mb-3 mt-3">
			<input type="text" class="form-control" name="username" placeholder="enter username" value="1000bang">
		</div>
		
		<div class="mb-3 ">
			<input type="password" class="form-control" name="password" placeholder="enter password" value="asd123">
		</div >
		
		<div class="mb-3 ">
			<input type="email" class="form-control"name="email" placeholder="enter email" value="a@naver.com">
		</div >
		
		<div class="mb-3 ">
			<input type="text" class="form-control"name="profile" placeholder="enter profile" value="개발자">
		</div >
		<span>
		<c:if test="${isError}">
		<p class="alert alert-danger">${error.message}</p>
		</c:if>
		</span>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>


</div>

<%@ include file="../layout/footer.jsp"%>