package kr.or.ddit.student.readingRoom.vo;

public class ReadingRoomVO {
	
	private String rnum;                    //순번
	private String roomIdnNum;              //열람실 식별 번호
	private String roomName;                //열람실 이름
	private String seatCnt;                 //좌석 수
	private String roomNum;                 //열람실 호수
	private String buildCode;               //건물 코드
	
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getRoomIdnNum() {
		return roomIdnNum;
	}
	public void setRoomIdnNum(String roomIdnNum) {
		this.roomIdnNum = roomIdnNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getSeatCnt() {
		return seatCnt;
	}
	public void setSeatCnt(String seatCnt) {
		this.seatCnt = seatCnt;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getBuildCode() {
		return buildCode;
	}
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}
	
	@Override
	public String toString() {
		return "ReadingRoomVO [rnum=" + rnum + ", roomIdnNum=" + roomIdnNum + ", roomName=" + roomName + ", seatCnt="
				+ seatCnt + ", roomNum=" + roomNum + ", buildCode=" + buildCode + "]";
	}
	
}
