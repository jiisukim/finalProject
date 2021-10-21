package kr.or.ddit.common.myPage.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class VCodeBank extends BaseVO{

	private String codeType;
	private String codeName;
	private String codeVal;
	
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeVal() {
		return codeVal;
	}
	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}
	
	
}
