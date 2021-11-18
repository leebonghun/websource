/**
 * qna_board_list.jsp 와 관련있는 스크립트
 */
$(function(){
	
	
	//페이지 번호를 클릭하면 actionform 보내기
	$(".move").click(function(e){
		e.preventDefault();
		
		let href = $(this).attr('href');
		
		$("#actionForm").find("[name='page']").val(href);
		$("#actionForm").submit();
		
		})
	
	
	//검색버튼을 누르면
	//검색조건 , 검색어 가져온 후
	//내용이 안들어 있으면 메세지 띄우기
			
	//검색어 		
	$(":text").keydown(function(e){
			if(e.keycode ==13){
				e.preventDefault();
			}
			
			
		})	

	$(".btn-primary").click(function(){

		let criteria = $("[name='criteria']");
		let keyword = $("[name='keyword']");
		
		if(criteria.val()=="n"){
			alert("내용이 없습니다")
			criteria.focus();
			return;
			
		}else if(keyword.val()==""){
			alert("검색어가 없습니다");
			keyword.focus();
			return;
		}
		
		
		$("#search").submit();
	})
		
	
	
	
	
	
})