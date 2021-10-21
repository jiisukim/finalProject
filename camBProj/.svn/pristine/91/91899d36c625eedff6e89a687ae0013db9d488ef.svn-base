<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="/resources/css/authDocFormat.css" rel="stylesheet">

<div id="body">

	<div class="row">
	
		<div class="col-sm-9 text-center" >
			<!-- 문서 헤더 시작-->
	
			<table id="tb1">
				<colgroup>
					<col width="80px;">
					<col width="135px;">
					<col width="80px;">
					<col width="116px;">
					<col width="80px;">
					<col width="91px;">
					<col width="80px;">
					<col width="116px;">
				</colgroup>
				<tbody>
					<tr>
						<td id="title" colspan="8">
							이수 변경 신청 
						</td>
					</tr>
					<tr>
						<td class="item1"> 
							기안부서
						</td>
						<td class="val1">
							학사관리 부
						</td>
						<td class="item1">
							수신 일자
						</td>
						<td class="val1 text-center">
							${authDocVo.rcpDate}
						</td>
						<td class="item1">
							문서 번호
						</td>
						<td class="val1" colspan="3">
							${authDocVo.authDocNum}
						</td>
					</tr>
					<tr>
						<td class="item1">
							기 안 자 
						</td>
						<td class="val1">
							${authDocVo.memId} 
						</td>
						<td class="item1">
							수신
						</td>
						<td class="val1 text-center">
							${authDocVo.rcpCode} 
						</td>
						<td class="item1">
							결재 상태
						</td>
						<td class="val1 text-center">
							${authDocVo.authStatCode}
						</td>
						<td class="item1">
							결재 일자
						</td>
						<td class="val1 text-center">
							${authDocVo.updateDate}
							<c:if test="${authDocVo.updateDate == null}"> -- </c:if>
						</td>
					</tr>
				</tbody>
			</table> <!-- // 문서 헤더 끝-->
			
			<!-- 제목 및 내용 시작 -->
			<table>
				<tbody>
					<tr> <!-- class="dext_table_border_t dext_table_border_r dext_table_border_b dext_table_border_l" -->
						<td id="tdContent" colspan="2">
							<br>
							<table style="border-collapse: collapse !important; color: black; background: white; border: 2px solid black">
								<colgroup>
									<col width="75px;">
									<col width="157px;">
									<col width="80px;">
									<col width="91px;">
								</colgroup>
								<tbody>
									<tr>
										<td class="item1">
											학과 
										</td>
										<td class="val1"> 	
											${memberVo.univDeptNum}
										</td>
										<td class="item1">
											등록 학기
										</td>
										<td class="val1">
											${memberVo.rgstSem} 학기
										</td>
									</tr>
									<tr>
										<td class="item1">
											학번
										</td>
										<td class="val1">
											${memberVo.stdId}
										</td>
										<td class="item1">
											성명
										</td>
										<td class="val1">
											${memberVo.name}
										</td>
									</tr>
								</tbody>
							</table>
	
	
							<table id="currencyTable" style="margin-top:20px; border-collapse: collapse !important; color: black; background: white; border: 2px solid black;">
	
								<tbody>
									<tr>
										<td style="padding: 3px; height: 99px; vertical-align: middle; border: 1px solid black; text-align: center; font-weight: bold;" colspan="3">
											아래와 같이 ${applyVo.year} 학년도 제 ${applyVo.semCode} 이수 변경을 신청합니다.
										</td>
									</tr>
									<tr>
										<td class="item1" rowspan="4">
											내용
										</td>
										<td class="item2">
											이수 변경 유형
										</td>
										<td class="val1">
											${applyVo.courseChngCode}
										</td>
									</tr>
									<tr>
										<td class="item2">
											희망 학과
										</td>
										<td class="val1">
											${applyVo.korName}
										</td>
									</tr>
									<tr>
										<td class="item2">
											이수 학점 / 평점
										</td>
										<td class="val1">
											${applyVo.stdCred}학점 / ${applyVo.stdScore}점 <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#scoreDetail" >성적 일람표</button>
										</td>
									</tr>
									<tr>
										<td class="item2">
											합격 기준 (학생 석차 / 지원자 수 / 모집 정원)
										</td>
										<td class="val1">
											${applyVo.stdRank}등 / ${applyVo.stdApplyCnt}명 / ${applyVo.maxCap}명
										</td>
									</tr>
								</tbody>
							</table> <br>
						</td>
					</tr>
				</tbody>
			</table> <!-- 제목 및 내용 끝 --> 
		</div>
		
		<div class="col-sm-3 text-center" >
			<table id="tb2">
				<tbody>
					<tr>
						<td class="item1">결재 선</td>
					</tr>
					
					<c:if test="${authDetailInfoVoList == null || authDetailInfoVoList == '' || authDetailInfoVoList == '[]'}">
						<tr>
							<td class="val2" style="border-top: solid 3px black;">
								결재선을 선택한 후 <br /> 
								기안을 제출하세요
							</td>
						</tr>
					</c:if>
					
					<!-- 결재 스텝, 결재 상세 가져오기 -->
					<c:forEach items="${authDetailInfoVoList}" var="authDetailInfoVo" varStatus="stat">
					<tr>
						<td class="val2" style="border-top: solid 3px black;">
							${authDetailInfoVo.univDeptNum}${authDetailInfoVo.deptCode} / ${authDetailInfoVo.jobCode}
						</td>
					</tr>
					<tr>
						<td class="val2">
							${authDetailInfoVo.name}
						</td>
					</tr>
					<tr>
						<td class="val2" style="height: 40px;">
							<img alt="authImage" 
								<c:if test="${authDetailInfoVo.procStatCode=='접수'}"> 
									 style="height: 40px;" src="/resources/img/auth/rcp.png"								 
								</c:if>
								<c:if test="${authDetailInfoVo.procStatCode=='승인'}"> 
									 style="height: 60px;" src="/resources/img/auth/auth.png"								 
								</c:if>
								<c:if test="${authDetailInfoVo.procStatCode=='미승인'}"> 
									 style="height: 60px;" src="/resources/img/auth/disAuth.png"								 
								</c:if>
							/>
						</td>
					</tr>
					<tr>
						<td class="val2" style="border-bottom: solid 3px black;">
							<c:if test="${authDetailInfoVo.authDate==null}">-</c:if>${authDetailInfoVo.authDate}
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/jsp/views/student/courseChange/scoreDetail.jsp"></jsp:include>
	
</div>

<script>
	$(function () {
			console.log('${applyVo}');
	});
</script>
