package kr.or.ddit.student.tuitionPayment.vo;

import java.text.SimpleDateFormat;

import kr.or.ddit.util.BaseVO.BaseVO;

public class TuitionPaymentRecodeVO extends BaseVO{
	
	private String vrtAccntNum;   //가상계좌 
	private int actualPayAmt;	  //가수금액 (납부할 금액)
	private int payAmt;           //납부금액 
	private int notPayAmt;        //미수금액 
	private int refundAmt;        //환불금액 
	private int interestAmt;      //이자금액 
	private String payCode;       //납부코드 
	private String payDate;       //납부일자 
	private String refundComplYn; //환불완료여부 
	private String refundDate;    //환불일자 
	private String createDate;    //생성일자 
	
	public String getPayDateDisplay(){
		String payDateDisplay="";
		if(this.payDate != null) {
			payDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.payDate);
		}
		return payDateDisplay;
	}
	
	public String getRefundDateDisplay(){
			String refundDateDisplay="";
			if(this.refundDate != null) {
				refundDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.refundDate);
			}
			return refundDateDisplay;
	}

	public String getCreateDateDisplay(){
		String createDateDisplay="";
		if(this.createDate != null) {
			createDateDisplay = new SimpleDateFormat("yyyy-MM-dd").format(this.createDate);
		}
		return createDateDisplay;
	}
	
	public String getVrtAccntNum() {
		return vrtAccntNum;
	}
	public void setVrtAccntNum(String vrtAccntNum) {
		this.vrtAccntNum = vrtAccntNum;
	}
	public int getActualPayAmt() {
		return actualPayAmt;
	}
	public void setActualPayAmt(int actualPayAmt) {
		this.actualPayAmt = actualPayAmt;
	}
	public int getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(int payAmt) {
		this.payAmt = payAmt;
	}
	public int getNotPayAmt() {
		return notPayAmt;
	}
	public void setNotPayAmt(int notPayAmt) {
		this.notPayAmt = notPayAmt;
	}
	public int getRefundAmt() {
		return refundAmt;
	}
	public void setRefundAmt(int refundAmt) {
		this.refundAmt = refundAmt;
	}
	public int getInterestAmt() {
		return interestAmt;
	}
	public void setInterestAmt(int interestAmt) {
		this.interestAmt = interestAmt;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getRefundComplYn() {
		return refundComplYn;
	}
	public void setRefundComplYn(String refundComplYn) {
		this.refundComplYn = refundComplYn;
	}
	public String getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}
	
	
	
}
