<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery.min.js"></script>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="card shadow">

	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">상담내역</h6>
	</div>

	<div class="card-body">

		<div class="row" style="margin-top: 20px;">
			<div class="col-12">
				<form id="frmSearch" name="frmSearch">
					<div style="float: right;">
						<div class="form-group" style="display: inline-block;">
							<label>신청일자</label>
							<input type="date" class="form-control" id="applyDate"
								name="selSearch" value="applyDate" value="${param.applyDate}"
								<c:if test="${param.selSearch=='applyDate'}">value="${applyDate}"</c:if>>
							<!-- 검색을 해도 유지되도록 수정해야함 -->
						</div>
						&nbsp;&nbsp; <span style="font-weight: bold;">-</span> &nbsp;&nbsp;
						<div class="form-group" style="display: inline-block;">
							<input type="date" class="form-control" id="applyDate2"
								name="selSearch2">
						</div>
						&nbsp;&nbsp;
						<div class="form-group" style="display: inline-block;">
							<button type="submit" class="btn btn-primary btn-icon-split"
								style="margin-bottom: 5px;">
								<span class="icon text-white-50"> <i
									class="fas fa-search"></i>
								</span>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="row" style="margin-top: 20px;">
			<div class="col-12">
				<table class="table text-nowrap">
					<thead>
						<tr>
							<th>순번</th>
							<th>신청일자</th>
							<th>상담원</th>
							<th>상담일시</th>
							<th>신청상태</th>
							<th>상담만족도</th>
							<th>불만족사유</th>
						</tr>
					</thead>
					<tbody style="text-align: center;">
						<c:forEach var="list" items="${list}">
							<tr class="trClick"
								onclick="javascript:location.href='/student/consult/consultationDetailList?consultNum=${list.consultNum}'">
								<td>${list.rnum}</td>
								<td>${list.applyDate}</td>
								<td>${list.profInformation}</td>
								<td>${list.consultTime}</td>
								<td>${list.procStatCode}</td>
								<td>${list.consultStf}</td>
								<td>${list.unstfRsn}</td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div id="paging" class="col-sm-12 text-center">
				<ul class="pagination">
					<li style="list-style: none;"
						class="paginate_button page-item previous <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">disabled</c:if>">
						<a
						href="/student/consult/consultationList?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }"
						data-dt-idx="0" class="page-link">이전</a>
					</li>

					<c:forEach var="pageNo"
						begin="${paginationInfo.firstPageNoOnPageList }"
						end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
						<li style="list-style: none;"
							class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (pageNo==1 && param.pageNo ==null)}">active</c:if>">
							<a href="/student/consult/consultationList?pageNo=${pageNo}"
							data-dt-idx="${pageNo}" class="page-link">${pageNo}</a>
						</li>
					</c:forEach>

					<li style="list-style: none;"
						class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if>">
						<a
						href="/student/consult/consultationList?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }"
						data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }"
						class="page-link">다음</a>
					</li>
				</ul>
			</div>
		</div>

		<hr>

		<div class="row">
			<div class="col-12">
				<div style="float: right; margin-right: 0px;">
					<div class="form-group">
						<button type="button" class="btn btn-primary"
							style="width: 100px;" onclick="fn_insert()">등록</button>
					</div>
				</div>

			</div>
		</div>

	</div>

</div>
<script type="text/javascript">
	function fn_insert() {
		location.href = '/student/consult/consultationApply';
	}
</script>