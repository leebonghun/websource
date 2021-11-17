/**
 * 
 */
$(function(){
	
	let formObj = $("[role='form']");
	
	$("#list").click(function(){
		location.href='/list.do';
	})
	//pwdCheck.jsp와 form obj를 동시에 보내기
	$("#delete").click(function(){
		formObj.attr("action","/view/qna_board_pwdCheck.jsp");
		formObj.submit();
	})
	$("#modify").click(function(){
		formObj.attr("action","/modify.do");
		formObj.submit();
	})
	//댓글 답변
	$("#reply").click(function(){
		formObj.attr("action","/replyView.do")
		formObj.submit();
		
	})
	
	
	
	
	
})


