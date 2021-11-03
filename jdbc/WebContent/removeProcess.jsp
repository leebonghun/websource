<%@page import="user.persistance.MemberDAO"%>
<%@page import="user.domain.MemberDTO"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.persistance.jdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	

	Connection con=jdbcUtil.getConnection();
	//생성된 con을 이용해 DAO 객체 생성
	MemberDAO dao = new MemberDAO(con);
	
	boolean deleteFlag = dao.delete(dto);
	
	if(deleteFlag){
		jdbcUtil.commit(con);
		response.sendRedirect("all.jsp");
	}else{
		jdbcUtil.rollback(con);
		response.sendRedirect("getMember.jsp");
	}
	
	
%>