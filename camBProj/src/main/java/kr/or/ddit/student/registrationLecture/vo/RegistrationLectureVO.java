package kr.or.ddit.student.registrationLecture.vo;

import java.text.SimpleDateFormat;

import kr.or.ddit.util.BaseVO.BaseVO;

public class RegistrationLectureVO extends BaseVO {
	
	private String stdId;                      //학번
	private String lectOpenNum;                //강의 개설 번호
	private String stdRgstSem;                 //학생 등록 학기
	private String stdGrade;                   //학생 학년
	private String lectUnivDeptNum;            //강의 학과 번호
	private String lectUnivDeptName;           //강의 학과 이름
	private String lectGrdtnRequYn;            //강의 졸업 필수 여부
	private String applyDate;                  //수강 신청 일자
	
	private String year;  			           //년도
	private String semCode;                    //학기
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLectUnivDeptName() {
		return lectUnivDeptName;
	}

	public void setLectUnivDeptName(String lectUnivDeptName) {
		this.lectUnivDeptName = lectUnivDeptName;
	}

	public String getSemCode() {
		return semCode;
	}

	public void setSemCode(String semCode) {
		this.semCode = semCode;
	}

	public String getApplyDateDisplay(){
		String applyDateDisplay="";
		if(this.applyDate != null) {
			applyDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.applyDate);
		}
		return applyDateDisplay;
	}
	
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
	public String getStdRgstSem() {
		return stdRgstSem;
	}

	public void setStdRgstSem(String stdRgstSem) {
		this.stdRgstSem = stdRgstSem;
	}

	public String getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	public String getLectUnivDeptNum() {
		return lectUnivDeptNum;
	}
	public void setLectUnivDeptNum(String lectUnivDeptNum) {
		this.lectUnivDeptNum = lectUnivDeptNum;
	}
	public String getLectGrdtnRequYn() {
		return lectGrdtnRequYn;
	}
	public void setLectGrdtnRequYn(String lectGrdtnRequYn) {
		this.lectGrdtnRequYn = lectGrdtnRequYn;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	
	
	
}
