<%@page import="java.net.URLEncoder"%>
<%@page import="board.domain.boardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Board Modify</h3>
		</div>
		<div style="height: 20px"></div>
		<form action="/update.do" method="post" role="form" enctype="multipart/form-data">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10">
						<input type="text" name="name" size="10" class="form-control"
							maxlength='10' value="${dto.name}" readonly>
					</div>
				</div>
				<div class="form-group row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"
							maxlength='100' value="${dto.title }">
					</div>
				</div>
				<div class="form-group row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15'>${dto.content}</textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control"
							size="10" maxlength='10'>
					</div>
				</div>
				<div class="form-group row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
						<c:choose>
							<c:when test="${empty dto.attach}">
								<input type="file" name="attach" id="" />
							</c:when>
							<c:otherwise>
								<%-- <a href="/view/download.jsp?fileName=${dto.attach}">${dto.attach}</a> --%>
								<%
								boardDTO dto = (boardDTO) request.getAttribute("dto");
								String attachFullName = dto.getAttach();

								if (attachFullName != null) {
									String attachName = URLEncoder.encode(attachFullName, "utf-8");
									out.print("<a href='/view/download.jsp?fileName=" + attachName + "'>");
									out.print(attachFullName);
									out.print("</a>");
								}
								%>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div style="height: 20px"></div>
				<div class="box-footer text-center">
					<button type="submit" class="btn btn-primary" id="submit">수정</button>
					<button type="reset" class="btn btn-danger">취소</button>
				</div>
				<div style="height: 20px"></div>
			</div>
			<input type="hidden" name="bno" value='<%=request.getParameter("bno")%>'/>
		</form>
	</div>
</section>
<script src="/js/modify.js"></script>
<%@include file="../include/footer.jsp"%>
