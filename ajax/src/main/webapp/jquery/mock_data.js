/**
 * 
 */
$(function() {
	$(".container div:last-child").click(function() {
		$.getJSON({
			url:"/data/MOCK_DATA.json",
			success:function(data) {
				let resText = "<ul>";
				$(data).each(function(idx,item){
				resText+="<li>id :"+item.id+"</li>";
				resText+="<li>name :"+item.name+"</li>";
				resText+="<li>email :"+item.email+"</li>";
				resText+="<li>gender :"+item.gender+"</li>";
				resText+="<li>ip_address :"+item.ip_address+"</li>";
				
				})
				resText+="</ul>";
				$("#contents").html(resText);
			},
			error:function(xhr, textStatus, error){
			$("#contents").html("가져올 데이터 없음");

			}
		})
	})
})