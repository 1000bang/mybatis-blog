<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<br>
<div class="container">

	<h2>로그인 하기</h2>
	<p>다양한 기록들을 남기고 공유해주세요</p>
	<br />
	<form action="/user/signin-proc" method="post">

		<div class="mb-3 mt-3">
			<input type="text" class="form-control" name="username" value="${username}" placeholder="enter username">
		</div>
		
		<div class="mb-3 ">
			<input type="password" class="form-control" name="password" placeholder="enter password">
		</div >
		
		<c:if test="${isNotSignIn}">
		<span>
		<p class="alert alert-danger"> 잘못된 요청입니다. </p>
		</span>
		</c:if>
		<div class="form-check mb-3">
		<label class="form-check-label">
		<input type="checkbox" id="remember" name="remember" class="form-check-input"> Remember me
		</label>
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>


</div>

<%@ include file="../layout/footer.jsp"%>