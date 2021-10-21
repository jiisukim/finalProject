<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 
	- 등록금 고지서 발급 내역, 수동 납부
 -->

<style>

	.datepicker-days {
	
	   display: none ;
	
	}
	
	.datepicker-months {
	
	   display: none ;
	
	}
	
	.datepicker-years {
	
	   display: block ;
	
	}

</style>

 

<div id="body">

	<p class="mb-4">
		<span id="info"></span>	
	</p>
	
	<div class="row">
	
		<!-- 등록금 리스트 출력 시작 -->
		<div class="col-sm-8">
			<div class="card shadow mb-4">
	
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">학생 등록 내역</h6>
				</div>
				
				<div class="card-body">
				
					<label>총 <span class="text-info">${totalCnt}</span> 개의 등록금 고지서 발급 내역이 있습니다. </label>
					<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12">
								<table class="table" id="dataTable" style="width: 100%;" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
									<colgroup>
										<col width="auto;">
										<col width="auto;">
										<col width="auto;">
										<col width="auto;">
									</colgroup>
									<thead>
										<tr role="row">
											<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >등록 학기</th>
											<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >총 발급 건수</th>
											<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >완납 건수</th>
											<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >미납 건수</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${tuitionPaymentList == '[]'}">
											<tr>
												<td colspan="6" class="text-center">등록 내역이 없습니다. </td>
											</tr>
										</c:if>
										
										<c:forEach items="${tuitionPaymentList}" var="row">
											
											<tr class="text-right">
												<td class="text-center">
													${row.year}년 ${row.semCode}학기
													<input type="hidden" class="yearSemCode" value="${row.year}${row.semCode}"/>
												</td>
												<td>
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${row.allCnt}" /> 건
												</td>
												<td>
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${row.payCnt}" /> 건
												</td>
												<td>
													<fmt:formatNumber type="number" maxFractionDigits="3" value="${row.notPayCnt}" /> 건
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- paging -->	
						<form id="pageFrm" action="/admin/tuitionPayment/tuitionPaymentList" method="post">
							<input type="hidden" name="pageNo" id="pageNo"/>
						</form>
						<div class="row">
							<div id="paging" class="col-sm-12 text-center">
				        		<ul class="pagination">
							    	<li style="list-style: none;" class="paginate_button page-item previous <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">disabled</c:if>">
							        	<button onclick="fn_movePage(${paginationInfo.firstPageNoOnPageList - 5 })" data-dt-idx="0" class="page-link">이전</button>
							        </li>
							       
									<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
							        	<li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == tuitionPaymentVo.pageNo || (pageNo==1 && tuitionPaymentVo.pageNo ==null)}">active</c:if>">
							            	<button onclick="fn_movePage(${pageNo})" data-dt-idx="${pageNo}" class="page-link">${pageNo}</button>
							            </li>
							        </c:forEach>
							       
							        <li style="list-style: none;" class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if>">
							          <button onclick="fn_movePage(${paginationInfo.lastPageNoOnPageList + 1 })" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" class="page-link">다음</button>
							        </li>
								</ul>
				        	</div> 
			        	</div><!-- //end paging -->
					</div>
				</div>
			</div>
		</div>
		<!-- // 등록금 리스트 출력 끝 -->
		
		<!-- 등록금 수동 납부 시작 -->
		<div class="col-sm-4">
			<div class="card shadow mb-4">
	
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">등록금 고지서 수동 발행</h6>
				</div>
				
				<div class="card-body">
					<form id="frm" action="/admin/tuitionPayment/tuitionPaymentInsert" method="post">
						<div class="row">
							<div class="col-sm-8">
								<div class="form-group">
									<label>년도</label>
									<input type="text" class="form-control" id="year" name="year">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label>학기</label>
									<input type="text" class="form-control" id="semCode" name="semCode">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 text-right">
								<input type="hidden" name="saveToken" value="${tuitionPaymentVo.saveToken}"/>
								<button type="button" class="btn btn-primary btn-primary-crud" onclick="fn_insertBill();">발행</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- // 등록금 수동 납부 끝 -->
	</div>
	

</div> <!-- // body 끝 -->

<script type="text/javascript">

	// 등록금 고지서 수동 발행 
	function fn_insertBill() {
		var year_pattern = /^(19|20)\d{2}$/;
		var yearVal = $("#year").val();
		var semVal = $("#semCode").val()
		if(!year_pattern.test(yearVal)){
			alert("올바른 년도를 입력하세요");
			$("#year").focus();
			return;
		}
		if(semVal != '1' && semVal != '2'){
			alert("올바른 학기를 입력하세요");
			$("#semCode").focus();
			return;
		}
		
		$(".yearSemCode").each(function (idx, item) { // 이전에 등록금 고지서를 발급한 년도/학기인지 확인
			if(yearVal + semVal == $(item).val()){
				alert("이미 고지서가 발행된 학기입니다.");
				return;
			}
		
		});

		$("#frm").submit();
	}
	
	// 페이지 이동
	function fn_movePage(pageNo) {
		$("#pageNo").val(pageNo);
		$("#pageFrm").submit();
	}
</script>













