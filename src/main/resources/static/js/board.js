/**
 * 
 */
 
 let boardInit = {
	
	version : 1,
	init : function(){
		$("#save--btn").bind("click", () => {
			this.save();
		});
		$("#board--delete").bind("click", () => {
			this.delete();
		});
	},
	save : function(){
		let sendData = {
			title : $('#title').val(),
			content : $('#content').val()
		};
		
		$.ajax({
			type : "post",
			url : "/api/board/save",
			data : JSON.stringify(sendData),
			contentType : "application/json; charset=utf-8",
			dataType : "json"
		}).done(function(data, textStatus, xhr){
			console.log(data);
			if(data.code == 1){
				location.href = "/board/list"
			};
		}).fail(function(error){
			console.log(error);
		});
	},
	
	delete : function (){
		let boardId = $("#boardId").val();
		
		$.ajax({
			type : "delete",
			url : "/api/board/delete/"+ boardId,
			dataType : "json"
		}).done(function(data, textStatus, xhr){
			console.log(data);
			data.responseText;
			
		}).fail(function(error){
			console.log(error);
			error.responseText;
		});
		
	}
	
	 
 }
 boardInit.init();
 