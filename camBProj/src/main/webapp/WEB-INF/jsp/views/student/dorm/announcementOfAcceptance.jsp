<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
/* 	#studentDiv{ */
/* 		margin-left: 80px; */
/* 	} */
	
/* 	#studentDiv > div > div { */
/* 		margin-right: 30px; */
/* 	} */
	
	
</style>

<div style="display: none;">
	<input type="text" class="postArea" id="stdId" name="stdId" <c:if test="${sessionScope.student == '01'}">value="${memberVo.memId}"</c:if>>
	<select class="postArea" id="year" name="year" disabled></select>
	<select class="postArea" id="semCode" name="semCode" disabled>
		<c:forEach var="code" items="${semCode}">
			<option value="${code.codeVal}">${code.codeName}</option>
		</c:forEach>
	</select>
</div>
<!-- ajax를 위한 정보 (숨김처리 해서 안보임) -->

<div class="card shadow">
	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">학생정보</h6>
	</div>
	<div class="card-body" id="studentDiv">
		<div class="row" id="inform">
			<div class="col-sm-3">
				<div class="form-group">
					학번 <input type="text" class="form-control" id="StdId">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					성명 <input type="text" class="form-control" id="name">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					성별 <input type="text" class="form-control" id="gen">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					단과대학 <input type="text" class="form-control" id="korNameUniv">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					학과 <input type="text" class="form-control" id="korNameDept">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					핸드폰 <input type="text" class="form-control" id="phNum">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					이메일 <input type="text" class="form-control" id="email">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					주소 <input type="text" class="form-control" id="Addr">
				</div>
			</div>
		</div>
	</div>
</div>

<br /><br />

<div class="card shadow">

	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">합격조회</h6>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
                    <label for="acptYn">합격여부</label>
                    <input type="text" class="form-control" id="acptYn"
<%--                     	<c:if test="${dormVo.acptYn == 'Y'}">value="합격"</c:if> --%>
<%--                     	<c:if test="${dormVo.acptYn == 'N'}">value="불합격"</c:if> --%>
					>
                  </div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
                    <label for="buildCode">생활관</label>
                    <input type="text" class="form-control" id="buildCode">
                  </div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
                    <label for="feePayYn">비용납부여부</label>
                    <input type="text" class="form-control" id="feePayYn"
<%--                      	<c:if test="${dormVo.feePayYn == 'Y'}">value="납부"</c:if> --%>
<%--                      	<c:if test="${dormVo.feePayYn == 'N'}">value="미납"</c:if> --%>
                     >
                  </div>
			</div>
		</div>
	</div>
</div>

<br /><br />

<div class="card shadow">

	<div class="card-header">
		<h6 class="card-title m-0 font-weight-bold text-primary">입사서약서</h6>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-sm-12">
				<div class="form-group">
					<textarea class="form-control" rows="6">
  위 본인은 생활관 입사기간 중 아래 생활관 기숙사 생활수칙 (벌점기준)을 위반하지 않을 것을 서약합니다.
  1. 학칙에 의하여 징계받은 자(학사 경고 등)									퇴사
  2. 전염병에 감염된 자(자가 치료)											권고퇴사
  3. 절도 행위나 사내 폭행													퇴사
  4. 생활지도에 불응 반항하여 기숙사생으로 적합하지 않다고 인정된 자			퇴사
  5. 공공기물을 파손한 자(변상)												퇴사
  6. 사내에서 취사행위한 자													퇴사
  7. 화재를 일으킨 자															퇴사
  8. 남학생이 여자기숙사에, 여학생이 남자기숙사에 허락없이 출입한 자			퇴사
  9. 위험물질이나 취사도구(전열기구)를 기숙사내에 들여온 자					벌점 5점
  10.실내에서 흡연한 자														벌점 5점
  11.타인을 무단으로 출입시킨 자												벌점 3점
  12.허락없이 다른 사람의 물품을 사용한 자									벌점 3점
  13.음주, 고성방가, 소란, 기타 경범죄에 속하는 행위를 한 자					벌점 3점
  14.생활관 예배 및 특강에 불참한 자											벌점 2점
  15.임의로 외박한 자														벌점 2점
  16.청소를 게을리 한 방(각자 점수 부가)										벌점 2점
  17.비품을 무단 이동한 자													벌점 2점
  18.낙서, 부착물의 첨부, 광고물 무단전시 및 배포한 자							벌점 2점
  19.음식물 반입자															벌점 2점
  20.지시사항을 불이행한 자													벌점 2점
  21.지각한 자(23:00～24:00 귀사자)											벌점 1점
[참고]
  1. 벌점 누계가 10점 이상인 자는 퇴사, 9점일 경우 학부형에게 통보
  2. 벌점 혹은 징계로 퇴사한 자는 차후 입사 불허(복학 때에도 불허)
  3. 벌점 관련하여, 생활관 내에서 봉사활동 실시 의무
￭ 점호시간 23:00 엄수(23:00～05:00까지 외출금지)
￭ 벌점과 징계로 인하여 퇴사 때에는 생활관규정에 의하여 환불 없음
                        </textarea>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$("input").prop("disabled", true);

		//년도와 학기 값 자동으로 넣어서 disabled
		var now = new Date();
		var year = now.getFullYear();
		var yearVal = "";
		yearVal = "<option>" + year + "</option>"

		$("#year").html(yearVal);

		var month = now.getMonth() + 1; //'월'은 0~11까지라서 +1해줘야함

		if (month >= 3 && month < 6) { // 1학기
			$("#semCode option:eq(0)").prop("selected", true);
		} else if (month >= 9 && month < 12) { //2학기
			$("#semCode option:eq(1)").prop("selected", true);
		} else if (month >= 6 && month < 9) { //여름학기
			$("#semCode option:eq(2)").prop("selected", true);
		} else { //겨울학기
			$("#semCode option:eq(3)").prop("selected", true);
		}

		var stdId = $("#stdId").val();
		var year = $("#year option:selected").val();
		var semCode = $("#semCode option:selected").val();

		var json = {
			"stdId" : stdId,
			"year" : year,
			"semCode" : semCode
		}

		//조건 날리면 바로 조회되는 ajax
		$.ajax({
			url : "/student/dorm/selectCondition",
			data : JSON.stringify(json),
			contentType : "application/json; charset=UTF-8", //보낼타입
			dataType : "json", //받을타입
			type : "post",
			success : function(data) {
				console.log(data);
				temp(data);
			},
			error : function(xhr) {
				alert("신청내역이 존재하지 않습니다.");
			}
		});

		function temp(data) {

			var acptYnResult = "";
			var color = "";

			if (data.acptYn == 'Y') {
				acptYnResult = "합격";
				color = 'blue';
			} else if (data.acptYn == 'N') {
				acptYnResult = "불합격";
				color = 'red';
			}else {
				acptYnResult = "접수";
				color = 'green';
			}

			$("#acptYn").val(acptYnResult).css("color" , color);

			var buildCode = "";

			if (data.buildCode == '09') {
				buildCode = '진리의 집';
			} else if (data.buildCode == '10') {
				buildCode = '자유의 집';
			} else if (data.buildCode == '11') {
				buildCode = '소망관';
			}

			$("#buildCode").val(buildCode);

			var feePayYnResult = "";

			if (data.feePayYn == 'Y') {
				feePayYnResult = "납부";
			} else if (data.feePayYn == 'N') {
				feePayYnResult = "미납";
			}

			$("#feePayYn").val(feePayYnResult);

			$("#StdId").val(data.stdId);
			$("#name").val(data.name);

			var genResult = "";

			if (data.gen == "F") {
				genResult = "여"
			} else if (data.gen == "M") {
				genResult = "남"
			}

			$("#gen").val(genResult);
			$("#korNameUniv").val(data.korNameUniv);
			$("#korNameDept").val(data.korNameDept);
			$("#phNum").val(data.phNum);
			$("#email").val(data.email);
			$("#Addr").val(data.addr + data.addrDetail);
		}
		
	});
</script>