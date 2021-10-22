<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	.table th, .table td {
		font-size: 0.8em;
    	padding: 0.2rem;
    }
    .innerTb {
    	margin-bottom: 10px;
    	width: 100%; 
    }
    .innerTb th, .innerTb td {
    	font-size: 0.6em;
    	text-align: center;
    }
    .innerTb th {
    	background-color: #F0F0F0;
		color: #505050;
    }
    .alignTB td, .alignTB th {
    	text-align : center;
  		vertical-align : middle;
    }
    .badge {
    	margin: 0px;
    }
</style>

<div id="body">

	<div class="modal fade bd-example-modal-xl" id="scoreDetail" role="dialog"  data-backdrop="static"> <!-- 사용자 지정 부분① : id명 -->
	    <div class="modal-dialog modal-xl">
	      <!-- Modal content-->
	      	<div class="modal-content" style="border-radius:20px 20px 8px 8px !important;">
				
				<div class="modal-header" style="background-color: #364085; border-radius: 8px 8px 0px 0px !important;">
					<p class="modal-title" style="color: white; font-weight: bold;">성적 일람표</p>
					<button type="button" class="close" data-dismiss="modal" style="color: white;">×</button>
				</div>
				
				<div class="modal-body">
					<div>
						<table class="table table-bordered">
							<colgroup>
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
							</colgroup>
							<thead>
								<tr>
									<th>학 번</th>
									<th>성 명</th>
									<th>학 과</th>
									<th>지도 교수</th>
									<th>봉사 시간</th>
								</tr>
							</thead>
							<tbody>
								<tr class="text-center">
									<td>
										${memInfo.memId}
									</td>
									<td>${memberVo.name}</td>
									<td>${memInfo.stdUnivDeptNum}</td>
									<td>${memInfo.advProf}</td>
									<td>${volTime.volRecogTimeSum} / ${volTime.volTimeCrt} 시간</td>
								</tr>
							</tbody>
							<thead>
								<tr>
									<th>주전공 이수학점</th>
									<th>복수전공 이수 학점</th>
									<th>부전공 이수학점</th>
									<th>교양 이수학점</th>
									<th>전학기 학점 / 평점</th>
								</tr>
							</thead>
							<tbody>
								<tr class="text-center">
									<td>
										${stdAcadInfo.ct1UnivDeptName} : ${stdAcadInfo.ct1Cred} / ${stdAcadInfo.ct1GrdtnCred} 학점
									</td>
									<td>
										<c:if test="${stdAcadInfo.ct2UnivDeptName == null}">
											복수전공 이수 내역이 없습니다
										</c:if>
										<c:if test="${stdAcadInfo.ct2UnivDeptName != null}">
											${stdAcadInfo.ct2UnivDeptName} : ${stdAcadInfo.ct2Cred} / ${stdAcadInfo.ct2GrdtnCred} 학점
										</c:if>
									</td>
									<td>
										<c:if test="${stdAcadInfo.ct2UnivDeptName == null}">
											부전공 이수 내역이 없습니다
										</c:if>
										<c:if test="${stdAcadInfo.ct2UnivDeptName != null}">
											${stdAcadInfo.ct3UnivDeptName} : ${stdAcadInfo.ct3Cred} / ${stdAcadInfo.ct3GrdtnCred} 학점
										</c:if>
									</td>
									<td>${stdAcadInfo.ct4Cred} / ${stdAcadInfo.ct4GrdtnCred} 학점</td>
									<td>${stdAcadInfo.ct1Cred + stdAcadInfo.ct2Cred + stdAcadInfo.ct3Cred + stdAcadInfo.ct4Cred} 학점 / ${scoreList[0].allScore} 점</td>
								</tr>
							</tbody>
							<!-- 테이블 내 테이블 시작 (학기 별 성적 테이블) -->
							<thead>
								<tr>
									<th colspan="5">
										학기 별 성적표
									</th>
								</tr>
							</thead>
							<tbody id="tb">
							</tbody>
							<!-- // 테이블 내 테이블 끝 (학기 별 성적 테이블) -->
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>

	var scoreList = ${jsonScoreList};
	
	$(function() {
		
		var tableCnt = 0;
		var tableHtml = "<tr>"; 
		
		for(i in scoreList){
			
			var preInx = parseInt(i) - 1;
			var postInx = parseInt(i) + 1;
			
			if(tableCnt == 0 || tableCnt % 2 == 0) {
				tableHtml += "<td class='"+ "tdWhite" +"'>";
			}
			
			if((i == 0) ||
				(i > 0 && (scoreList[i].year + scoreList[i].semCode) != (scoreList[preInx].year + scoreList[preInx].semCode))) {
				
				tableHtml += "<table class='innerTb'>" 
							+ "<colgroup>"
							+ "<col width='10%'>"
							+ "<col width='20%'>"
							+ "<col width='5%'>"
							+ "<col width='5%'>"
							+ "</colgroup>"
							+ "<tr>" 
							+ "<th>" + "학기" + "</th>"
							+ "<td colspan='3'>" + scoreList[i].year + "년 " + scoreList[i].semCode + "학기" + "</td>" 
							+ "</tr>"
							+ "<tr>"
							+ "<th>" + "강의유형" + "</th>"
							+ "<th>" + "강의명" + "</th>"
							+ "<th>" + "학점" + "</th>"
							+ "<th>" + "평점" + "</th>"
							+ "</tr>";
			}		
			
			// i가 0보다 크면서 year, semCode가 달라질 때마다 table을 새로 만든다.
			
			// null처리
			var textAlign = 'text-left';
			if(scoreList[i].lectName == null) textAlign = 'text-center'; 
			
			tableHtml += "<tr>"
				+ "<td>" + fn_isNull(scoreList[i].subjTypeCode) + "</td>"
				+ "<td class='" + textAlign + "'>" + fn_isNull(scoreList[i].lectName) + "</td>"
				+ "<td>" + fn_isNull(scoreList[i].cred) + "</td>"
				+ "<td>" + fn_isNull(scoreList[i].rating) + "</td>"
				+ "</tr>";
			
			if((i == scoreList.length-1) ||
				(i < scoreList.length && (scoreList[i].year + scoreList[i].semCode) != (scoreList[postInx].year + scoreList[postInx].semCode))) {
				tableHtml += "<tr>" 
							+ "<th>" + "학점/평점" + "</th>"
							+ "<td colspan='3'>" + fn_isNull(scoreList[i].credSum) + "학점 / " + fn_isNull(scoreList[i].semScore) + "점 </td>"
							+ "</tr>"
							+ "</table>"; 
				tableCnt++;
			}				
			
			if(tableCnt % 2 == 0) {
				tableHtml += "</td>";
			}
		}
		
		tableHtml += "</td></tr>";
		tableHtml = tableHtml.replaceAll("</tr></td><td class='tdWhite'><tr>" , "</tr><tr>");
		
		$("#tb").html(tableHtml);
		
	});
	
	function fn_isNull(value) {
		if(value == null || value.length === 0){
			return " - ";
		}else{
			return value;
		}
	}
</script>