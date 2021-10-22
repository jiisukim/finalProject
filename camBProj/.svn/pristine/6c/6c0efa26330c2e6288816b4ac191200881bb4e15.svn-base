<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
th{
	background-color: #F4F5F9;
}
td{
	background-color: white;
}
</style>
<body>
	<div class="card shadow mb-4" style="width: 70%; margin:20px 250px;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/evaluation/lectureEvaluationList'">강의평가</h6>
		</div>
		<div class="card-body">
					<div class="row">
						<div class="col-sm-12">
							<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<tr role="row">
									<th class="sorting sorting_asc" style="text-align:center; width: 10%;" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" >
										교과 번호
									</th>
									<td class="sorting_1" style="width: 10%; text-align:center; ">${lectureOpenVO.subjNum}</td>
									<th class="sorting sorting_asc" style="text-align:center; width: 8%;" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending">
										강의명
									</th>
									<td class="sorting_1" style="width: 20%;">${lectureOpenVO.lectName}</td>
									<th class="sorting sorting_asc" style="text-align:center; width: 10%;" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" >
										담당 교수
									</th>
									<td class="sorting_1" style="width: 10%; text-align:center; ">${lectureOpenVO.profId}</td>
									<th class="sorting sorting_asc" style="text-align:center; width: 20%;" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" >
										평가인원/수업인원
									</th>
									<td class="sorting_1" style="width: 10%; text-align:center; ">${lectureOpenVO.evalCnt}/${lectureOpenVO.stdCnt}</td>
								</tr>	
							</table>
							<br/>
							<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<c:forEach var="lectureEvalItem" items="${lectureEvalItem}" varStatus="stat">
								<tr role="row" >
									<td class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="2" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="vertical-align:middle; text-align: center; width: 6%; font-weight: bold; background-color: #F4F5F9;">
										${lectureEvalItem.evalItemSeq}
									</td>
									<th colspan="10">${lectureEvalItem.evalItemQst}</th>
								</tr>
								<tr style="text-align: center;" id="seq${lectureEvalItem.evalItemSeq}">
									<c:if test="${lectureEvalItem.evalItemCode == '01'}">
										<td style="width: 12%; font-weight: bold;">1. 매우 만족</td>
										<td style="text-align: left;" class="ans1">0명</td>
										<td style="width: 12%; font-weight: bold;">2. 만족</td>
										<td style="text-align: left;" class="ans2">0명</td>
										<td style="width: 12%; font-weight: bold;">3. 보통</td>
										<td style="text-align: left;" class="ans3">0명</td>
										<td style="width: 12%; font-weight: bold;">4. 불만족</td>
										<td style="text-align: left;" class="ans4">0명</td>
										<td style="width: 12%; font-weight: bold;">5. 매우 불만족</td>
										<td style="text-align: left;" class="ans5">0명</td>
									</c:if>
									<c:if test="${lectureEvalItem.evalItemCode == '02'}">
										<td colspan="10" style="text-align: left;" id="shortAnsQues"></td>
									</c:if>
								</tr>
								
								</c:forEach>
							</table>
						</div>
					</div>
					
						<div class="row" style=" float: right;">
							<c:if test="${empty param.pageNo}"> 
	                		    	<button type="button" class="btn btn-secondary" style="width: 120px;" id="btnCancel" onclick="location.href='/professor/evaluation/lectureEvaluationList?pageNo=1&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}&inputStatus=${param.inputStatus}&checkSemester=${param.checkSemester}'">목록</button>
	                		    </c:if>
							<c:if test="${!empty param.pageNo}"> 
	                		    	<button type="button" class="btn btn-secondary" style="width: 120px;" id="btnCancel" onclick="location.href='/professor/evaluation/lectureEvaluationList?pageNo=${param.pageNo}&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}&inputStatus=${param.inputStatus}&checkSemester=${param.checkSemester}'">목록</button>
	               		    </c:if>
							
							&nbsp;&nbsp;
						</div>	
							
			</div>
	</div>

</body>
<script src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	var count = 0;
	<c:forEach var="searchEvalDetail" items="${searchEvalDetail}" varStatus="stat">
		var evalItemSeq  = "${searchEvalDetail.evalItemSeq}";
		var answer  = `${searchEvalDetail.answer}`;
		var countAnswer  = "${searchEvalDetail.countAnswer}";
// 		alert("문제번호 : " + evalItemSeq +"\n 답번호 : " + answer + "\n 해당 답의 개수 :" + countAnswer);
		var evalItemCode= "${searchEvalDetail.evalItemCode}" ;
		if(evalItemCode == "02"){
			if(parseInt(countAnswer) >1){
				for(var i=1; i<=parseInt(countAnswer); i++){
					count++;
					$("#seq"+evalItemSeq+" #shortAnsQues").append(count+". &nbsp;"+answer+"<br/>");		
				}	
			}else{
				count++;
				$("#seq"+evalItemSeq+" #shortAnsQues").append(count+".  &nbsp;"+answer+"<br/>");
			}
		}else{
			$("#seq"+evalItemSeq+" .ans"+answer).text(countAnswer+"명");	
		}
	</c:forEach>




</script>
</html>