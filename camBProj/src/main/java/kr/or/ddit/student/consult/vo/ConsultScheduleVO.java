package kr.or.ddit.student.consult.vo;

public class ConsultScheduleVO {

	private String profId;             //교번 No 외래키 210201001
	private String consultAvlDate;     //상담 가능 일자
	private String startTime;          //시작 시간
	private String endTime;            //종료 시간
	private String consultSchdlNum;    //상담 일정 번호 No 기본키
	private int cap;                   //정원
	private int capSeat;               //잔여석
	private String createDate;         //등록 일자
	private String modDate;            //수정 일자
	
	private String rnum;
	private String name;               //교수 이름
	private String department;		   //교수 학과
	
	public String getProfId() {
		return profId;
	}
	public void setProfId(String profId) {
		this.profId = profId;
	}
	public String getConsultAvlDate() {
		return consultAvlDate;
	}
	public void setConsultAvlDate(String consultAvlDate) {
		this.consultAvlDate = consultAvlDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getConsultSchdlNum() {
		return consultSchdlNum;
	}
	public void setConsultSchdlNum(String consultSchdlNum) {
		this.consultSchdlNum = consultSchdlNum;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public int getCapSeat() {
		return capSeat;
	}
	public void setCapSeat(int capSeat) {
		this.capSeat = capSeat;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "ConsultScheduleVO [profId=" + profId + ", consultAvlDate=" + consultAvlDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", consultSchdlNum=" + consultSchdlNum + ", cap=" + cap + ", capSeat="
				+ capSeat + ", createDate=" + createDate + ", modDate=" + modDate + ", rnum=" + rnum + ", name=" + name
				+ ", department=" + department + "]";
	}
}
