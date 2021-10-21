<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- 
	학생 전용 결재선은 [상세 보기] 안 됨
	- [상세 보기]는 이미 존재하는 결재 선 데이터를 검색해서 가져오는 거라서.. 
	- 학생 전용 결재선을 가져오려면 memId의 문자열을 파싱해서 member 테이블에서 검색해야 함 
 -->


<style>
	label {
		margin-right: 10px;
	}
	p {
		margin : 0px;
	}
</style>

<div id="body" style="height: 600px;">	

	<div class="card shadow mb-4" style="margin-top:20px;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">결재 선 설정</h6>
		</div>
		
		<div class="card-body">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" >
				
				<!-- 검색 -->
				<div class="row">
					<div class="col-sm-5">
						
					</div>
					<div class="col-sm-5">
						<div class="form-group">
							<select class="form-control" id="searchKeyword">
								<c:forEach items="${codeList}" var="code">
									<option value="${code.codeVal}"
										<c:if test='${param.authDocFormNum == code.codeName}'>selected</c:if>	
									>${code.codeName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="form-group">
							<input type="hidden" id="stdId" value="${stdId}" />
							<button type="button" id="btnSearch" class="btn btn-primary btn-block">검색</button>
						</div>
					</div>
				</div>
				
				<!-- 리스트 -->
				<table class="table" id="dataTable" style="width: 100%;" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
					<colgroup>
						<col width= "130px;">
						<col width= "250px;">
						<col width= "110px;">
						<col width= "110px;">
						<col width= "110px;">
					</colgroup>
					<thead>
						<tr role="row">
							<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">결재 선 번호</th>
							<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">결재 선 이름</th>
							<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">업무 유형</th>
							<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">결재자</th>
							<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1">선택</th>
						</tr>
					</thead>
					<tbody id="tb">
						<tr class="text-center">
							<td colspan="4">결재 선을 검색해주세요</td>
						</tr>
					</tbody>
				</table>
	
				<!-- 버튼 -->
				<div class="row">
					<div class="col-sm-10">
					</div>
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary-crud btn-block" id="btnCancel">취소</button>
					</div>
				</div>
	
			</div>
		</div>
	</div>
	
	<jsp:include page="authStepInfo.jsp"></jsp:include>
	
</div>

<script>

	$(function() {
		
		$("#btnSearch").on("click", function() {
			// 선택한 값 
			var searchKeyword = $("#searchKeyword option:selected").val();
			// 학생 값
			var stdId = $("#stdId").val();
			
			$.ajax({
				type:"POST"
				,url:"/auth/authLineSearch"
				,contentType: "application/json; charset=UTF-8"
				,data: JSON.stringify({'searchCondition' : 'authLineTypeCode'
										, 'searchKeyword' : searchKeyword
										, 'stdId' : stdId })
				,dataType: "json"
				,success: function(data) {
					console.log(data);
					showList(data);
				}
			});	
		});
		
		// 결재 문서에 따라 미리 선택한 검색어로 검색을 실행한다.
		$("#btnSearch").trigger('click');
		
		$("#btnCancel").on("click", function() {
			self.close();
		});
	});
	
	function showList(list) {
		
		var tbHtml = ""
		
		$(list).each(function (idx, item) {
			
			if(item.authLineNum == null) return true; // 학사 결재가 아닌 경우 학생 전용 결재선 생성하지 않음
			
			tbHtml += "<tr class='trClick text-center' id='TR"+ idx +"'> "
				   + "<td>" + item.authLineNum + "</td>"
				   + "<td class='text-left'>" + item.authLineName + "</td>"
				   + "<td>" + item.authLineTypeCode + "</td>"
				   + "<td><button type='button' class='btn btn-info btn-sm' data-toggle='modal' data-target='#authStepInfo' onclick='fn_getAuthStepInfo("+item.authLineNum+")'>상세 정보</button></td>"
				   + "<td><button type='button' class='btn btn-primary btn-sm' onclick='fn_setValue(" + ("TR" + idx) + ")'>선택</button></td>";
		});
		
		$("#tb").html(tbHtml);
	}
	
	function fn_getAuthStepInfo(authLineNum) {
		// 스텝 정보 가져오기
		$.ajax({
			type:"POST"
			,url:"/auth/getAuthStepInfo"
			,contentType: "application/json; charset=UTF-8"
			,data: JSON.stringify({'authLineNum' : authLineNum })
			,dataType: "json"
			,success: function(data) {
				fn_showStep(data);
			}
		});
	}
	
	function fn_showStep(stepList) {
		
		var stepHtml = "";
		
		$(stepList).each(function (idx, item) {
			
			var job = item.deptCode; 
			var dept = item.jobCode;
			
			if(item.memTypeCode != "직원"){
				job = "교수";
				dept = item.univDeptNum;
			}
			
			stepHtml += "<div class='card bg-info text-white shadow'>" 
					 + "<div class='card-body'>"

					 + "<div class='row'>"
					 + "<div class='col-sm-12'>"
					 + "<h5> <label class='badge badge-light'>"+item.sequence+"</label>" 
					 + item.name
					 + "</h5>" 
					 + "</div>"
					 + "</div>"
					 
					 + "<div class='row'>"
					 + "<div class='col-sm-6'>"
					 + "<p> 아이디 : "
					 + item.memId
					 + "</p>" 
					 + "<p> 소속 : "
					 + job
					 + "</p>" 
					 + "<p> 업무 : "
					 + dept
					 + "</p>" 
					 + "</div>"
					 + "<div class='col-sm-6'>"
					 + "<p> 연락처 : "
					 + item.phNum
					 + "</p>" 
					 + "<p> 이메일 : "
					 + item.email
					 + "</p>" 
					 + "</div>"
					 + "</div>"

					 + "</div>"
					 + "</div>";
		});
		$("#stepInfo").html(stepHtml);
	}
	
	
	function fn_setValue(trId) {
		console.log(trId);
		var tdList = $(trId).children();
		opener.document.getElementById("authLineNum").value = tdList[0].innerHTML;
		opener.document.getElementById("authLineNumSpan").innerHTML = tdList[0].innerHTML;
		opener.document.getElementById("authLineName").innerHTML = tdList[1].innerHTML;
		self.close();
	}
</script>