<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<br>
<div class="container">

	<h2>블로그 글 쓰기</h2>
	<br />
	<form>
		<input type="hidden" id="boardId" value="1">
		<div class="mb-3 mt-3">
			<input type="text" class="form-control" id="title" name="title" placeholder="enter title">
		</div>

		<div class="mb-3 ">
			<textarea rows="8" class="form-control" id="content" name="content"
				placeholder="내용을 입력하세요 "> </textarea>
		</div>
	</form>
		<button type="submit" id="save--btn" class="btn btn-primary">글쓰기 완료</button>

</div>
<script type="text/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>