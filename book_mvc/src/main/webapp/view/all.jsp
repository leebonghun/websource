<%@page import="java.util.List"%>
<%@page import="book.domain.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<BookDTO> bookList = (List<BookDTO>)request.getAttribute("list");
%>
<%--도서 전체 조회 --%>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">code</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">price</th>
    </tr>
  </thead>
  <tbody>
  <%
  for(BookDTO dto : bookList){
 %>
    <tr>
      <th scope="row"><%=dto.getCode() %></th>
      <td><%=dto.getTitle() %></td>
      <td><%=dto.getWriter() %></td>
      <td><%=dto.getPrice() %></td>
    </tr>
    
    <%
  }
    %>
  </tbody>
</table>