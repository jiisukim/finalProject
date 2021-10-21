package kr.or.ddit.student.tuitionPayment.vo;

import java.text.SimpleDateFormat;

import kr.or.ddit.util.BaseVO.BaseVO;

public class VrtAccntCodeVO extends BaseVO {
	
	private String vrtAccnt; // 가상 계좌 번호
	private String bankCode; // 가상 계좌 은행
	private String createDate; // 생성일자
	private String useYn; // 사용 여부
	private String memId; // 가상계좌 사용자
	
	public String getCreateDateDisplay(){
		String createDateDisplay="";
		if(this.createDate != null) {
			createDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.createDate);
		}
		return createDateDisplay;
	}
	
	public String getVrtAccnt() {
		return vrtAccnt;
	}
	public void setVrtAccnt(String vrtAccnt) {
		this.vrtAccnt = vrtAccnt;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	
	
	
}
