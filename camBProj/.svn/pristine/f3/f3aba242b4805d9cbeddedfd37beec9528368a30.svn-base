<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery.min.js"></script>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="card shadow">
	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary" id="cardHeader">상담신청</h6>
	</div>
	<div class="card-body">
		<form action="/student/consult/consultationApply" 
		 enctype="multipart/form-data" method="post" id="insertForm">
		 	<!-- 자동으로 들어가는 데이터, 안보이기 -->
			<div class="row" style="display:none">
				<div class="col-sm-2">
					<div class="form-group"><!-- 학생 아이디 -->
						<input type="text" class="form-control" id="stdId" name="stdId"
							<c:if test="${sessionScope.student == '01'}">value="${memberVo.memId}"</c:if>>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group"><!-- 처리상태 -->
						<select class="form-control" id="procStatCode" name="procStatCode">
							<c:forEach var="code" items="${proSta}">
								<option value="${code.codeVal}">${code.codeName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<!-- 보이는 영역 -->
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담방법</label><span style="color: red;">*</span> <select
							class="form-control" id="consultTypeCode" name="consultTypeCode">
							<c:forEach var="code" items="${conTyp}">
								<option value="${code.codeVal}">${code.codeName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담목적</label><span style="color: red;">*</span> <select
							class="form-control" id="consultGoalCode" name="consultGoalCode">
							<c:forEach var="code" items="${conGoa}">
								<option value="${code.codeVal}">${code.codeName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담동기</label><span style="color: red;">*</span> <select
							class="form-control" id="consultMotiveCode" name="consultMotiveCode">
							<c:forEach var="code" items="${conMot}">
								<option value="${code.codeVal}">${code.codeName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label>상담원</label><span style="color: red;">*</span> <input
							type="hidden" class="form-control" id="consultSchdlNum"
							name="consultSchdlNum"> <input type="text"
							class="form-control" id="profId">
					</div>
				</div>
				<div class="col-sm-2" style="padding-top: 30px;">
					<div class="form-group">
						<button type="button" id="openModalBtn" class="btn btn-default"
							style="border-color: gray; width: 100%;" data-toggle="modal"
							data-target="#exampleModal">예약확인</button> <!-- modal창 -->
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담일시</label><span style="color: red;">*</span> <input
							type="text" class="form-control" id="ConsultDate">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label>상담내용</label><span style="color: red;">*</span>
						<textarea class="form-control" rows="3" id="consultContent"
							name="consultContent"></textarea>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label>상담결과</label>
						<textarea class="form-control" rows="3" id="consultResult"
							name="consultResult" disabled></textarea>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label for="exampleInputFile">첨부파일</label>
						<div class="input-group">
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="fileList"
									name="fileList" multiple> <label
									class="custom-file-label" for="fileList"></label>
							</div>
						</div>
						<div id="setFileName">
							<div style="display: none;">
								<input type="checkbox" id="fileCheck" name="fileCheck">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer"
				style="background-color: white; border-top-color: white; float: right; padding-right: 0px;">
				<button type="button" class="btn btn-primary" id="btnSubmit"
					style="width: 120px;">저장</button>
				<button type="button" class="btn btn-default"
					style="background-color: white; border-color: gray; width: 120px;"
					id="btnCancel">취소</button>
				<button type="button" class="btn btn-default"
					style="background-color: white; border-color: gray; width: 120px;"
					onclick="javascript:location.href='/student/consult/consultationList'">목록</button>
			</div>
		</form>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true" data-backdrop="static">
	<div class="modal-dialog" role="document" style="max-width: 100%; width: auto; display: table;">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">상담일정</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<div class="row" style="margin-top: 20px;">
					<div class="col-12">
						<form id="frmSearch" name="frmSearch">
							<div style="float: right;">
								<div class="form-group" style="display: inline-block;">
									<input type="text" class="form-control"
										id="porfInformation" name="selSearch" placeholder="상담원을 입력해주세요."
										value="${param.selSearch}">
								</div>
								<div style="display: inline-block;">
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
						<div class="card">
							<div class="card-header">
								<h6 class="card-title m-0 font-weight-bold text-primary">상담일정</h6>
							</div>
							<div class="card-body table-responsive p-0">
								<table class="table text-nowrap" id="sel">
									<thead>
										<tr>
											<th>순번</th>
											<th style="display: none;">상담번호</th>
											<th>상담원</th>
											<th>학과</th>
											<th>상담 일자</th>
											<th>시작 시간</th>
											<th>종료 시간</th>
											<th>잔여석</th>
											<th>정원</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${vo}">
											<tr id="table_sel" onclick="setVal(this);" class="trClick">
												<td>${row.rnum}</td>
												<td id="consultScheduleNum" style="display: none;">${row.consultSchdlNum}</td>
												<td>${row.name}</td>
												<td>${row.department}</td>
												<td>${row.consultAvlDate}</td>
												<td>${row.startTime}</td>
												<td>${row.endTime}</td>
												<td>${row.capSeat}</td>
												<td>${row.cap}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div id="paging" class="col-sm-12 text-center">
								<ui:pagination paginationInfo="${paginationInfo}" type="image"
									jsFunction="linkPage" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

	$(function(){
		
		//파일 입력 유무 및 파일 확장자 검사 & 파일 이름 하단에 출력
		$("#fileList").on("change",function(e){
			$("#fileCheck").prop("checked",true);
			fileExtnsImgPdf(e);
		});
		
		//저장버튼
		$("#btnSubmit").on("click",function(){
			if($("#profId").val()==''){
				alert("상담원을 선택해주세요.");
				return;
			}else if($("#consultContent").val()==''){
				alert("상담내용을 입력해주세요.");
				$("#consultContent").focus();
				return;
			}
			
			var result = confirm("상담신청을 완료하시겠습니까?");
			if(result){
				$("#insertForm").submit();
			}else{
				return;
			}
	
		});
		
		//취소버튼
		$("#btnCancel").on("click",function(){
			var input = confirm("작성내역을 취소하시겠습니까? 취소된 데이터는 저장되지 않습니다.");
			
			if(input){
				$(location).attr("href","/student/consult/consultationApply");
			}else{
				return;
			}
		});
		
		//모달 함수
		function closeModal(){
// 			$('#exampleModal').hide();
			$(".modal-dialog").attr("data-dismiss","modal");
		}
		
		modalFunc = closeModal;	//jquery 함수를 javascript함수로 넘기기.
		
		//$('#exampleModal').modal({backdrop: 'static'});	//모달 창 꺼지기 방지

		$("#cardHeader").click(function () {
			$("#consultContent").val("졸업을 압두고 어떤 진로를 선택해야 할지 고민 중입니다. 제 적성에는 어떤 일이 잘 맞을까요?");
		});
		
	});

	//--------------모달 영역----------------
	//페이징
	function linkPage(pageNo) {
		location.href = "/student/consult/consultationApply?pageNo=" + pageNo;
	}	
	
	//선택 해서 부모창으로 넘기기
	function setVal(tr) {
		var tdList = $(tr).children('td');		
 		var capSeat = tdList[7].innerHTML;
 		
 		if(capSeat > 0){
			var consultSchdlNum  = tdList[1].innerHTML;
			var profInformation = tdList[2].innerHTML + "(" + tdList[3].innerHTML + ")";
			var ConsultDate = tdList[4].innerHTML + ":::" +  tdList[5].innerHTML + "~" + tdList[6].innerHTML;
			
			document.getElementById("consultSchdlNum").value = consultSchdlNum;
			document.getElementById("profId").value = profInformation;  
			document.getElementById("ConsultDate").value = ConsultDate; 
			
			modalFunc();	//제이쿼리 hide함수
 			
 		}else{
 			alert("잔여석이 없으므로 다른 시간을 선택해주시기 바랍니다.");
 			return;
 		}
	}
</script>
