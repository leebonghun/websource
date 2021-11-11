/**
 * getxml.js에서 메뉴 4 클릭시 동작
 */

$(function(){
	$(".container div:last-child").click(function(){
		
		$.get({
			url:"/data/schoolArray.xml",
			success:function(data){
				let output = "<ul>";
				$(data).find("subject").each(function(){
					
					output += "<li>title :"+$(this).find("title").text()+"</li>";
					output += "<li>time :"+$(this).find("time").text()+"</li>";
					output += "<li>teacher :"+$(this).find("teacher").text()+"</li>";
					
				})
				output+="</ul>";
				
				$("#contents").html(output);
				
				
			},
			error:function(xhr,textStatus,error){
				$("#contents").html("데이터없음");
			}
			
			
		})
		
	})
	
	
})

/*let last_div = document.querySelector(".container div:last-child")
	.addEventListener('click', makeRequest);

let xhr = new XMLHttpRequest();
function makeRequest() {
	xhr.onreadystatechange = getJson;
	xhr.open("get", "/data/schoolArray.xml");
	xhr.send(null);

}
//서버가 응답하는 경우 호출
function getJson() {
	//서버가 보내준 데이터를 contents 영역에 보여주기
	let contents = document.querySelector("#contents");
	if (xhr.readyState==4) {

		if (xhr.status == 200) {
			//xml
			let response = xhr.responseXML;
			console.log(response);
			
			/*xml 자체 형태로 그대로 보여줄 때*/
			/*let school = response.getElementsByTagName("school");
			contents.innerText = school[0].innerHTML;
			
			let title = response.getElementsByTagName("title");
			let time = response.getElementsByTagName("time");
			let teacher = response.getElementsByTagName("teacher");
			
			let data = "<ul>";
			for(var i=0; i<title.length; i++){
			data+="<li>title : "+title[i].innerHTML+"</li>";
			data+="<li>time : "+time[i].innerHTML+"</li>";
			data+="<li>teacher : "+teacher[i].innerHTML+"</li>";	
			}
			data += "</ul>";
			
			contents.innerHTML = data;
			
		} else {
			contents.innerHTML=  "가져온 데이터없음";
		}


	}
}*/