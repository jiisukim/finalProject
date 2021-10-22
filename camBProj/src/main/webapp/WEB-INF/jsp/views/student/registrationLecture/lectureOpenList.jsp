<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	.table th {
		padding : 0.50rem;
	}
	.table td {
		padding : 0.40rem;
	}
	label, input {
		margin : 0px;
	}
	label {
		font-size: 0.8em;
		font-weight: bold;
	}
	.upper-card {
		height: 90px;
	}
	.down-card {
/* 		height: 300px; */
/* 		overflow: auto; */
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
	
</style>

<div id="body">

	<p class="mb-4">
		<span id="info"></span>	
	</p>
	
	<div class="card shadow mb-4">
	
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" onclick="fn_semInput();">수강 신청</h6>
		</div>
		
		<div class="card-body">

			<!-- 검색, 상태요약 시작 -->
				<div class="row">
					<!-- 검색 시작 -->
					<div class="col-sm-8">
					
						<!--  form -->
						<form:form commandName="lectureOpenFormVO" action="/student/registrationLectureL/lectureOpenList" id="frm" name="frm" class="form-horizontal">
							<div class="card mb-4 py-3 border-left-primary">
								<div class="card-body upper-card" style="padding: 4px 30px;">
									<div class="row">
										<div class="form-group col-sm-2">
											<form:label path="searchLectureOpenVO.subjTypeCode">교과 구분</form:label>
											<form:select path="searchLectureOpenVO.subjTypeCode" class="form-control">
							                    <option value="">전체</option>
							                    <form:options items="${codeList}" itemLabel="codeName" itemValue="codeVal"/>
							                </form:select>
										</div>
										<div class="form-group col-sm-3">
											<form:label path="searchLectureOpenVO.univDeptName">학과</form:label>
											<form:input path="searchLectureOpenVO.univDeptName" class="form-control"/>
										</div>
										<div class="form-group col-sm-3">
											<form:label path="searchLectureOpenVO.name">교수 명</form:label>
											<form:input path="searchLectureOpenVO.name" class="form-control"/>
										</div>
										<div class="form-group col-sm-3">
											<form:label path="searchLectureOpenVO.lectName">강의 명 / 강의 번호</form:label>
											<form:input path="searchLectureOpenVO.lectName" class="form-control"/>
										</div>
										<div class="col-sm-1" id="btnDiv">
											<form:input path="searchLectureOpenVO.searchCondition" type="hidden" value="LECT"/> <!-- LECT-수강신청 / CART-장바구니 / REGI-신청완료  -->
											<form:hidden path="lectureOpenVO.lectOpenNum" id="lectOpenNum" />
											<form:hidden path="lectureOpenVO.univDeptNum" id="univDeptNum" />
											<form:hidden path="lectureOpenVO.grdtnRequYn" id="grdtnRequYn" />
											<form:hidden path="searchLectureOpenVO.pageNo" id="pageNo" />
											<form:hidden path="lectureOpenVO.saveToken" id="saveToken" />
											
											<!-- 현 학기 외의 수강신청 위한 input  -->
											<form:hidden path="searchLectureOpenVO.year" id="year"/>
											<form:hidden path="searchLectureOpenVO.semCode" id="semCode"/>
											<!-- // 현 학기 외의 수강신청 위한 input  -->
											
											<button type="submit" class="btn btn-secondary"><i class="fas fa-search fa-sm"></i></button>
										</div>
									</div>
								</div>
							</div>
						</form:form>
					</div><!-- // 검색 끝 -->
					<!-- 상태 요약 시작 -->
					<div class="col-sm-4">
						<div class="card mb-4 py-3 border-left-primary">
							<div class="card-body upper-card">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<label for="stdId" class="text-info">
											<c:out value="${lectureOpenFormVO.lectureOpenVO.year}"/>년도 
											<c:out value=" ${lectureOpenFormVO.lectureOpenVO.semCode}"/>학기 신청 학점
										</label>
										<i class="fas fa-clock" style="margin-left: 35px;margin-right: 5px;"></i><label id="clock"></label>
										<div class="row no-gutters align-items-center">
											<div class="col-auto">
												<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
													<span class="text-info">${registrationLectureCount}</span> 과목
												</div>
											</div>
											<div class="col-auto">
												<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
													<span class="text-info" id="credSum">${credSum}</span> / <span id="credAvail">${credAvail}</span> 학점   
												</div>
											</div>
											<div class="col">
												<div class="progress progress-sm mr-2">
													<fmt:parseNumber var="credPercent" value="${credSum/credAvail*100}" integerOnly="true"/> 
													<div class="progress-bar bg-info" role="progressbar" style="width: ${credPercent}%" aria-valuenow="${credPercent}" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div><!-- // 상태 요약 끝 -->
				</div><!-- // 검색, 상태요약 끝 -->
			
			<!-- 장바구니, 수강신청 위한 데이터 제출 form -->
			
			<label>총 <span class="text-info">${lectureOpenListCount}</span> 개의 강의가 있습니다. </label> 
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12">
						<table class="table" id="dataTable" style="width: 100%;" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
							<colgroup>
								<col width= "120px">
								<col width= "180px">
								<col width= "60px">
								<col width= "90px">
								<col width= "180px">
								<col width= "60px">
								<col width= "140px">
								<col width= "150px">
								<col width= "150px">
								<col width= "80px">
								<col width= "80px">
								<col width= "95px;">
								<col width= "80px">
								<col width= "80px">
							</colgroup>
							<thead>
								<tr role="row">
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >강의 번호</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >강의 명</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >분반</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >과목구분</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >학과</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >학점</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >담당교수</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >강의시간(교시)</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >강의실</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >수강인원</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >신청인원</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >강의계획서</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >장바구니</th>
									<th tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" >수강신청</th>
								</tr>
							</thead>
							<tbody id="td">
								<c:if test="${lectureOpenList == '[]'}">
									<tr>
										<td colspan="13" class="text-center">강의가 없습니다. </td>
									</tr>
								</c:if>
								<c:if test="${lectureOpenList != '[]'}">
									<c:forEach var="row" items="${lectureOpenList}" varStatus="stat">
										<tr class="text-center lectRow">
											<td class="lectOpenNum">${row.lectOpenNum}</td>
											<td class="text-left">${row.lectName}</td>
											<td>${row.divideNum}</td>
											<td>${row.subjTypeCodeName}</td>
											<td class="text-left">${row.univDeptName}</td>
											<td>${row.cred}</td>
											<td>${row.name}</td>
											<td>${row.lectTime}</td>
											<td>${row.roomIdnName}</td>
											<td>${row.maxStdCnt} 명</td>
											<td class="stdCnt">${row.stdCnt} 명</td>
											<td><button type="button" class="btn btn-sm btn-info" data-toggle="modal" data-target="#myModal" onclick="fn_showSyllabus('${row.lectOpenNum}');">열람</button></td>
											<td class="cartBtnTd">
												<button type="button" class="btn btn-sm btn-info" onclick="fn_cartInsert('${row.lectOpenNum}');">담기</button>
												<button type="button" class="btn btn-sm btn-danger" onclick="fn_cartDelete('${row.lectOpenNum}');" style="display: none;">취소</button>
											</td>
											<td class="regLectBtnTd">
												<button type="button" class="btn btn-sm btn-info" onclick="fn_regLectInsert('${stat.index}', 1);"
													<c:if test="${row.maxStdCnt <= row.stdCnt}">disabled</c:if>
												>신청</button>
												<button type="button" class="btn btn-sm btn-danger" onclick="fn_regLectDelete('${row.lectOpenNum}','${row.lectName}');" style="display: none;">취소</button>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
				
				<!-- paging -->	
				<div class="row">
					<div id="paging" class="col-sm-12 text-center">
		        		<ul class="pagination">
					    	<li style="list-style: none;" class="paginate_button page-item previous <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">disabled</c:if>">
					        	<button onclick="fn_movePage(${paginationInfo.firstPageNoOnPageList - 5 })" data-dt-idx="0" class="page-link">이전</button>
					        </li>
					       
							<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
					        	<li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == lectureOpenFormVO.searchLectureOpenVO.pageNo || (pageNo==1 && lectureOpenFormVO.searchLectureOpenVO.pageNo ==null)}">active</c:if>">
					            	<button onclick="fn_movePage(${pageNo})" data-dt-idx="${pageNo}" class="page-link">${pageNo}</button>
					            </li>
					        </c:forEach>
					       
					        <li style="list-style: none;" class="paginate_button page-item next <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if>">
					          <button onclick="fn_movePage(${paginationInfo.lastPageNoOnPageList + 1 })" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" class="page-link">다음</button>
					        </li>
						</ul>
		        	</div> 
	        	</div><!-- //end paging -->
	        	
	        	<hr>
	        	
			</div>
					
		</div>
		
	</div>

	<div class="row">
		<div class="col-sm-6">
			<div class="card shadow mb-4">
				<a href="#cart" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="cart">
					<h6 class="m-0 font-weight-bold text-primary">장바구니</h6>
				</a>
				<div class="collapse show" id="cart">
					<div class="card-body down-card">
						<label>총 <span class="text-info">${cartCount}</span> 개의 강의가 있습니다. </label>
						<table class="table">
							<thead>
								<tr class="grayTr">
									<td style="border-bottom: 2px; border-top:2px; background-color: #F0F0F0;" >
										<div class="form-check">
											<input type="checkbox" id="cartCheckAll" class="form-check-input"/>
										</div>
									</td>
									<th>강의번호</th>
									<th>강의 명</th>
									<th>분반</th>
									<th>신청인원</th>
									<th>수강신청</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${cartList == '[]'}">
									<tr>
										<td colspan="6" class="text-center">장바구니가 비어있습니다. </td>
									</tr>
								</c:if>
								<c:if test="${cartList != '[]'}">
									<c:forEach var="row" items="${cartList}" varStatus="stat">
										<tr class="text-center">
											<td>
												<div class="form-check">
													<input type="checkbox" class="form-check-input cartCheck"/>
												</div>
											</td>
											<td class="cartLectOpenNum">${row.lectOpenNum}</td>
											<td class="text-left">${row.lectName}</td>
											<td>${row.divideNum}</td>
											<td>${row.stdCnt} / ${row.maxStdCnt}</td>
											<td>
												<button type="button" class="btn btn-sm btn-info regLectInsert" onclick="fn_regLectInsert('${stat.index}', 2);"
													<c:if test="${row.maxStdCnt <= row.stdCnt}">disabled</c:if>
												>신청</button>
											</td>
											<td><button type="button" class="btn btn-sm btn-danger" onclick="fn_cartDelete('${row.lectOpenNum}');">삭제</button></td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-12">
								<button type="button" class="btn btn-sm btn-info mb-1" onclick="fn_insertChecked();">일괄 신청</button>
								<button type="button" class="btn btn-sm btn-danger mb-1" onclick="fn_deleteChecked();">일괄 삭제</button>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="col-sm-6">
			<div class="card shadow mb-4">
				<!-- Card Header - Accordion -->
				<a href="#regst" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="regst">
					<h6 class="m-0 font-weight-bold text-primary">신청 완료 목록</h6>
				</a>
				<!-- Card Content - Collapse -->
				<div class="collapse show" id="regst">
					<div class="card-body down-card">
						<label>총 <span class="text-info">${registrationLectureCount}</span> 개의 강의가 있습니다. </label>
						<table class="table">
							<thead>
								<tr class="grayTr">
									<th>강의번호</th>
									<th>강의 명</th>
									<th>분반</th>
									<th>신청인원</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${registrationLectureList == '[]'}">
									<tr>
										<td colspan="5" class="text-center">신청한 강의가 없습니다. </td>
									</tr>
								</c:if>
								<c:if test="${registrationLectureList != '[]'}">
									<c:forEach var="row" items="${registrationLectureList}">
										<tr class="text-center">
											<td class="regLectOpenNum">${row.lectOpenNum}</td>
											<td class="text-left">${row.lectName}</td>
											<td>${row.divideNum}</td>
											<td>${row.stdCnt} / ${row.maxStdCnt}</td>
											<td><button type="button" class="btn btn-sm btn-danger" onclick="fn_regLectDelete('${row.lectOpenNum}','${row.lectName}')">삭제</button></td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="syllabus.jsp"></jsp:include>
	
</div>

<script>
	var jsonLectureOpenList = ${jsonLectureOpenList};
	var jsonCartList = ${jsonCartList};
	var jsonRegistrationLectureList = ${jsonRegistrationLectureList};
	
	var regLectTimeStr = ''; // 수강신청 완료한 강의 시간 문자열로 저장 (강의 시간 중복 막기 위함)
	for( idx in jsonRegistrationLectureList){
		regLectTimeStr += jsonRegistrationLectureList[idx].lectTime + ', '; 
	}
	
	var regLectInsertFlag = true; // 신청 가능 학점 초과 시 false
	
	$(function () {
		fn_cart(); // 강의가 이미 장바구니에 담겨있으면 [담기] 버튼 비활성화 
		
		fn_realTimeClock("clock");
		setInterval(fn_realTimeClock, 1000, "clock"); // 시계를 넣을 요소의 아이디를 파라미터로 넣기
		
		// 장바구니 일괄 체크 (전체) 
		$("#cartCheckAll").on("click", function () {
			if($("#cartCheckAll").is(":checked")){
				$(".cartCheck").prop("checked", true);
			}else{
				$(".cartCheck").prop("checked", false);
			}
			$(".cartCheck").on("click", function() {
				var checkAll = true;
				// 모든 체크박스가 체크되어있는지 확인
				$(".cartCheck").each(function(idx, item) {
					if($(item).is(":checked") == false){ // 하나라도 체크되어 있지 않다면  false
						checkAll = false;	
					}				
				});
				if(checkAll == true){
					$("#cartCheckAll").prop("checked", true); // 모두 체크되어 있다면 true
				}else{
					$("#cartCheckAll").prop("checked", false); // 모두 체크되어 있다면 true
				}
			});
		});
		
		
		// 수강 인원 초과로 신청을 실패했을 경우 alert
		if("${result}" == 'fail'){
			alert("수강 인원이 초과되었습니다.");
		}
	});
	
	// 장바구니 담기
	function fn_cartInsert(lectOpenNum) {
		// frm의 action 바꿔 요청
		$("#frm").prop("action", "/student/registrationLecture/cartInsert");
		$("#lectOpenNum").val(lectOpenNum);
		$("#frm").submit();
	}
	
	// 이미 장바구니, 수강완료에 담겨있으면 버튼 조정
	function fn_cart() {
		var cartArr = new Array();
		$(".cartLectOpenNum").each(function (idx, item) {
			cartArr.push($(item).text());
		});
		
		var regLectArr = new Array();
		$(".regLectOpenNum").each(function (idx, item) {
			regLectArr.push($(item).text());
		});
		
		$(".lectRow").each(function (idx, item) {
 			var lectOpenNum = $(item).children(".lectOpenNum")[0].innerText;
 			if(cartArr.includes(lectOpenNum)){
 				$($(item).children(".cartBtnTd").children()[0]).hide();
 				$($(item).children(".cartBtnTd").children()[1]).show();
 			}
 			if(regLectArr.includes(lectOpenNum)){
 				$($(item).children(".regLectBtnTd").children()[0]).hide();
 				$($(item).children(".regLectBtnTd").children()[1]).show();
 			}
			
 			var isVisible = $($(item).children(".regLectBtnTd").children()[0]).is(':visible');
 			if(!isVisible){
 				$($(item).children(".cartBtnTd").children()[0]).prop("disabled", true);
 			}
 		});
	}
	
	// 다른 학기 수강신청 페이지 보기
	function fn_semInput() {
		var sem = prompt("년도학기 입력 (ex. 2021-1)").split("-");
		$("#year").val(sem[0]);
		$("#semCode").val(sem[1]);
		
		$("#frm").submit();
	}
	
	// 장바구니에 담아 일괄 신청
	function fn_insertChecked() {
		var checked = $(".cartCheck:checked");
		
		$(checked).each(function (idx, item) {
			var jsonList = [];
			jsonList = jsonCartList;
			
			var index = $(item).parents("tr").index();
			
			// 신청 학점 넘었는지 확인
			if(fn_isOverCredAvail(jsonList[index].cred)){
				alert("[" + jsonList[index].lectName +  "] : 수강 신청을 실패했습니다. 수강 신청 가능 학점 범위를 벗어났습니다.");
				return;
			};
			
			// 같은 시간대 강의가 있는지 확인 (만들어야 함)
			if(fn_isDuplTime(jsonList[index].lectTime)){
				alert("[" + jsonList[index].lectName +  "] : 수강 신청을 실패했습니다. 강의 시간이 중복입니다.");
				return;
			}
		
			// 하나씩 넣어야 중간에 학점 초과가 일어나면 막을 수 있음
			$.ajax({
				type:"POST"
				,url:"/student/registrationLecture/registrationLectureInsertAll"
				,contentType: "application/json; charset=UTF-8"
				,data: JSON.stringify({'lectOpenNum' : $(item).closest("td").next().html()})
				,dataType: "json"
				,async: false
				,success: function(data) {
					var result = "수강 신청을 성공했습니다.";
					if(data != 'success') result = "수강 신청을 실패했습니다. 신청 인원이 초과되었습니다.";
					alert("[" + $(item).closest("td").next().next().html() + "] : " + result);
					$("#credSum").text(parseInt($("#credSum").text()) + parseInt(jsonList[index].cred)); //신청한 학점 업데이트
				}
			});	
		});
		location.reload();
	}
	
	// 장바구니에 담은 것 일괄 삭제
	function fn_deleteChecked(){
		var checked = $(".cartCheck:checked");
		var lectOpenNumList = [];
		$(checked).each(function (idx, item) {
			lectOpenNumList[idx] = $(item).closest("td").next().html();
		});
		
		$.ajax({
			type:"POST"
			,url:"/student/registrationLecture/registrationLectureDeleteAll"
			,contentType: "application/json; charset=UTF-8"
			,data: JSON.stringify({'lectOpenNumList' : lectOpenNumList})
			,dataType: "json"
			,async: false
			,success: function(data) {
				alert(data + "개의 강의를 장바구니에서 삭제했습니다.")
				location.reload();
			}
		});	
	}
	
	function fn_showResult(result) {
		console.log(result);
	}
	
	
</script>