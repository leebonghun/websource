<%@page import="user.domain.MemberDTO"%>
<%@page import="user.persistance.MemberDAO"%>
<%@page import="user.persistance.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));

	Connection con = jdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	MemberDTO dto1 = dao.getRow(dto);
	
	jdbcUtil.close(con);
	
	
	if(dto1 != null){
		request.setAttribute("dto1", dto1);
		pageContext.forward("getMember.jsp");
	}else{
		response.sendRedirect("select.jsp");
		
	}
%>