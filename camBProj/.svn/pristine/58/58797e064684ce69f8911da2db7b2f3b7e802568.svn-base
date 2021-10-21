<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<style>
	tbody tr:hover{
		background-color: #F4F5F9;
	}
</style>
<body>
	<div class="card shadow mb-4" style="width: 98%;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/attendance/list'">출결 관리</h6>
		</div>
		
		<div class="card-body">
			<div class="table-responsive">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="width: 99%">
					<div class="row">
						<div class="col-sm-12">
						<form method="get" action="/professor/attendance/list" name="frmSearch" id="frmSearch">
							<input type="hidden" name="pageNo" value="1">
							<div style="float: right; width: 70%; margin-top: 4%;">
									<button type="submit" class="btn btn-secondary" style=" float: right;  margin-left: 1%;" >검색</button>
									<input type="checkbox" id="selectAll" name="selectAll" style="float: right; margin-top: 13px; margin-left: 5px;"><label for="selectAll" style="float: right; margin-top: 7px;">&nbsp;&nbsp;전체</label>
									<input type="text" class="form-control" id="searchKeyword" name="searchKeyword" value="${param.searchKeyword}" maxlength="30" style="width: 30%; float: right; margin-left: 3px;" placeholder="강의명을 입력해주세요">
									<select id="selectSemester" class="form-control" name="selectSemester" style="text-align: center; width: 12%; float: right; margin-left: 3px;  padding: 0px;" >
										<option value="">---- 학기 ----</option>
										<option value="1"
										<c:if test="${param.selectSemester=='1'}">selected</c:if>
										>1학기</option>
										<option value="2"
										<c:if test="${param.selectSemester=='2'}">selected</c:if>
										>2학기</option>
										<option value="S"
										<c:if test="${param.selectSemester=='S'}">selected</c:if>
										>여름 계절 학기</option>
										<option value="W"
										<c:if test="${param.selectSemester=='W'}">selected</c:if>
										>겨울 계절 학기</option>
									</select>		
									<select id="selectYear" class="form-control" name="selectYear" style="text-align: center; width: 10%; float: right; padding: 0px;" >
										<%
										Date nowYear = new Date();
										SimpleDateFormat date = new SimpleDateFormat("yyyy");
										String year = date.format(nowYear);
										int intYear = Integer.parseInt(year);
										%>
										<option value="">-- 년도 --</option>
										<!-- intYear을 비교할 방법이 없어서 var에 저장하고 foreach문에서 사용 -->
										<c:set var="nowYear" value="<%=(intYear) %>"></c:set>
										<c:forEach var="i" begin="${nowYear-30}" end="${nowYear}" step="1">
											<option value="${nowYear-i+(nowYear-30)}"
											<c:if test="${param.selectYear==nowYear-i+(nowYear-30)}">selected</c:if>
											>${nowYear-i+(nowYear-30)}</option>
										</c:forEach>
										
									</select>
								
								
							</div>
						</form>
							<!-- 게시글 수  -->
							<span style="color: black; font-weight: bold; float: left; margin-top: 5%;">총 <span style="color: #C02B55"><fmt:formatNumber value="${paginationInfo.totalRecordCount}" pattern="#,###" /></span>건의 게시물이 있습니다.</span>
						<form method="get" action="/professor/attendance/list" name="inputStatusSearch" id="inputStatusSearch">
						<input type="hidden" name="selectYear" value="${param.selectYear}">
						<input type="hidden" name="selectSemester" value="${param.selectSemester}">
						<input type="hidden" name="searchKeyword" value="${param.searchKeyword}">
<!-- 						<select id=inputStatus class="form-control" name="inputStatus" style="text-align: center; width: 150px; float: right; margin-bottom: 2px;  padding: 0px;" > -->
<!-- 							<option id="checkAll" value="">전체 강의</option> -->
<!-- 							<option value="ok" -->
<%-- 							<c:if test="${param.inputStatus=='ok'}">selected</c:if> --%>
<!-- 							>입력 강의</option> -->
<!-- 							<option value="no" -->
<%-- 							<c:if test="${param.inputStatus=='no'}">selected</c:if> --%>
<!-- 							>미입력 강의</option> -->
<!-- 						</select> -->
						</form>
							<table class="table" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%; text-align: center;">
								<thead>
									<tr role="row">
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 5%;">
											순번
										</th>
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
											교과 번호
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 15%;">
											년도/학기
										</th>
<!-- 										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 10%;"> -->
<!-- 											학기 -->
<!-- 										</th> -->
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 20%;">
											강의명
										</th>
<!-- 										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 20%;"> -->
<!-- 											강의 시간 [교시] -->
<!-- 										</th> -->
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 10%;">
											강의실
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 5%;">
											분반
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 5%;">
											학점
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 10%;">
											교과구분
										</th>
										
									</tr>
								</thead>
								
								<tbody>
								<c:forEach var="list" items="${lectureOpenVO}">
										<!-- 해당 학기가 아닌경우 클릭 막기 -->
										<%
										Date nowYear2 = new Date();
										//년
										SimpleDateFormat date2 = new SimpleDateFormat("yyyy");
										String year2 = date2.format(nowYear2);
										int intYear2 = Integer.parseInt(year2);
										//월
										SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
										String month = monthFormat.format(nowYear2);
										int intMonth = Integer.parseInt(month);
										
										//일
										SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
										String day = dayFormat.format(nowYear2);
										int intday = Integer.parseInt(day);
										
										String semCode = "";
										//해당 학기인지 확인해주는 체크 변수
										String checkSemester = "";
										%>
										<c:set var="nowYear" value="<%=(intYear) %>"></c:set>	<!-- 년 -->
										<c:set var="nowMonth" value="<%=intMonth %>"></c:set>	<!-- 월 -->
										<c:set var="nowDay" value="<%=intday %>"></c:set>		<!-- 일 -->
										<c:if test="${nowMonth >=1 && nowMonth <=2}"><%semCode="겨울 계절 학기"; %></c:if>
										<c:if test="${nowMonth >=3 && (nowMonth <=6 && nowDay <= 28)}"><%semCode="1학기"; %></c:if>
										<c:if test="${(nowMonth >=6 && nowDay >28) && nowMonth <= 8}"><%semCode="여름 계절 학기"; %></c:if>
										<c:if test="${nowMonth >=9 && nowMonth <=12}"><%semCode="2학기"; %></c:if>
										<!-- 학기 변수 -->
										<c:set var="nowSem" value="<%=semCode %>"></c:set>	<!-- 학기 -->
										<c:if test="${nowSem eq list.semCode && nowYear eq list.year}"><%checkSemester ="ok";%></c:if>
										<c:if test="${nowSem ne list.semCode || nowYear ne list.year}"><%checkSemester ="no";%></c:if>
										
									<tr class="trClick" style="cursor: pointer;" onclick="clickList(${list.profId},${list.lectOpenNum},'<%=checkSemester%>')">
										<td>${list.rnum}</td>
										<td>${list.subjNum}</td>
										<td style="text-align: left;">${list.year}/${list.semCode}</td>
										<td style="text-align: left;">${list.lectName}</td>
										<td style="text-align: left; padding: 3px">
											${list.buildName}(${list.buildCode}) <br/> ${fn:substring(list.roomNum,2,4) }층 ${fn:substring(list.roomNum,4,6)}호
										</td>
										<td>${list.divideNum}</td>
										<td>${list.cred}학점</td>
										<td>${list.subjTypeCode}</td>
										
									</tr>
										
								</c:forEach>
									
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-5">

						</div>
						<div id="paging" class="col-sm-12-text-center">
								<ul class="pagination">
								<!-- previous 시작 -->
						            <c:if test="${paginationInfo.firstPageNoOnPageList > 5 }">
						              <li style="list-style: none;" class="paginate_button page-item previous" id="example2_previous"> 
						            </c:if>
						            <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">
						              <li style="list-style: none;" class="paginate_button page-item previous disabled" id="example2_previous"> 
						            </c:if>      
						              <a href="/professor/attendance/list?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}&inputStatus=${param.inputStatus}" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">이전</a>
						            </li>      
						            <!-- previous 끝 -->
						            
									<!-- page번호 시작 -->
									<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
										  <li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (empty param.pageNo && pageNo == 1)}">active</c:if>">
							                <a href="/professor/attendance/list?pageNo=${pageNo}&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}&inputStatus=${param.inputStatus}" aria-controls="example2" data-dt-idx="${pageNo }" tabindex="0" class="page-link">${pageNo }</a>
							              </li>        
						            </c:forEach> 
						            <!-- page번호 끝 -->
						            
						            <!-- next시작 -->
						            <li style="list-style: none;" class="paginate_button page-item next 
						            <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if> " id="example2_next">
						              <a href="/professor/attendance/list?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}&inputStatus=${param.inputStatus}" aria-controls="example2" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" tabindex="0" class="page-link">다음</a>
						            </li>       
						            <!-- next끝 -->       
		            			</ul>
	            			</div>
					</div>
							
				</div>
			</div>
		</div>		
	</div>
</body>
<script src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {

		$("#selectAll").click(function() {
			var checkTest = $("input:checkbox[id=selectAll]").is(":checked");
			if(checkTest == true){
				$("#selectYear").prop("disabled",true);
				$("#selectSemester").prop("disabled",true);
				$("#searchKeyword").prop("disabled",true);
				$("#selectYear option:eq(0)").prop("selected", true);
				$("#selectSemester option:eq(0)").prop("selected", true);
				$("#inputStatus option:eq(0)").prop("selected", true);
				$("#inputStatus").prop("disabled",true);
				//년도, 학기, 강의명 검색폼 안에 hidden으로 있는 inputStatus의 value값을 초기화해줌
				$("#inputStatus2").val("");
			}else{
				$("#selectYear").prop("disabled",false);
				$("#selectSemester").prop("disabled",false);
				$("#searchKeyword").prop("disabled",false);
				$("#inputStatus").prop("disabled",false);
			}
		});
		
		$('#inputStatus').on('change', function() {
			$("#inputStatusSearch").submit();
		});
		
	});
	
	//디테일 페이지 이동전 세션ID와 디테일페이지ID 대조
	function clickList(profId,lectOpenNum,checkSemester) {
		var sessionId= '${sessionScope.memberVo.memId}';
		var pageNo = '${param.pageNo}';
		if(profId != sessionId){
			alert("ID정보가 게시글ID와 일치하지 않습니다.");
			return;
		}else{
			if(pageNo == ""){
				pageNo = 1;
			}
			window.location.href = "/professor/attendance/detail?pageNo="+pageNo+"&lectOpenNum="+lectOpenNum+"&inputStatus=${param.inputStatus}&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}&checkSemester="+checkSemester;
		}
	}
	
</script>
</html>