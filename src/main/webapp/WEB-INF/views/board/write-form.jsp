<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<br>
<div class="container">

	<h2>블로그 글 쓰기</h2>
	<br />
	<form>

		<div class="mb-3 mt-3">
			<input type="text" class="form-control" placeholder="enter title">
		</div>

		<div class="mb-3 ">
			<textarea rows="8" class="form-control"
				placeholder="enter password"> </textarea>
		</div>
		<button type="submit" class="btn btn-primary">글쓰기 완료</button>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>