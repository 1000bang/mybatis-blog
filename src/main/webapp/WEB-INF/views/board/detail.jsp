<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<style>
.board--info {
	display: flex;
	margin-top: 10px;
	justify-content: space-between;
}

.board--info >span {
	color: grey;
	font-size: 15px;
	font-style: italic;
}

.board--content {
	margin: 10px
}

</style>


<br>
<br>
<div class="container">
	<div class="board--list">
		<h2>${board.title}</h2>
		<div class="board--info">
			<p > ${board.username}</p>
			<span>${board.createDate}</span> <span class="board--urlCopy">URL 복사 </span>
			<input type="text" value="http://localhost:8080/board/detail/${board.id}" id="urlAddress" style="display : none">
			<input type="hidden" id="boardId" value="${board.id}">
		</div>
		<c:if test="${isWriter}">
		<div>
			<a type="button" href="/auth/board/modify/${board.id}" id="board--update" class="btn btn-info">update</a>
			<button type="button" id="board--delete" class="btn btn-danger">delete</button>
		</div>
		</c:if>
		<hr/>
		</div>
		<br/>
		<div class="board--content">
		${board.content}
		</div>
		
	


</div>
<script> 
$( document ).ready(function() {
    $('.board--urlCopy').bind("click", function(){
    	
    	let urlAddress = $('#urlAddress');
    	urlAddress.css('display', 'block').select();
    	document.execCommand("Copy");
    	urlAddress.css('display', 'none').select();
    	alert("URL 주소가 복사 되었습니다. ");
    });
});
</script>
<script src = "/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>