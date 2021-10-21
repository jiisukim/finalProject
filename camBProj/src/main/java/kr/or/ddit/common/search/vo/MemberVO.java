package kr.or.ddit.common.search.vo;

import java.util.Date;

public class MemberVO {
	private String email;
	private int pwdErrCnt;
	private String alertUseYn;
	private String resRgstNum;
	private String gen;
	private String delYn;
	private Date delDate;
	private String bankCode;
	private String bankAccntNum;
	private String memTypeCode;
	private String delTypeCode;
	private Date createDate;
	private Date modDate;
	private String memId;
	private String fileGrNum;
	private String pwd;
	private String name;
	private String phNum;
	private String addr;
	private String addrDetail;
	private String zipcode;
	private String firstLoginInsertVal;
	private String newPw;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getMemTypeCode() {
		return memTypeCode;
	}
	public void setMemTypeCode(String memTypeCode) {
		this.memTypeCode = memTypeCode;
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
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
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
	public String getFirstLoginInsertVal() {
		return firstLoginInsertVal;
	}
	public void setFirstLoginInsertVal(String firstLoginInsertVal) {
		this.firstLoginInsertVal = firstLoginInsertVal;
	}
	
	
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", pwdErrCnt=" + pwdErrCnt + ", alertUseYn=" + alertUseYn + ", resRgstNum="
				+ resRgstNum + ", gen=" + gen + ", delYn=" + delYn + ", delDate=" + delDate + ", bankCode=" + bankCode
				+ ", bankAccntNum=" + bankAccntNum + ", memTypeCode=" + memTypeCode + ", delTypeCode=" + delTypeCode
				+ ", createDate=" + createDate + ", modDate=" + modDate + ", memId=" + memId + ", fileGrNum="
				+ fileGrNum + ", pwd=" + pwd + ", name=" + name + ", phNum=" + phNum + ", addr=" + addr
				+ ", addrDetail=" + addrDetail + ", zipcode=" + zipcode + ", firstLoginInsertVal=" + firstLoginInsertVal
				+ ", newPw=" + newPw + "]";
	}

}
