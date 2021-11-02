<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	session.setAttribute("userid", userid);
	session.setAttribute("password", password);
	session.setAttribute("name", name);
	session.setAttribute("gender", gender);
	session.setAttribute("email", email);
	/* if(gender.equals("Male")){
		gender = "Male";
	}else if(gender.equals("Female")){
		gender = "Female";
	} */
	
	/* response.sendRedirect("***.jsp"); */
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 성공</h1>
<h2>아이디 : <%=session.getAttribute("userid") %></h2>
<h2>비밀번호 : <%=session.getAttribute("password") %></h2>
<h2>사용자 이름 : <%=session.getAttribute("name") %></h2>
<h2>성별 : <%=session.getAttribute("gender") %></h2>
<h2>이메일 : <%=session.getAttribute("email") %></h2>
</body>
</html>