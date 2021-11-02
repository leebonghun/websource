<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<h3>장바구니</h3>
<%
	ArrayList<String> cartList = (ArrayList<String>)session.getAttribute("cartList");
%>
<p>
	<%=cartList %>
</p>
<p>
	<a href="cartRemove.jsp">장바구니 비우기</a>
</p>
</body>
</html>