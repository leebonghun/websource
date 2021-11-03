<%@page import="user.persistance.MemberDAO"%>
<%@page import="user.persistance.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//update.jsp에서 넘긴 값 가져오기
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("currentPassword"));
	dto.setChagnePassword(request.getParameter("changePassword"));
	
	//db작업
	
	Connection con = jdbcUtil.getConnection();
	MemberDAO dao = new MemberDAO(con);
	boolean updateFlag = dao.update(dto);
	
	if(updateFlag){
		response.sendRedirect("allProcess.jsp");
		jdbcUtil.commit(con);
	}else{
		response.sendRedirect("update.jsp");
		jdbcUtil.rollback(con);
	}
	//페이지 이동
%>