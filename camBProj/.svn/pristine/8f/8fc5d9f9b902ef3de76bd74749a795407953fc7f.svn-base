<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div id="body">
	<div id='calendar' style="width: 64%; position: relative; left: 270px;"></div>
	
	<!-- insertModal -->
  <div class="modal fade insertModal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <form action="/common/calendar/insertCalendar" method="post">
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title" onclick="fn_setData();">일정 등록</h4>
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        </div>
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	          <div class="form-group">
				<label for="startDate">시작날짜 : </label>
				<input type="date" class="form-control" name="startDate" id="startDate" >
			  </div>
	          <div class="form-group">
				<label for="endDate">종료날짜 : </label>
				<input type="date" class="form-control" name="endDate" id="endDate">
			  </div>
			  <br>
	          <div class="form-group">
				<label for="title">제목 :</label>
				<input type="text" class="form-control" placeholder="" name="title" id="title">
			  </div>
	          <div class="form-group">
				<label for="description">내용 :</label>
				<textarea rows="10" cols="10" class="form-control" name="description" id="description"></textarea>
			  </div>
	          <div class="form-group">
				<label for="acadCalCode">학사일정분류 :</label>
				<select class="form-control" style="width: 100%;" name="acadCalCode" id="acadCalCode">
					<option value="" selected="selected">학사 일정 코드를 선택하세요</option>
					<c:forEach var="autLin" items="${autLin}" varStatus="stat">
						<option value="${autLin.codeVal}" >${autLin.codeName}</option>
					</c:forEach>
				</select>
			  </div>
			  <div class="form-group">
				<label for="backgroundColor">배경색상 :</label>
				<select class="form-control" style="width: 100%;" name="backgroundColor" id="backgroundColor">
					<option value="" selected="selected">배경 색상을 선택하세요</option>
					<option value="skyblue" style="background-color: skyblue;">skyblue</option>
					<option value="red" style="background-color: red;">red</option>
					<option value="pink" style="background-color: pink;">pink</option>
					<option value="yellow" style="background-color: yellow;">yellow</option>
					<option value="lightgreen" style="background-color: lightgreen;">lightgreen</option>
					<option value="orange" style="background-color: orange;">orange</option>
					<option value="gray" style="background-color: gray;">gray</option>
					<option value="white" style="background-color: white;">white</option>
					<option value="black" style="background-color: black;">black</option>
				</select>
			  </div>
			  <div class="form-group">
				<label for="textColor">글자색상 :</label>
				<select class="form-control" style="width: 100%;" name="textColor" id="textColor">
					<option value="" selected="selected">글자 색상을 선택하세요</option>
					<option value="skyblue" style="color: skyblue;">skyblue</option>
					<option value="red" style="color: red;">red</option>
					<option value="pink" style="color: pink;">pink</option>
					<option value="yellow" style="color: yellow;">yellow</option>
					<option value="lightgreen" style="color: lightgreen;">lightgreen</option>
					<option value="orange" style="color: orange;">orange</option>
					<option value="gray" style="color: gray;">gray</option>
					<option value="white" style="color: white;">white</option>
					<option value="black" style="color: black;">black</option>
				</select>
			  </div>
	        </div>
	        <!-- Modal footer -->
	        <div class="modal-footer">
			  <button type="submit" class="btn btn-warning float-right insertBtn" >등록</button>
	        </div>
        </form>
        
      </div>
    </div>
  </div>
  
  	<!-- updateModal -->
  <div class="modal fade updateModal" id="clickModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <form action="/common/calendar/updateCalendar" method="post" id="calendarFrm">
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title">일정 수정</h4>
	          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        </div>
	        
	        <div>
				<input type="hidden" name="eventId" id="eventId">
			</div>
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	          <div class="form-group">
				<label for="startDate">시작날짜 : </label>
				<input type="text" class="form-control" name="startDate" id="startDateUpdate" >
			  </div>
	          <div class="form-group">
				<label for="endDate">종료날짜 : </label>
				<input type="text" class="form-control" name="endDate" id="endDateUpdate">
			  </div>
			  <br>
	          <div class="form-group">
				<label for="title">제목 :</label>
				<input type="text" class="form-control" placeholder="" name="title" id="titleUpdate">
			  </div>
	          <div class="form-group">
				<label for="description">내용 :</label>
				<textarea rows="10" cols="10" class="form-control" name="description" id="descriptionUpdate"></textarea>
			  </div>
	          <div class="form-group">
				<label for="acadCalCode">학사일정분류 :</label>
				<select class="form-control" style="width: 100%;" name="acadCalCode" id="acadCalCodeUpdate">
					<option value="01">1학기 수강 신청</option>
					<option value="02">1학기 개강</option>
					<option value="03">1학기 종강</option>
					<option value="04">1학기 등록</option>
					<option value="05">2학기 수강 신청</option>
					<option value="06">2학기 개강</option>
					<option value="07">2학기 종강</option>
					<option value="08">2학기 등록</option>
					<option value="09">전공</option>
					<option value="10">수업일수</option>
					<option value="11">자율학습</option>
					<option value="12">동계 계절수업</option>
					<option value="13">1학기</option>
					<option value="14">2학기</option>
					<option value="15">장학</option>
					<option value="16">하계 계절수업</option>
				</select>
			  </div>
			  <div class="form-group">
				<label for="backgroundColor">배경색상 :</label>
				<select class="form-control" style="width: 100%;" name="backgroundColor" id="backgroundColorUpdate">
					<option value="" selected="selected">배경 색상을 선택하세요</option>
					<option value="skyblue" style="background-color: skyblue;">skyblue</option>
					<option value="red" style="background-color: red;">red</option>
					<option value="pink" style="background-color: pink;">pink</option>
					<option value="yellow" style="background-color: yellow;">yellow</option>
					<option value="lightgreen" style="background-color: lightgreen;">lightgreen</option>
					<option value="orange" style="background-color: orange;">orange</option>
					<option value="gray" style="background-color: gray;">gray</option>
					<option value="white" style="background-color: white;">white</option>
					<option value="black" style="background-color: black;">black</option>
				</select>
			  </div>
			  <div class="form-group">
				<label for="textColor">글자색상 :</label>
				<select class="form-control" style="width: 100%;" name="textColor" id="textColorUpdate">
					<option value="" selected="selected">글자 색상을 선택하세요</option>
					<option value="skyblue" style="color: skyblue;">skyblue</option>
					<option value="red" style="color: red;">red</option>
					<option value="pink" style="color: pink;">pink</option>
					<option value="yellow" style="color: yellow;">yellow</option>
					<option value="lightgreen" style="color: lightgreen;">lightgreen</option>
					<option value="orange" style="color: orange;">orange</option>
					<option value="gray" style="color: gray;">gray</option>
					<option value="white" style="color: white;">white</option>
					<option value="black" style="color: black;">black</option>
				</select>
			  </div>
	        </div>
	        <!-- Modal footer -->
	        <div class="modal-footer">
			  <button type="submit" class="btn btn-warning float-right updateBtn" >수정</button>
			  <button type="button" class="btn btn-dark  float-right deleteBtn" id="btnDelete">삭제</button>
	        </div>
        </form>
        
      </div>
    </div>
  </div>
  
  
</div>

    
<script>
	$(function () {
		
		// 이벤트들을 불러오기
		fn_get_events();
		
		
		//삭제 버튼 클릭 후 일정 삭제 처리
		$("#btnDelete").on("click",function(){
			
			var input = confirm("삭제하시겠습니까?");
			
			if(input){//true
				$("#calendarFrm").attr("action", "/common/calendar/deleteCalendar").submit();
			}else{//false
				return;
			}
		});
		
	});
	
	// 이벤트를 불러와서 fn_set_calendar()에 파라미터로 넣어주기
	function fn_get_events() {
		$.ajax({ 
			type:"get", 
			url:"/common/calendar/calendarData", 
			dataType:"json",
			success : function(result){
				console.log(result); // [VO...] 형태
			
// 				이벤트에 뿌려주기전에 데이터가공
// 				자바스크립트 객체로 만든다
// 				길어지니까 밖으로 뺀다.
				result = fn_set_event(result);
				
				fn_set_calendar(result);
			}
		}); 
	}
	

	
// 	데이터를 이벤트객체로 가공하는 함수
	function fn_set_event(result) {

	// 		리턴해줄 이벤트객체(어레이)를 선언
		var events = new Array();
	
		for(i in result) {//향상된포문
			
	// 		이벤트 객체(단수) 만들기
			var event = {
				eventId : result[i].eventId,
				title : result[i].title,
				description : result[i].description,
				start : result[i].startDateDisplay,
				end : result[i].endDateDisplay,
				acadCalCode : result[i].acadCalCode,
				color : result[i].backgroundColor,
				textColor : result[i].textColor
			}
			
			events.push(event); // 배열안에 단수객체 넣기
		}
		
		return events;	
	}

	
	
	// 이벤트 파라미터를 받아서 캘린더를 그리기
	function fn_set_calendar(events){
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, { 
			selectable: true,
	        selectOverlap: false,
			events: events, 	
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			droppable: true, // this allows things to be dropped onto the calendar
			drop: function() {
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
				  // if so, remove the element from the "Draggable Events" list
				  $(this).remove();
				}
			},
			locale: 'ko',
			editable : 'true',
			navLinks: true, // can click day/week names to navigate views
		    businessHours: true, // display business hours
		    select: function(calEvent, jsEvent, view) {
		    	fn_setModalValSelect(calEvent); // 모달에 값을 세팅
		    	$("#myModal").modal("show");	//일자 클릭 시 모달 호출
		    },
		    eventClick: function(calEvent, jsEvent, view) {
		    	
		    	console.log("calEvent>>>>>>>>>>>>>>>>>>>>>>>");
		    	console.log(calEvent);
		    	
		    	var item = calEvent.event._def.extendedProps; //글 속성 정보
		    	console.log("item>>>>>>>>>>>>>>>>>>>>>>>");
		    	console.log(item);
		    	
		    	var startDate = calEvent.event._instance.range.start
		    	var endDate = calEvent.event._instance.range.end
		    		
		    	
		    	//수정 폼 모달에 기존 일정값 세팅
				$("#eventId").val(item.eventId); // 일정번호
				$("#startDateUpdate").val(getFormatDate(startDate)); // 시작일
				$("#endDateUpdate").val(getFormatDate(endDate)); // 종료일
				$("#titleUpdate").val(calEvent.event._def.title); // 제목
				$("#descriptionUpdate").val(item.description); // 내용
				
// 				$("#acadCalCodeUpdate").val(item.acadCalCode); // 학사 일정 코드 
				
				// 셀렉트 박스 안에 있는 옵션 중에서 값이 같은 옵션에 selected 속성을 넣어주기 (prop)
				$("#acadCalCodeUpdate").val(item.acadCalCode).prop("selected", true);
				
				$("#backgroundColorUpdate").val(calEvent.event.backgroundColor); // 배경색
				$("#textColorUpdate").val(calEvent.event.textColor); // 글자색
		    	
		    	
		    	$("#clickModal").modal("show");	//이벤트 클릭 시 모달 호출
		    	
		      },
			dateClick: function(calEvent, jsEvent, view) {
				fn_setModalValDateClick(calEvent);
			   $("#myModal").modal("show");
			}
		      
		});
		
		calendar.render();
		
	}
	
	/**
	 *  yyyyMMdd 포맷으로 반환
	 */
	function getFormatDate(date){
	    var year = date.getFullYear();              //yyyy
	    var month = (1 + date.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    var day = date.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
	}
	
// 	영역 긁었을때
	function fn_setModalValSelect(calEvent) {
		$("#startDate").val(calEvent.startStr);
		
		var endDate = new Date(calEvent.end);
	    var beforeDay = new Date(endDate.getFullYear(),endDate.getMonth(),endDate.getDate() - 1);
	    
		$("#endDate").val(beforeDay.getFullYear() + "-" + stringFormat(((parseInt(beforeDay.getMonth()) + 1))) + "-" + stringFormat(beforeDay.getDate()));
	}
	
// 	하루만 찍었을때
	function fn_setModalValDateClick(calEvent) {
		$("#startDate").val(calEvent.dateStr);
		
		$("#endDate").val(calEvent.dateStr);
	}
	
	//stringFormat date.getMonth() 또는 getDate()가 한자리수 일때 0 추가
	function stringFormat(p_val){
		if(p_val < 10){
			return p_val = '0'+p_val;
		}
		else{
			return p_val;
		}
	}
	
	// 이벤트를 불러와서 fn_set_calendar_modal()에 파라미터로 넣어주기
	function fn_event_detail() {
		$.ajax({ 
			type:"get", 
			url:"/common/calendar/calendarDataDetail", 
			dataType:"json",
			success : function(result){
				console.log(result); // [VO...] 형태
			
// 				이벤트에 뿌려주기전에 데이터가공
// 				자바스크립트 객체로 만든다
// 				길어지니까 밖으로 뺀다.
				result = fn_set_event_Detail(result);
				console.log("fn_get_event_detail >>> ");
				console.log(result);
				fn_set_calendar_Detail(result);
			}
		}); 
	}
	
	
	function fn_setData() {
		$("#startDate").val("2021-10-22");
		$("#endDate").val("2021-10-22");
		$("#title").val("개교기념일");
		$("#description").val("개교기념일");
		$("#acadCalCode").val("10").prop("selected", true);
		$("#backgroundColor").val("black").prop("selected", true);
		$("#textColor").val("yellow").prop("selected", true);
	}
</script>


