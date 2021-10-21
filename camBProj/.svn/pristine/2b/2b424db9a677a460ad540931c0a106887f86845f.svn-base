package kr.or.ddit.student.studyRoom.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.student.studyRoom.mapper.StudyRoomMapper;
import kr.or.ddit.student.studyRoom.service.StudyRoomService;
import kr.or.ddit.student.studyRoom.vo.StudyRoomReservationVO;
import kr.or.ddit.student.studyRoom.vo.StudyRoomVO;

@Service
public class StudyRoomServiceImpl implements StudyRoomService{
	
	@Autowired
	private StudyRoomMapper studyRoomMapper;
	
	//스터디건물에 따른 정보
	@Override
	public List<StudyRoomVO> selectStudyBuild(String buildCode){
		return this.studyRoomMapper.selectStudyBuild(buildCode);
	}
	//예약시간을 선택하기 위한 예약 정보 조회
	@Override
	public List<StudyRoomReservationVO> selectUseDate(Map<String, Object> map){
		return this.studyRoomMapper.selectUseDate(map);
	}
	//스터디 룸 예약
	@Override
	public int studyRoomReservation(StudyRoomReservationVO stRoomReserv){
		return this.studyRoomMapper.studyRoomReservation(stRoomReserv);
	}
	//예약 상세보기
	@Override
	public List<StudyRoomReservationVO> selectReservDetail(String memId){
		return this.studyRoomMapper.selectReservDetail(memId);
	}
	//스터디 룸 예약 취소
	@Override
	public int studyRoomReservCancel(String reservNum) {
		return this.studyRoomMapper.studyRoomReservCancel(reservNum);
	}
}
