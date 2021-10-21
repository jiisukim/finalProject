package kr.or.ddit.util.auth.vo;

public class AuthLineVO {
	
	private String authLineNum;
	private String authLineName;
	private String authLineTypeCode;
	private String creator;
	private String updateDate;
	
	public String getAuthLineNum() {
		return authLineNum;
	}
	public void setAuthLineNum(String authLineNum) {
		this.authLineNum = authLineNum;
	}
	public String getAuthLineName() {
		return authLineName;
	}
	public void setAuthLineName(String authLineName) {
		this.authLineName = authLineName;
	}
	public String getAuthLineTypeCode() {
		return authLineTypeCode;
	}
	public void setAuthLineTypeCode(String authLineTypeCode) {
		this.authLineTypeCode = authLineTypeCode;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "AuthLineVO [authLineNum=" + authLineNum + ", authLineName=" + authLineName + ", authLineTypeCode="
				+ authLineTypeCode + ", creator=" + creator + ", updateDate=" + updateDate + "]";
	}
	
	
}
