<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>
<!-- 공통부분 -->


<div style="margin-top: 20px">
	<form action="insertProcess.jsp" method="post">
		<div class="form-group">
			<label for="userid">UserID</label> <input type="text"
				class="form-control" id="userid" placeholder="현재 아이디" required="required" name="userid">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="password" placeholder="현재 비밀번호" required="required" name="password">
		</div>
		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control" id="name" placeholder="이름" required="required" name="name">
		</div>
		<div class="form-group">
			<label for="gender">Gender</label> <input type="text"
				class="form-control" id="gender" placeholder="성별" required="required" name="gender">
		</div>
		
		<div class="form-group">
			<label for="email">Email</label> <input type="text"
				class="form-control" id="email" placeholder="이메일" required="required" name="email">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="/layout/footer.jsp"%>
<!-- 공통부분 -->
