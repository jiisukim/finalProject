package kr.or.ddit.professor.lecture.vo;

import java.util.Date;

public class SyllabusVO {
	private String otherthings;		       //기타사항
	private String sylNum;                 //강의계획서 번호
	private String lectOvr;                //강의 개요
	private String lectGoal;               //강의 목표
	private String lectMethod;             //강의 방법
	private String w1LectPlan;             //1주 강의계획
	private String w2LectPlan;             //2주 강의 계획
	private String w3LectPlan;             //3주 강의 계획
	private String w4LectPlan;             //4주 강의 계획
	private String w5LectPlan;             //5주 강의 계획
	private String w6LectPlan;             //6주 강의 계획
	private String w7LectPlan;             //7주 강의 계획
	private String w8LectPlan;             //8주 강의 계획
	private String w9LectPlan;             //9주 강의 계획
	private String w10LectPlan;            //10주 강의 계획
	private String w11LectPlan;            //11주 강의 계획
	private String w12LectPlan;            //12주 강의 계획
	private String w13LectPlan;            //13주 강의 계획
	private String w14LectPlan;            //14주 강의 계획
	private String w15LectPlan;            //15주 강의 계획
	private String w16LectPlan;            //16주 강의 계획
	private String mainTxtb;               //주교재
	private String secTxtb;                //부교재
	private int midReflectPer;             //중간고사 반영 비율
	private int finalReflectPer;           //기말고사 반영 비율
	private int attendReflectPer;          //출석 반영 비율
	private int assignRelectPer;           //과제 반영 비율
	private int quizReflectPer;            //퀴즈 반영 비율
	private int debateReflectPer;          //토론 반영 비율
	private int otherReflectPer;           //기타 반영 비율
	
	///////////////////////////MEMBER테이블 
	private String email;                     //이메일
	private int pwdErrCnt;                    //비밀번호 오류 횟수
	private String alertUseYn;                //알림 사용 여부
	private String resRgstNum;                //주민등록번호
	private String gen;                       //성별
	private String delYn;                     //삭제 여부
	private Date delDate;                     //삭제 일자
	private String bankCode;                  //은행 코드
	private String bankAccntNum;              //계좌 번호
	private String memTypeCode;               //회원 유형 코드
	private String delTypeCode;               //삭제 유형 코드
	private Date createDate;                  //등록 일자
	private Date modDate;                     //수정 일자
	private String memId;                     //회원 아이디
	private String fileGrNum;                 //파일 그룹 번호
	private String pwd;                       //비밀번호
	private String name;                      //이름
	private String phNum;                     //전화 번호
	private String addr;                      //주소
	private String addrDetail;                //상세 주소
	private String zipcode;                   //우편번호
	
	////////////////////////////
	private String subjNum;         //과목 번호 // 학수번호
	private String profId;			//교번
	
	
	
	public String getSubjNum() {
		return subjNum;
	}
	public void setSubjNum(String subjNum) {
		this.subjNum = subjNum;
	}
	public String getProfId() {
		return profId;
	}
	public void setProfId(String profId) {
		this.profId = profId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPwdErrCnt() {
		return pwdErrCnt;
	}
	public void setPwdErrCnt(int pwdErrCnt) {
		this.pwdErrCnt = pwdErrCnt;
	}
	public String getAlertUseYn() {
		return alertUseYn;
	}
	public void setAlertUseYn(String alertUseYn) {
		this.alertUseYn = alertUseYn;
	}
	public String getResRgstNum() {
		return resRgstNum;
	}
	public void setResRgstNum(String resRgstNum) {
		this.resRgstNum = resRgstNum;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankAccntNum() {
		return bankAccntNum;
	}
	public void setBankAccntNum(String bankAccntNum) {
		this.bankAccntNum = bankAccntNum;
	}
	public String getMemTypeCode() {
		return memTypeCode;
	}
	public void setMemTypeCode(String memTypeCode) {
		this.memTypeCode = memTypeCode;
	}
	public String getDelTypeCode() {
		return delTypeCode;
	}
	public void setDelTypeCode(String delTypeCode) {
		this.delTypeCode = delTypeCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getFileGrNum() {
		return fileGrNum;
	}
	public void setFileGrNum(String fileGrNum) {
		this.fileGrNum = fileGrNum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getOtherthings() {
		return otherthings;
	}
	public void setOtherthings(String otherthings) {
		this.otherthings = otherthings;
	}
	public String getSylNum() {
		return sylNum;
	}
	public void setSylNum(String sylNum) {
		this.sylNum = sylNum;
	}
	public String getLectOvr() {
		return lectOvr;
	}
	public void setLectOvr(String lectOvr) {
		this.lectOvr = lectOvr;
	}
	public String getLectGoal() {
		return lectGoal;
	}
	public void setLectGoal(String lectGoal) {
		this.lectGoal = lectGoal;
	}
	public String getLectMethod() {
		return lectMethod;
	}
	public void setLectMethod(String lectMethod) {
		this.lectMethod = lectMethod;
	}
	public String getW1LectPlan() {
		return w1LectPlan;
	}
	public void setW1LectPlan(String w1LectPlan) {
		this.w1LectPlan = w1LectPlan;
	}
	public String getW2LectPlan() {
		return w2LectPlan;
	}
	public void setW2LectPlan(String w2LectPlan) {
		this.w2LectPlan = w2LectPlan;
	}
	public String getW3LectPlan() {
		return w3LectPlan;
	}
	public void setW3LectPlan(String w3LectPlan) {
		this.w3LectPlan = w3LectPlan;
	}
	public String getW4LectPlan() {
		return w4LectPlan;
	}
	public void setW4LectPlan(String w4LectPlan) {
		this.w4LectPlan = w4LectPlan;
	}
	public String getW5LectPlan() {
		return w5LectPlan;
	}
	public void setW5LectPlan(String w5LectPlan) {
		this.w5LectPlan = w5LectPlan;
	}
	public String getW6LectPlan() {
		return w6LectPlan;
	}
	public void setW6LectPlan(String w6LectPlan) {
		this.w6LectPlan = w6LectPlan;
	}
	public String getW7LectPlan() {
		return w7LectPlan;
	}
	public void setW7LectPlan(String w7LectPlan) {
		this.w7LectPlan = w7LectPlan;
	}
	public String getW8LectPlan() {
		return w8LectPlan;
	}
	public void setW8LectPlan(String w8LectPlan) {
		this.w8LectPlan = w8LectPlan;
	}
	public String getW9LectPlan() {
		return w9LectPlan;
	}
	public void setW9LectPlan(String w9LectPlan) {
		this.w9LectPlan = w9LectPlan;
	}
	public String getW10LectPlan() {
		return w10LectPlan;
	}
	public void setW10LectPlan(String w10LectPlan) {
		this.w10LectPlan = w10LectPlan;
	}
	public String getW11LectPlan() {
		return w11LectPlan;
	}
	public void setW11LectPlan(String w11LectPlan) {
		this.w11LectPlan = w11LectPlan;
	}
	public String getW12LectPlan() {
		return w12LectPlan;
	}
	public void setW12LectPlan(String w12LectPlan) {
		this.w12LectPlan = w12LectPlan;
	}
	public String getW13LectPlan() {
		return w13LectPlan;
	}
	public void setW13LectPlan(String w13LectPlan) {
		this.w13LectPlan = w13LectPlan;
	}
	public String getW14LectPlan() {
		return w14LectPlan;
	}
	public void setW14LectPlan(String w14LectPlan) {
		this.w14LectPlan = w14LectPlan;
	}
	public String getW15LectPlan() {
		return w15LectPlan;
	}
	public void setW15LectPlan(String w15LectPlan) {
		this.w15LectPlan = w15LectPlan;
	}
	public String getW16LectPlan() {
		return w16LectPlan;
	}
	public void setW16LectPlan(String w16LectPlan) {
		this.w16LectPlan = w16LectPlan;
	}
	public String getMainTxtb() {
		return mainTxtb;
	}
	public void setMainTxtb(String mainTxtb) {
		this.mainTxtb = mainTxtb;
	}
	public String getSecTxtb() {
		return secTxtb;
	}
	public void setSecTxtb(String secTxtb) {
		this.secTxtb = secTxtb;
	}
	public int getMidReflectPer() {
		return midReflectPer;
	}
	public void setMidReflectPer(int midReflectPer) {
		this.midReflectPer = midReflectPer;
	}
	public int getFinalReflectPer() {
		return finalReflectPer;
	}
	public void setFinalReflectPer(int finalReflectPer) {
		this.finalReflectPer = finalReflectPer;
	}
	public int getAttendReflectPer() {
		return attendReflectPer;
	}
	public void setAttendReflectPer(int attendReflectPer) {
		this.attendReflectPer = attendReflectPer;
	}
	public int getAssignRelectPer() {
		return assignRelectPer;
	}
	public void setAssignRelectPer(int assignRelectPer) {
		this.assignRelectPer = assignRelectPer;
	}
	public int getQuizReflectPer() {
		return quizReflectPer;
	}
	public void setQuizReflectPer(int quizReflectPer) {
		this.quizReflectPer = quizReflectPer;
	}
	public int getDebateReflectPer() {
		return debateReflectPer;
	}
	public void setDebateReflectPer(int debateReflectPer) {
		this.debateReflectPer = debateReflectPer;
	}
	public int getOtherReflectPer() {
		return otherReflectPer;
	}
	public void setOtherReflectPer(int otherReflectPer) {
		this.otherReflectPer = otherReflectPer;
	}
	@Override
	public String toString() {
		return "SyllabusVO [otherthings=" + otherthings + ", sylNum=" + sylNum + ", lectOvr=" + lectOvr + ", lectGoal="
				+ lectGoal + ", lectMethod=" + lectMethod + ", w1LectPlan=" + w1LectPlan + ", w2LectPlan=" + w2LectPlan
				+ ", w3LectPlan=" + w3LectPlan + ", w4LectPlan=" + w4LectPlan + ", w5LectPlan=" + w5LectPlan
				+ ", w6LectPlan=" + w6LectPlan + ", w7LectPlan=" + w7LectPlan + ", w8LectPlan=" + w8LectPlan
				+ ", w9LectPlan=" + w9LectPlan + ", w10LectPlan=" + w10LectPlan + ", w11LectPlan=" + w11LectPlan
				+ ", w12LectPlan=" + w12LectPlan + ", w13LectPlan=" + w13LectPlan + ", w14LectPlan=" + w14LectPlan
				+ ", w15LectPlan=" + w15LectPlan + ", w16LectPlan=" + w16LectPlan + ", mainTxtb=" + mainTxtb
				+ ", secTxtb=" + secTxtb + ", midReflectPer=" + midReflectPer + ", finalReflectPer=" + finalReflectPer
				+ ", attendReflectPer=" + attendReflectPer + ", assignRelectPer=" + assignRelectPer
				+ ", quizReflectPer=" + quizReflectPer + ", debateReflectPer=" + debateReflectPer + ", otherReflectPer="
				+ otherReflectPer + ", email=" + email + ", pwdErrCnt=" + pwdErrCnt + ", alertUseYn=" + alertUseYn
				+ ", resRgstNum=" + resRgstNum + ", gen=" + gen + ", delYn=" + delYn + ", delDate=" + delDate
				+ ", bankCode=" + bankCode + ", bankAccntNum=" + bankAccntNum + ", memTypeCode=" + memTypeCode
				+ ", delTypeCode=" + delTypeCode + ", createDate=" + createDate + ", modDate=" + modDate + ", memId="
				+ memId + ", fileGrNum=" + fileGrNum + ", pwd=" + pwd + ", name=" + name + ", phNum=" + phNum
				+ ", addr=" + addr + ", addrDetail=" + addrDetail + ", zipcode=" + zipcode + ", subjNum=" + subjNum
				+ ", profId=" + profId + "]";
	}
	
	
	
	
	
	
}
