<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="\resources\js\jquery.min.js"></script>
<body>
	<div class="card shadow mb-4" style="width: 55%; margin:70px 300px;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">FAQ 수정</h6>
		</div>
		<div class="card-body">
		<form action="/common/faq/faqUpdate" method="post" id="faqFrm" enctype="multipart/form-data">
					<input name="artcNum" type="hidden" value="${fv.artcNum}">
				<div class="row">
					<div class="col-sm-12">  
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<tr role="row">
								<th class="sorting sorting_asc" tabindex="0"
									aria-controls="dataTable" rowspan="1" colspan="1"
									aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 50px;">작성자</th>
								<td class="sorting_1"><input type="text" id="empId"
									name="empId" value="${fv.empId}" readonly="readonly"></td>
							</tr>
							<tr>
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 100px;">제목</th>
								<td><input type="text" id="title" name="title"
									value="${fv.title}"></td>
							</tr>
							<tr class="even">
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 60px; height: 190px;">내용</th>
							<td>
								<textarea rows="6" cols="75" id="content" name="content">${fv.content}</textarea>
							</td>
							</tr>
							<tr class="even">
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 60px;">분류</th>
								<td><input type="text" id="faqKwdCode" name="faqKwdCode"
									value="${fv.faqKwdCode}"></td>
							</tr>
							<tr class="even">
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 60px;">첨부파일</th>
								<td>
									<input type="file" class="custom-file-input" id="fileList" name="fileList" multiple> 
								</td>
							</tr>
							<tr class="odd">
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 30px;">수정일</th>
								<td><input type="date" id="writeDate" name="writeDate"
									value="${fv.writeDate}"></td>
							</tr>
						</table>
					</div>

				</div>
				&nbsp;&nbsp;&nbsp;
				<div class="row" style="float: right;">

					<a href="#" class="btn btn-secondary btn-icon-split"> <span
						class="text" onclick="javascript:history.go(-1)">뒤로가기</span>
					</a> &nbsp;&nbsp;&nbsp;
					<button type="submit" id="btnUpdate" style="width: 70px; height: 40px; color: white; background-color: #5175df; border-radius: 30px; border: 1px;">등록</button>
				</div>

			</form>
		</div>
	</div>

	<script type="text/javascript">
	$(function() {
	
		$("#btnUpdate").on("click",function(){
			var input = confirm("수정하시겠습니까?");
			if(input == ""){
				return false;
			}
			if(input){//true
				$("#faqFrm").submit();

			}else{//false
				return;
			}
		});		
	});

	</script>

</body>
</html>