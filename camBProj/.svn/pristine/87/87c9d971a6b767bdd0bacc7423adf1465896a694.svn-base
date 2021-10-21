package kr.or.ddit.student.consult.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.consult.vo.ConsultScheduleVO;
import kr.or.ddit.student.consult.vo.ConsultVO;

public interface ConsultService {

	//교수들 상담 스케줄 검색
	List<ConsultScheduleVO> selectConsultSchedule(Map<String, Object> map);
	//스케줄 행 갯수
	int selectCountSchedule();
	//상담신청
	int insertConsult(ConsultVO consultVo);
	//스케줄 디테일(상담신청하면 좌석 변경)
	ConsultScheduleVO scheduleDetail(String consultSchdlNum);
	//스케줄 좌석 업데이트
	int updateSchedule(ConsultScheduleVO ConsultScheduleVO);
	//상담신청내역 리스트
	List<ConsultVO> selectConsult(Map<String, Object> map);
	//상담내역 행 갯수
	int selectCountConsult(Map<String, Object> map);
	//상담내역 상세 보기
	ConsultVO consultDetailList(String consultNum);
	//상담내역 삭제
	int deleteConsult(String consultNum);
	//상담신청 내역 수정
	int updateConsult(ConsultVO consultVo);

}
