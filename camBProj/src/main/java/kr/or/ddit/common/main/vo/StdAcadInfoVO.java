package kr.or.ddit.common.main.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class StdAcadInfoVO extends BaseVO {

	public String ct1UnivDeptNum;
	public String ct2UnivDeptNum;
	public String ct3UnivDeptNum;

	public String ct1UnivDeptName;
	public String ct2UnivDeptName;
	public String ct3UnivDeptName;
	
	public int ct1Cred; // 주전공 학점
	public int ct2Cred; // 복수전공 학점
	public int ct3Cred; // 부 전공 학점
	public int ct4Cred; // 교양 학점
	
	public int ct1GrdtnCred; // 주전공 졸업 학점 
	public int ct2GrdtnCred; // 복수전공 졸업 학점
	public int ct3GrdtnCred; // 부 전공 졸업 학점
	public int ct4GrdtnCred; // 교양 졸업 학점
	
	public String volRecogTimeSum; // 봉사 인정 시간
	public String volTimeCrt; // 봉사 졸업 기준 시간
	
	public String getCt1UnivDeptNum() {
		return ct1UnivDeptNum;
	}
	public void setCt1UnivDeptNum(String ct1UnivDeptNum) {
		this.ct1UnivDeptNum = ct1UnivDeptNum;
	}
	public String getCt2UnivDeptNum() {
		return ct2UnivDeptNum;
	}
	public void setCt2UnivDeptNum(String ct2UnivDeptNum) {
		this.ct2UnivDeptNum = ct2UnivDeptNum;
	}
	public String getCt3UnivDeptNum() {
		return ct3UnivDeptNum;
	}
	public void setCt3UnivDeptNum(String ct3UnivDeptNum) {
		this.ct3UnivDeptNum = ct3UnivDeptNum;
	}
	public String getCt1UnivDeptName() {
		return ct1UnivDeptName;
	}
	public void setCt1UnivDeptName(String ct1UnivDeptName) {
		this.ct1UnivDeptName = ct1UnivDeptName;
	}
	public String getCt2UnivDeptName() {
		return ct2UnivDeptName;
	}
	public void setCt2UnivDeptName(String ct2UnivDeptName) {
		this.ct2UnivDeptName = ct2UnivDeptName;
	}
	public String getCt3UnivDeptName() {
		return ct3UnivDeptName;
	}
	public void setCt3UnivDeptName(String ct3UnivDeptName) {
		this.ct3UnivDeptName = ct3UnivDeptName;
	}
	public int getCt1Cred() {
		return ct1Cred;
	}
	public void setCt1Cred(int ct1Cred) {
		this.ct1Cred = ct1Cred;
	}
	public int getCt2Cred() {
		return ct2Cred;
	}
	public void setCt2Cred(int ct2Cred) {
		this.ct2Cred = ct2Cred;
	}
	public int getCt3Cred() {
		return ct3Cred;
	}
	public void setCt3Cred(int ct3Cred) {
		this.ct3Cred = ct3Cred;
	}
	public int getCt4Cred() {
		return ct4Cred;
	}
	public void setCt4Cred(int ct4Cred) {
		this.ct4Cred = ct4Cred;
	}
	public int getCt1GrdtnCred() {
		return ct1GrdtnCred;
	}
	public void setCt1GrdtnCred(int ct1GrdtnCred) {
		this.ct1GrdtnCred = ct1GrdtnCred;
	}
	public int getCt2GrdtnCred() {
		return ct2GrdtnCred;
	}
	public void setCt2GrdtnCred(int ct2GrdtnCred) {
		this.ct2GrdtnCred = ct2GrdtnCred;
	}
	public int getCt3GrdtnCred() {
		return ct3GrdtnCred;
	}
	public void setCt3GrdtnCred(int ct3GrdtnCred) {
		this.ct3GrdtnCred = ct3GrdtnCred;
	}
	public int getCt4GrdtnCred() {
		return ct4GrdtnCred;
	}
	public void setCt4GrdtnCred(int ct4GrdtnCred) {
		this.ct4GrdtnCred = ct4GrdtnCred;
	}
	public String getVolRecogTimeSum() {
		return volRecogTimeSum;
	}
	public void setVolRecogTimeSum(String volRecogTimeSum) {
		this.volRecogTimeSum = volRecogTimeSum;
	}
	public String getVolTimeCrt() {
		return volTimeCrt;
	}
	public void setVolTimeCrt(String volTimeCrt) {
		this.volTimeCrt = volTimeCrt;
	}
	
	
}
