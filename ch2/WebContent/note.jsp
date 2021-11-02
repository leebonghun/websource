<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<!--form2.jsp -> info2.jsp -> forward1.jsp -> 주소줄과 보여지는 페이지가 같지않다   
 	info2.jsp 가 가지고 있는 request = forward1.jsp 가 가지고 있는 request
 	
 	 	
 	4) HttpSession session : http 프로토콜의 stateless 를 보완하는 방법
 	http 프로토콜의 stateless? 연결을 유지하고 있지 않음
 	ex) 로그인,장바구니 정보를 유지하는데 주로 사용
 	
 	
 	페이지 이동(서버에서 데이터베이스 작업을 수행하고 난 후)
 	sendRedirect => response객체
 	forward => pageContext
 	
 	session : session 유효기간
 	브라우저 닫기 전까지(웹사이트가 가지고 있는 모든 페이지에서 세션 값은 살아 있게 됨)
 	어떤 이동방식이든 상관없음
 	a태그 / form action / sendRedirect★ / forward
 	
	Http 프로토콜 : 상태유지 하지 않음(stateless)
	
	세션 : 서버
	setAttribute/getAttribute/removeAttribute(특정세션제거)/invalidate(모든세션제거)
	로그인 => 회원정보 수정 => 세션 제거 => 다시 로그인 => 세션 저장
	
	쿠키 : 클라이언트 브라우저 저장	
		(객체 값 저장 불가) => ex) session.setAttribute("",value); => 쿠키는 이런 양식이 불가.
		 쿠키의 만료 시간 설정 가능(설정을 안하면 브라우저가 종료되면 쿠키 값이 제거됨.)
		 특정 사이트 방문시 쿠키를 브라우저를 통해 담기
		 다음에 동일한 사이트 방문할 때 저장된 쿠키를 가져와서
		 서버 쪽에서 확인이 가능함.
	
	
	
	
	
 	-->
</body>
</html>