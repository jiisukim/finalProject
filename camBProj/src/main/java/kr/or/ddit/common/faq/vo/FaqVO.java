package kr.or.ddit.common.faq.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.util.BaseVO.BaseVO;

public class FaqVO extends BaseVO {
	
	private String empId;
	private String artcNum;
	private String title;
	private String content;
	private String faqKwdCode;
	private String fileGrNum;
	private Date writeDate;
	private Date modDate;
	private int rnum;
	private List<MultipartFile> fileList;
	
	private String name;  //멤버에 name 조인
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getArtcNum() {
		return artcNum;
	}
	public void setArtcNum(String artcNum) {
		this.artcNum = artcNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFaqKwdCode() {
		return faqKwdCode;
	}
	public void setFaqKwdCode(String faqKwdCode) {
		this.faqKwdCode = faqKwdCode;
	}
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public List<MultipartFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "FaqVO [empId=" + empId + ", artcNum=" + artcNum + ", title=" + title + ", content=" + content
				+ ", faqKwdCode=" + faqKwdCode + ", fileGrNum=" + fileGrNum + ", writeDate=" + writeDate + ", modDate="
				+ modDate + ", rnum=" + rnum + ", fileList=" + fileList + ", name=" + name + "]";
	}
	
}
