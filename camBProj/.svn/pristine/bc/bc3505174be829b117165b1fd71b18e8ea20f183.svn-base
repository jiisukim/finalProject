<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.table th {
	padding: 0.50rem;
	vertical-align: middle;
}

.table td {
	padding: 0.40rem;
	vertical-align: middle;
}

label, input {
	margin: 0px;
}

label {
	font-size: 0.8em;
	font-weight: bold;
}

.upper-card {
	height: 90px;
}

.down-card {
	height: 300px;
	overflow: auto;
}

#btnDiv {
	display: flex;
	align-items: center;
	padding-top: 8px;
}

.checkbox-inline {
	margin-right: 30px;
}

.grayTr {
	background-color: #F0F0F0;
	color: #505050;
}

.btnSns {
	width: 46px;
}

</style>

<div id="body">

	<p class="mb-4">
		<span id="info"></span>
	</p>


	<div class="row">
		<!-- 신청 목록 테이블 시작 -->
		<div class="col-sm-8">
		
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">수강 목록</h6>
				</div>
				
				<div class="card-body">

					<!-- 검색, 상태요약 시작 -->
					<div class="row">
						<!-- 검색 시작 -->
						<div class="col-sm-12">
							<div class="card mb-4 py-3 border-left-primary">
								<div class="card-body upper-card" style="padding: 4px 30px;">
									<div class="row">
										<!--  form -->
										<div class="form-group col-sm-3">
											<form:form commandName="lectureOpenFormVO" action="/student/lecture/lectureList" id="frm" name="frm" class="form-horizontal">
												
												<form:label path="lectureOpenVO.year">학기</form:label>
												<form:select path="lectureOpenVO.year" class="form-control" id="yearAndSem">
								                    <form:options items="${yearAndSemList}" itemLabel="yearAndSem" itemValue="yearAndSem"/>
								                </form:select>
								                
												<form:hidden path="searchLectureOpenVO.year" id="yearSubmit" />
												<form:hidden path="searchLectureOpenVO.semCode" id="semCode" />
												<form:hidden path="searchLectureOpenVO.pageNo" id="pageNo" />
												<form:hidden path="lectureOpenVO.lectOpenNum" id="lectOpenNum" />
												<form:hidden path="lectureOpenVO.saveToken" id="saveToken" />
											</form:form>
										</div><!-- // 검색 끝 -->
										<!-- 상태 요약 -->
										<div class="col-sm-9">
											<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800" style="margin-top: 30px;">
												<span class="text-info">${registrationLectureCount}</span> 과목
												<span class="text-info">${credSum}</span> 학점을 수강하였습니다
											</div>
										</div>
									</div>
								</div>
							</div>
						</div><!-- // 상태 요약 끝 -->
					</div><!-- // 검색, 상태요약 끝 -->

					<div class="row">
						<c:if test="${registrationLectureList == '[]'}">
							<div class="col-lg-12 text-center">
								<img alt="빈 페이지" src="/resources/img/page/empty.png" style="height: 490px;">
								<p>신청 내역이 없습니다</p>
							</div>
						</c:if>
						<!-- 이수구분(전공, 교양 등), 분반, 과목명, 학점, 담당교수, 강의시간, 강의실, 수업계획서 -->
						<c:if test="${registrationLectureList != '[]'}">
							<c:forEach var="row" items="${registrationLectureList}" varStatus="stat">
								<div class="col-12" id="accordion${stat.index}">
					                <div class="card text-black shadow">
					                    <div class="card-header">
					                    	 <a class="d-block w-100 collapsed" data-toggle="collapse" href="#ROW${row.lectOpenNum}" aria-expanded="false">
					                            <h5 class="card-title" style="margin-bottom: 0px;">
					                                ${row.lectName} <i class="far fa-angle-down"></i>
					                            </h5>
				                            </a>
				                        </div>
					                    <div id="ROW${row.lectOpenNum}" class="collapse" data-parent="#accordion${stat.index}" style="">
					                        <div class="card-body">
					                           	<table class="table">
					                           		<colgroup>
					                           			<col width="50px;">
					                           			<col width="80px;">
					                           			<col width="50px;">
					                           			<col width="80px;">
					                           			<col width="50px;">
					                           			<col width="80px;">
					                           		</colgroup>
					                           		<tbody>
						                           		<tr>
						                           			<th class="defaultTh">강의 명</th>
						                           			<td>${row.lectName}</td>
						                           			<th class="defaultTh">강의 번호</th>
						                           			<td>${row.lectOpenNum}</td>
						                           			<th class="defaultTh">분반</th>
						                           			<td>${row.divideNum}</td>
						                           		<tr>
						                           		<tr>
						                           			<th class="defaultTh">담당 교수</th>
						                           			<td>${row.name}</td>
						                           			<th class="defaultTh">학과</th>
						                           			<td>${row.univDeptName}</td>
						                           			<th class="defaultTh">이수 구분</th>
						                           			<td>${row.subjTypeCodeName}</td>
						                           		<tr>
						                           		<tr>
						                           			<th class="defaultTh">강의 시간</th>
						                           			<td>${row.lectTime}</td>
						                           			<th class="defaultTh">강의실</th>
						                           			<td>${row.roomIdnName}</td>
						                           			<th class="defaultTh">학점</th>
						                           			<td>${row.cred}</td>
						                           		<tr>
						                           		<tr>
						                           			<th class="defaultTh">강의 계획서</th>
						                           			<td colspan="5"><button type="button" class="btn btn-sm btn-info" data-toggle="modal" data-target="#myModal" onclick="fn_showSyllabus('${row.lectOpenNum}');">강의 계획서</button></td>
						                           		</tr>
					                           		</tbody>
					                          	</table>
					                        </div>
					                    </div>
					                </div>
					            </div>
				            </c:forEach>
                         </c:if>
					</div>
				</div>
			</div>
		</div>
		<!-- // 신청 목록 테이블 끝 -->
	
		<!-- 신청 목록 시간표 시작 -->
		<div class="col-sm-4">
			<div class="card mb-4 py-3 border-left-primary">
				<div class="card-body">
					<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800 text-center" style="padding-bottom: 10px;">시간표</div>
					<table class="table table-bordered dataTable text-center">
						<colgroup>
                   			<col width="16%;">
                   			<col width="16%;">
                   			<col width="16%;">
                   			<col width="16%;">
                   			<col width="16%;">
                   			<col width="16%;">
                   		</colgroup>
						<thead>
							<tr class="grayTr">
								<th style="width: 70px;">/</th>
								<th>월</th>
								<th>화</th>
								<th>수</th>
								<th>목</th>
								<th>금</th>
							</tr>
						</thead>
						<tbody id="tb">
							<c:forEach var="i" begin="1" end="15">
								<tr>
									<td>${i}교시 <br/> ${i + 8} : 00</td>
									<td class="mon" id="01${i}"></td>
									<td class="tue" id="02${i}"></td>
									<td class="wed" id="03${i}"></td>
									<td class="thu" id="04${i}"></td>
									<td class="fri" id="05${i}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
		<!-- // 신청 목록 시간표 끝 -->
	</div>

	<jsp:include page="../registrationLecture/syllabus.jsp"></jsp:include>

</div>

<script>

	var jsonRegistrationLectureList = ${jsonRegistrationLectureList};
	var jsonLectTimeTableList = ${jsonLectTimeTableList};
	
	$(function() {
		
		console.log(jsonRegistrationLectureList);
		
		// 셀렉트 박스로 선택한 학기 보여주기
		var yearAndSemCode = '${lectureOpenFormVO.searchLectureOpenVO.year}' + '년 ' + '${lectureOpenFormVO.searchLectureOpenVO.semCode}' + '학기';
		$("#yearAndSem option[value='"+yearAndSemCode+"']").prop('selected', true);
		
		fn_makeTimeTable();
		
		$("#yearAndSem").on("change", function () {
			// year, semCode 입력하기 
			var year = this.value.substr(0, 4);
			var semCode = this.value.substr(6, 1);
			$("#yearSubmit").val(year);
			$("#semCode").val(semCode);
			$("#frm").submit();
		});
		
	});
	
	// 시간표 데이터 가져와 뿌리기
	function fn_makeTimeTable() {
		var colorIdx = 1; // 시간표 색상 지정용
		for(i in jsonLectTimeTableList){
			if(i > 0 && jsonLectTimeTableList[i].lectOpenNum != jsonLectTimeTableList[i-1].lectOpenNum){ // i가 1 이상일 때 이전과 다른 과목이면  colorIdx + 1
				colorIdx++;
			}
			
			var txt = "<label>" + jsonLectTimeTableList[i].lectName + "</label><br /><label style='font-weight:lighter'>" + jsonLectTimeTableList[i].roomIdnName + "</label>";
			
			$("#" + jsonLectTimeTableList[i].dayCode + jsonLectTimeTableList[i].period).html(txt).addClass('C' + colorIdx);
		}
		genRowspan(); // 셀 병합
	}
	
	
	
	
</script>
