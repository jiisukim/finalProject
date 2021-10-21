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
tbody tr:hover {
	background-color: #F4F5F9;
}

</style>
<body>
	<div class="card shadow mb-4" style="width: 100%;">
		<div class="card-header py-3">
		
			<h6 class="m-0 font-weight-bold text-primary">
				전체 공지
				<br>
			</h6>

		</div>
		<div class="card-body">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="width: 100%">
					<div class="row">
						<div class="col-sm-12 col-md-6">
							<div class="dataTables_length" id="dataTable_length"></div>
						</div>

						<div class="col-sm-12 col-md-6">
							
							<div class="card-body" style="position: relative; top: 70px; left: 258px;">
	
								<form method="get" action="/common/notice/noticeList" name="frmSearch" id="frmSearch">

								<div style="margin-top: 30px;">
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
											class="btn btn-primary" style="float:left;  width: 70px; height: 40px; color: white; border-radius: 10px; border: 1px; margin-left: 30px;" onclick="icon_click()">검색</button>
								</div>
									
								</form>

								</div>
								<br>
								<br />

							</div>
						</div>
					</div>
					<br>
					<br>
					<div class="row">
						<div class="col-sm-12">
						     <span style="color: black; margin-left:50px; font-weight: bold;">총<span style="color: #C02B55">
  							 <fmt:formatNumber value="${totalCnt}" pattern="#,###" /></span>건의 게시물이 있습니다.</span>
							<table class="table" id="dataTable" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 93%; position: relative; left: 50px; top: 10px;;">
								<thead>
									<tr role="row">
										<th
											style="width: 4%; background-color: #5175df; color: white;"
											id="number" class="sorting sorting_asc" tabindex="0"
											aria-controls="dataTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
										>번호</th>
										<th
											style="width: 50%; background-color: #5175df;; color: white; text-align: left;"
											class="sorting sorting_asc" tabindex="0"
											aria-controls="dataTable" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="Name: activate to sort column descending"
										>제목</th>
										<th
											style="width: 12%; background-color: #5175df;; color: white;"
											class="sorting" tabindex="0" aria-controls="dataTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
										>날짜</th>
										<th
											style="width: 6%; background-color: #5175df;; color: white;"
											class="sorting" tabindex="0" aria-controls="dataTable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											>첨부파일</th>
									</tr>
								</thead>


								<tbody>
								<c:if test="${list == '[]'}">
									<tr>
										<td colspan="5" class="text-center">게시글이 존재하지 않습니다. </td>
									</tr>
								</c:if>								
									<c:forEach var="list" items="${list}">
										<tr onclick="fn_detail('${list.artcNum}')" class="trClick">
											<td style="width: 5px; text-align: center;">${list.rnum}</td>
										<%-- 	<td style="text-align: center;">${list.empId}</td> --%>
											<td>${list.title}</td>
											<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd"
													value="${list.writeDate}" /></td>
											<td style="text-align: center;"><c:if
													test="${list.fileGrNum!=null}">
													<img src="/resources/img/attach.png" style="width: 30px;">
												</c:if></td>
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
							href="/common/notice/noticeList?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }"
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
								<a href="/common/notice/noticeList?pageNo=${pageNo}"
								aria-controls="example2" data-dt-idx="${pageNo }" tabindex="0"
								class="page-link">${pageNo }</a>
							</li>
						</c:forEach>
						<!-- page번호 끝 -->

						<!-- next시작 -->
						<li style="list-style: none;"
							class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if> "
							id="example2_next"><a
							href="/common/notice/noticeList?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }"
							aria-controls="example2"
							data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }"
							tabindex="0" class="page-link">다음</a></li>
						<!-- next끝 -->
					</ul>
					<c:if test="${sessionScope.admin == '03'}">
						<hr>
					</c:if>
					<div class="row" style="float: right;">
						<c:if test="${sessionScope.admin == '03'}">
							<button
								class="btn btn-primary btn-primary-crud" style="position: relative; float: right;" type="button" onclick="javascript:location.href='/common/notice/noticeInsert'">등록
							</button>
						</c:if>
					</div>
				</div>
			</div>
		<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/js/ddit.min.js"></script>

		<script type="text/javascript">
			function linkPage(pageNo) {
				location.href = "/common/notice/noticeList?pageNo=" + pageNo;
			}

			function fn_detail(num) {
				location.href = '/common/notice/noticeDetail?artcNum=' + num;
			}
			function icon_click() {
				$("#frmSearch").submit();
			}
			$(function() {

				$("#selectAll").click(
						function() {
							var checkTest = $("input:checkbox[id=selectAll]")
									.is(":checked");
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