<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<br>
<div class="container">

	<h2>블로그 글 수정하기 </h2>
	<br />
	<form>
		<input hidden="true" value="${boardData.id}" id="boardId">
		<div class="mb-3 mt-3">
			<input type="text" class="form-control" id="title" name="title" value="${boardData.title}" placeholder="enter title">
		</div>

		<div class="mb-3 ">
			<textarea rows="8" class="form-control" id="content" name="content" 
				placeholder="내용을 입력하세요 ">${boardData.content} </textarea>
		</div>
	</form>
		<button type="submit" id="update--btn" class="btn btn-primary">글수정 완료 </button>

</div>
<script type="text/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>