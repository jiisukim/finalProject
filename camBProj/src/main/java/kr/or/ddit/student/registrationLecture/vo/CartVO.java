package kr.or.ddit.student.registrationLecture.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class CartVO extends BaseVO{
	
	private String stdId;            //학번
	private String lectOpenNum;      //강의 개설 번호
	private String year;             //년도
	private String semCode;          //학기 코드
	
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getLectOpenNum() {
		return lectOpenNum;
	}
	public void setLectOpenNum(String lectOpenNum) {
		this.lectOpenNum = lectOpenNum;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemCode() {
		return semCode;
	}
	public void setSemCode(String semCode) {
		this.semCode = semCode;
	}
}
