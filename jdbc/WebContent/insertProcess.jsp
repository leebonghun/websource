<%@page import="user.domain.MemberDTO"%>
<%@page import="user.persistance.jdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="user.persistance.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//insert.jsp에서 넘긴값을가져오기 
	/* String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email"); */
	MemberDTO dto = new MemberDTO();
	dto.setUserid(request.getParameter("userid"));
	dto.setPassword(request.getParameter("password"));
	dto.setName(request.getParameter("name"));
	dto.setGender(request.getParameter("gender"));
	dto.setEmail(request.getParameter("email"));
	//db작업
	//Connection 생성
	Connection con=jdbcUtil.getConnection();
	//생성된 con을 이용해 DAO 객체 생성
	MemberDAO dao = new MemberDAO(con);
	
	boolean insertFlag = dao.insert(dto);
	
	//db작업 결과에 따라 페이지 이동
	if(insertFlag){
		jdbcUtil.commit(con);
		response.sendRedirect("allProcess.jsp");
	}else{
		jdbcUtil.rollback(con);
		response.sendRedirect("insert.jsp");
	}
	


%>