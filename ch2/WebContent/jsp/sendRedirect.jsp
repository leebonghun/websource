<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect("form1.jsp");
	/*  sendRedirect vs forward
		데이터베이스에서 업무를 처리한 후 페이지를 이동시키는 방법
		모든 jsp,servlet => 자신만의 request 객체를 가지고 있음
			*/
%>