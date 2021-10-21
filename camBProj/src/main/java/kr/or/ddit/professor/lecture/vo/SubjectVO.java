package kr.or.ddit.professor.lecture.vo;

public class SubjectVO {
	private String univDeptNum;
	private String univDeptName;
	private String subjNum;
	private String subjName;
	private String subjTypeCode;
	private String subjTypeCodeName;
	private String abolYn;
	private String rgstDate;
	private String grdtnRequYn;
	private String cred;
	private String lectTime;
	private String searchKeyword; //키워드검색
	private int pageNo; // 페이지 번호
	
	
	
	
	
	public String getSubjTypeCodeName() {
		return subjTypeCodeName;
	}
	public void setSubjTypeCodeName(String subjTypeCodeName) {
		this.subjTypeCodeName = subjTypeCodeName;
	}
	public String getUnivDeptName() {
		return univDeptName;
	}
	public void setUnivDeptName(String univDeptName) {
		this.univDeptName = univDeptName;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getUnivDeptNum() {
		return univDeptNum;
	}
	public void setUnivDeptNum(String univDeptNum) {
		this.univDeptNum = univDeptNum;
	}
	public String getSubjNum() {
		return subjNum;
	}
	public void setSubjNum(String subjNum) {
		this.subjNum = subjNum;
	}
	public String getSubjName() {
		return subjName;
	}
	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}
	public String getSubjTypeCode() {
		return subjTypeCode;
	}
	public void setSubjTypeCode(String subjTypeCode) {
		this.subjTypeCode = subjTypeCode;
	}
	public String getAbolYn() {
		return abolYn;
	}
	public void setAbolYn(String abolYn) {
		this.abolYn = abolYn;
	}
	public String getRgstDate() {
		return rgstDate;
	}
	public void setRgstDate(String rgstDate) {
		this.rgstDate = rgstDate;
	}
	public String getGrdtnRequYn() {
		return grdtnRequYn;
	}
	public void setGrdtnRequYn(String grdtnRequYn) {
		this.grdtnRequYn = grdtnRequYn;
	}
	public String getCred() {
		return cred;
	}
	public void setCred(String cred) {
		this.cred = cred;
	}
	public String getLectTime() {
		return lectTime;
	}
	public void setLectTime(String lectTime) {
		this.lectTime = lectTime;
	}
	@Override
	public String toString() {
		return "SubjectVO [univDeptNum=" + univDeptNum + ", univDeptName=" + univDeptName + ", subjNum=" + subjNum
				+ ", subjName=" + subjName + ", subjTypeCode=" + subjTypeCode + ", subjTypeCodeName=" + subjTypeCodeName
				+ ", abolYn=" + abolYn + ", rgstDate=" + rgstDate + ", grdtnRequYn=" + grdtnRequYn + ", cred=" + cred
				+ ", lectTime=" + lectTime + ", searchKeyword=" + searchKeyword + ", pageNo=" + pageNo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
