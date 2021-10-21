<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jquery.min.js"></script>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<div class="card-body" style="height: 80px;">
		<form method="get" action="/student/consult/popUp/consultSchedule"
			name="frmSearch" id="frmSearch">
			<input type="date" id="consultAvlDate" name="selSearch" value="consultAvlDate">
			<button type="submit">검색</button>
		</form>
	</div>
	<br /><br />
<div class="row">
	<div class="col-12">
		<div class="card">
			<div class="card-header">
				<h4 class="card-title">상담일정</h4>
			</div>
			<div class="card-body table-responsive p-0">
				<table class="table table-hover text-nowrap" id="sel">
					<thead>
						<tr>
							<td>순번</td>
							<td>상담번호</td>
							<td>상담원</td>
							<td>학과</td>
							<td>상담 일자</td>
							<td>시작 시간</td>
							<td>종료 시간</td>
							<td>잔여석</td>
							<td>정원</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${vo}">
							<tr id="table_sel" onclick="setVal(this);">
								<td>${row.rnum}</td>
								<td id="consultScheduleNum">${row.consultSchdlNum}</td>
								<!-- 숨기기 처리 -->
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
<script type="text/javascript">
//페이징
function linkPage(pageNo) {
	location.href = "/student/consult/popUp/consultSchedule?pageNo=" + pageNo;
}

(function(){
// 	alert("adf");
// 	console.log($(tr).children('td'));
// 	.style.display = 'none';
}());

	function setVal(tr) {
		var tdList = $(tr).children('td');		
 		var capSeat = tdList[7].innerHTML;
 		
 		if(capSeat > 0){
			var consultSchdlNum  = tdList[1].innerHTML;
			var profInformation = tdList[2].innerHTML + "(" + tdList[3].innerHTML + ")";
			var ConsultDate = tdList[4].innerHTML + ":::" +  tdList[5].innerHTML + "~" + tdList[6].innerHTML;
			
			opener.document.getElementById("consultSchdlNum").value = consultSchdlNum;
			opener.document.getElementById("profId").value = profInformation;
			opener.document.getElementById("ConsultDate").value = ConsultDate;
			
			self.close();
 			
 		}else{
 			alert("잔여석이 없으므로 다른 시간을 선택해주시기 바랍니다.");
 			return;
 		}
	}
	$(function(){
// 		$("button").on("click",function(){
// 			console.log($("#consultAvlDate").val());
// 		});
	});
</script>

