package kr.or.ddit.professor.lecture.vo;

import java.util.List;

public class LectureTimeVO {
	
	//xml의 foreach collection에 들어갈 변수
	private String dayCode;
	private String period;
	private String lectOpenNum;     //강의 개설 번호
	private String lectName;        //강의 이름
	private String roomIdnNum;      //강의실 식별 번호
	private List<LectureTimeVO> lectureTimeVO;

	
	
	
	public String getRoomIdnNum() {
		return roomIdnNum;
	}

	public void setRoomIdnNum(String roomIdnNum) {
		this.roomIdnNum = roomIdnNum;
	}

	public String getLectName() {
		return lectName;
	}

	public void setLectName(String lectName) {
		this.lectName = lectName;
	}

	public String getLectOpenNum() {
		return lectOpenNum;
	}

	public void setLectOpenNum(String lectOpenNum) {
		this.lectOpenNum = lectOpenNum;
	}

	

	public String getDayCode() {
		return dayCode;
	}

	public void setDayCode(String dayCode) {
		this.dayCode = dayCode;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public List<LectureTimeVO> getLectureTimeVO() {
		return lectureTimeVO;
	}

	public void setLectureTimeVO(List<LectureTimeVO> lectureTimeVO) {
		this.lectureTimeVO = lectureTimeVO;
	}

	@Override
	public String toString() {
		return "LectureTimeVO [dayCode=" + dayCode + ", period=" + period + ", lectOpenNum=" + lectOpenNum
				+ ", lectName=" + lectName + ", roomIdnNum=" + roomIdnNum + ", lectureTimeVO=" + lectureTimeVO + "]";
	}

	

	

	
	
	
	

	
	
}
