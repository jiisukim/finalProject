package kr.or.ddit.util.file.vo;

import java.util.Date;

public class AttachFileGroupVO {
	
	private String fileGrNum;
	private Date createDate;
	private Date deleteDate;
	
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	@Override
	public String toString() {
		return "AttachFileVO [fileGrNum=" + fileGrNum + ", createDate=" + createDate + ", deleteDate=" + deleteDate
				+ "]";
	}
	
}
