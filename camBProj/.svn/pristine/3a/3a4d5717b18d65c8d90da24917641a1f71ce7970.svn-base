package kr.or.ddit.student.takeOff.vo;

import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.student.takeOff.mapper.TakeOffMapper;
import kr.or.ddit.util.BaseVO.BaseVO;

public class StudentVO extends BaseVO{
	
	@Autowired
	TakeOffMapper takeOffMapper;
	//학년, 전공, 휴학 기간
	private String stdId;
	private int grade = setGrade();
	private String univDeptNum;
	private int rgstSem;
	private String acadStatCode;
	private String phNum;
	
	// 학생이 휴학할 수 있는 학기 수
	// 한 번에 최대 2개 학기까지 선택할 수 있고, 총 6개 학기까지 휴학 가능하다.
	// 휴학 승인을 받았거나 신청 중인 학기를 제외한다. 
	private int availableSemCnt;
	
	public int getAvailableSemCnt() {
		return availableSemCnt;
	}
	public void setAvailableSemCnt(int availableSemCnt) {
		this.availableSemCnt = availableSemCnt;
	}
	// 등록 학기 수로 학년 구하기 
	public int getGrade() {
		return grade;
	}
	public int setGrade() {
		if(rgstSem <= 2) 	  {return 1;}
		else if(rgstSem <= 4) {return 2;}
		else if(rgstSem <= 6) {return 3;}
		else 				  {return 4;}
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getUnivDeptNum() {
		return univDeptNum;
	}
	public void setUnivDeptNum(String univDeptNum) {
		this.univDeptNum = univDeptNum;
	}
	public int getRgstSem() {
		return rgstSem;
	}
	public void setRgstSem(int rgstSem) {
		this.rgstSem = rgstSem;
	}
	public String getAcadStatCode() {
		return acadStatCode;
	}
	public void setAcadStatCode(String acadStatCode) {
		this.acadStatCode = acadStatCode;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
}
