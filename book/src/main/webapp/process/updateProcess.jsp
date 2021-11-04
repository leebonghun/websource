<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.domain.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int price = Integer.parseInt(request.getParameter("price"));
String code = request.getParameter("code");

Connection con = jdbcUtil.getConnection();
BookDAO dao = new BookDAO(con);
boolean updateFlag = dao.update(code, price);

String path = "/index.jsp";
if (updateFlag) {
	jdbcUtil.commit(con);
	path += "?tab=all";
} else {
	jdbcUtil.rollback(con);
	path += "?tab=modify";
}

jdbcUtil.close(con);
response.sendRedirect(path);
%>