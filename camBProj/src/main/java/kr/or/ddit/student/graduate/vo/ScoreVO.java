package kr.or.ddit.student.graduate.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class ScoreVO extends BaseVO{
	
	private String stdId;
	private String year; 			//년도
	private String semCode;			//학기
	private String lectName;        //과목 이름
	private String subjTypeCode;    //수업 유형
	private String cred;			//강의 학점
	private String totalScore;      //백분율 점수
	private String rating;          //학점 (A+, A ... )
	private String score;           //평점 (4.5, 4.0 ...)
	private String credSum;         //한 학기 학점 합계
	private String semScore;        //한 학기 평점 
	private String allScore;        //전 학기 평점
	
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
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
	public String getLectName() {
		return lectName;
	}
	public void setLectName(String lectName) {
		this.lectName = lectName;
	}
	public String getSubjTypeCode() {
		return subjTypeCode;
	}
	public void setSubjTypeCode(String subjTypeCode) {
		this.subjTypeCode = subjTypeCode;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCredSum() {
		return credSum;
	}
	public void setCredSum(String credSum) {
		this.credSum = credSum;
	}
	public String getSemScore() {
		return semScore;
	}
	public void setSemScore(String semScore) {
		this.semScore = semScore;
	}
	public String getAllScore() {
		return allScore;
	}
	public void setAllScore(String allScore) {
		this.allScore = allScore;
	}
	public String getCred() {
		return cred;
	}
	public void setCred(String cred) {
		this.cred = cred;
	}
	
	
}
