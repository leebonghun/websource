<%@page import="java.util.List"%>
<%@page import="book.persistence.BookDAO"%>
<%@page import="book.domain.BookDTO"%>
<%@page import="book.persistence.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");
	
	Connection con = jdbcUtil.getConnection();
	BookDAO dao = new BookDAO(con);
	
	List<BookDTO> list=dao.search(criteria, keyword);
	jdbcUtil.close(con);
	
	request.setAttribute("list", list);
	pageContext.forward("/searchIndex.jsp");//주소와 옮기는 주소가 다르당
%>