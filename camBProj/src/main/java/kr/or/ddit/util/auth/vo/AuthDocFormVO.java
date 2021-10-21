package kr.or.ddit.util.auth.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class AuthDocFormVO extends BaseVO{
	
	private String authDocFormNum;
	private String authDocFormName;
	private String authDocFormPath;
	private String memId;
	
	public String getAuthDocFormNum() {
		return authDocFormNum;
	}
	public void setAuthDocFormNum(String authDocFormNum) {
		this.authDocFormNum = authDocFormNum;
	}
	public String getAuthDocFormName() {
		return authDocFormName;
	}
	public void setAuthDocFormName(String authDocFormName) {
		this.authDocFormName = authDocFormName;
	}
	public String getAuthDocFormPath() {
		return authDocFormPath;
	}
	public void setAuthDocFormPath(String authDocFormPath) {
		this.authDocFormPath = authDocFormPath;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
}
