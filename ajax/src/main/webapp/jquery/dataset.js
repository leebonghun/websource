/**
 * 
 */
$(function(){
	$(".container div:last-child").click(function(){
		$.get({
			url:"/data/dataset.xml",
			success:function(data){
				let output = "<ul>";
				$(data).find("record").each(function(){
					output += "<li> id :"+$(this).find("id").text()+"</li>";
					output += "<li> name :"+$(this).find("name").text()+"</li>";
					output += "<li> email :"+$(this).find("email").text()+"</li>";
					output += "<li> gender :"+$(this).find("gender").text()+"</li>";
				})
				output+="</ul><br></br>";
				
				$("#contents").html(output);
				
			},
			error:function(xhr,textStatus,error){
				$("#content").html("데이터 없음");				
			}
			
			
		})
		
		
	})
	
	
})
