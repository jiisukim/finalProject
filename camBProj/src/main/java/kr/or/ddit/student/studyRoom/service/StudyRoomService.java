package kr.or.ddit.student.studyRoom.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.studyRoom.vo.StudyRoomReservationVO;
import kr.or.ddit.student.studyRoom.vo.StudyRoomVO;

public interface StudyRoomService {

	//스터디건물에 따른 정보
	List<StudyRoomVO> selectStudyBuild(String buildCode);
	//예약시간을 선택하기 위한 예약 정보 조회
	List<StudyRoomReservationVO> selectUseDate(Map<String, Object> map);
	//스터디 룸 예약
	int studyRoomReservation(StudyRoomReservationVO stRoomReserv);
	//예약 상세보기
	List<StudyRoomReservationVO> selectReservDetail(String memId);
	//스터디 룸 예야 취소
	int studyRoomReservCancel(String reservNum);

}
