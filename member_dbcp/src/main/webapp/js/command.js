/**
 * 버튼(회원탈퇴, 로그아웃, 비밀번호 수정) 클릭 시 동작하는 스크립트 
 */

$(function() {
	$("#modify").click(function() {
		location.href="modifyForm.jsp"

	})
	$("#logout").click(function() {
		//logout.do
		location.href="/logout.do";
	})
	$("#leave").click(function() {
		location.href="leaveForm.jsp"

	})





})
