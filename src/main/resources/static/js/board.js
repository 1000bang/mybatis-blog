/**
 * 
 */
 
 let boardInit = {
	
	version : 1,
	init : function(){
		$("#save--btn").bind("click", () => {
			this.save();
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
	}
	 
 }
 boardInit.init();
 