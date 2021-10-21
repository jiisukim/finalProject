package kr.or.ddit.student.courseChange.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class CourseChangeVO extends BaseVO{

	private String univDeptNum;
	private String korName; // 학과 이름
	private String courseChngApplyNum; 
	private String courseChngCode;
	private String year;
	private String semCode;
	private String applyDate;
	private String procStatCode;
	private String disauthRsn;
	private String stdId;
	private String name;
	private String authDocNum;
	private String stdCred; // 학생의 이수 학점
	private String stdScore; // 학생의 평점
	
	private int cnt01;
	private int cnt02;
	private int cnt03;
	private int cnt04;
	private int totalCnt;
	
	// courseChngCode 다중 검색을 위한 list
	private String[] courseChngCodeList;
	
	// 합격 판단 위한 컬럼들
	private String maxCap; // 해당 학과, 이수 변경 유형이 모집하는 학생 수
	private String stdRank; // 지원한 학생의 순위 (평점과 학점 내림차순)
	private String stdApplyCnt; // 지원한 학생의 수

	public int getCnt01() {
		return cnt01;
	}
	public void setCnt01(int cnt01) {
		this.cnt01 = cnt01;
	}
	public int getCnt02() {
		return cnt02;
	}
	public void setCnt02(int cnt02) {
		this.cnt02 = cnt02;
	}
	public int getCnt03() {
		return cnt03;
	}
	public void setCnt03(int cnt03) {
		this.cnt03 = cnt03;
	}
	public int getCnt04() {
		return cnt04;
	}
	public void setCnt04(int cnt04) {
		this.cnt04 = cnt04;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String[] getCourseChngCodeList() {
		return courseChngCodeList;
	}
	public void setCourseChngCodeList(String[] courseChngCodeList) {
		this.courseChngCodeList = courseChngCodeList;
	}
	
	public String getUnivDeptNum() {
		return univDeptNum;
	}
	public void setUnivDeptNum(String univDeptNum) {
		this.univDeptNum = univDeptNum;
	}
	public String getCourseChngApplyNum() {
		return courseChngApplyNum;
	}
	public void setCourseChngApplyNum(String courseChngApplyNum) {
		this.courseChngApplyNum = courseChngApplyNum;
	}
	public String getCourseChngCode() {
		return courseChngCode;
	}
	public void setCourseChngCode(String courseChngCode) {
		this.courseChngCode = courseChngCode;
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
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getProcStatCode() {
		return procStatCode;
	}
	public void setProcStatCode(String procStatCode) {
		this.procStatCode = procStatCode;
	}
	public String getDisauthRsn() {
		return disauthRsn;
	}
	public void setDisauthRsn(String disauthRsn) {
		this.disauthRsn = disauthRsn;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getAuthDocNum() {
		return authDocNum;
	}
	public void setAuthDocNum(String authDocNum) {
		this.authDocNum = authDocNum;
	}
	public String getStdCred() {
		return stdCred;
	}
	public void setStdCred(String stdCred) {
		this.stdCred = stdCred;
	}
	public String getStdScore() {
		return stdScore;
	}
	public void setStdScore(String stdScore) {
		this.stdScore = stdScore;
	}
	public String getMaxCap() {
		return maxCap;
	}
	public void setMaxCap(String maxCap) {
		this.maxCap = maxCap;
	}
	public String getStdRank() {
		return stdRank;
	}
	public void setStdRank(String stdRank) {
		this.stdRank = stdRank;
	}
	public String getStdApplyCnt() {
		return stdApplyCnt;
	}
	public void setStdApplyCnt(String stdApplyCnt) {
		this.stdApplyCnt = stdApplyCnt;
	}
	
	
}
