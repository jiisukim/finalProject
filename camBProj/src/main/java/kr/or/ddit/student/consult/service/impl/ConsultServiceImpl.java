package kr.or.ddit.student.consult.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.student.consult.mapper.ConsultMapper;
import kr.or.ddit.student.consult.service.ConsultService;
import kr.or.ddit.student.consult.vo.ConsultScheduleVO;
import kr.or.ddit.student.consult.vo.ConsultVO;

@Service
public class ConsultServiceImpl implements ConsultService{
	
	@Autowired
	private ConsultMapper consultMapper;
	
	//교수들 상담 스케줄 검색
	@Override
	public List<ConsultScheduleVO> selectConsultSchedule(Map<String, Object> map){
		return this.consultMapper.selectConsultSchedule(map);
	}
	
	//스케줄 행 갯수
	@Override
	public int selectCountSchedule() {
		return this.consultMapper.selectCountSchedule();
	}
	
	//상담신청
	@Override
	public int insertConsult(ConsultVO consultVo) {
		return this.consultMapper.insertConsult(consultVo);
	}
	
	//스케줄 디테일(상담신청하면 좌석 변경)
	@Override
	public ConsultScheduleVO scheduleDetail(String consultSchdlNum) {
		return this.consultMapper.scheduleDetail(consultSchdlNum);
	}
	
	//스케줄 잔여석 업데이트
	@Override
	public int updateSchedule(ConsultScheduleVO ConsultScheduleVO) {
		return this.consultMapper.updateSchedule(ConsultScheduleVO);
	}
	
	//상담신청내역
	@Override
	public List<ConsultVO> selectConsult(Map<String, Object> map){
		return this.consultMapper.selectConsult(map);
	}
	
	//상담내여 행 갯수
	@Override
	public int selectCountConsult(Map<String, Object> map) {
		return this.consultMapper.selectCountConsult(map);
	}
	
	//상담신청 상세 내역
	@Override
	public ConsultVO consultDetailList(String consultNum) {
		return this.consultMapper.consultDetailList(consultNum);
	}
	
	//상담신청내역 삭제
	@Override
	public int deleteConsult(String consultNum) {
		return this.consultMapper.deleteConsult(consultNum);
	}
	
	//상담신청내역 수정
	@Override
	public int updateConsult(ConsultVO consultVo) {
		return this.consultMapper.updateConsult(consultVo);
	}

}
