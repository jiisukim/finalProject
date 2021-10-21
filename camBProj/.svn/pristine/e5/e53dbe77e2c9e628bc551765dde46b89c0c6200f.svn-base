<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<style>
	#div1{
		width: 500px; 
		height: 560px; 
		/* background-color: #e9ecef; */
		background: linear-gradient(#e9ecef 50%, #191970 50%);
		margin-left: 190px; margin-top: 28px; 
		border-radius: 25px;
		float: left;
		
	}
	#div2{
		width: 600px; 
		height: 560px; 
		background-color: #e9ecef;
		margin-left: 100px; margin-top: 5px; 
		border-radius: 25px;
		float: left;
	}

	#name{
		margin-top: 15px;
		text-align: center;
		color: black;	
	}
	#pwdCh{
		margin-left: 30px;
		color: black;
	}
	#memId{
		margin-left:20px;
		color: white;
		margin-top: 150px;
	}
	.gradient {
	    background-image: linear-gradient(180deg,#4e73df 10%,#17146e 100%);
	}
	table {
	  border-collapse: separate;
	  border-spacing: 3rem 1rem;
	}
	th {
		font-weight: bold;
		color: #4e73df;
	}
	td {
		border-bottom: 1px solid #F0F0F0;
		width: 230px;
	}
</style>

<div id="body">

	<div class="card shadow mb-4" style="width: 800px;">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">마이페이지</h6>
		</div>

		<input name="memId" type="hidden" value="${list.memId}">
		<input name="pwd" type="hidden" value="${list.pwd}">
		
		<div class="card-body">
		
			<div class="row">
			
				<!-- 사진 -->
				<div class="col-sm-4" style="text-align: center;">
					<div class="mb-2" style="width: 150px; height: 150px; margin: auto; margin-top: 20px;">
						<!-- 사진이 없으면 기본 사진을 보여준다 -->
                   		<c:if test="${MemberInfoVO.filePath != null}">
                   			<c:set var="filePath" value="/${MemberInfoVO.filePath}"/>
                   		</c:if>
                   		<c:if test="${MemberInfoVO.filePath == null}">
                   			<c:set var="filePath" value="/resources/img/temp/profile.png"/>
                       	</c:if>
                       	<img src="${filePath}" style="height:100%; width: 100%; border-radius: 5px; box-shadow: 3px 3px 3px lightgray;">
                       	<!-- //사진이 없으면 기본 사진을 보여준다 -->
					</div>
					
					<hr>
					
					<!-- 회원 유형 별 정보 -->
					<div class="text-center">
						<c:choose>
						    <c:when test="${memberVo.memTypeCode=='01'}">
								<div class="text-center" id="studentInfo">
									<!-- 등록한 학기가 없으면 '미등록 신입생' 표시 -->
	                           		<c:if test="${MemberInfoVO.rgstSem != null}">
	                           			<c:set var="rgstSem" value="${MemberInfoVO.rgstSem}"/>
	                           		</c:if>
	                           		<c:if test="${MemberInfoVO.rgstSem == null}">
	                           			<c:set var="rgstSem" value="미등록 신입생"/>
	                           		</c:if>
	                           		<!-- // 등록한 학기가 없으면 '미등록 신입생' 표시 -->
	                           		<label class="badge badge-light" style="font-size: 1.1em;">${MemberInfoVO.stdUnivDeptNum}</label><br/>
	                           		<label class="badge badge-light" style="font-size: 1.1em;">${rgstSem}학기</label>
	                           		<label class="badge badge-light" style="font-size: 1.1em;">${MemberInfoVO.acadStatCode}</label><br/>	
								</div>
						    </c:when>
						    <c:when test="${memberVo.memTypeCode=='02'}">
								<div class="text-center" id="professorInfo">
	                               	<label class="badge badge-light" style="font-size: 1.1em;">${MemberInfoVO.profUnivDeptNum}</label>
								</div>
						    </c:when>
						    <c:otherwise>
								<div class="text-center" id="employeeInfo">
	                             	<label class="badge badge-light" style="font-size: 1.1em;">${MemberInfoVO.deptCode}</label><br/>
	                             	<label class="badge badge-light" style="font-size: 1.1em;">${MemberInfoVO.jobCode}</label>
								</div>
						    </c:otherwise>
						</c:choose> 
					</div>
					<!-- //회원 유형 별 정보 -->
					
					<hr>
					
					<!-- 바로가기 -->
					<div class="row">
						<c:if test="${memberVo.memTypeCode=='01'}">
							<div class="col-sm-6">
								<a href="/common/calendar/calendarList" class="btn btn-info btn-circle shadow"> 
									<i class="fas fa-calendar"></i>
								</a>
								<p style="margin-top: 8px;">일정관리</p>
							</div>
							<div class="col-sm-6">
								<a href="/common/inquiry/inquiryList?searchCondition=memId&searchKeyword=${memberVo.memId}" class="btn btn-info btn-circle shadow"> 
									<i class="fas fa-question"></i>
								</a>
								<p style="margin-top: 8px;">나의 Q&A</p>
							</div>
						</c:if>
						<c:if test="${memberVo.memTypeCode!='01'}">
							<div class="col-sm-12">
								<a href="/common/calendar/calendarList" class="btn btn-info btn-circle shadow"> 
									<i class="fas fa-calendar"></i>
								</a>
								<p style="margin-top: 8px;">일정관리</p>
							</div>
						</c:if>
					</div>
					<!-- // 바로가기 -->
					
				</div>
				<!-- // 사진 -->
				
				<!-- 기본 정보-->
				<div class="col-sm-8">
					<table>
						<tr> 
							<th class="td1">아이디</th>
							<td>${memberVo.memId}</td>
						</tr>
						<tr> 
							<th class="td1">이름</th>
							<td>${memberVo.name}</td>
						</tr>
						<tr> 
							<th class="td1">전화번호</th>
							<td>${memberVo.phNum}</td>
						</tr>
						<tr> 
							<th class="td1">이메일</th>
							<td>${memberVo.email}</td>
						</tr>
						<tr> 
							<th class="td1">우편번호</th>
							<td>
								${memberVo.zipcode}
							</td>
							
						</tr>
						<tr> 
							<th class="td1">주소</th>
							<td>${memberVo.addr}
						</tr>
						<tr> 
							<th class="td1">상세 주소</th>
							<td>${memberVo.addrDetail}</td>
						</tr>
						<tr> 
							<th class="td1">은행 명</th>
							<td>${memberVo.bankCode}</td>
						</tr>
						<tr> 
							<th class="td1">계좌 번호</th>
							<td>${memberVo.bankAccntNum}</td>
						</tr>
						<tr> 
							<th class="td1">비밀번호 변경일</th>
							<td>${memberVo.modDateDisplay}<c:if test="${memberVo.modDateDisplay == null}">-</c:if></td>
						</tr>
					</table>
					<div>
						<p style="margin-left: 30px; color: red; font-size: small;text-align: right;">*비밀번호 90일 이상 사용 시 변경을 권장드립니다.</p>
					</div>
				</div>
				<!-- //기본 정보 수정 -->
				
			</div><!-- // 정보 -->
			
			<hr>
			
			<!-- 버튼 -->
			<div class="row">
				<div class="col-sm-12 text-right">
					<button type="button" class="btn btn-primary btn-primary-crud" onclick="location.href='/common/myPage/myPageCheckPwd?memId=${list.memId}'">정보 변경</button>
				</div> 
			</div>
			<!-- // 버튼 -->
			
		</div>
	</div>
</div>
