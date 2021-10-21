<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<style>
table1{
   width: 100%;
   padding: 10px;
   border-spacing: 5px;
}
#table1 td {
	width: 140px;
	height: 60px;
	background-color: #5175df;;
	color: white;
	padding: 10px;
  	border-spacing: 5px;
	border:1px solid;
	border-color: white;
}
#table1 tr{
	padding: 10px;
  	border-spacing: 5px;
}

#table1 td {

	cursor: pointer;
}

button.selected {
	background-color: red;
	
}

</style>
<body>

	<div class="card shadow mb-4" style="width: 100%;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">FAQ</h6>
		</div>
		<br> 
		<br>
		<div class="card-body">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="width: 100%">
					<div class="row">

							<div class="dataTables_length" id="dataTable_length"></div>

							<%--   <option id="faqKwdCode" value="faqKwdCode" <c:if test="${param.search=='faqKwdCode'}"
                   >checked==true</c:if>>분류</option> --%>
							<div class="faq-tab" style="margin-left: 360px;">
								<table id="table1" cellspacing="0" cellpadding="0" 
									style="text-align: center; border-collapse:separate; border-radius: 15px;">
									<tr>
										<td class="clickMenu" id="faqKwdCode01">수 업</td>
										<td class="clickMenu" id="faqKwdCode02">등 록</td>
										<td class="clickMenu" id="faqKwdCode03">복수전공/부전공</td>
										<td class="clickMenu" id="faqKwdCode04">성적/출결</td>
										<td class="clickMenu" id="faqKwdCode05">수강신청</td>
										<td class="clickMenu" id="faqKwdCode06">장학금</td>
									</tr>
									</table>
									<table id="table1" cellspacing="0" cellpadding="0"
									style="text-align: center; border-collapse:separate; border-radius: 15px;">
									<tr>
										<td class="clickMenu" id="faqKwdCode07">졸 업</td>
										<td class="clickMenu" id="faqKwdCode08">휴학/복학</td>
										<td class="clickMenu" id="faqKwdCode09">생활관</td>
										<td class="clickMenu" id="faqKwdCode10">증명서</td>
										<td class="clickMenu" id="faqKwdCode11">봉 사</td>
										<td class="clickMenu" id="faqKwdCode12">기 타</td>
									</tr>
								</table>
							</div>


					<div style="width: 40%; height: 100px; padding-left:70px;  position: relative; top:80px; left:1015px;">
						
							<form method="get" action="/common/faq/faqList" name="frmSearch" id="frmSearch">
							
								<div style="margin-top: 13px;">
								<input type="hidden" value="" id="faqKwdCode" name="faqKwdCode" style="display: inline-block;">
								   <select id="search" name="search" class="form-control" style="width: 80px; float: left;">
											 <option value="">전체</option>
											<option id="title" value="title"
												<c:if test="${param.search=='title'}"
												>checked==true</c:if>>제목</option>
										<option id="content" value="content"
											<c:if test="${param.search=='content'}"
											>checked==true</c:if>>내용</option>
									</select>
									
										 <input type="text" id="keyword" class="form-control" name="keyword" placeholder="검색어를 입력해주세요" value="${param.keyword}"
											style="height: 38px; width: 185px; float: left; margin-left: 20px;" maxlength="30">
										<div style="float: left; margin-top: 6px;">
											&nbsp;&nbsp;목록&nbsp;&nbsp;<input type="checkbox" id="selectAll" name="selectAll"> <label for="selectAll"></label>
										</div>
										
										<button
											class="btn btn-primary" style="float:left;  width: 70px; height: 40px; color: white; border-radius: 10px; border: 1px; margin-left: 30px;" onclick="icon_click()">검색
										</button>
									</div>

							</form>

						</div>


					</div>
						<br><br>
					<div class="row">
						<div class="col-sm-12">
							<span
								style="color: black; position: relative; left: 50px; font-weight: bold;">총<span
								style="color: #C02B55"> <fmt:formatNumber
										value="${totalCount}" pattern="#,###" /></span>건의 게시물이 있습니다.
							</span>
							<table class="table" id="dataTable" cellspacing="0" role="grid"
								aria-describedby="dataTable_info" style="width: 93%; position: relative; left: 50px; top: 10px;">
								<thead>
									<tr role="row">
										<th class="sorting sorting_asc" tabindex="0"
											aria-controls="dataTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
											style="width: 5%; background-color: #5175df; color: white; text-align: center;">번호
										</th>
										<th class="sorting sorting_asc" tabindex="0"
											aria-controls="dataTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
											style="width:12%; background-color: #5175df; color: white; text-align: left;">분류
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 55%; background-color: #5175df; color: white; text-align: left;">제목
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 15%; background-color: #5175df; color: white;">날짜
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 7%; background-color: #5175df; color: white;">첨부파일
										</th>
									</tr>
								</thead>
								<tbody id="tb1">
								<c:if test="${list == '[]'}">
									<tr>
										<td colspan="5" class="text-center">게시글이 존재하지 않습니다. </td>
									</tr>
								</c:if>
									<c:forEach var="list" items="${list}">
										<tr onclick="fn_detail('${list.artcNum}')" class="trClick">
											<td style="text-align: center;">${list.rnum}</td>
											<td>${list.faqKwdCode}</td>
											<td>${list.title}</td>
											<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd"
													value="${list.writeDate}" /></td>
											<td style="text-align: center;"><c:if
													test="${list.fileGrNum!=null}">
													<img src="/resources/img/attach.png" style="width: 30px;">
												</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<!-- paging -->
					<ul class="pagination">
						<!-- previous 시작 -->
						<c:if test="${paginationInfo.firstPageNoOnPageList > 5 }">
							<li style="list-style: none;"
								class="paginate_button page-item previous"
								id="example2_previous">
						</c:if>
						<c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">
							<li style="list-style: none;"
								class="paginate_button page-item previous disabled"
								id="example2_previous">
						</c:if>
						<a
							href="/common/faq/faqList?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }"
							aria-controls="example2" data-dt-idx="0" tabindex="0"
							class="page-link">이전</a>
						</li>
						<!-- previous 끝 -->

						<!-- page번호 시작 -->
						<c:forEach var="pageNo"
							begin="${paginationInfo.firstPageNoOnPageList }"
							end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
							<li style="list-style: none;"
								class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (pageNo==1 && param.pageNo == null)}">active</c:if>">
								<a href="/common/faq/faqList?pageNo=${pageNo}"
								aria-controls="example2" data-dt-idx="${pageNo }" tabindex="0"
								class="page-link">${pageNo }</a>
							</li>
						</c:forEach>
						<!-- page번호 끝 -->

						<!-- next시작 -->
						<li style="list-style: none;"
							class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if> "
							id="example2_next"><a
							href="/common/faq/faqList?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }"
							aria-controls="example2"
							data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }"
							tabindex="0" class="page-link">다음</a></li>
						<!-- next끝 -->
					</ul>
					<hr>
					<c:if test="${sessionScope.admin == '03'}">
						<button
							class="btn btn-primary btn-primary-crud" style="width: position: relative; float:right;" type="button" onclick="javascript:location.href='/common/faq/faqInsert'">등록
						</button>
					</c:if>
				</div>
			</div>
		</div>
	<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/ddit.min.js"></script>

	<script type="text/javascript">
		
			$(function() {
				var faqKwdCode = "${param.faqKwdCode}";
				$("#faqKwdCode" + faqKwdCode).css("background", "lightGray").css("color", "black");
			
			});
		$(".clickMenu").click(function() {
	
			var a = $(this).attr("id");
			var faqCode = a.substr(10, 12);

			$(function() {
				var url = window.location.pathname;
				var urlRegExp = new RegExp(url.replace(/\/$/, '') + "$");

				$('.clickMenu').each(function() {

					if (urlRegExp.test(this.href.replace(/\/$/, ''))) {
						$(this).addClass('active');
						var parents = $(this).parents(".faq-tab");
						$(parents).each(function(idx, item) {
							$(item).addClass("show");
						});
					}
				});
			});

			$("#faqKwdCode").val(faqCode);

			$("#frmSearch").submit();

		});

		function linkPage(pageNo) {
			location.href = "/common/faq/faqList?pageNo=" + pageNo;
		}

		function fn_detail(num) {
			location.href = '/common/faq/faqDetail?artcNum=' + num;
		}

		function icon_click() {
			$("#frmSearch").submit();
		}
		$(function() {

			$("#selectAll").click(
					function() {
						var checkTest = $("input:checkbox[id=selectAll]").is(
								":checked");
						if (checkTest == true) {
							$("#search").prop("disabled", true);
							$("#keyword").prop("disabled", true);
						} else {
							$("#search").prop("disabled", false);
							$("#keyword").prop("disabled", false);
						}

					});
		});
	</script>
</body>
</html>