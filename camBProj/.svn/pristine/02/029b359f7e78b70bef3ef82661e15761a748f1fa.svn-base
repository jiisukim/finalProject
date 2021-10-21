<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<style>
	tbody tr:hover{
		background-color: #F4F5F9;
	}
	.pagination {
		justify-content: center; 
		align-items: center;
	}
	
</style>

<body>
	<div class="card shadow mb-4" style="width: 98%;">
		<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary" style="cursor: pointer;" onclick="javascript:location.href='/professor/study/list?pageNo=1'">전체 강의</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="width: 99%">
					<div class="row">
						<div class="col-sm-12">
					
						<form method="get" action="/professor/study/list" name="frmSearch" id="frmSearch">
							<input type="hidden" name="pageNo" value="1">
									<div style="float: right; width: 70%; margin-top: 4%;">
											<button type="submit" class="btn btn-secondary " style=" float: right; margin-left: 1%;" >검색</button>
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
							<span style="color: black; font-weight: bold; float: left; margin-top: 5%;">총 <span style="color: #C02B55"><fmt:formatNumber value="${totalCount}" pattern="#,###" /></span>건의 게시물이 있습니다.</span>
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
										<th class="sorting sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 15%;">
											강의실
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 5%;">
											분반
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 10%;">
											교과구분
										</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 5%;">
											개설 여부
										</th>
									</tr>
								</thead>
								
								<tbody>
								<c:forEach var="list" items="${list}">
									<tr class="trClick" style="cursor: pointer;" onclick="javascript:location.href='/professor/study/detail?pageNo=${param.pageNo}&lectOpenNum=${list.lectOpenNum}&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}'">
										<td style="vertical-align: middle; padding: 3px">${list.rnum}</td>
										<td style="vertical-align: middle; padding: 3px">${list.subjNum}</td>
										<td style="text-align: left; vertical-align: middle; padding: 3px">${list.year}/${list.semCode}</td>
										<td style="text-align: left; vertical-align: middle; padding: 3px">${list.lectName}</td>
										<td style="text-align: left; padding: 3px">
										${list.buildName}(${list.buildCode}) <br/> ${fn:substring(list.roomNum,2,4) }층 ${fn:substring(list.roomNum,4,6)}호
										</td>
										<td style="vertical-align: middle; padding: 3px">${list.divideNum}</td>
										<td style="vertical-align: middle; padding: 3px">${list.subjTypeCode}</td>
										<td style="vertical-align: middle; padding: 3px">${list.procStatCode}</td>
									</tr>
								</c:forEach>
									
								</tbody>
							</table>
						</div>
						
						
						<c:set var="list" value="${list}"></c:set>
						<c:if test="${empty list}"></c:if>
						<div style="width: 100%;">
							<div id="paging" class="col-sm-12-text-center">
								<ul class="pagination">
								<!-- previous 시작 -->
						            <c:if test="${paginationInfo.firstPageNoOnPageList > 5 }">
						              <li style="list-style: none;" class="paginate_button page-item previous" id="example2_previous"> 
						            </c:if>
						            <c:if test="${paginationInfo.firstPageNoOnPageList <= 5 }">
						              <li style="list-style: none;" class="paginate_button page-item previous disabled" id="example2_previous"> 
						            </c:if>      
						              <a href="/professor/study/list?pageNo=${paginationInfo.firstPageNoOnPageList - 5 }&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">이전</a>
						            </li>      
						            <!-- previous 끝 -->
						            
									<!-- page번호 시작 -->
									<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
										  <li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (empty param.pageNo && pageNo == 1)}">active</c:if>">
							                <a href="/professor/study/list?pageNo=${pageNo}&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}" aria-controls="example2" data-dt-idx="${pageNo }" tabindex="0" class="page-link">${pageNo }</a>
							              </li>        
						            </c:forEach> 
						            <!-- page번호 끝 -->
						            
						            <!-- next시작 -->
						            <li style="list-style: none;" class="paginate_button page-item next 
						            <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if> " id="example2_next">
						              <a href="/professor/study/list?pageNo=${paginationInfo.lastPageNoOnPageList + 1 }&selectYear=${param.selectYear}&selectSemester=${param.selectSemester}&searchKeyword=${param.searchKeyword}" aria-controls="example2" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" tabindex="0" class="page-link">다음</a>
						            </li>       
						            <!-- next끝 -->       
		            			</ul>
	            			</div>
            			</div>
					</div>
					
					
					<hr/>
					<div class="row" style=" float: right; margin-right: 2px;">
						<a href="/professor/study/insert?univDeptNum=${dept.univDeptNum}" class="btn btn-primary btn-icon-split" > 
							<span class="text">강의 신청</span>
						</a>
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
			}else{
				$("#selectYear").prop("disabled",false);
				$("#selectSemester").prop("disabled",false);
				$("#searchKeyword").prop("disabled",false);
			}
		});
	});

	function linkPage(pageNo) {
		location.href = "/professor/study/list?pageNo=" + pageNo;
	}
</script>
</html>