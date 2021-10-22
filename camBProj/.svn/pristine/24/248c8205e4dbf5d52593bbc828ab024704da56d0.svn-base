<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<script src="\resources\js\jquery.min.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
    textarea{
		resize: none;
}

	#title{
		font-size: large;
		font-weight: bolder;

		
	}
	#writeDate, #memId{
		font-size: small;
		font-weight: bolder;
	} 
	#title,#writeDate, #memId, #contentE{
		background-color: white;
		border: none;
		position: relative;top: 4px;
	}
	th{
		font-size: small;
		margin-left: 30px;
	}

</style>


<body>

<c:choose>
<c:when test="${sessionScope.admin == '03' or iv.memId == memberVo.memId}">
<div class="card shadow mb-4" style="width: 55%; float: left;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">내 문의</h6>
		</div>
		<div class="card-body">
			<form action="/common/inquiry/inquiryUpdate" method="post"
				id="updateForm" enctype="multipart/form-data">
				<div class="row">
					<div class="col-sm-12">
						<table class="table" id="dataTable"  cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<tr role="row">
							<tr>
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 100px;"><p style="margin-top: 6px;">제목</p>
								</th>
								<td class="tdWhite">
									<input name="title" id="title" class="oh" type="text" value="${iv.title}" style="width: 99%;" maxlength="50">
								</td>
							</tr>
							<tr>
								<th class="sorting sorting_asc" tabindex="0"
									aria-controls="dataTable" rowspan="1" colspan="1"
									aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 100px;"><p style="margin-top: 6px;">작성자</p>
								</th>
								<td class="tdWhite">
									<input name="memId" id="memId" class="oh" type="text" value="${iv.memId}" style="width: 99%; border: none;" readonly="readonly">
								</td>
							</tr>
							<tr class="even">
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 60px; height: 500px;"><p style="margin-top: 10px;">질문내용</p></th>
								<td colspan="4" class="tdWhite">
									<textarea style="width: 99%;height: 500px" class="oh" id="contentE" name="content" maxlength="1000">${iv.content}</textarea>
								</td>
							</tr>
							<tr>	
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 100px;"><p style="margin-top: 6px;">첨부파일</p>
								</th>
									<td colspan="3" class="tdWhite">
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
									</td>
							</tr>	
						</table>
					</div>
				</div>
				<div class="card-footer" id="updateAndDeleteArea" style="background-color: white; border-top-color: white; float: right; padding-right: 0px;">
					<c:if test="${sessionScope.student == '01'}">
					<button type="button" class="btn btn-default" id="btnUpdate" style="background-color: white; border-color: gray; width: 120px;">수정</button>
					<button type="button" class="btn btn-primary" style="width: 120px;" id="btnDelete">삭제</button>
					</c:if>
					<button type="button" class="btn btn-default btn-primary-crud" style="border-color: gray; width: 120px;" onclick="javascript:location.href='/common/inquiry/inquiryList';">목록</button>
				</div>

				<div class="card-footer" id="updateArea"
					style="background-color: white; border-top-color: white; float: right; padding-right: 0px; display: none;">
					<button type="button" class="btn btn-default" id="btnSubmit" style="width: 120px; border-color: gray;">저장</button>
					<button type="button" class="btn btn-primary btn-primary-crud" style="width: 120px;" onclick="javascript:location.href='/common/inquiry/inquiryList';">목록</button>
					<button type="reset" class="btn btn-default" style="background-color: white; border-color: gray; width: 120px;" id="btnCancel">취소</button>
				</div>
				<div>
					<input type="hidden" name="artcNum" value="${iv.artcNum}" />
				</div>
			</form>
		</div>
	</div>

	<!-- 댓글 창  -->
	<div class="card shadow mb-8" style="width: 43%; position: relative; left: 30px;">
		<div class="card-header py-3"> 
			<h6 class="m-0 font-weight-bold text-primary" id="cardHeader">답변</h6>
		</div>

		<div class="card-body">

			<div id="replyInsertDiv">
				<form action="/common/reply/replyInsert" method="post" id="replyForm">
					
					
					<div id="emptyCheck">		
						<div id="test" style="height: auto;">
							
						<p>답변등록이 완료되지 않았습니다.</p>
					<br>
						</div>
					</div>
					<c:if test="${sessionScope.admin == '03'}">
					<br>
						<textarea rows="2" cols="10" name="replyComment" id="replyComment" style="border: 1px solid gray; width: 100%"></textarea>
						
						<h6 id="checkNull" style="font-size: small; display: inline-block;">작성자: ${memberVo.name}(${memberVo.memId})</h6>
					<button type="button" class="btn btn-primary" id="replyInsert"
						style="width: 120px; float: right; position: relative; top: 10px;">등록</button>

					</c:if>

				</form>
				</div>
			</div>
		</div>
		</c:when>
		<c:otherwise> 
		<script type="text/javascript">alert("접근이 불가합니다.");history.back();
		</script>
		</c:otherwise>
 		</c:choose>

	<script type="text/javascript">

	$(function() {
			
			var memId ="${iv.memId}"; //회원 ID 
			var oriNum = "${iv.artcNum}"; //글 번호
			var name = "${iv.name}";	//이름
			var writeDate ="${iv.writeDate};" //날짜
			
			
			json2 = {
					"oriNum" : oriNum,
					"memId" : memId,
					"name" : name,
					"writeDate" : writeDate		
			}
			
			$.ajax({
				url: "/common/reply/replyList", 
				type: "POST",
				data : JSON.stringify(json2),
				dataType : "json",
				async: false,
				contentType: "application/json; charset=UTF-8", //보낼타입
				success : function(result) {
					temp(result);
				}
					
			});
			

			$('.oh').attr("disabled", true);

			//수정 버튼

			$("#btnUpdate").on("click", function() {
				 CKEDITOR.replace('contentE',{
				    	height: 360
				    });

				$("#updateAndDeleteArea").css("display", "none");
				$("#updateArea").css("display", "block");
				$("#memId").attr("disabled", false);
				$('.oh').attr("disabled", false);
				$("#writeDate").attr("type", "date");

			});
			
			//삭제 버튼
			$("#btnDelete").on("click", function() {
				var replyComment =  $("#test").text();
				
								var result = confirm("삭제 하시겠습니까?");
								if(result){
										if((replyComment.length)){
											alert("답변이 등록되어 삭제할 수 없습니다.");
										return;
									} 
									if (result) {
										$(location).attr('href','/common/inquiry/inquiryDelete?artcNum=${iv.artcNum}');
									} else {
										return;
									}	
								}
					 			
								
							});
			//취소 버튼
			$("#btnCancel").on("click", function() {
								var result = confirm("취소 하시겠습니까?");
								if (result) {
									$(location)
											.attr('href',
													'/common/inquiry/inquiryDetail?artcNum=${iv.artcNum}');
								} else {
									return;
								}
							});

			//저장 버튼
			$("#btnSubmit").on("click", function() {
				
				var input = confirm("수정하시겠습니까?");
				if (input == "") {
					return false;
				} else if (input) {//true
					$("#updateForm").submit();
				}

			});


		$("#replyInsert").on("click", function() {
						
 			var memId ="${memberVo.memId}"; //회원 ID 
			var oriNum = "${iv.artcNum}"; //글 번호
			var replyComment = $("#replyComment").val(); //댓글
			var name = "${iv.name}";
			var writeDate = "${iv.writeDate}"
			
			json = {
					"replyComment" : replyComment,
					"oriNum" : oriNum,
					"memId" : memId,
					"writeDate" : writeDate,
					"name" : name
					}						
			
			$.ajax({
				
				url: "/common/reply/replyInsert", 
				type: "POST",
				data : JSON.stringify(json),
				dataType : "json",
				contentType: "application/json; charset=UTF-8", //보낼타입
				success : function(result) {
					 $("#replyComment").val("");
					console.log(result);
					
					json2 = {
							"oriNum" : oriNum,
							"memId" : memId,
							"name" : name,
							"writeDate" : writeDate				
					}
					
					$.ajax({
						url: "/common/reply/replyList", 
						type: "POST",
						data : JSON.stringify(json2),
						dataType : "json",
						contentType: "application/json; charset=UTF-8", //보낼타입
						success : function(result) {
							console.log(result);
							
							temp(result);
								
						}
							
					});
					
					
				},
				error : function() {
					console.log("ajax 통신 실패");
				}
			}); 
			
		
	 });
		
		$(".replyDel").on("click",function(){

			var artcNum = $(this).next().val();
			console.log(artcNum);
				var deleteResult = confirm("삭제 하시겠습니까?");
				
				if(deleteResult){
					
			var data ={"artcNum":artcNum};
 			$.ajax({
				type:"POST"
				,url:"/common/reply/replyDelete"
				,data:JSON.stringify(data)	//보내는 값
				,dataType : "json"
				,contentType:"application/json; charset=UTF-8"
				,cache : false
				,success:function(data){
					
					console.log(data);
					
					parent.location.reload();
				}
			}); 					
				}else{			
				}
		});		
		
		// 자동 값 입력	      
	    $("#cardHeader").click(function () {
			$("#replyComment").val('안녕하세요. 2학기 이상 등록, 30학점 이상 학점 이수하여야 전과 신청이 가능합니다. 좋은 결과 있길 바랍니다.')
		});
		
	});

	function temp(list){
		if((list.length == 0)){
			
		}else{
			var opts = '';
			
			$(list).each(function(idx, item){
				
				opts += "<div style='color: gray'>" + item.name + " - (" + item.memId + ")" +"<br><br>" +  item.replyComment  + "<input type='hidden' value=" + item.oriNum + "><c:if test="${sessionScope.admin == '03'}"><button class='replyDel' type='button' value='${item.artcNum}' style='float: right; background-color:white; border:none;'>❌ </button></c:if><input type='hidden' value=" +item.artcNum +"></div><hr>" ;
			});
			
			$("#test").html(opts);
		}
	}
	
	</script>
</body>
</html>