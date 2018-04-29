/*$(function(){
	$("#modifyBtn").click(function(){
		location.href="/updateBoardForm.do?title="+$("#title").html()+"&";
	});
})*/

$(function() {
	$("#modifyBtn").click(function() {
		replyNum = $(this).attr('name');
		var a = '';

		a += '<div class="input-group">';
		a += '<input id=' + replyNum + 'contents type="text" class="form-control" value=""/>';
		a += '<span class="input-group-btn"><button class="btn btn-info btn-fill btn-sm" type="button" onclick="commentUpdate(' + replyNum + ');">수정</button> </span>';
		a += '</div>';

		$('.replyContent' + replyNum).html(a);
	})

	function commentUpdate(replyNum) {
		$.ajax({
			method : "POST",
			url : "/updateReply.do",
			type : "JSON",
			data : {
				"replyNum" : replyNum,
				"replyContent" : $("#" + replyNum + "contents").val()
			},
			success : function(data) {
				if (data.result == "success")
					location.href = "getBoard.do?boardNum=" + data.boardNum;
			}
		})
	}
})