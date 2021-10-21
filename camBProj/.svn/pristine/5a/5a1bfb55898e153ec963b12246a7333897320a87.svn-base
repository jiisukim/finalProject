<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	/*헤더 위치 조정*/
	.fc .fc-toolbar.fc-header-toolbar { 
		margin-bottom: 10px !important;
	}
	
	/*헤더 글씨 크기 조정*/
	.fc .fc-toolbar-title {
	    font-size: 1.2em;
	    margin: 0px;
	}
	/*헤더 버튼 크기 조정*/
	.fc .fc-button {
	    display: inline-block;
	    font-weight: 400;
	    text-align: center;
	    vertical-align: middle;
	    user-select: none;
	    border: 1px solid transparent;
	    padding: 0.4em 0.65em;
	    font-size: 0.8em;
	    line-height: 1.5;
	    border-radius: 0.25em;
	}
	/*헤더 버튼 색깔 조정*/
	.fc .fc-button-primary {
	    color: var(--fc-button-text-color, #fff);
	    background-color: var(--fc-button-bg-color, #5175df);
	}
	/*헤더 버튼 색깔 조정*/
	.fc .fc-button-primary:hover {
	    color: var(--fc-button-text-color, #fff);
	    background-color: #1c53c9;
	    border-color: var(--fc-button-hover-border-color, #1c53c9);
	}
	/*헤더 버튼 색깔 조정*/
	.fc .fc-button-primary:disabled:hover {
	    background-color: var(--fc-button-bg-color, #858796);
	    border-color: var(--fc-button-border-color, #858796);
	}
	/*날짜 글씨 크기 조정*/
	.fc table {
	    border-collapse: collapse;
	    border-spacing: 0;
	    font-size: 0.9em;
	}
	/* 캘린더 크기 조정 */
	.fc .fc-view-harness {
	    height: 415px !important;
	}
</style>    

<div id='calendar'></div>

<script>
	$(function () {
		
		// 이벤트들을 불러오기
		fn_get_events();
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
				title : result[i].title,
				start : result[i].startDateDisplay,
				end : result[i].endDateDisplay,
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
// 			navLinks: true, // can click day/week names to navigate views
		    businessHours: true, // display business hours
		    select: function(calEvent, jsEvent, view) {
		    	fn_setModalValSelect(calEvent); // 모달에 값을 세팅
		    	$("#myModal").modal("show");	//일자 클릭 시 모달 호출
		    },
		    eventClick: function(calEvent, jsEvent, view) {
		    	$("#myModal").modal("show");	//이벤트 클릭 시 모달 호출
		      },
			dateClick: function(calEvent, jsEvent, view) {
				console.log(calEvent);
				fn_setModalValDateClick(calEvent);
			   $("#myModal").modal("show");
			}
		      
		});
		
		calendar.render();
		
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
</script>


