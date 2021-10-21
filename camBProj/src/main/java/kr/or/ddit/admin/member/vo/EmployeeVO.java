package kr.or.ddit.admin.member.vo;

import java.util.Date;


public class EmployeeVO extends MemberVO{

	private String empId;		// 사번
	private Date apptDate;		// 발령 일자
	private Date retireDate;	// 퇴직 일자
	private String deptCode;	// 부서 코드
	private String jobCode;		// 직무 코드
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Date getApptDate() {
		return apptDate;
	}
	public void setApptDate(Date apptDate) {
		this.apptDate = apptDate;
	}
	public Date getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	
	
}
