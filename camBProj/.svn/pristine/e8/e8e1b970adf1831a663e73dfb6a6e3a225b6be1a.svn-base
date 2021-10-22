<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>


<div class="card shadow">

	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">사회봉사
			졸업인증제 등록 및 승인신청 안내</h6>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-sm-12">
				<div class="form-group">
					<div
						style="border: 1px solid white; border-radius: 5px; background-color: #F8F8FF; padding: 20px 0px 0px 20px;">
						<p style="color: red;">기준 : 재학생 60시간, 장애학생은 제외가능</p>
						<p>⊙ 국가인증센터인 1365, VMS, 코이카 또는 국가기관에서 인증관리된 봉사를 원칙으로함</p>
						<p>⊙ 영리 및 종교목적, 개인적 농촌봉사 등 공익적 목적이외의 봉사활동은 제외됨</p>
						<p>⊙ 봉사시간은 1일 8시간까지만 인정되며, 헌혈은 1회당 5시간이 인정됨</p>
						<p>⊙ 봉사활동 후 기관에서 자원봉사활동확인서(인증서)를 받는 즉시 학교 포털 에 등록함</p>
						<p>⊙ 봉사기관이 동일하면 학기단위로 봉사시간을 합산하여 등록하고 증빙자료는 필히 업로드함</p>
						<p>⊙ 입학(편입) 후부터 졸업사정 전까지 실적을 인정하며, 위 사항에 위배될시 승인되지 않음</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<br />
<div>
	<input type="hidden" id="stdId" name="stdId"
		<c:if test="${sessionScope.student == '01'}">value="${memberVo.memId}"</c:if> />
</div>
<div class="card shadow">

	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">봉사내역 리스트</h6>
	</div>
	
	<div class="card-body">

		<div class="row" style="margin-top: 20px;">
			<div class="col-12">
				<form method="get" action="/student/volunteer/volunteerList"
					name="frmSearch" id="frmSearch">
					<div style="float: right;">
						<div class="form-group" style="display: inline-block;">
							<label>활동종류</label> <select class="form-control" name="code">
								<c:forEach var="volAct" items="${volAct}">
									<option value="${volAct.codeVal}"
										<c:if test="${param.code == volAct.codeVal}">selected</c:if>>${volAct.codeName}</option>
								</c:forEach>
							</select>
						</div>
						&nbsp;&nbsp;
						<div class="form-group" style="display: inline-block;">
							<label>기관명</label> <input type="text" class="form-control"
								id="keyword" name="keyword" placeholder="기관명을 입력해주세요"
								value="${param.keyword}" />
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
		
		<div class="row">
			<div class="col-12">
				<div style="float: right;">
					<p style="color: blue; display: inline-block;">인정시간&nbsp;&nbsp;:&nbsp;&nbsp;<span id="volRecogTimeSum" style="font-weight: bold;"></span>
					/ <span id="volTimeCrt" style="font-weight: bold;"></span></p>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<p style="color: red; display: inline-block;">신청시간&nbsp;&nbsp;:&nbsp;&nbsp;<span id="volRecogTimeSumTotal"></span>
					/ <span id="volTimeCrt2" style="font-weight: bold;"></span></p>
				</div>
			</div>
		</div>
		
		<div class="row" style="margin-top: 10px;">
			<div class="col-12">
				<table class="table text-nowrap">
					<thead>
						<tr>
							<th>순번</th>
							<th>시작일자</th>
							<th>종료일자</th>
							<th>인정시간</th>
							<th>활동종류</th>
							<th style="width: 200px;">기관명</th>
							<th>첨부파일</th>
							<th>신청상태</th>
							<th>반려사유</th>
						</tr>
					</thead>
					<tbody style="text-align: center;">
						<c:forEach var="list" items="${list}">
							<tr onclick="fn_detail('${list.volNum}')" class="trClick">
								<td>${list.rnum}</td>
								<td>${list.startDate}</td>
								<td>${list.endDate}</td>
								<td>${list.volRecogTime}</td>
								<td>${list.volActCode}</td>
								<td>${list.insName}</td>
								<td><c:if test="${list.fileGrNum!=null}">
										<img src="/resources/img/attach.png" style="width: 30px;">
									</c:if></td>
								<td>${list.procStatCode}</td>
								<td>${list.disauthRsn}</td>
							</tr>
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
						href="/student/volunteer/volunteerList?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }"
						data-dt-idx="0" class="page-link">이전</a>
					</li>

					<c:forEach var="pageNo"
						begin="${paginationInfo.firstPageNoOnPageList }"
						end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
						<li style="list-style: none;"
							class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (pageNo==1 && param.pageNo ==null)}">active</c:if>">
							<a href="/student/volunteer/volunteerList?pageNo=${pageNo}"
							data-dt-idx="${pageNo}" class="page-link">${pageNo}</a>
						</li>
					</c:forEach>

					<li style="list-style: none;"
						class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if>">
						<a
						href="/student/volunteer/volunteerList?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }"
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
							style="width: 100px;"
							onclick="javascript:location.href='/student/volunteer/volunteerListAppApply'">등록</button>
					</div>
				</div>

			</div>
		</div>

	</div>
	
</div>

<script type="text/javascript">
	//상세내역보기 함수, 파라미터로 보내면 되는데 저기서 하면 안됨
	function fn_detail(num) {
		location.href = '/student/volunteer/volunteerDetailList?volNum=' + num;
	}
	
	$(function(){
		
		var stdId = $("#stdId").val();
		
		$.ajax({
			url : "/student/volunteer/volRecogTimeAndGraduation",
			data : {
				"stdId" : stdId
			},
			dataType : "json",
			type : "post",
			success : function(data) {
				console.log(data);
				$("#volRecogTimeSum").text(data.volRecogTimeSum + "시간");
				$("#volRecogTimeSumTotal").text(data.volRecogTimeSumTotal + "시간");
				$("#volTimeCrt, #volTimeCrt2 ").text(data.volTimeCrt);
			}
			
		});
		
		
	});
	
</script>