<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="\resources\js\jquery.min.js"></script>
<style>
	#title{
		font-size: large;
		font-weight: bolder;
		
	}
	#modDate, #memId{
		font-size: small;
		font-weight: bolder;
	} 
	th{
		font-size: small;
		margin-left: 30px;
	}

</style>
<body>
	<div class="card shadow mb-4" style="width: 100%;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">학과공지 세부</h6>
		</div>
		<div class="card-body">
		<form action="/common/deptNotice/deptNoticeDetail" method="post" id="faqFrm" enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-12">
			<table class="table" id="dataTable" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<tr>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 100px; text-align: center; border-right: hidden;">
										<p style="position: relative; top: 10px;">제목<p>
									</th>
									<td id="title" class="tdWhite" colspan="4">${dv.title}</td>
								</tr>
								<tr role="row">
									<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 50px; text-align: center;">
										작성자
									</th>
									<td id="memId" class="tdWhite" style="width: 40%">${dv.name} - (${dv.empId})</td>
									<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 100px; text-align: center;">
										최종 수정일
									</th>
										<td id="modDate" class="tdWhite" colspan="4" ><fmt:formatDate pattern="yyyy-MM-dd" value="${dv.modDate}"/></td>
								</tr>
								<tr class="even">

									<td colspan="4" id="content" class="tdWhite" style="height: 380px">${dv.content}<br>
									<c:forEach items="${fileList}" var="getFile">
 										<img src="<c:url value='/${getFile.filePath}'/>">	
									</c:forEach>
									</td> 
								</tr>
								<tr>
									<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 50px; text-align: center;">
										첨부 파일
									</th>
								
									<td colspan="3" class="tdWhite">
										<div class="row">
											<div class="col-sm-12">
												<div class="form-group">
													<div id="setFileName">
														<c:forEach items="${fileList}" var="getFile">
															<div style="margin-top: 5px;">
																<!-- 파일 다운로드 참고용 (수정 페이지에서는 원래 다운로드 기능 쓰지 않음) -->
																 <span style="color: red;">*</span> <a href="/fileDownload?filePath=${getFile.filePath}" style="margin-right: 5px;">${getFile.originFileName}</a>
																<input type="hidden" name="fileGrNum" value="${getFile.fileGrNum}"/>
															</div>
														</c:forEach>
													</div>
													<!-- 파일이 들어왔는지 확인 -->
													<div style="display: none;">
									                    <input type="checkbox" name="fileCheck" id="fileCheck">
								                    </div>
												</div>
											</div>
										</div>
									</td>
								</tr> 
							</table>
							
						</div>
						
					</div>
					&nbsp;&nbsp;&nbsp;	
						<div class="row" style=" float: right; ">
	
						<c:if test="${sessionScope.admin == '03'}">
						<a href="/common/deptNotice/deptNoticeUpdate?artcNum=${dv.artcNum}"><button type="button" class="btn btn-default"
						style="background-color: white; border-color: gray; width: 120px;">수정 </button></a>
                        &nbsp;&nbsp;&nbsp;
                     
                     
							<button type="button" id="btnDelete" class="btn btn-primary" style="width:120px;">삭제</button>
                   
							&nbsp;&nbsp;&nbsp;
							
                        </c:if>
                        <a href="/common/deptNotice/deptNoticeList"><button type="button" class="btn btn-default"
						style="background-color: white; border-color: gray; width: 120px;">목록 </button></a>
						
						</div>			
					</form>	
				   
				   <form method="post" action="/deptNoticeDelete" id="frmDelete" name="frmDelete">
				   <div>
	              	<input type="hidden" name="artcNum" value="${dv.artcNum}" />
				   </div>
	              </form>
		
	     
			</div>
	</div>
	
	<script type="text/javascript">
	$(function() {
		$("#fileList").on("change", function(e) {
			$("#fileCheck").prop("checked", true);
			fileExtnsImgPdf(e); // 확장자 검사 & 파일 이름 출력
		});
		
		//삭제 버튼 클릭 후 고객 정보 삭제 처리
		$("#btnDelete").on("click",function(){
			var input = confirm("삭제하시겠습니까?");
			
			if(input){//true
				$("#frmDelete").submit();
			}else{//false
				return;
			}
		});		
	});
		

	</script>

</body>
</html>