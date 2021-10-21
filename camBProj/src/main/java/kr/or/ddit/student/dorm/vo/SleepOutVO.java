package kr.or.ddit.student.dorm.vo;

public class SleepOutVO {

	private String roomIdnNum;                 //생활관 방 식별 번호  - 기본키
	private String applyDate;                  //외박 신청 일자 - 기본키
	private String departDate;                 //외박 출발 일자
	private String returnDate;                 //외박 귀가 일자
	private String destination;                //행선지
	private String emrContact;                 //긴급 연락처
	private String slpOutRsn;                  //외박 사유
	private String roomPos;                    //생활관 방 자리
	private String entrApplyNum;               //입실 신청 번호 - 기본키
	
	private String rnum;

	public String getRoomIdnNum() {
		return roomIdnNum;
	}

	public void setRoomIdnNum(String roomIdnNum) {
		this.roomIdnNum = roomIdnNum;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getEmrContact() {
		return emrContact;
	}

	public void setEmrContact(String emrContact) {
		this.emrContact = emrContact;
	}

	public String getSlpOutRsn() {
		return slpOutRsn;
	}

	public void setSlpOutRsn(String slpOutRsn) {
		this.slpOutRsn = slpOutRsn;
	}

	public String getRoomPos() {
		return roomPos;
	}

	public void setRoomPos(String roomPos) {
		this.roomPos = roomPos;
	}

	public String getEntrApplyNum() {
		return entrApplyNum;
	}

	public void setEntrApplyNum(String entrApplyNum) {
		this.entrApplyNum = entrApplyNum;
	}

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "SleepOutVO [roomIdnNum=" + roomIdnNum + ", applyDate=" + applyDate + ", departDate=" + departDate
				+ ", returnDate=" + returnDate + ", destination=" + destination + ", emrContact=" + emrContact
				+ ", slpOutRsn=" + slpOutRsn + ", roomPos=" + roomPos + ", entrApplyNum=" + entrApplyNum + ", rnum="
				+ rnum + "]";
	}
	
}
