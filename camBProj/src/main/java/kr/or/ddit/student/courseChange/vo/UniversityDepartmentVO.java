package kr.or.ddit.student.courseChange.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class UniversityDepartmentVO extends BaseVO{
	
	private String univDeptNum;
	private String univNum;
	private String korName;
	private String abolYn;
	private String engName;
	private int tuitFee;
	private int admFee;
	private String officePhNum;
	private String openDate;
	private String abolDate;
	private int maxCap;
	private int stdCnt;
	
	public String getUnivDeptNum() {
		return univDeptNum;
	}
	public void setUnivDeptNum(String univDeptNum) {
		this.univDeptNum = univDeptNum;
	}
	public String getUnivNum() {
		return univNum;
	}
	public void setUnivNum(String univNum) {
		this.univNum = univNum;
	}
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getAbolYn() {
		return abolYn;
	}
	public void setAbolYn(String abolYn) {
		this.abolYn = abolYn;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public int getTuitFee() {
		return tuitFee;
	}
	public void setTuitFee(int tuitFee) {
		this.tuitFee = tuitFee;
	}
	public int getAdmFee() {
		return admFee;
	}
	public void setAdmFee(int admFee) {
		this.admFee = admFee;
	}
	public String getOfficePhNum() {
		return officePhNum;
	}
	public void setOfficePhNum(String officePhNum) {
		this.officePhNum = officePhNum;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getAbolDate() {
		return abolDate;
	}
	public void setAbolDate(String abolDate) {
		this.abolDate = abolDate;
	}
	public int getMaxCap() {
		return maxCap;
	}
	public void setMaxCap(int maxCap) {
		this.maxCap = maxCap;
	}
	public int getStdCnt() {
		return stdCnt;
	}
	public void setStdCnt(int stdCnt) {
		this.stdCnt = stdCnt;
	}
	
	
	
}
