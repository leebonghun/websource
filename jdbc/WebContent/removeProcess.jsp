<%@page import="user.persistance.MemberDAO"%>
<%@page import="user.domain.MemberDTO"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.persistance.jdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	

	Connection con=jdbcUtil.getConnection();
	//생성된 con을 이용해 DAO 객체 생성
	MemberDAO dao = new MemberDAO(con);
	boolean deleteFlag = dao.delete(userid,password);
	
	if(deleteFlag){
		jdbcUtil.commit(con);
		jdbcUtil.close(con);
		response.sendRedirect("allProcess.jsp");
	}else{
		jdbcUtil.rollback(con);
		jdbcUtil.close(con);
		response.sendRedirect("selectProcess.jsp");
	}
	
	
%>