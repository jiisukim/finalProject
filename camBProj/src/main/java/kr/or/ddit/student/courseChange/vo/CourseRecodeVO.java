package kr.or.ddit.student.courseChange.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class CourseRecodeVO extends BaseVO{
	
	private String stdId;
	private String univDeptNum;
	private String courseRcdNum;
	private String abandYn;
	private String courseTypeNum;
	private String startDate;
	private String abandDate;
	
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
	public String getCourseRcdNum() {
		return courseRcdNum;
	}
	public void setCourseRcdNum(String courseRcdNum) {
		this.courseRcdNum = courseRcdNum;
	}
	public String getAbandYn() {
		return abandYn;
	}
	public void setAbandYn(String abandYn) {
		this.abandYn = abandYn;
	}
	public String getCourseTypeNum() {
		return courseTypeNum;
	}
	public void setCourseTypeNum(String courseTypeNum) {
		this.courseTypeNum = courseTypeNum;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getAbandDate() {
		return abandDate;
	}
	public void setAbandDate(String abandDate) {
		this.abandDate = abandDate;
	}
	
	
	
}
