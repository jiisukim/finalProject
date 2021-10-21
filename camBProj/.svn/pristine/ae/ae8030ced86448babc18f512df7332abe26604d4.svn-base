<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

 <style>
	label, input {
		margin : 0px;
	}
	label {
		font-size: 0.8em;
		font-weight: bold;
	}
	.upper-card {
		height: 90px;
	}
	.h5 {
		text-align: center;
	}
	.marginTop20 {
		margin-top: 20px;	
	}
	.marginBottom10 {
		margin-bottom: 10px;	
	}
</style>
 
<div id="body">

	<p class="mb-4">
	</p>
	
	<div class="card shadow mb-4">
	
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">결재 선 관리</h6>
		</div>
		
		<div class="card-body">
		
			<div class="row">
				<div class="col-sm-8" style="padding-top: 40px;">
					<label>총 <span class="text-info">${TotalCount}</span> 개의 결재 선이 있습니다. </label>
				</div>
				<div class="col-sm-4 text-right">
					<form class="" action="/auth/authLineList" method="post" id="frmSearch">
						<div class="row marginTop20">
							<div class="form-group col-sm-4">
								<select class="form-control" name="searchCondition" id="searchCondition">
									<option value="authLineNum" <c:if test="${authLineStepVo.searchCondition=='authLineNum'}">selected</c:if>>결재 선 번호</option>
									<option value="authLineTypeCode" <c:if test="${authLineStepVo.searchCondition=='authLineTypeCode'}">selected</c:if>>결재 선 업무</option>
									<option value="authLineName" <c:if test="${authLineStepVo.searchCondition=='authLineName'}">selected</c:if>>결재 선 이름</option>
								</select>
							</div>
							<div class="form-group col-sm-6 " id="inputType1" style="padding: 0px;">
								<input type="text" class="form-control bg-light small" id="keyword1"/>
							</div>
							<div class="form-group col-sm-6" id="inputType2" style="display: none; padding: 0px;">
								<select class="form-control" id="keyword2">
									<c:forEach var="code" items="${codeList}">
										<option value='' <c:if test='${authDocVo.searchKeyword==code.codeVal}'>selected</c:if>>전체</option>
										<option value="${code.codeVal}" <c:if test="${authDocVo.searchKeyword==code.codeVal}">selected</c:if>>${code.codeName}</option>
									</c:forEach>	                	
			                	</select>
							</div>
							<div class="form-group col-sm-2">
								<input type="hidden" name="searchKeyword" id="searchKeyword"/>
			                	<button type="button" class="btn btn-primary" id="btnSearch">검색</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12">
						<table class="table" id="dataTable" style="width: 100%;" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<colgroup>
								<col width= "150px;">
								<col width= "150px;">
								<col width= "300px;">
								<col width= "150px;">
								<col width= "150px;">
							</colgroup>
							<thead>
								<tr role="row">
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >결재 선 번호</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >결재 선 업무</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >결재 선 이름</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >결재 선 등록자</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >결재 선 수정일</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${authLineList=='[]'}">
									<tr class="text-center">
										<td colspan="5">결재 선 내역이 없습니다. </td>
									</tr>
								</c:if>
								<c:forEach items="${authLineList}" var="row">
									<tr class="trClick" onclick="frmDetail(${row.authLineNum})">
										<td class="text-center">${row.authLineNum}</td>
										<td class="text-center">${row.authLineTypeCode}</td>
										<td>${row.authLineName}</td>
										<td class="text-center">${row.name} (${row.creator})</td>
										<td class="text-center">
											<c:if test="${row.updateDate == null}"> - </c:if>
											<c:if test="${row.updateDate != null}">${row.updateDate}</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<form action="/auth/authLineDetailView" method="post" id="frm">
							<input type="hidden" id="authLineNum" name="authLineNum" />
							<c:set var="pageNo" value="${param.pageNo}" />
							<c:if test="${param.pageNo==null}">
								<c:set var="pageNo" value="1" />
							</c:if>
							<input type="hidden" name="pageNo"  value="${pageNo}"/> 
						</form>
					</div>
				</div>

				<!-- paging -->	
				<div class="row">
					<div id="paging" class="col-sm-12 text-center">
		        		<ul class="pagination">
					    	<li style="list-style: none;" class="paginate_button page-item previous <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">disabled</c:if>">
					        	<a href="/auth/authLineList?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }" data-dt-idx="0" class="page-link">이전</a>
					        </li>
					       
							<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
					        	<li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (pageNo==1 && param.pageNo ==null)}">active</c:if>">
					            	<a href="/auth/authLineList?pageNo=${pageNo}" data-dt-idx="${pageNo}" class="page-link">${pageNo }</a>
					            </li>
					        </c:forEach>
					       
					        <li style="list-style: none;" class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if>">
					          <a href="/auth/authLineList?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" class="page-link">다음</a>
					        </li>
						</ul>
		        	</div> <!-- //end paging -->
	        	</div>
	        	
	        	<hr>
	        	
	        	<!-- button -->	
				<div class="row">
					<div class="col-sm-12 text-right">
						<button type="button" class="btn btn-primary btn-primary-crud" onclick="location.href='/auth/authLineStepInsertView'">등록</button>
					</div> <!-- //end button -->
				</div>
				
			</div>
					
		</div>
		
	</div>

</div>


<script type="text/javascript">
	
	$(function () {
		
		searchConditionCheck(); // 화면이 로딩될 때마다 select 옵션 변경

		// select 옵션 바뀔 때마다 변경
		$("#searchCondition").on("change", function() {
			searchConditionCheck();
		});
		
		// 검색 
		$("#btnSearch").on("click", function() {
			var selectedOpt = $('#searchCondition option:selected').val();
			 
			 if(selectedOpt=='authLineTypeCode'){
				 $("#searchKeyword").val($("#keyword2").val());
			 }else{
				 $("#searchKeyword").val($("#keyword1").val());
			 }
			 $("#frmSearch").submit();
		});
		
		// 검색 키워드 넣어주기
		searchKeywordCheck();
	});
	
	// 검색 조건에 검색 키워드 select 옵션 변경
	function searchConditionCheck () {
		var selectedOpt = $('#searchCondition option:selected').val();
		 if(selectedOpt=='authLineTypeCode'){
			 $("#inputType1").css("display", "none");
			 $("#inputType2").css("display", "block");
		 }else{
			 $("#inputType1").css("display", "block");
			 $("#inputType2").css("display", "none");
		 }
		
	}
	
	function searchKeywordCheck() {
		var selectedOpt = $('#searchCondition option:selected').val();
		 if(selectedOpt!='authLineTypeCode'){
			 $("#keyword1").val('${authLineStepVo.searchKeyword}');
		 }
	}
	
	function frmDetail(authLineNum) {
		$("#frm").prop("action", "/auth/authLineDetailView");
		$("#authLineNum").val(authLineNum);
		$("#frm").submit();
	}
	
</script>