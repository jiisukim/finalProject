<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="body"> 

	<div class="card shadow mb-4">
	
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" onclick="fn_setData();">사용자 등록</h6>
		</div>
		
		<div class="card-body">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				
				<form action="/admin/member/insert" method="post" enctype="multipart/form-data" id="memberFrm"><!-- form start -->
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="memTypeCode">회원유형<span style="color: red;">*</span></label>
								<select class="form-control" style="width: 100%;" name="memTypeCode" id="memTypeCode">
									<option value="" selected="selected">유형을 선택하세요</option>
									<option value="01">학생</option>
									<option value="02">교수</option>
									<option value="03">직원</option>
								</select>
							</div>
						</div>
					</div>	
					<div class="row common">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">이름</label>
								<input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요" disabled="disabled">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="resRgstNum">주민등록번호</label>
								<input type="text" class="form-control" name="resRgstNum" id="resRgstNum" placeholder="숫자만 입력하세요" disabled="disabled">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label>성별</label>
								<select class="form-control" style="width: 100%;" name="gen" disabled="disabled">
									<option value="M" selected="selected">남</option>
									<option value="F">여</option>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="phNum">전화번호</label>
								<input type="tel" class="form-control" name="phNum" id="phNum" placeholder="숫자만 입력하세요" disabled="disabled">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="email">이메일</label>
								<input type="email" class="form-control" name="email" id="email" placeholder="이메일을 입력하세요" disabled="disabled">
							</div>
						</div>
					</div>
					
<!-- 			empStart	 -->
					<div class="row selectAdmin" id="selectAdmin">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="deptCode">부서코드</label>
								<select class="form-control" style="width: 100%;" name="deptCode" id="deptCode">
									<option value="" selected="selected">부서를 선택하세요</option>
									<c:forEach var="dept" items="${Dlist}" varStatus="stat">
										<option value="${dept.codeVal}" >${dept.codeName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="jobCode">직무코드</label>
								<select class="form-control" style="width: 100%;" name="jobCode" id="jobCode">
									<option value="" selected="selected">직무를 선택하세요</option>
									<c:forEach var="job" items="${Jlist}" varStatus="stat">
										<option value="${job.codeVal}" >${job.codeName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="apptDateEmp">발령일자</label>
								<input type="date" class="form-control" name="apptDateEmp" id="apptDateEmp" placeholder="">
							</div>
						</div>
					</div>
<!-- 			empEnd	 -->

<!-- 			prfStart	 -->
					<div class="row selectProfessor" id="selectProfessor">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="univDeptNumPrf">학과</label>
								<select class="form-control" style="width: 100%;" name="univDeptNumPrf" id="univDeptNumPrf">
									<option value="" selected="selected">학과를 선택하세요</option>
									<c:forEach var="univDev" items="${Vlist}" varStatus="stat">
										<option value="${univDev.codeVal}" >${univDev.codeName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="apptDatePrf">발령일자</label>
								<input type="date" class="form-control" name="apptDatePrf" id="apptDatePrf" placeholder="">
							</div>
						</div>
					</div>
<!-- 			prfEnd	 -->

<!-- 			stdStart	 -->
					<div class="row selectStudent" id="selectStudent">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="admDate">입학 일자</label>
								<input type="date" class="form-control" name="admDate" id="admDate" />
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="univDeptNumStd">학과</label>
								<select class="form-control" style="width: 100%;" name="univDeptNumStd" id="univDeptNumStd">
									<option value="" selected="selected">학과를 선택하세요</option>
									<c:forEach var="univDev" items="${Vlist}" varStatus="stat">
										<option value="${univDev.codeVal}" >${univDev.codeName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for=" advProf">지도교수</label>
								<select class="form-control" style="width: 100%;" name="advProf" id="advProf" disabled="disabled">
									<option value="">지도교수를 선택하세요</option>
								</select>
							</div>
						</div>
					</div>
<!-- 			stdEnd	 -->
					

					<hr>
					
					<div class="row">
						<div class="col-sm-12 text-right">
							<button type="button" class="btn btn-primary" id="btnSubmit" style="width: 120px;">등록</button>
							<button type="button" class="btn btn-default" onclick="location.href='/admin/member/list'"
								style="background-color: white; border-color: gray; width: 120px;">취소</button>
						</div>
					</div>
							
				</form><!-- // form end -->
						
			</div>
		</div>
		
	</div>

</div>	

<script type="text/javascript">

$(document).ready(function() {
	
		
		$('.selectAdmin').hide();
	    $('.selectProfessor').hide();
	    $('.selectStudent').hide();
	    
	    
	  $('#memTypeCode').change(function() {
		  
    	$('.form-control').attr("disabled", false);
		$('#advProf').attr("disabled", true);
		    
	    var result = $('#memTypeCode option:selected').val();
	    if (result == '03') {
	      $('.selectAdmin').show();
	      $('.selectProfessor').hide();
	      $('.selectStudent').hide();
	    } else if (result == '02'){
	      $('.selectAdmin').hide();
	      $('.selectProfessor').show();
	      $('.selectStudent').hide();
	    } else{
	      $('.selectAdmin').hide();
	      $('.selectProfessor').hide();
	      $('.selectStudent').show();
	    }
	    
	  });//end memTypeCode
	  
// 	  $("#admDate").daterangepicker();

	  
	  $('#univDeptNumStd').on("change",function() {
		  
		  var codeVal = $('#univDeptNumStd').val();
		  
		  $.ajax({
				type: "post", //요청 메소드 방식
				url:"/admin/member/selectAdvProf",
				data : {codeVal: codeVal},
				dataType:"json", //서버가 요청 URL을 통해서 응답하는 내용의 타입
				success : function(result){
					// 컨트롤로에서 받아온 데이터는 result 에 담겼습니다. 
					//result 는 임의로 변경해서 써도 됩니다. 
					// result 는 json 형태의 데이가로 담겨 있습니다.
					//  우선 alert(result); 나 로그로 데이터를 가져오는지 확인 합니다.
					console.log("result : " + result);
					
					$('#advProf').attr("disabled", false);
					
					var str = "";
					for(var i=0 in result){
						str +="<option value="+result[i].memId+" >"+result[i].name+"</option>";
                     }    
					
					$('#advProf').append(str);
				},
				error : function(xhr, status, error){
					//통신 실패시 발생하는 함수(콜백)
					console.log("xhr:"+xhr+", status:"+ status + ", error:"+error);
				}
			});
		  
		  
	  });//univDeptNum
	  
	  
	  $("#btnSubmit").click(function() {
			
			if($("#name").val()==""){
				alert("이름을 입력하세요.");
				$("#name").focus();
				return;
			}
			if($("#resRgstNum").val()==""){
				alert("주민등록번호를 입력하세요.");
				$("#resRgstNum").focus();
				return;
			}
			if($("#phNum").val()==""){
				alert("연락처를 입력하세요.");
				$("#phNum").focus();
				return;
			}
			
			
			$("#memberFrm").submit();
		});//end btnSubmit
	  
	  
	}); 
	
	function fn_setData() {
		$("[name='name']").val("정수지");
		$("[name='resRgstNum']").val("9004062154785");
		$("[name='gen']").val("F").prop("selected", true);
		$("[name='phNum']").val("01078945555");
		$("[name='email']").val("camb.camb.test@gmail.com");
		$("#univDeptNumPrf").val("11").prop("selected", true);
		$("#apptDatePrf").val("2021-10-21");
	}
	
</script>
