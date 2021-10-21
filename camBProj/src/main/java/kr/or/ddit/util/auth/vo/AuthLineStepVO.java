package kr.or.ddit.util.auth.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class AuthLineStepVO extends BaseVO {
	
	private String authLineNum;
	private String authLineName;
	private String authLineTypeCode;
	private String creator;
	private String updateDate;
	private String memId;
	private String memIdList;
	
	// 휴학 결재 시 학생 별 결재선 생성을 위해
	private String stdId;
	
	// 이름도 가져오기
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemIdList() {
		return memIdList;
	}
	public void setMemIdList(String memIdList) {
		this.memIdList = memIdList;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	
}
