<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.headNavA{
		color: gray !important;
	}
	.headNavA:hover {
		color: silver !important;
	}
	.headNavLi.active .headNavA{
		color: #5175DF !important;
	}
</style>

<script>
	// 드롭다운 메뉴 (공지사항)은 active 시 표시를 따로 해줘야 함
	$(function () {
		// 1. url 가공 
		var url = window.location.pathname;
		var urlIdxParam = url.lastIndexOf("?"); 
		if(urlIdxParam > 0) url = url.substring(0, url.lastIndexOf("?")); // OSY : get 파라미터가 있다면 삭제
		
		// 3. 비교 후 active, show : 하위 메뉴 있을 경우 - 하위 메뉴의 href와 비교
		$('.dropdown-item').each(function() {
			var href = this.href.substring(this.href.indexOf("/",7)); // 'http://localhost:9090' 삭제한 pathName - url과 비교
			
			var hrefIdxParam = href.lastIndexOf("?"); // OSY : get 파라미터가 있다면 삭제
			if(hrefIdxParam > 0) href = href.substring(0, hrefIdxParam);
			
			if(url == href){
				$(this).parents(".headNavLi").addClass('active'); // 조상 중 .nav-item을 active
			}
		});
	});
</script>

<div id="header">
				<!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                     <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                         <i class="fa fa-bars"></i>
                     </button> 
					
					<!-- ****** 공통 메뉴 시작 ******************************************************-->
						<ul class="navbar-nav mr-auto ">
	
							<!-- 캘린더 시작 -->
							<li class="nav-item headNavLi">
								<a class="nav-link headNavA" href="/common/calendar/calendarList" role="button" style="font-size: small; ">
									<i class="fas fa-dot-circle mr-2"></i>
									캘린더
                                </a> 
							</li>
							<!-- // 캘린더 끝 -->	
							
	                        
	                        <!-- 공지사항 시작 -->
	                       	<li class="nav-item dropdown no-arrow headNavLi">
	                            <a class="nav-link dropdown-toggle headNavA" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
	                                <span class="d-none d-lg-inline small ">
		                                <i class="fas fa-dot-circle mr-2"></i>
	                                	공지사항 
	                                </span>
	                            </a>
	                            <!-- Dropdown - User Information -->
	                            <div class="dropdown-menu dropdown-menu-left shadow animated--grow-in" aria-labelledby="userDropdown">
		                    	    <a class="dropdown-item" href="/common/notice/noticeList">
		                    	    	<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
		                                 	전체 공지사항
		                            </a> 
		                   
		                            <div class="dropdown-divider"></div>
		                            
		                            <a class="dropdown-item" href="/common/deptNotice/deptNoticeList">
		                            	<i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
		                                 	학과 공지사항
		                            </a>  
	                            </div>
	                        </li>
							<!-- // 공지사항 끝 -->
							
							
							<!-- FAQ 시작 -->
							<li class="nav-item headNavLi">
								<a class="nav-link headNavA" href="/common/faq/faqList" role="button" style="font-size: small;">
									<i class="fas fa-dot-circle mr-2"></i>
                                	F A Q
                                </a> 
							</li>
							<!-- // FAQ 끝 -->	
							
							
							<!-- Q&A 시작 -->
							<li class="nav-item headNavLi">
								<a class="nav-link headNavA"  href="/common/inquiry/inquiryList" role="button" style="font-size: small;">
									<i class="fas fa-dot-circle mr-2"></i>
                                	Q & A
                                </a> 
							</li>
							<!-- // Q&A 끝 -->	
	                    </ul>
					
					
					<!-- // 공통 메뉴 끝 -->
                    
                    
                    
                    
                     <!-- ****** 사용자 메뉴 시작 ******************************************************-->
                     
                    <ul class="navbar-nav ml-auto">

                        <!-- 로그아웃 상태 -->
                        <c:if test="${sessionScope.memberVo.memId==null}">
                        	<li class="nav-item headNavLi">      
                                <a class="headNavA" href="/common/login" style="font-size: small;">
                                <i class="fas fa-dot-circle mr-2"></i>
                                	로그인
                                </a>  
                            </li>
                        </c:if>        
                        <!-- // 로그아웃 상태 -->
                        
						<!-- 로그인 상태 -->                                                
                        <c:if test="${sessionScope.memberVo.memId!=null}">
                       	<li class="nav-item dropdown no-arrow headNavLi">
                       		<a class="nav-link dropdown-toggle headNavA" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
                                <span class="d-none d-lg-inline small ">
	                                <i class="fas fa-dot-circle mr-2"></i>
                                	내 정보
                                </span>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
	                    	    <a class="dropdown-item" href="/common/myPage/myPageList">
	                                 <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
	                                 	마이 페이지
	                            </a> 
	                   
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="/logout">
	                                 <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
	                                 	로그아웃
	                            </a>  
                            </div>
                        </li>
						</c:if>
						<!-- // 로그인 상태 --> 
						<!-- // 사용자 메뉴 끝 -->
						
                    </ul>

                </nav>
                <!-- End of Topbar -->
</div>