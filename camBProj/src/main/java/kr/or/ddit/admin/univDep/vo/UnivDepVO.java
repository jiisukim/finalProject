package kr.or.ddit.admin.univDep.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.or.ddit.util.BaseVO.BaseVO;

public class UnivDepVO extends BaseVO{
	
	private String univDeptNum;		// 학과 번호
	private String univNum;			// 대학 번호
	private String korName;			// 학과 한글 이름
	private String abolYn;			// 폐지 여부
	private String engName;			// 학과 영어 이름
	private int admFee;				// 입학금
	private int tuitFee;			// 수업료
	private String officePhNum;		// 학과 전화 번호
	private Date openDate;			// 개설 일자
	private Date abolDate;			// 폐지 일자
	private int maxCap;				// 학년 당 정원
	private int stdCnt;				// 학생 수
	
	
	public String getOpenDateDisplay() {
		String openDateDisplay = "";
		if(this.openDate != null) {
			openDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.openDate);
		}
		return openDateDisplay;
	}
	
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
	public int getAdmFee() {
		return admFee;
	}
	public void setAdmFee(int admFee) {
		this.admFee = admFee;
	}
	public int getTuitFee() {
		return tuitFee;
	}
	public void setTuitFee(int tuitFee) {
		this.tuitFee = tuitFee;
	}
	public String getOfficePhNum() {
		return officePhNum;
	}
	public void setOfficePhNum(String officePhNum) {
		this.officePhNum = officePhNum;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getAbolDate() {
		return abolDate;
	}
	public void setAbolDate(Date abolDate) {
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
