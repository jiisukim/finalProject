<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	#docDiv {
		overflow: auto;
	}
</style>

<div id="body">

	<h1 class="h3 mb-2 text-gray-800">결재</h1>
	
	<p class="mb-4">
	</p>
	
	<div class="row">
		<div class="col-sm-8">
			<!-- 결재 문서 -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">결재 문서</h6>
				</div>
				
				<div class="card-body" id="docDiv">
					<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4 text-center" >
						<jsp:include page="${authDocVo.authDocFormPath}">
							<jsp:param name="authDocVo" value="${authDocVo}"/>
							<jsp:param name="applyVo" value="${applyVo}"/>
							<jsp:param name="authDetailInfoVoList" value="${authDetailInfoVoList}"/>
						</jsp:include>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<!-- 결재 정보 및 승인 처리 -->
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">결재</h6>
				</div>
				
				<div class="card-body">
					<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
						<form action="/auth/authDocUpdateForSteps" method="post" id="frm">
							<!-- 결재 진행 -->
							<div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 text-center">
											<div class="custom-control custom-radio">
												<input class="custom-control-input disabledProp" type="radio" value="02" id="procStatCode02" name="procStatCode" 
													<c:if test="${authDocVo.procStatCode=='승인'}">checked</c:if>> 
												<label for="procStatCode02" class="custom-control-label">승인</label> 
											</div>
										</div>
										<div class="col-sm-6 text-center">
											<div class="custom-control custom-radio">
												<input class="custom-control-input disabledProp" type="radio" value="03" id="procStatCode03" name="procStatCode" 
													<c:if test="${authDocVo.procStatCode=='미승인'}">checked</c:if>> 
												<label for="procStatCode03" class="custom-control-label">미승인</label>
											</div>
										</div>
									</div>
								</div>
								
								<div class="form-group" id="disAuthRsn" style="display: none">
									<label>미승인 사유 </label>
									<textarea name="disauthRsn" id="disauthRsn" class="form-control disabledProp" rows="3" onkeyup="checkByte(this)"><c:if test="${authDocVo.disAuthRsn!=''|| authDocVo.disAuthRsn!=null}">${authDocVo.disAuthRsn}</c:if></textarea>
									<span id="nowByte">0</span>/100bytes
								</div>

								<hr>
								<div class="text-right">
<%-- 									<input type="hidden" name="memId" value="${authDocVo.memId}" /> --%>
									<input type="hidden" name="authLineNum" value="${authDocVo.authLineNum}" />
									<input type="hidden" name="authDocNum" value="${authDocVo.authDocNum}"/>
									<input type="hidden" id="checkProcStatCode" value="${authDocVo.procStatCode}" /> 
									<button type="button" id="btnSubmit" class="btn btn-primary btn-primary-crud disabledProp">결재</button>								
									<button type="button" class="btn btn-default btn-default-crud" onclick="location.href='/auth/authDocListForSteps'">
										<c:if test="${authDocVo.procStatCode == '접수'}">
											취소
										</c:if>
										<c:if test="${authDocVo.procStatCode != '접수'}">
											확인
										</c:if>
									</button>								
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 붙임 파일 -->
	<div class="card shadow mb-4">
		<!-- Card Header - Accordion -->
		<a href="#collapseCardExample1" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
			<h6 class="m-0 font-weight-bold text-primary">붙 임</h6>
		</a>
		<!-- Card Content - Collapse -->
		<div class="collapse show" id="collapseCardExample1">
			<div class="card-body">
				<!-- 파일 다운로드 -->
				<c:forEach items="${fileList}" var="getFile">
					<div style="margin-top: 5px;">
						<a href="/fileDownload?filePath=${getFile.filePath}" style="margin-right: 5px;">${getFile.originFileName}</a>
						<input type="hidden" name="fileGrNum" value="${getFile.fileGrNum}"/>
					</div>
				</c:forEach>
				<c:if test="${fileList==null}">붙임 파일이 존재하지 않습니다.</c:if>
			</div>
		</div>
	</div>
	

</div>

<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/ddit.min.js"></script>

<script type="text/javascript">

	$(function() {
		
		if($("#checkProcStatCode").val()!='접수'){
			$(".disabledProp").prop("disabled", true);
		}

		if($("#checkProcStatCode").val()=='미승인'){
			$("#disAuthRsn").css("display", "block");
		}
		
		// 미승인 사유 슬라이드 기능
		$("#procStatCode02").on("click", function() {
			$("#disAuthRsn").slideUp(500);	
		});
		$("#procStatCode03").on("click", function() {
			$("#disAuthRsn").slideDown(500);	
		});
		
		
		// 제출
		$("#btnSubmit").on("click", function () {
			
			if($("input:radio[name='procStatCode']").is(':checked') == false){
				alert("승인 / 미승인 여부를 선택하세요.");
				return;
			}
			
			console.log(">> val " + $("input:radio[name='procStatCode']:checked").val());
			
			var disauthRsn = $("#disauthRsn").val().trim();
			
			// 미승인 사유를 입력하지 않았을 때
			if($("input:radio[name='procStatCode']:checked").val() == '03' 
					&& (disauthRsn == null || disauthRsn == '')){
				alert("미승인 시 미승인 사유를 입력해야 합니다.");
				$("#disauthRsn").focus();
				return;
			}
			
			// 미승인 사유가 500byte를 초과할 떄
			if($("input:radio[name='procStatCode']:checked").val() == '03' 
					&& !validate()){
				alert("미승인 사유는 최대 100Byte까지 입력 가능합니다.");
				$("#disauthRsn").focus();
				return;
			}
			
			if(!confirm("결재하시겠습니까?")){
				return;
			}
			
			$("#frm").submit();
		});
		
		
		
	});
	
	// 미승인 사유 검증
	function checkByte(obj) {
		var maxByte = 100; //최대 100바이트
	    var text_val = obj.value; //입력한 문자
	    var text_len = text_val.length; //입력한 문자수
	    
	    let totalByte=0;
	    for(let i=0; i<text_len; i++){
	    	var each_char = text_val.charAt(i);
	        var uni_char = escape(each_char) //유니코드 형식으로 변환
	        if(uni_char.length>4){
	        	// 한글 : 2Byte
	            totalByte += 2;
	        }else{
	        	// 영문,숫자,특수문자 : 1Byte
	            totalByte += 1;
	        }
	    }
	    
	    if(totalByte>maxByte){
	    	alert('최대 100Byte까지 입력 가능합니다.');
	        	document.getElementById("nowByte").innerText = totalByte;
	            document.getElementById("nowByte").style.color = "red";
	        }else{
	        	document.getElementById("nowByte").innerText = totalByte;
	            document.getElementById("nowByte").style.color = "green";
	        }
	}
	
	function validate() {
		var totalByte = document.getElementById("nowByte").innerText;
		if(totalByte > 100){ // 100자를 넘기면 false
			return false;
		}else {
			return true;
		}
	}
		
</script>
