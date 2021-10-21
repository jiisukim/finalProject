<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.lectName:hover{
		background-color: #F4F5F9;
	}
</style>
<title></title>
</head>
<body>
	<br/>
	<form style="text-align: center;" method="get" action="/professor/study/popup/lectureSubject" name="subjectSearch" id="subjectSearch">
		<input type="hidden" value="${param.univDeptNum}" name="univDeptNum" id="univDeptNum">
		<span style="float: left; margin-top: 6px; margin-left: 28%;">강의명 &nbsp;</span><input type="text" class="form-control" id="searchKeyword" name="searchKeyword" value="${param.searchKeyword}" style="width: 30%; float: left;">&nbsp;
		&nbsp;
		<button type="submit" class="btn btn-secondary" style=" float: left; margin-left: 1%;">검색</button>
	</form>
	<div class="card shadow mb-4" style="width: 90%; margin:0px 30px;">
		<div class="card-body">
			<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%; text-align: center;">
				<tr>
					<th>학수번호</th>
					<th>강의명</th>
					<th>학과</th>
					<th>교과구분</th>
					<th>학점</th>
				</tr>
				<c:forEach var="subjectVO2" items="${subjectVO2}" varStatus="stat" >  
					<tr style="cursor: pointer;" class="lectName" id="${stat.count}"> 
						<td id="subjNum${stat.count}">${subjectVO2.subjNum}</td>
						<td id="subjName${stat.count}">${subjectVO2.subjName}</td>
						<td id="univDeptName${stat.count}">${subjectVO2.univDeptName}<input type="hidden" value="${subjectVO2.univDeptNum}"> </td>
						<td id="subjTypeCode${stat.count}">${subjectVO2.subjTypeCodeName}<input type="hidden" value="${subjectVO2.subjTypeCode}"></td>
						<td id="cred${stat.count}">${subjectVO2.cred}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
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
	              <a href="/professor/study/popup/lectureSubject?univDeptNum=${param.univDeptNum}&pageNo=${paginationInfo.firstPageNoOnPageList - 5 }&searchKeyword=${param.searchKeyword}" aria-controls="example2" data-dt-idx="0" tabindex="0" class="page-link">이전</a>
	            </li>      
	            <!-- previous 끝 -->
	            
				<!-- page번호 시작 -->
				<c:forEach var="pageNo" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }" varStatus="stat">
					  <li style="list-style: none;" class="paginate_button page-item <c:if test="${pageNo == param.pageNo || (empty param.pageNo && pageNo == 1)}">active</c:if>">
		                <a href="/professor/study/popup/lectureSubject?univDeptNum=${param.univDeptNum}&pageNo=${pageNo}&searchKeyword=${param.searchKeyword}" aria-controls="example2" data-dt-idx="${pageNo }" tabindex="0" class="page-link">${pageNo }</a>
		              </li>        
	            </c:forEach> 
	            <!-- page번호 끝 -->
	            
	            <!-- next시작 -->
	            <li style="list-style: none;" class="paginate_button page-item next 
	            <c:if test="${paginationInfo.lastPageNoOnPageList == paginationInfo.totalPageCount}">disabled</c:if> " id="example2_next">
	              <a href="/professor/study/popup/lectureSubject?univDeptNum=${param.univDeptNum}&pageNo=${paginationInfo.lastPageNoOnPageList + 1 }&searchKeyword=${param.searchKeyword}" aria-controls="example2" data-dt-idx="${paginationInfo.lastPageNoOnPageList + 1 }" tabindex="0" class="page-link">다음</a>
	            </li>       
	            <!-- next끝 -->       
 				</ul>
			</div>
		</div>
</body>
<script src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">

	$(function () {
		
		$(".lectName").click(function() {
			var num = $(this).attr('id');
			$("#subjNum",opener.document).val($("#subjNum"+num).text());
			$("#lectName",opener.document).val($("#subjName"+num).text());
			$("#univDeptName",opener.document).val($("#univDeptName"+num).text());			
			$("#univDeptNum",opener.document).val($("#univDeptName"+num).children('input').val());			
			$("#subjTypeCodeName",opener.document).val($("#subjTypeCode"+num).text());
			$("#subjTypeCode",opener.document).val($("#subjTypeCode"+num).children('input').val());
			$("#cred",opener.document).val($("#cred"+num).text());
			self.close();
		});
		
	});
	
	
</script>
</html>

	