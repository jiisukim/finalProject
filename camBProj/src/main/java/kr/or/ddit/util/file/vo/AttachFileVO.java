package kr.or.ddit.util.file.vo;

import java.util.Date;

public class AttachFileVO {
	
	private Date deleteDate;
	private String deleteYn;
	private String filePath;
	private Date createDate;
	private String creator;
	private String fileExtns;
	private String saveFileName;
	private String originFileName;
	private int fileGrSeq;
	private String fileGrNum;
	
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getFileExtns() {
		return fileExtns;
	}
	public void setFileExtns(String fileExtns) {
		this.fileExtns = fileExtns;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public int getFileGrSeq() {
		return fileGrSeq;
	}
	public void setFileGrSeq(int fileGrSeq) {
		this.fileGrSeq = fileGrSeq;
	}
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	@Override
	public String toString() {
		return "AttachFileVO [deleteDate=" + deleteDate + ", deleteYn=" + deleteYn + ", filePath=" + filePath
				+ ", createDate=" + createDate + ", creator=" + creator + ", fileExtns=" + fileExtns + ", saveFileName="
				+ saveFileName + ", originFileName=" + originFileName + ", fileGrSeq=" + fileGrSeq + ", fileGrNum="
				+ fileGrNum + "]";
	}
	
	
}
