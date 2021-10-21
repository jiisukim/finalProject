package kr.or.ddit.common.calendar.mapper;

import java.util.ArrayList;
import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.common.calendar.vo.CalendarVO;
import kr.or.ddit.util.code.vo.CodeVO;

@Mapper("calendarMapper")
public interface CalendarMapper {
	
//	일정 전체 가져오기
	ArrayList<CalendarVO> calenderList();
	
//	학사일정분류리스트
	List<CodeVO> selectAutLin();
	
//	학사일정 입력
	int insertCalendar(CalendarVO calendarVo);
	
//	일정 하나 디테일 가져오기
	CalendarVO calendarDetail(CalendarVO calendarVo);
	
//	일정 수정
	int calendarUpdate(CalendarVO calendarVo);
	
//	일정 삭제
	int calendarDelete(CalendarVO calendarVo);

}
