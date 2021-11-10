/**
 * 
 */
function gethtml() {
	//페이지가 로드 되자마자 서버가 가지고 있는 html 페이지를 가져와서 div 안에
	//보여주기 => 비동기식(Ajax) 처리

	//XMLHttpRequest 객체 생성
	let httpRequest = new XMLHttpRequest();

	//생성된 객체를 통해 서버에게 보낼 요청 설정
	httpRequest.open("get", "/data/data.html");
	//서버로 전송-get방식일때 null or 비워두기 , post 일때는 전송할 데이터포함 시키기
	httpRequest.send(null);


	//서버가 응답 : 200(성공), 400(404 에러), 500(서버 에러)
	httpRequest.onreadystatechange = function() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				let div = document.querySelector("div:last-of-type"); //data.html에서 맨 밑에 div에 보여주기 
				div.innerHTML = httpRequest.responseText;//응답내용 보여주기
			}
		}

	}
}