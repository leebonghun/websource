<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	

	Connection con = jdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	boolean deleteFlag = dao.delete(code);
	
	
	
	
	String path="/index.jsp";
	if(deleteFlag){
		jdbcUtil.commit(con);
		path +="?tab=all";
	}else{
		jdbcUtil.rollback(con);
		path +="?tab=delete";
	}
	jdbcUtil.close(con);
	response.sendRedirect(path);
	
%>