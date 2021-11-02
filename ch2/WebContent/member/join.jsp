<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="/member/joinProcess.jsp" method="post">
			<div class="form-group">
				<label for="userid">아이디</label> <input type="text"
					class="form-control" id="userid" name="userid">
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password"
					class="form-control" id="password" name="password">
			</div>
			<div class="form-group">
				<label for="name">이름</label> <input type="text" class="form-control"
					id="name" name="name">
			</div>
			<div class="form-group">
				<input type="radio" name="gender" value="Male" checked>남 <input
					type="radio" name="gender" value="Female">여<br>
			</div>
			<div class="form-group">
				<label for="email">이메일</label> <input type="text"
					class="form-control" id="email" name="email">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>