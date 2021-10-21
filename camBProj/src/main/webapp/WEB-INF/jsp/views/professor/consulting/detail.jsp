<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery.min.js"></script>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="card card-warning">
	<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/consulting/list'">학생 상담일정</h6>
		</div>
	<div class="card-body">
		<form action="/professor/consulting/update" method="post" id="consultUpdate" name="consultUpdate">
			<input type="hidden" id="pageNo" name="pageNo" value="${param.pageNo}">
			<input type="hidden" id="startDate" name="startDate" value="${param.startDate}">
			<input type="hidden" id="endDate" name="endDate" value="${param.endDate}">
			<input type="hidden" id="inputStatus" name="inputStatus" value="${param.inputStatus}">
			<!-- 보이는 영역 -->
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label id="setValue">상담방법</label><span style="color: red;">*</span> <select
							class="form-control studentArea" id="consultTypeCode" name="consultTypeCode" disabled="disabled">
								<option value="${consultVO.consultTypeCode}">${consultVO.consultTypeCode}</option>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담목적</label><span style="color: red;">*</span> <select disabled="disabled"
							class="form-control studentArea" id="consultGoalCode" name="consultGoalCode">
							<option>${consultVO.consultGoalCode}</option>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담동기</label><span style="color: red;">*</span> <select disabled="disabled"
							class="form-control studentArea" id="consultMotiveCode"
							name="consultMotiveCode">
							<option>${consultVO.consultMotiveCode}</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label>학번</label>
						<input type="text" class="form-control studentArea" id="" value="${consultVO.stdId }" disabled="disabled">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>학생 이름</label>
						<input type="text" class="form-control studentArea" id="" value="${consultVO.stdName }" disabled="disabled">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>학과</label>
						<input type="text" class="form-control studentArea" id="" value="${consultVO.stdUnivDeptNum }" disabled="disabled">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-8">
					<div class="form-group">
						<label>상담원</label><span style="color: red;">*</span> 
						<input type="text" class="form-control studentArea" id="profId" value="${consultVO.profName}(${consultVO.univDeptNum})" disabled="disabled">
					</div>
				</div>
				
				<div class="col-sm-4">
					<div class="form-group">
						<label>상담일시</label><span style="color: red;">*</span> 
						<input type="text" class="form-control studentArea" id="ConsultDate" value="${fn:substring(consultVO.consultAvlDate,0,10)} / ${consultVO.startTime} ~ ${consultVO.endTime}" disabled="disabled">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label>상담내용</label><span style="color: red;">*</span>
						<textarea class="form-control studentArea" disabled="disabled"  rows="3" id="consultContent" name="consultContent" style="resize: none;">${consultVO.consultContent}</textarea>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
				
				<input type="hidden" id="consultNum" name="consultNum" value="${consultVO.consultNum}">
					<div class="form-group">
						<label>상담결과</label>
						<textarea class="form-control" rows="3" id="consultResult" name="consultResult" disabled style="resize: none;">${consultVO.consultResult}</textarea>
					</div>
				
				</div>
			</div>
			<div class="card-footer" id="updateAndDeleteArea" style="background-color: white; border-top-color: white; float: right; padding-right: 0px;">
				<button type="button" class="btn btn-primary" id="btnUpdate" style="width: 120px;">수정</button>
				<button type="button" class="btn btn-default" style="background-color: white; border-color: gray; width: 120px;"
					onclick="javasciprt:location.href='/professor/consulting/list?pageNo=${param.pageNo}&startDate=${param.startDate}&endDate=${param.endDate}&inputStatus=${param.inputStatus}'">목록</button>
			</div>
			<div class="card-footer" id="updateArea" style="background-color: white; border-top-color: white; float: right; padding-right: 0px; display: none;">
				<button type="button" class="btn btn-primary" id="btnSubmit" style="width: 120px;">저장</button>
				<button type="button" class="btn btn-default" style="background-color: white; border-color: gray; width: 120px;" id="btnCancel">취소</button>
			</div>
			
		</form>
	</div>
</div>
<script src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#btnUpdate").on("click",function(){
			//입력란의 읽기전용을 해제
			//버튼 영역 처리
			$("#updateAndDeleteArea").css("display","none");	//확인 취소
			$("#updateArea").css("display","block");		//수정 삭제 목록

			$("#consultResult").prop("disabled",false);

			
		});
		$("#btnCancel").on("click",function(){
			//입력란의 읽기전용을 해제
			//버튼 영역 처리
			$("#updateAndDeleteArea").css("display","block");	//확인 취소
			$("#updateArea").css("display","none");		//수정 삭제 목록
			
			$("#consultResult").val("");
			$("#consultResult").prop("disabled",true);
			
		});
		
		$("#btnSubmit").on("click",function(){
			$("#consultUpdate").submit();
		});
		
		
		$("#setValue").click(function () {
			$("#consultResult").val("김학생이 소질 있는 분야를 설명해주고 응원해주었습니다. 추후 어려운 일이 있으면 언제든 연락해도 좋습니다.");
		});
	})
</script>
</body>
</html>