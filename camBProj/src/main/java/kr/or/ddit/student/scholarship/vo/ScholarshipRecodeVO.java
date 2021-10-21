package kr.or.ddit.student.scholarship.vo;

public class ScholarshipRecodeVO extends ScholarshipType {
	
	private String scholaRcdNum;
	private String stdId;
	private String scholaTypeCode;
	// 2021-1학기 성적 기반으로 2021-2학기 장학금 지급됨
	// => year = 2021, semCode = 2
	private String year; // 장학금 지급될 년도
	private String semCode; // 장학금 지급될 학기
	private int scholaAmt;
	private String confirmDate;
	private String payDate;
	private String payYn;
	
	public String getScholaRcdNum() {
		return scholaRcdNum;
	}
	public void setScholaRcdNum(String scholaRcdNum) {
		this.scholaRcdNum = scholaRcdNum;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getScholaTypeCode() {
		return scholaTypeCode;
	}
	public void setScholaTypeCode(String scholaTypeCode) {
		this.scholaTypeCode = scholaTypeCode;
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
	public int getScholaAmt() {
		return scholaAmt;
	}
	public void setScholaAmt(int scholaAmt) {
		this.scholaAmt = scholaAmt;
	}
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayYn() {
		return payYn;
	}
	public void setPayYn(String payYn) {
		this.payYn = payYn;
	}
	
	
	
}
