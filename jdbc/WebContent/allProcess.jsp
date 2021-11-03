<%@page import="java.util.List"%>
<%@page import="user.domain.MemberDTO"%>
<%@page import="user.persistance.MemberDAO"%>
<%@page import="user.persistance.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전체 조회 후 페이지 이동
		Connection con = jdbcUtil.getConnection();
		MemberDAO dao = new MemberDAO(con);

		List<MemberDTO> list=dao.getRows();
		jdbcUtil.close(con);
		
		request.setAttribute("list", list);
		pageContext.forward("all.jsp");//주소와 옮기는 주소가 다르당	
		
%>