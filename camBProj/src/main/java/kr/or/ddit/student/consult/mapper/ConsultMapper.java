package kr.or.ddit.student.consult.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.student.consult.vo.ConsultScheduleVO;
import kr.or.ddit.student.consult.vo.ConsultVO;

@Mapper("consultMapper")
public interface ConsultMapper {
	//상담스케줄 화인, 상담원 예약
	List<ConsultScheduleVO> selectConsultSchedule(Map<String, Object> map);
	//스케줄 행 갯수
	int selectCountSchedule();
	//상담신청
	int insertConsult(ConsultVO consultVo);
	//스케줄 디테일 선택
	ConsultScheduleVO scheduleDetail(String consultSchdlNum);
	//스케줄 잔여석 업데이트
	int updateSchedule(ConsultScheduleVO ConsultScheduleVO);
	//상담신청 내역 리스트
	List<ConsultVO> selectConsult(Map<String, Object> map);
	//상담내역 행 갯수
	int selectCountConsult(Map<String, Object> map);
	//상담신청 상세 내역
	ConsultVO consultDetailList(String consultNum);
	//상담예약 취소
	int deleteConsult(String consultNum);
	//상담신청내역 수정
	int updateConsult(ConsultVO consultVo);
}
