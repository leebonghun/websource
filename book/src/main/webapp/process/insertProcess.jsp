<%@page import="book.persistence.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.persistence.BookDAO"%>
<%@page import="book.domain.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	BookDTO insertDto = new BookDTO();
	insertDto.setCode(request.getParameter("code"));
	insertDto.setTitle(request.getParameter("title"));
	insertDto.setWriter(request.getParameter("writer"));
	insertDto.setPrice(Integer.parseInt(request.getParameter("price")));
	
	Connection con = jdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	Boolean insertFlag = dao.insert(insertDto);
	
	String path = "/index.jsp";
	if(insertFlag){
		jdbcUtil.commit(con);
		path +="?tab=all";	 //path = path+""
	}else{
		jdbcUtil.rollback(con);
	}
	jdbcUtil.close(con);
	response.sendRedirect(path);
		
	
%>