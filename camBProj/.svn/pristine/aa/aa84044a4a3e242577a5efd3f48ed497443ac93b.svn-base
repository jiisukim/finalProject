<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<style>

</style>
<body>
	<div class="card shadow mb-4" style="width: 98%;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/consulting/list'">학생 상담일정</h6>
		</div>
				
		<div class="card-body">
			<div class="table-responsive">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="width: 99%">
					
					<div class="row">
						<div class="col-sm-12">
						<!-- 게시글 수 -->
						<div style="float: left; margin-top: 3%;">
						<span style="color: black; font-weight: bold;">총 <span style="color: #C02B55"><fmt:formatNumber value="${paginationInfo.totalRecordCount}" pattern="#,###" /></span>건의 게시물이 있습니다.</span>
						<span style="color: black; font-weight: bold;">[미입력 <span style="color: #C02B55"><fmt:formatNumber value="${scheduleResultZeroCount}" pattern="#,###" /></span>건]</span>
						</div>
						
							<form method="get" action="/professor/consulting/list" name="frmSearch" id="frmSearch">
							<input type="hidden" name="inputStatus" value="${param.inputStatus}" id="inputStatus2">
									<button type="submit" class="btn btn-secondary btn-icon-split" style="padding: 3px 8px 3px 8px; float: right; margin-top: 2.3%; margin-left: 1%;" >검색</button>
									<label for="selectAll" style="float: right; margin-top: 2.5%;">전체</label><input type="checkbox" id="selectAll" name="selectAll" style="float: right; margin-top: 2.9%; margin-left: 1%;">
									<input class="form-control" id="endDate" name="endDate" type="date" style="float: right; width: 20%; margin-top: 2%;" value="${param.endDate}">
									<span style="float: right; margin-top: 2.5%;font-weight: bold;">&nbsp;&nbsp; - &nbsp;&nbsp;</span>
									<input class="form-control" type="date" id="startDate" name="startDate" style="float: right; width: 20%; margin-top: 2%;" value="${param.startDate}">
									
							</form>
						
						
							<table class="table" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<thead>
									<tr role="row">
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 12%;">
											상담 일자
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 15%;">
											상담 시간
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
											학번
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
											학생 이름
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 18%;">
											학과
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 8%;">
											상담 목적
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
											상담 만족도
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
											결과 입력 여부
										</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach var="consultList" items="${consultList}">
										<tr class="trClick" onclick="clickList(${consultList.profId},${consultList.consultNum})">
											<td style="text-align: center;">${fn:substring(consultList.consultAvlDate,0,10)}</td>
											<td style="text-align: center;">${consultList.startTime}~${consultList.endTime}</td>
											<td style="text-align: center;">${consultList.stdId}</td>
											<td style="text-align: center;">${consultList.stdName}</td>
											<td style="text-align: left;">${consultList.univDeptNum}</td>
											<td style="text-align: center;">${consultList.consultGoalCode}</td>
											<td>${consultList.consultStf}</td>
											<td style="text-align: center;">${consultList.consultOx}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<form method="get" action="/professor/consulting/list" name="inputStatusSearch" id="inputStatusSearch">
						<input type="hidden" name="startDate" value="${param.startDate}" id="">
						<input type="hidden" name="endDate" value="${param.endDate}" id="">
						<select id=inputStatus class="form-control" name="inputStatus" style="text-align: center; width: 150px; float: right; margin-bottom: 2px;  padding: 0px;" >
							<option id="checkAll" value="">전체 상담</option>
							<option value="ok"
							<c:if test="${param.inputStatus=='ok'}">selected</c:if>
							>입력 상담</option>
							<option value="no"
							<c:if test="${param.inputStatus=='no'}">selected</c:if>
							>미입력 상담</option>
						</select>
					</form>
					<div class="row">
						<div class="col-sm-12 col-md-5">

						</div>
						<div id="paging" class="col-sm-12-text-center" style="margin-left: 4.3%;">
								<ul class="pagination">
								<!-- previous 시작 -->
						            <c:if test="${paginationInfo.firstPageNoOnPageList > 5 }">
						              <li style="list-style: none;" class="paginate_button page-item previous" id="example2_previous"> 
						            </c:if>
						            <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">
						              <li style="list-style: none;" class="paginate_button page-item previous disabled" id="example2_previous"> 
						            </c:if>      
						              <a href="/professor/consulting/list?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }&startDate=${param.startDate}&endDate=${param.endDate}&inputStatus=${param.inputStatus}" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">이전</a>
						            </li>      
						            <!-- previous 끝 -->
						            
									<!-- page번호 시작 -->
									<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
										  <li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (empty param.pageNo && pageNo == 1)}">active</c:if>">
							                <a href="/professor/consulting/list?pageNo=${pageNo}&startDate=${param.startDate}&endDate=${param.endDate}&inputStatus=${param.inputStatus}" aria-controls="example2" data-dt-idx="${pageNo }" tabindex="0" class="page-link">${pageNo }</a>
							              </li>        
						            </c:forEach> 
						            <!-- page번호 끝 -->
						            
						            <!-- next시작 -->
						            <li style="list-style: none;" class="paginate_button page-item next 
						            <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if> " id="example2_next">
						              <a href="/professor/consulting/list?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }&startDate=${param.startDate}&endDate=${param.endDate}&inputStatus=${param.inputStatus}" aria-controls="example2" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" tabindex="0" class="page-link">다음</a>
						            </li>       
						            <!-- next끝 -->       
		            			</ul>
	            			</div>
					</div>
            			
						<div class="row" style=" float: right;">
						
						</div>		
				</div>
			</div>
		</div>		
	</div>

</body>
<script src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
$("#startDate").change(function () {
	//오늘날짜 20211008 형식으로 구하기
// 	var date = new Date();						
// 	var year = date.getFullYear(); 
// 	var month = (1 + date.getMonth());          
// 		month = month >= 10 ? month : '0' + month; 
// 	var day = date.getDate();                 
// 		day = day >= 10 ? day : '0' + day;
// 	date = year+""+ month+""+day;		
// 	console.log("date : " + date);
// 	var dateInt = parseInt(date);
	
	//종료일자가 비어있는 상태에서 시작일자를 선택시 자동으로 종료일자에 시작일자가 들어가도록 설정
	if($("#endDate").val()==""){
		$("#endDate").val($("#startDate").val());
	}
	var startDateVal = $("#startDate").val();
	startDateVal = startDateVal.replace(/-/gi, ""); 
	
	var endDateVal = $("#endDate").val();
	endDateVal = endDateVal.replace(/-/gi, ""); 
	
	
	var startDateInt = parseInt(startDateVal);
	var endDateValInt = parseInt(endDateVal);
	if((endDateVal-startDateInt)<0 && endDateValInt){
		alert("시작 일자가 종료 일자 이후입니다.");
		$("#endDate").val($("#startDate").val());
		return;
	}
	
	
});
$("#endDate").change(function () {
	//종료일자가 비어있는 상태에서 시작일자를 선택시 자동으로 종료일자에 시작일자가 들어가도록 설정
	if($("#startDate").val()==""){
		$("#startDate").val($("#endDate").val());
	}
	
	var startDateVal = $("#startDate").val();
	startDateVal = startDateVal.replace(/-/gi, ""); 
	
	var endDateVal = $("#endDate").val();
	endDateVal = endDateVal.replace(/-/gi, ""); 
	
	
	var startDateInt = parseInt(startDateVal);
	var endDateValInt = parseInt(endDateVal);
	if((endDateVal-startDateInt)<0 && endDateValInt){
		alert("종료 일자가 시작일자 이전입니다.");
		$("#startDate").val($("#endDate").val());
		return;
	}
	
	
});


	$(function () {
		$('#inputStatus').on('change', function() {
			$("#inputStatusSearch").submit();
		});
		
		$("#selectAll").click(function() {
			var checkTest = $("input:checkbox[id=selectAll]").is(":checked");
			if(checkTest == true){
				$("#startDate").prop("disabled",true);
				$("#endDate").prop("disabled",true);
				$("#inputStatus").prop("disabled",true);
				$("#startDate").val("");
				$("#endDate").val("");
				$("#inputStatus2").val("");
			}else{
				$("#startDate").prop("disabled",false);
				$("#endDate").prop("disabled",false);
				$("#inputStatus").prop("disabled",false);
			}
		});
		
		$('#inputStatus').on('change', function() {
			$("#inputStatusSearch").submit();
		});
		
	});
	
	
	//디테일 페이지 이동전 세션ID와 디테일페이지ID 대조
	function clickList(profId,consultNum) {
		var sessionId= '${sessionScope.memberVo.memId}';
		var pageNo = '${param.pageNo}';
		var startDate = '${param.startDate}';
		var endDate = '${param.endDate}';
		var inputStatus = '${param.inputStatus}';
		if(profId != sessionId){
			alert("ID정보가 게시글ID와 일치하지 않습니다.");
			return;
		}else{
			if(pageNo == ""){
				pageNo = 1;
			}
			window.location.href = "/professor/consulting/detail?pageNo="+pageNo+"&startDate="+startDate+"&endDate="+endDate+"&inputStatus="+inputStatus+"&consultNum="+consultNum;
		}
	}
</script>
</html>