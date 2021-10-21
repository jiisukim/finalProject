package kr.or.ddit.student.returnBack.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.util.BaseVO.BaseVO;

public class ReturnVO extends BaseVO{
	
	private String returnApplyNum;
	private String returnTypeCode;
	private String stdId;
	private String name;
	private String year;
	private String semCode;
	private String applyDate;
	private String procStatCode;
	private String disauthRsn;
	private String fileGrNum;
	private List<MultipartFile> fileList;
	private String authDocNum;
	
	private int cnt01;
	private int cnt02;
	private int cnt03;
	private int cnt04;
	private int totalCnt;
	
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
	public String getReturnApplyNum() {
		return returnApplyNum;
	}
	public void setReturnApplyNum(String returnApplyNum) {
		this.returnApplyNum = returnApplyNum;
	}
	public String getReturnTypeCode() {
		return returnTypeCode;
	}
	public void setReturnTypeCode(String returnTypeCode) {
		this.returnTypeCode = returnTypeCode;
	}
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
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	public List<MultipartFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}
	public String getAuthDocNum() {
		return authDocNum;
	}
	public void setAuthDocNum(String authDocNum) {
		this.authDocNum = authDocNum;
	}
	
	
}
