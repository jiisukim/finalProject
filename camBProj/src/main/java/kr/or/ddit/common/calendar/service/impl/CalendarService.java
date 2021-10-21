package kr.or.ddit.common.calendar.service.impl;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.common.calendar.vo.CalendarVO;
import kr.or.ddit.util.code.vo.CodeVO;

public interface CalendarService {
	
//	일정 전체 가져오기
	public ArrayList<CalendarVO> calenderList() throws Exception;
	
//	학사일정분류리스트
	public List<CodeVO> selectAutLin() throws Exception;
	
//	학사일정 입력
	public int insertCalendar(CalendarVO calendarVo) throws Exception;
	
//	일정 하나 디테일 가져오기
	public CalendarVO calendarDetail(CalendarVO calendarVo) throws Exception;
	
//	일정 수정
	public int calendarUpdate(CalendarVO calendarVo) throws Exception;
	
//	일정 삭제
	public int calendarDelete(CalendarVO calendarVo) throws Exception;

}
