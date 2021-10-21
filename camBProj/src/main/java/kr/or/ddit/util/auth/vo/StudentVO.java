package kr.or.ddit.util.auth.vo;

import kr.or.ddit.util.BaseVO.BaseVO;

public class StudentVO extends BaseVO {
	
	private String stdId;
	private String univDeptNum;
	private String admDate;
	private String grdDate;
	private String rgstSem;
	private String acadStatCode;
	private String advProf;
	
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getUnivDeptNum() {
		return univDeptNum;
	}
	public void setUnivDeptNum(String univDeptNum) {
		this.univDeptNum = univDeptNum;
	}
	public String getAdmDate() {
		return admDate;
	}
	public void setAdmDate(String admDate) {
		this.admDate = admDate;
	}
	public String getGrdDate() {
		return grdDate;
	}
	public void setGrdDate(String grdDate) {
		this.grdDate = grdDate;
	}
	public String getRgstSem() {
		return rgstSem;
	}
	public void setRgstSem(String rgstSem) {
		this.rgstSem = rgstSem;
	}
	public String getAcadStatCode() {
		return acadStatCode;
	}
	public void setAcadStatCode(String acadStatCode) {
		this.acadStatCode = acadStatCode;
	}
	public String getAdvProf() {
		return advProf;
	}
	public void setAdvProf(String advProf) {
		this.advProf = advProf;
	}
	
	
	
}
