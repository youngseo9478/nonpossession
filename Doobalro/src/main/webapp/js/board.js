/*$(function(){
	$("#modifyBtn").click(function(){
		location.href="/updateBoardForm.do?title="+$("#title").html()+"&";
	});
})*/

$(function(){
	$("#modifyBtn").click(function(){
		$.ajax({
			method: "POST",
			url: "/updateReply.do",
			type: "JSON",
			data: {
				"replyNum" : $("#replyNum").val();
				"replyContent" : $("#replyContent").html();
			},
			success: function(data){
				if(data.result == "success")
					location.href="getBoard.do?boardNum="+data.boardNum;
			}
		})
	})
})