<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<br>
<div class="container">

	<h2>회원가입하기</h2>
	<p>우리의 친구가 되어주세요</p>
	<br />
	<form>

		<div class="mb-3 mt-3">
			<input type="text" class="form-control" placeholder="enter username">
		</div>
		
		<div class="mb-3 ">
			<input type="password" class="form-control" placeholder="enter password">
		</div >
		
		<div class="mb-3 ">
			<input type="email" class="form-control" placeholder="enter email">
		</div >
		
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>


</div>

<%@ include file="../layout/footer.jsp"%>