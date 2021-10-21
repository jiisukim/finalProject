<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<style>
 a{
 	text-decoration: none !important;
 }
</style>
<script>
	$(function() {
		// 메뉴 액티브
		fn_menuActive();
	});
</script>

<div id="aside" style="float: left; clear: both;">
	<aside class="main-sidebar">
		<!-- Sidebar -->
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
			<br>
			<br>
			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/common/main"> 
				<img alt="mainlogo" src="/resources/img/camblogo.png" width="100px;">
			</a>
			<br>
			<br>
			<!-- Divider -->
			<hr class="sidebar-divider my-0">
			
			<!-- Nav Item - Dashboard -->
<!-- 			<li class="nav-item active"> -->
<!-- 				<a class="nav-link" href="/common/intro">  -->
<!-- 					<i class="fas fa-fw fa-tachometer-alt"></i> -->
<!-- 					<span>CamB 소개</span> -->
<!-- 				</a> -->
<!-- 			</li> -->

			<!-- Divider -->
			<hr class="sidebar-divider">
			
			<!-- ************** 학생 메뉴 시작 ************** ************** ************** ************** ************** ************** -->
			<c:if test="${sessionScope.memberVo.memTypeCode == '01'}">
			
			<li class="nav-item">
				<a class="nav-link collapsed" data-toggle="collapse" data-target="#STUDENT_lect" aria-expanded="true" aria-controls="STUDENT_lect"> 
					<i class="fas fa-dot-circle"></i>
					<span>수업</span>
				</a>
				<!-- 수업 하위메뉴 시작 -->
				<div id="STUDENT_lect" class="collapse " aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/student/lecture/lectureList">수강 목록</a>
						<a class="collapse-item" href="/student/lecture/lectureEval">강의 평가</a>
						<a class="collapse-item" href="/student/lecture/lectureScore">성적 확인</a> 
					</div>
				</div> <!-- 수업 하위메뉴 끝 -->
			</li>
			<li class="nav-item">
				<a class="nav-link collapsed"  data-toggle="collapse" data-target="#STUDENT_registLect" aria-expanded="true" aria-controls="STUDENT_registLect"> 
					<i class="fas fa-dot-circle"></i>
					<span>수강신청</span>
				</a>
				<!-- 수강신청 하위메뉴 시작 -->
				<div id="STUDENT_registLect" class="collapse " aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/student/registrationLectureL/lectureOpenList">수강신청</a>
						<a class="collapse-item" href="/student/registrationLectureC/cartList">장바구니</a>
						<a class="collapse-item" href="/student/registrationLectureR/registrationLectureList">수강신청 완료 확인</a> 
					</div>
				</div> <!-- 수강신청 하위메뉴 끝 -->
			</li>
			<li class="nav-item">
				<a class="nav-link collapsed" data-toggle="collapse" data-target="#STUDENT_acad" aria-expanded="true" aria-controls="STUDENT_acad"> 
					<i class="fas fa-dot-circle"></i>
					<span>학적</span>
				</a>
				<!-- 학적 하위메뉴 시작 -->
				<div id="STUDENT_acad" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/student/takeOff/takeOffApplyList">휴학</a>
						<a class="collapse-item" href="/student/return/returnApplyList">복학</a>
						<a class="collapse-item" href="/student/readmission/readmApplyList">복적 재입학</a> 
						<a class="collapse-item" href="/student/expulsion/expulsionApplyList">퇴학</a> 
						<a class="collapse-item" href="/student/courseChange/courseChangeApplyList">이수 변경</a>
					</div>
				</div> <!-- 학적 하위메뉴 끝 -->
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/student/tuitionPayment/tuitionPaymentList"> 
					<i class="fas fa-dot-circle"></i>
					<span>등록금</span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/student/graduate/gradEvaluationDetail"> 
					<i class="fas fa-dot-circle"></i>
					<span>졸업</span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/student/volunteer/volunteerList"> 
					<i class="fas fa-dot-circle"></i>
					<span>봉사</span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/student/consult/consultationList"> 
					<i class="fas fa-dot-circle"></i>
					<span>상담</span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link collapsed"  data-toggle="collapse" data-target="#STUDENT_dorm" aria-expanded="true" aria-controls="STUDENT_dorm"> 
					<i class="fas fa-dot-circle"></i>
					<span>생활관</span>
				</a>
				<!-- 생활관 하위 메뉴 시작 -->
				<div id="STUDENT_dorm" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/student/dorm/announcementOfAcceptance">합격조회</a>
						<a class="collapse-item" href="/student/dorm/dormApply">생활관 신청</a>
						<a class="collapse-item" href="/student/dorm/sleepOut/sleepOutApplyList">외박 신청</a>
					</div>
				</div>
				<!-- // 생활관 하위 메뉴 끝 -->
			</li>
			
			<li class="nav-item">
				<a class="nav-link collapsed"  data-toggle="collapse" data-target="#STUDENT_informatization_facility" aria-expanded="true" aria-controls="STUDENT_informatization_facility"> 
					<i class="fas fa-dot-circle"></i>
					<span>정보화시설</span>
				</a>
				<!-- 정보화 시설 하위 메뉴 시작 -->
				<div id="STUDENT_informatization_facility" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/student/readingRoom/readingRoomLookup">열람실 신청</a>
						<a class="collapse-item" href="/student/studyRoom/studyRoomReservation">스터디룸 신청</a>
					</div>
				</div>
				<!-- // 정보화 시설 하위 메뉴 끝 -->
			</li>
			</c:if>
			<!-- // ************** 학생 메뉴 끝 ************** ************** ************** ************** ************** ************** -->
			
			
			<!-- ************** 교수 메뉴 시작 ************** ************** ************** ************** ************** ************** -->
			<c:if test="${sessionScope.memberVo.memTypeCode == '02'}">
			<li class="nav-item" >
				<a class="nav-link collapsed" data-toggle="collapse" data-target="#PROFESSOR_menu" aria-expanded="true" aria-controls="PROFESSOR_menu"> 
					<i class="fas fa-dot-circle"></i>
					<span>강의 관리</span>
				</a>
				<!-- 강의 관리 하위 메뉴 시작 -->
				<div id="PROFESSOR_menu" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded" >
						<a class="collapse-item" href="/professor/study/list?pageNo=1">전체 강의
							<input type="hidden" value="/professor/study/detail"/>
						</a> 
						<a class="collapse-item" href="/professor/schedule/scheduleList">시간표 조회</a> 
						<a class="collapse-item" href="/professor/evaluation/lectureEvaluationList?pageNo=1">강의평가</a> 
						<a class="collapse-item" href="/professor/attendance/list">출결 관리</a>
						<a class="collapse-item" href="/professor/grade/list">성적 관리</a>
					</div>
				</div>
				<!-- // 강의 관리 하위 메뉴 끝 -->
			</li>
			
			<li class="nav-item">
				<a class="nav-link collapsed" data-toggle="collapse" data-target="#PROFESSOR_consulting" aria-expanded="true" aria-controls="PROFESSOR_consulting">  
					<i class="fas fa-dot-circle"></i>
					<span>학생 상담 관리</span>
				</a>
				<!-- 학생 상담 관리 하위 메뉴 시작 -->
				<div id="PROFESSOR_consulting" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/professor/consulting/list">상담 조회</a> 
						<a class="collapse-item" href="/professor/consulting/possibleTimeList">상담 시간 관리</a> 
						<a class="collapse-item" href="/professor/consulting/chart">상담 통계</a>
					</div>
				</div>
				<!-- // 학생 상담 관리 하위 메뉴 끝 -->
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="/auth/authDocListForSteps"> 
					<i class="fas fa-dot-circle"></i>
					<span>결재</span>
				</a>
			</li>
			</c:if>
			<!-- // ************** 교수 메뉴 끝 ************** ************** ************** ************** ************** ************** -->
			
			<!-- ************** 직원 메뉴 시작 ************** ************** ************** ************** ************** ************** -->
			<c:if test="${sessionScope.memberVo.memTypeCode == '03'}">
			<li class="nav-item">
				<a class="nav-link collapsed" data-toggle="collapse" data-target="#ADMIN_auth" aria-controls="ADMIN_auth"> 
					<i class="fas fa-dot-circle"></i>
					<span>결재</span>
				</a>
				<!-- 결재 하위 메뉴 시작 -->
				<div id="ADMIN_auth" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/auth/authDocListForSteps">결재</a> 
						<a class="collapse-item" href="/auth/authDocList">결재 기안</a> 
						<a class="collapse-item" href="/auth/authLineList">결재 선 관리</a>
					</div>
				</div>
				<!-- // 결재 하위 메뉴 끝 -->
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/admin/member/list"> 
					<i class="fas fa-dot-circle"></i>
					<span>사용자 관리</span>
				</a>
			</li>
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>강의 관리</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
			<li class="nav-item">
				<a class="nav-link" href="/admin/tuitionPayment/tuitionPaymentList"> 
					<i class="fas fa-dot-circle"></i>
					<span>학생 등록 내역</span>
				</a>
			</li>
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>학적</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>학사 일정</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
			<li class="nav-item">
				<a class="nav-link" href="/admin/univDep/list"> 
					<i class="fas fa-dot-circle"></i>
					<span>학과 관리</span>
				</a>
			</li>
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>증명서</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>급여</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>Q&A</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>시설</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
<!-- 			<li class="nav-item"> -->
<!-- 				<a class="nav-link" href="#">  -->
<!-- 					<i class="fas fa-dot-circle"></i> -->
<!-- 					<span>봉사</span> -->
<!-- 				</a> -->
<!-- 			</li> -->
			</c:if>
			<!-- // ************** 직원 메뉴 끝 ************** ************** ************** ************** ************** ************** -->
			

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->
	</aside>
</div>