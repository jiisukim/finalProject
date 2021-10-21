<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery.min.js"></script>

<div class="card shadow">
	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">외박신청</h6>
	</div>
	<div class="card-body">
		<form id="frmSleepOutApp">
			<div style="display:none;">
				<!-- 기숙여부를 알기 위한 정보, 전송은 안함 -->
				<input type="text" id="stdId" <c:if test="${sessionScope.student == '01'}">value="${memberVo.memId}"</c:if>>
				<select id="year"></select>
				<select id="semCode">
					<c:forEach var="code" items="${semCode}">
						<option value="${code.codeVal}">${code.codeName}</option>
					</c:forEach>
				</select>
				<!-- 여기서부터 전송영역 -->
				<input type="text" id="roomIdnNum" name="roomIdnNum">
				<input type="text" id="entrApplyNum" name="entrApplyNum">
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label>신청일자</label><span style="color: red;">*</span>
						<input type="date" class="form-control" id="applyDate" name="applyDate" disabled>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>호실자리</label><span style="color: red;">*</span>
<!-- 						<input class="form-control" id="roomPos" name="roomPos" /> -->
						<select class="form-control" id="roomPos" name="roomPos">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label>출발일자</label><span style="color: red;">*</span>
						<input type="date" class="form-control" id="departDate" name="departDate">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>귀가일자</label><span style="color: red;">*</span>
						<input type="date" class="form-control" id="returnDate" name="returnDate">
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label>행선지</label>
						<input type="text" class="form-control" id="destination" name="destination">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label>긴급연락처</label><span style="color: red;">*</span>
						<input type="text" class="form-control" 
						 placeholder="000-0000-0000" id="emrContact" name="emrContact">
					</div>
				</div>
				<div class="col-sm-8">
					<div class="form-group">
						<label>외박사유</label><span style="color: red;">*</span>
						<input type="text" class="form-control" id="slpOutRsn" name="slpOutRsn">
					</div>
				</div>
			</div>
			<div class="card-footer"
				style="background-color: white; border-top-color: white; float: right; padding-right: 0px;">
				<button type="button" class="btn btn-default"
					style="background-color: white; border-color: gray; width: 120px;"
					onclick="javascript:location.href='/student/dorm/sleepOut/sleepOutApplyList'">목록</button>
				<button type="button" class="btn btn-primary" id="btnApply"
					style="width: 120px;">저장</button>
				<button type="button" class="btn btn-default"
					style="background-color: white; border-color: gray; width: 120px;"
					id="btnCancel">취소</button>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		
		//년도와 학기 값 자동으로 넣어서 disabled
		var now = new Date();
		console.log(now);
		var year = now.getFullYear();
		var yearVal = "";
		yearVal = "<option>" + year + "</option>"
	
		$("#year").html(yearVal);
		
		$("#applyDate").val(now.toISOString().substring(0, 10));
	
		var month = now.getMonth() + 1; //'월'은 0~11까지라서 +1해줘야함
	
		if (month >= 3 && month < 6) { // 1학기
			$("#semCode option:eq(0)").prop("selected", true);
		} else if (month >= 9 && month < 12) { //2학기
			$("#semCode option:eq(1)").prop("selected", true);
		} else if (month >= 6 && month < 9) { //여름학기
			$("#semCode option:eq(2)").prop("selected", true);
		} else { //겨울학기
			$("#semCode option:eq(3)").prop("selected", true);
		}
		
		var stdId =  $("#stdId").val();
		var year = $("#year option:selected").val();
		var semCode = $("#semCode option:selected").val();
		
		var json = {
				"stdId" : stdId,
				"year" : year,
				"semCode" : semCode
		}
		
		//조건 날리면 바로 조회되는 ajax
		$.ajax({
			url : "/student/dorm/sleepOut/sleepOutCondition",
			data : JSON.stringify(json),
			contentType: "application/json; charset=UTF-8", //보낼타입
			dataType : "json", //받을타입
			type : "post",
			success : function(data){
				console.log(data);
				$("#roomIdnNum").val(data.roomIdnNum);
				$("#entrApplyNum").val(data.entrApplyNum);
				
			},
			error : function(xhr){
				alert("생활관 사생이 아닙니다.");
				$(".card-footer > button").not('.card-footer > button:eq(0)').attr('disabled', true);
			}
		});
		
		//출발일자 선택되면 귀가일자 자동 선택
		$("#departDate").on("change", function(){
			console.log($("#departDate").val());
			
			var returnDate = new Date(new Date($("#departDate").val()).getTime() + 24*60*60*1000);	//처음 date객체는 val값이라 스트링임
			console.log(returnDate);
			
			returnDate = returnDate.toISOString().slice(0, 10); 
			
			$("#returnDate").val(returnDate);
			
		});
		
		$("#btnApply").on("click",function(){
			var input = confirm("외박신청을 완료하시겠습니까?");
			
			if(input){
				if($("#departDate").val() == ''){
					alert("출발일자를 선택해주세요.");
					$("#departDate").focus();
					return;
				}else if($("#returnDate").val() == ''){
					alert("귀가일자를 선택해주세요.");
					$("#returnDate").focus();
					return;
				}else if($("#emrContact").val() == ''){
					alert("긴급연락처를 작성해주세요.");
					$("#emrContact").focus();
					return;
				}else if($("#slpOutRsn").val() == ''){
					alert("외박사유를 작성해주세요.");
					$("#slpOutRsn").focus();
					return;
				}
				
				var roomIdnNum = $("#roomIdnNum").val();
				var applyDate = $("#applyDate").val();
				var entrApplyNum = $("#entrApplyNum").val();
				
				var json = {
						"roomIdnNum" : roomIdnNum,
						"applyDate" : applyDate,
						"entrApplyNum" : entrApplyNum
				}
				
				//전송전에 기본키를 보내서 신청내역이 있으면 당일신청 방지(하루에 한번만 신청 가능)
				$.ajax({
					url : "/student/dorm/sleepOut/selectSleepOutApplyYN",
					data : JSON.stringify(json),
					contentType: "application/json; charset=UTF-8", //보낼타입
					dataType : "json", //받을타입
					type : "POST",
					success : function(data){
						console.log(data);
						if(data != null){
							alert("현재 신청내역이 존재합니다. 다음날 다시 신청해주시기바랍니다."); //중복신청 방지
							$(".card-footer > button").not('.card-footer > button:eq(0)').attr('disabled', true);
							
						}
					},
					error : function(xhr){	//신청내역이 없으면 data가 없으므로 신청가능 submit
						$("#applyDate").removeAttr("disabled");
						$("#frmSleepOutApp").attr({
							action : "/student/dorm/sleepOut/sleepOutApplyPost",
							method : "post"
						}).submit();
					}
				});
			}else{
				return;
			}
		});
		
		
		$("#btnCancel").on("click",function(){
			var input = confirm("작성 내역을 취소하시겠습니까? 데이터는 저장되지 않습니다.");
			
			if(input){
				$(location).attr('href','/student/dorm/sleepOut/sleepOutApplyList');
			}else{
				return;
			}
		});
	});
</script>
