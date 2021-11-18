<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">List Board</h3>
		</div>
		<div class="row">
			<div class="col-md-4">
				<button type="button" class="btn btn-success"
					onclick="location.href='/view/qna_board_write.jsp'">새글작성</button>
			</div>
			<!--글쓰기 버튼-->
			<div class="col-md-4 offset-md-4">
				<!--검색 들어갈 부분-->
				<form action="/search.do" method="post" id="search">
					<select name="criteria" id="">
						<option value="n"
							<c:out value="${empty searchDto.criteria==null?'selected':''}"/>>----------</option>
						<option value="title"
							<c:out value="${empty searchDto.criteria=='title'?'selected':''}"/>>title</option>
						<option value="content"
							<c:out value="${empty searchDto.criteria=='content'?'selected':''}"/>>content</option>
						<option value="name"
							<c:out value="${empty searchDto.criteria=='name'?'selected':''}"/>>name</option>
					</select> <input type="text" name="keyword" id=""
						value="${searchDto.keyword }" />
					<button type="button" class="btn btn-primary">검색</button>
				</form>
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class='text-center' style='width: 100px'>번호</th>
				<th class='text-center'>제목</th>
				<th class='text-center'>작성자</th>
				<th class='text-center'>날짜</th>
				<th class='text-center' style='width: 100px'>조회수</th>
			</tr>
			<c:forEach var="dto" items="${list}">
				<!-- var: 변수 items : request.setAttribute에서 받아온 변수명  -->
				<tr>
					<!-- 리스트 목록 보여주기 -->
					<td class='text-center'>${dto.bno}</td>
					<!--번호-->
					<td>
						<!--re_lev가 0이 아니면 증가한 수 *1 앞으로 띄워쓰기해줌  --> <c:if
							test="${dto.re_lev!=0}">
							<c:forEach begin="0" end="${dto.re_lev*1}">
							&nbsp;<!-- 띄워쓰기 -->
							</c:forEach>
						</c:if> <a href="/countUpdate.do?bno=${dto.bno}">${dto.title}</a>
					</td>
					<!--제목-->
					<td class='text-center'>${dto.name}</td>
					<!--작성자-->
					<td class='text-center'>${dto.regdate}</td>
					<!--날짜-->
					<td class='text-center'><span
						class="badge badge-pill badge-primary">${dto.readcount}</span></td>
				</tr>
			</c:forEach>
		</table>
		<div class="container">
			<div class="row  justify-content-md-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<!--하단의 페이지 나누기 부분-->
						<c:if test="${pageDto.prev}">
						<li class="page-item"><a class="page-link move" href="${pageDto.page-10}">Previous</a>
						</li>
						</c:if>
						
						<!-- 하단의 1 2 3 4 5.... -->
						<c:forEach begin="${pageDto.startPage}" end="${pageDto.endPage}" var="idx">
						<li class="page-item ${pageDto.page==idx?'active':''}" aria-current="page">
						<a class="page-link move" href="${idx}">${idx}</a></li>
						</c:forEach>
						
						<c:if test="${pageDto.next}">
						<li class="page-item"><a class="page-link move" href="${pageDto.page+10}">Next</a>
						</li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<div style="height: 20px"></div>
	</div>
</section>
<form action="" method="get" role="form" id="actionForm">
	<input type="hidden" name="page" value='${pageDto.page}'/>
	<input type="hidden" name="amount" value='${pageDto.amount}'/>
	<input type="hidden" name="criteria" value='${pageDto.searchDto.criteria}'/>
	<input type="hidden" name="keyword" value='${pageDto.searchDto.keyword}'/>
</form>
<script src="/js/list.js"></script>
<%@include file="../include/footer.jsp"%>
