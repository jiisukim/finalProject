<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
	p {
		margin: 0px;
	}
</style>   


<div id="body">
	
	<p class="mb-4">
	</p>
	
	<div class="card shadow mb-4">
	
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">전과 포기 신청</h6>
		</div>
		
		<div class="card-body">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">

				<form action="/student/courseChange/courseChangeApplyUpdate" id="frm" name="frm"  method="post" enctype="multipart/form-data"><!-- form start -->
					
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="stdId">학번</label>
								<input type="text" class="form-control" name="stdId" id="stdId" value="${sessionScope.memberVo.memId}" readonly>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label>이름</label>
								<input type="text" class="form-control" value="${sessionScope.memberVo.name}" readonly>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label>전공</label>
								<input type="text" class="form-control" value="${studentVo.univDeptNum}" readonly>
							</div>
						</div>
						<div class="col-sm-3">
							<div>
								<label for="input4">학년</label>
								<input type="text" class="form-control" value="${studentVo.grade}" readonly>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-8">
							<div class="form-group">
								<label>주소</label>
								<input type="text" class="form-control" value="${sessionScope.memberVo.addr} ${sessionScope.memberVo.addrDetail} [${sessionScope.memberVo.zipcode}]" readonly>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label>전화 번호</label>
								<input type="text" class="form-control" value="${studentVo.phNum}" readonly>
							</div>
						</div>
					</div>
					
					<hr>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label>기준 학기</label>
								<input type="text" class="form-control" id="semInfo" value="${courseChangeVo.year} - ${courseChangeVo.semCode} 학기" readonly/>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label>학과</label>
								<input type="text" class="form-control bg-light border-0 small" name="korName" id="korName" value="${courseChangeVo.korName}" onclick="univDeptSearch();" readonly/>
								<input type="hidden" name="univDeptNum" id="univDeptNum" value="${courseChangeVo.univDeptNum}" />
							</div>
						</div>
					</div>
					
					<input type="hidden" name="procStatCode" value="01"/>
					
					<hr>
					
					<div class="row">
						<div class="col-sm-12 text-right">
							<!-- 중복 방지용 토큰 -->
							<input type="hidden" name="saveToken" value="${courseChangeVo.saveToken}"/>
							<!-- 포워드 용 페이지 번호 -->
							<input type="hidden" name="pageNo" value="${courseChangeVo.pageNo}"/>
							<!-- 신청 번호 -->
							<input type="hidden" name="courseChngApplyNum" value="${courseChangeVo.courseChngApplyNum}" />
							<!-- 신청 유형 -->
							<input type="hidden" name="courseChngCode" value="${courseChangeVo.courseChngCode}"/>
							<button type="button" class="btn btn-primary btn-primary-crud" id="btnSubmit">신청</button>
							<button type="button" class="btn btn-default btn-default-crud" onclick="location.href='/student/courseChange/courseChangeApplyList'">목록</button>
						</div>
					</div>
							
				</form><!-- // form end -->
						
			</div>
		</div>
		
	</div>

	<div class="row">
		<div class="col-sm-12">
			<div class="card shadow mb-4">
				<!-- Card Header - Accordion -->
				<a href="#collapseCardExample1" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
					<h6 class="m-0 font-weight-bold text-primary">전과 포기 안내</h6>
				</a>
				<!-- Card Content - Collapse -->
				<div class="collapse show" id="collapseCardExample1" style="">
					<div class="card-body">
						<p>  ◦ 포기기간 이후에는 합격포기 불가(원 소속학과로 복귀할 수 없음)</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
	
<script type="text/javascript">
	$(function() {
		
		$("#btnSubmit").on("click", function() { // 신청
			if(!confirm("전과를 포기하시겠습니까?")){
				return;
			}
			$("#frm").submit();
		});
		
	});
	
</script>