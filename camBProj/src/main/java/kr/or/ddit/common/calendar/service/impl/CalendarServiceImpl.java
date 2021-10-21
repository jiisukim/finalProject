package kr.or.ddit.common.calendar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.calendar.mapper.CalendarMapper;
import kr.or.ddit.common.calendar.vo.CalendarVO;
import kr.or.ddit.util.code.vo.CodeVO;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired(required = false)
	private CalendarMapper calendarMapper;

	@Override
	public ArrayList<CalendarVO> calenderList() throws Exception {
		return calendarMapper.calenderList();
	}
	
//	학사일정분류리스트
	@Override
	public List<CodeVO> selectAutLin() throws Exception {
		return calendarMapper.selectAutLin();
	}

//	학사일정 입력
	@Override
	public int insertCalendar(CalendarVO calendarVo) throws Exception {
		return calendarMapper.insertCalendar(calendarVo);
	}

//	일정 하나 디테일 가져오기
	@Override
	public CalendarVO calendarDetail(CalendarVO calendarVo) throws Exception {
		return calendarMapper.calendarDetail(calendarVo);
	}

//	일정 수정하기
	@Override
	public int calendarUpdate(CalendarVO calendarVo) throws Exception {
		return calendarMapper.calendarUpdate(calendarVo);
	}

//	일정 삭제
	@Override
	public int calendarDelete(CalendarVO calendarVo) throws Exception {
		return calendarMapper.calendarDelete(calendarVo);
	}

	
}
