<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style>
	label, input {
		margin : 0px;
	}
	#searchBox {
		border-radius: 15px; background-color: #F4F5F9; line-height: 50px; margin-bottom: 20px;
	}
	.checkbox-inline {
		margin-right: 30px;
	}
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
	.marginTop10 {
		margin-top: 5px;	
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
			<h6 class="m-0 font-weight-bold text-primary">이수 변경 신청 내역</h6>
		</div>
		
		<div class="card-body">
			
			<!-- 안내문 (기준 학기, 기간)시작 --> 
			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-4 py-3 border-left-primary">
						<div class="card-body upper-card">
							<div class="row">
								<div class="col-sm-2">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
										<i class="fas fa-calendar-check text-gray-300 marginBottom10"></i> <span class="text-info" id="yearSemCode"></span>
										<br />
									</div>
								</div>
								<div class="col-sm-2">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
											
										<c:if test="${studentVo.acadStatCode == null || studentVo.acadStatCode == ''}">
											<c:set var="acadStatCode" value="미등록 신입생"/>
										</c:if>
										<c:if test="${studentVo.acadStatCode != null && studentVo.acadStatCode != ''}">
											<c:set var="acadStatCode" value="${studentVo.acadStatCode}"/>
										</c:if>
									
										<i class="fas fa-user-alt text-gray-300 marginBottom10"></i> <span class="text-info">학사 상태</span> 
										<br />${acadStatCode}
									</div>
								</div>
								<div class="col-sm-2">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
										<i class="fas fa-check-square text-gray-300 marginBottom10"></i> <span class="text-info">등록 학기 / 이수 학점</span> 
										<br /><span id="rgstSem">${studentVo.rgstSem}</span>학기 / <span id="cred"></span>학점
									</div>
								</div>
								<div class="col-sm-2">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
										<i class="fas fa-spinner text-gray-300 marginBottom10"></i> <span class="text-info">접수</span> 
										<br /> ${courseChangeApplyCount.cnt01} 건
									</div>
								</div>
								<div class="col-sm-2">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
										<i class="fas fa-check-circle text-gray-300 marginBottom10"></i> <span class="text-info">승인</span> 
										<br /> ${courseChangeApplyCount.cnt02} 건
									</div>
								</div>
								<div class="col-sm-2">
									<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
										<i class="fas fa-exclamation-circle text-gray-300 marginBottom10"></i> <span class="text-info">미승인</span> 
										<br /> ${courseChangeApplyCount.cnt03} 건
									</div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- // 상태 요약 끝 -->
			</div><!-- // 끝 -->
			
			<div class="row">
				<div class="col-sm-12 text-center">
					<div id="searchBox">
						<label class="checkbox-inline"> 
							<input type="checkbox" id="00" onclick="checkAll(this);"> 
							전체
						</label>
						<label class="checkbox-inline"> 
							<input type="checkbox" id="01" name="courseChngCode" class="courseChngCheck" value="01">
							전과
						</label> 
						<label class="checkbox-inline"> 
							<input type="checkbox" id="02" name="courseChngCode" class="courseChngCheck" value="02">
							복수전공
						</label> 
						<label class="checkbox-inline"> 
							<input type="checkbox" id="03" name="courseChngCode" class="courseChngCheck" value="03">
							부전공
						</label>
	
						<button type="button" class="btn btn-sm btn-secondary" onclick="courseChngSearch();">검색</button>
					</div>
				</div>
			</div>
			
			<label>총 <span class="text-info">${courseChangeApplyCount.totalCnt}</span> 개의 신청 내역이 있습니다. </label>	
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12">
						<table class="table" id="dataTable" style="width: 100%;" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<colgroup>
								<col width= "150px">
								<col width= "150px">
								<col width= "150px">
								<col width= "150px">
								<col width= "250px">
								<col width= "150px">
								<col width= "auto">
								<col width= "80px">
								<col width= "80px">
								<col width= "80px">
							</colgroup>
							<thead>
								<tr role="row">
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >접수번호</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >신청일자</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >이수변경 유형</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >이수변경 학기</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >학과 명</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >처리상태</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >미승인 사유</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >수정</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >취소</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >포기</th>
								</tr>
							</thead>
							<tbody id="td">
								<c:if test="${courseChangeApplyList == '[]'}">
									<tr>
										<td colspan="10" class="text-center">신청 내역이 없습니다. </td>
									</tr>
								</c:if>
								
								<c:forEach items="${courseChangeApplyList}" var="row">
								
									<!-- 배지 색깔 결정 시작 -->
									<c:if test='${row.procStatCode == "접수"}'>
										<c:set var="badgeColor" value="badge-warning"/>
									</c:if> 
									<c:if test='${row.procStatCode == "승인"}'>
										<c:set var="badgeColor" value="badge-light"/>
									</c:if> 
									<c:if test='${row.procStatCode == "미승인"}'>
										<c:set var="badgeColor" value="badge-secondary"/>
									</c:if>
									<!-- // 배지 색깔 결정 끝 -->
									
									<tr class="text-center">
										<td>${row.courseChngApplyNum}</td>
										<td>${row.applyDate}</td>
										<td>${row.courseChngCode}</td>
										<td>${row.year}-${row.semCode}</td>
										<td class="text-left">${row.univDeptNum}</td>
										<td>
											<label class="badge ${badgeColor}" style="font-size: 1em; font-weight: normal;">${row.procStatCode}</label>
										</td>
										
										<c:if test="${row.disauthRsn == null}">
											<td>-</td>
										</c:if>
										<c:if test="${row.disauthRsn != null}">
											<td class="text-left">${row.disauthRsn}</td>
										</c:if>
										
										<!-- 처리 상태 '접수' 인 경우 활성화-->
										<td>
											<button type="button" onclick="frmUpdate(${row.courseChngApplyNum});" class="btn btn-info btn-sm"  
												<c:if test="${row.procStatCode != '접수'}">disabled</c:if>>
												<i class="fas fa-edit"></i>
											</button>
										</td>
										<td>
											<button type="button" onclick="frmDelete(${row.courseChngApplyNum});" class="btn btn-danger btn-sm" 
												<c:if test="${row.procStatCode != '접수'}">disabled</c:if>>
												<i class="fas fa-trash-alt"></i>
											</button>
										</td>
										<td>
											<button type="button" onclick="frmGiveUp(${row.courseChngApplyNum});" class="btn btn-danger btn-sm" 
												<c:if test="${row.procStatCode != '승인'}">disabled</c:if>>
												<i class="fas fa-eraser"></i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:set var="pageNo" value="${param.pageNo}" />
						<c:if test="${param.pageNo==null || param.pageNo==''}">
							<c:set var="pageNo" value="1" />
						</c:if>
						<!-- get방식으로 url을 통해 삭제하지 못하도록 post방식으로 삭제 요청 -->
						<form action="/student/courseChange/courseChangeApplyDelete" method="post" id="frm">
							<input type="hidden" id="courseChngApplyNum" name="courseChngApplyNum" />
							<input type="hidden" name="pageNo"  value="${pageNo}"/> 
						</form>
					</div>
				</div>
				
				<!-- paging -->	
				<div class="row">
					<div id="paging" class="col-sm-12 text-center">
		        		<ul class="pagination">
					    	<li style="list-style: none;" class="paginate_button page-item previous <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">disabled</c:if>">
					        	<a onclick="courseChngSearch(${paginationInfo.firstPageNoOnPageList - 5 })" data-dt-idx="0" class="page-link">이전</a>
					        </li>
					       
							<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
					        	<li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (pageNo==1 && param.pageNo ==null)}">active</c:if>">
					            	<a onclick="courseChngSearch(${pageNo})" data-dt-idx="${pageNo}" class="page-link">${pageNo}</a>
					            </li>
					        </c:forEach>
					       
					        <li style="list-style: none;" class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if>">
					          <a onclick="courseChngSearch(${paginationInfo.lastPageNoOnPageList + 1 })" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" class="page-link">다음</a>
					        </li>
						</ul>
		        	</div> <!-- //end paging -->
	        	</div>
	        	
	        	<hr>
	        	
	        	<!-- button -->	
				<div class="row">
					<div class="col-sm-12 text-right">
						<form action="/student/courseChange/courseChangeApplyInsertView" method="post" id="insertViewFrm">
							<input type="hidden" name="courseChngCode" id="courseChngCode" />
						</form>
						
						<button type="button" class="btn btn-primary btn-primary-crud" id="btnInsert01" onclick="courseChangeApplyInsertView('01')">
							전과 신청
						</button>
						<button type="button" class="btn btn-primary btn-primary-crud" id="btnInsert02" onclick="courseChangeApplyInsertView('02')">
							복수전공 신청
						</button>
						<button type="button" class="btn btn-primary btn-primary-crud" id="btnInsert03" onclick="courseChangeApplyInsertView('03')">
							부전공 신청
						</button>
					</div> <!-- //end button -->
				</div>
			</div>
			
					
		</div>
		
	</div>

</div>


<script type="text/javascript">

	// 신청 가능 여부 기준이 되는 이수학점 점수와 등록학기
	var stdAcadInfo	= ${jsonStdAcadInfo};
	var credSum = stdAcadInfo.ct1Cred + stdAcadInfo.ct2Cred + stdAcadInfo.ct3Cred + stdAcadInfo.ct4Cred;
	var ct1ApplyCred = 20;
	var ct2ApplyCred = 30;
	var ct3ApplyCred = 30;
	var ct1ApplySem = 3;
	var ct2ApplySem = 2;
	var ct3ApplySem = 2;
	
	$(function() {
		
		$("#cred").text(credSum); // 학생의 이수 학점 보여주기
		
// 		applyCheck(); // 신청 가능한 상태인지 확인
		
		$("#yearSemCode").text(getYearSemCode()); // 현재 학기 입력
		
		// 이수 유형 검색 체크박스 다 선택 시 전체 체크박스 체크
		$(".courseChngCheck").on("click", function() {
			var checkAll = true;
			// 모든 체크박스가 체크되어있는지 확인
			$(".courseChngCheck").each(function(idx, item) {
				if($(item).is(":checked") == false){ // 하나라도 체크되어 있지 않다면  false
					checkAll = false;	
				}				
			});
			if(checkAll == true){
				$("#00").prop("checked", true); // 모두 체크되어 있다면 true
			}else{
				$("#00").prop("checked", false); // 모두 체크되어 있다면 true
			}
		});
		
	});
	
	// 신청 가능한 상태인지 확인
	function applyCheck() {
		var acadStatCode = "${studentVo.acadStatCode}";  
		
		var courseRecodeCheckCT2 = "${courseRecodeCheck.CT2}";
		var courseRecodeCheckCT3 = "${courseRecodeCheck.CT3}";
		
		var applyCheck01 = "${applyCheck.applyCheck01}";
		var applyCheck02 = "${applyCheck.applyCheck02}";
		var applyCheck03 = "${applyCheck.applyCheck03}";
		
		if(acadStatCode != '재학' && acadStatCode != '휴학'){ // 재학생01, 휴학생02만 신청 가능
			$("#btnInsert01").prop("disabled", true);
			$("#btnInsert02").prop("disabled", true);
			$("#btnInsert03").prop("disabled", true);
			makeToastr("재학생 또는 휴학생만 이수 변경 신청이 가능합니다.", 100000);
		}
		
		if(courseRecodeCheckCT2 == 'False'){
			$("#btnInsert02").prop("disabled", true); // 복수 전공은 1개만
			makeToastr("현재 복수 전공을 이수하고 있습니다. 복수 전공은 1개 전공 이상 이수할 수 없습니다.", 100000);
		}

		if(courseRecodeCheckCT3 == 'False'){
			$("#btnInsert02").prop("disabled", true); // 부 전공은 1개만
			makeToastr("현재 부 전공을 이수하고 있습니다. 부 전공은 1개 전공 이상 이수할 수 없습니다.", 100000);
		}

		if(applyCheck01 == 'False'){
			$("#btnInsert01").prop("disabled", true); // 신청은 한 번에 한 개씩 
			makeToastr("현재 접수 상태인 전과 신청 내역이 존재합니다.", 100000);
		}

		if(applyCheck02 == 'False'){
			$("#btnInsert02").prop("disabled", true); // 신청은 한 번에 한 개씩 
			makeToastr("현재 접수 상태인 복수 전공 신청 내역이 존재합니다.", 100000);
		}
		
		if(applyCheck03 == 'False'){
			$("#btnInsert03").prop("disabled", true);  // 신청은 한 번에 한 개씩 
			makeToastr("현재 접수 상태인 부 전공 신청 내역이 존재합니다.", 100000);
		}
		
		// 이수 학점 / 등록 학기 기준
		var rgstSem = parseInt($("#rgstSem").text());
		if(credSum < ct1ApplyCred || rgstSem < ct1ApplyCred){
			$("#btnInsert01").prop("disabled", true);  
			makeToastr("전과는 " + ct1ApplySem + "학기 이상 등록, " + ct1ApplyCred + "학점 이상 이수하여야 신청 가능합니다.", 100000);
		}
		if(credSum < ct2ApplyCred || rgstSem < ct2ApplyCred){
			$("#btnInsert02").prop("disabled", true);  
			makeToastr("복수 전공은 " + ct2ApplySem + "학기 이상 등록, " + ct2ApplyCred + "학점 이상 이수하여야 신청 가능합니다.", 100000);
		}
		if(credSum < ct3ApplyCred || rgstSem < ct3ApplyCred){
			$("#btnInsert03").prop("disabled", true);  
			makeToastr("부 전공은 " + ct3ApplySem + "학기 이상 등록, " + ct3ApplyCred + "학점 이상 이수하여야 신청 가능합니다.", 100000);
		}
	}
	
	// **** Toastr 알림 띄우기
	function makeToastr(message, time) {
		toastr.options.positionClass = "toast-bottom-right"
		toastr.options.closeButton = true;
		toastr.options.timeOut = time;
		toastr.info(message)
	}
	
	// 이수 유형 검색 전체 체크박스 선택 시 모든 체크박스에 체크
	function checkAll(obj) { 
		if($(obj).is(":checked") == true){
			$(".courseChngCheck").prop("checked", true);
		}else{
			$(".courseChngCheck").prop("checked", false);
		}
	}
	
	// 수정
	function frmUpdate(courseChngApplyNum) {
		$("#frm").prop("action", "/student/courseChange/courseChangeApplyUpdateView");
		$("#courseChngApplyNum").val(courseChngApplyNum);
		$("#frm").submit();
	}
	
	// 취소
	function frmDelete(courseChngApplyNum) {
		if(!confirm("이수 변경 신청을 취소하시겠습니까?")){
			return;
		}
		$("#courseChngApplyNum").val(courseChngApplyNum);
		$("#frm").submit();
	}

	// 취소
	function frmGiveUp(courseChngApplyNum) {
		if(!confirm("이수 내역을 포기하시겠습니까?")){
			return;
		}
		$("#frm").prop("action", "/student/courseChange/courseChangeApplyGiveUpView");
		$("#courseChngApplyNum").val(courseChngApplyNum);
		$("#frm").submit();
	}
	
	// 이수 변경 유형에 따라 다른 신청 페이지 보여주기
	function courseChangeApplyInsertView(flag) {
		$("#courseChngCode").val(flag);
		$("#insertViewFrm").submit();
	}
	
	// 이수 변경 유형 검색하기
	function courseChngSearch(pageNo) {
		var searchCondition = 'courseChngApplyNum';
		var courseChngCodeList = new Array();
		
		$(".courseChngCheck").each(function(idx, item) { // 체크된 검색 조건만 배열에 담기
			if($(item).is(":checked") == true){ 
				courseChngCodeList.push($(item).val());	
			}				
		});
		
		$.ajax({
			type:"POST"
			,url:"/student/courseChange/courseChangeApplySearch"
			,contentType: "application/json; charset=UTF-8"
			,data: JSON.stringify({'searchCondition' : searchCondition
									, 'courseChngCodeList' : courseChngCodeList 
									, 'pageNo' : pageNo})
			,dataType: "json"
			,success: function(data) {
				console.log(data);
				// 학과 검색 리스트 만들기
				makeTable(data.courseChangeApplyList);
				// 페이징 버튼 만들기
				makePagination(data.paginationInfo);
			}
		});	
	}
	
	// 검색 리스트 만들기
	function makeTable(courseChangeApplyList) {
		$("#td").html(''); // 초기화
		
		var tdHtml = "";
		
		$(courseChangeApplyList).each(function(idx, item) {
			var disauthRsn = ""
			if(item.disauthRsn != null) disauthRsn = item.disauthRsn;
			
			tdHtml += "<tr>" + 
							"<td>" + item.courseChngApplyNum + "</td>" + 
							"<td>" + item.applyDate + "</td>" + 
							"<td>" + item.courseChngCode + "</td>" + 
							"<td>" + item.year + "-" + item.semCode + "</td>" + 
							"<td>" + item.univDeptNum + "</td>" + 
							"<td>" + item.procStatCode + "</td>" + 
							"<td>" + disauthRsn + "</td>" +
							"<td class='text-center'>" +
								"<button type='button' onclick='frmUpdate(" + item.courseChngApplyNum + ");' class='btn btn-info btn-sm'";
			
			if(item.procStatCode != '접수'){
				tdHtml += " disabled ";
			}
			
			tdHtml += ">" + 
						"<i class='fas fa-edit'></i>" +
					"</button>" +
					"</td>" +
					"<td class='text-center'>" +
						"<button type='button' onclick='frmDelete(" + item.courseChngApplyNum + ");' class='btn btn-danger btn-sm'";
			
			if(item.procStatCode != '접수'){
				tdHtml += " disabled ";
			}
			
			tdHtml += ">" +
						"<i class='fas fa-trash-alt'></i>" +
					"</button>" +
					"</td>" + 
					"<td class='text-center'>" +
						"<button type='button' onclick='frmGiveUp(" + item.courseChngApplyNum + ");' class='btn btn-danger btn-sm'";
			
			if(item.procStatCode != '승인'){
				tdHtml += " disabled ";
			}
					
			tdHtml += ">" +
						"<i class='fas fa-eraser'></i>" +
					"</button>" +
					"</td>" + 
					"</tr>";
		});
		
		$("#td").html(tdHtml);
	}
	
	// 검색 페이징 만들기
	function makePagination(paginationInfo) {
		
		$("#paging").html(''); // 초기화
			
		// 이전 버튼 처리
		var preDisabled = "";
		if(paginationInfo.firstPageNoOnPageList <= 5) preDisabled = "disabled"
		var prePageNo = paginationInfo.firstPageNoOnPageList - 5;
		
		// 숫자 버튼 처리
		var pageNoBegin = paginationInfo.firstPageNoOnPageList;
		var pageNoEnd = paginationInfo.lastPageNoOnPageList;

		// 다음 버튼 처리
		var nextDisabled = "";
		if(paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount) nextDisabled = "disabled";
		var nextPageNo = paginationInfo.lastPageNoOnPageList + 1;
		
		// 이전 버튼 html
		var pagingHtml = "<ul class='pagination'>" + 
						    	"<li style='list-style: none;' class='paginate_button page-item previous " + preDisabled +"' >" + 
						    	"<a onclick='courseChngSearch(" + prePageNo + ");' data-dt-idx='0' class='page-link'>이전</a>" + 
						    "</li>";
		// 숫자 버튼 html
		for(var i=pageNoBegin; i<=pageNoEnd; i++){
			
			var active = "";
			if(paginationInfo.currentPageNo == i || (i == 1 && paginationInfo.currentPageNo == null)) active = "active";
			console.log(paginationInfo.currentPageNo + " / " + i + " / " + active);
			
			pagingHtml +=   "<li style='list-style: none;' class='paginate_button page-item " + active + " '>" +
					        	"<a onclick='courseChngSearch("+i+")'  data-dt-idx='"+i+"' class='page-link'>"+i+"</a>" +
					        "</li>";
		}
		
		// 다음 버튼 html
		pagingHtml +=   "<li style='list-style: none;' class='paginate_button page-item next " +nextDisabled+"' >" +
						      "<a onclick='courseChngSearch(" + nextPageNo + ")' data-dt-idx='" + nextPageNo + "' class='page-link'>다음</a>" +
						    "</li>" +
						"</ul>";
		
						
		$("#paging").html(pagingHtml); // html 넣기
	}
</script>













