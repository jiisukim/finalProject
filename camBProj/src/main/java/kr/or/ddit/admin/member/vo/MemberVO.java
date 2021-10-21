package kr.or.ddit.admin.member.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.or.ddit.util.BaseVO.BaseVO;

public class MemberVO extends BaseVO{
	
	
	private String memId;		// 회원 아이디
	private String name;		// 이름
	private String resRgstNum;	// 주민등록번호
	private String gen;			// 성별
	private String pwd;			// 사용자 입력 비밀번호
	private String phNum;		// 전화번호
	private String email;		// 이메일
	private String addr;		// 주소
	private String addrDetail;	// 상세 주소
	private String zipcode;		// 우편번호
	private String memTypeCode;	// 회원 유형 코드
	private int pwdErrCnt;		// 비밀번호 오류 횟수
	private String alertUseYn;	// 알림 사용 여부
	private String delYn;		// 삭제 여부
	private Date delDate;		// 삭제 일자
	private String bankCode;	// 은행 코드
	private String bankAccntNum;// 계좌 번호
	private String delTypeCode;	// 삭제 유형 코드
	private Date createDate;	// 등록 일자
	private Date modDate;		// 수정 일자
	private String fileGrNum;	// 파일 그룹 번호
	private String firstLoginInsertVal;	// 초기 비밀번호
	
	
	private String univDeptNumStd;		// 학과 번호 학생용
	private String univDeptNumPrf;		// 학과 번호 교수용
	private String deptCode;			// 부서 번호 직원용
	
	public String getCreateDateDisplay(){
		String createDateDisplay="";
		if(this.createDate != null) {
			createDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.createDate);
		}
		return createDateDisplay;
	}
	
	public String getFirstLoginInsertVal() {
		return firstLoginInsertVal;
	}
	public void setFirstLoginInsertVal(String firstLoginInsertVal) {
		this.firstLoginInsertVal = firstLoginInsertVal;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getUnivDeptNumPrf() {
		return univDeptNumPrf;
	}
	public void setUnivDeptNumPrf(String univDeptNumPrf) {
		this.univDeptNumPrf = univDeptNumPrf;
	}
	public String getUnivDeptNumStd() {
		return univDeptNumStd;
	}
	public void setUnivDeptNumStd(String univDeptNumStd) {
		this.univDeptNumStd = univDeptNumStd;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResRgstNum() {
		return resRgstNum;
	}
	public void setResRgstNum(String resRgstNum) {
		this.resRgstNum = resRgstNum;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getMemTypeCode() {
		return memTypeCode;
	}
	public void setMemTypeCode(String memTypeCode) {
		this.memTypeCode = memTypeCode;
	}
	public int getPwdErrCnt() {
		return pwdErrCnt;
	}
	public void setPwdErrCnt(int pwdErrCnt) {
		this.pwdErrCnt = pwdErrCnt;
	}
	public String getAlertUseYn() {
		return alertUseYn;
	}
	public void setAlertUseYn(String alertUseYn) {
		this.alertUseYn = alertUseYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankAccntNum() {
		return bankAccntNum;
	}
	public void setBankAccntNum(String bankAccntNum) {
		this.bankAccntNum = bankAccntNum;
	}
	public String getDelTypeCode() {
		return delTypeCode;
	}
	public void setDelTypeCode(String delTypeCode) {
		this.delTypeCode = delTypeCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	

}
