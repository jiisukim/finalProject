package kr.or.ddit.admin.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.member.vo.AllMemberVO;
import kr.or.ddit.admin.member.vo.EmployeeVO;
import kr.or.ddit.admin.member.vo.MemberVO;
import kr.or.ddit.admin.member.vo.ProfessorVO;
import kr.or.ddit.admin.member.vo.StudentVO;
import kr.or.ddit.admin.member.vo.VCodeVO;
import kr.or.ddit.util.code.vo.CodeVO;

public interface MemberService {

//	멤버 목록
	public List<MemberVO> selectMemberList(MemberVO memberVo) throws Exception;
	
//	멤버 인원 수
	public int totalMember(MemberVO memberVo) throws Exception;
	
//	학과목록
	public List<VCodeVO> selectUnivDepList() throws Exception;
	
//	지도교수목록
	public List<MemberVO> selectAdvProfList(String codeVal) throws Exception;
	
//	부서 목록
	public List<CodeVO> selectDeptCodeList() throws Exception;
	
//	직무 목록
	public List<CodeVO> selectJobCodeList() throws Exception;
	
//	memId생성	
	public String makeMemId(MemberVO memberVo) throws Exception;;
	 
//	멤버 등록
	public String insertMember(MemberVO memberVo) throws Exception;
	
//	학생등록
	public String insertStudent(StudentVO studentVo) throws Exception;;
	
//	교수등록
	public String insertProfessor(ProfessorVO professorVo) throws Exception;;
	
//	직원등록
	public String insertEmployee(EmployeeVO employeeVo) throws Exception;;
	
//	멤버기본정보
	public MemberVO detailMemberBefore(String memId) throws Exception;;
	
//	멤버상세
	public AllMemberVO detailMember(MemberVO memberVo) throws Exception;
	
//	멤버수정
	public int updateMember(MemberVO memberVo) throws Exception;
	
//	학생수정
	public int updateStudent(StudentVO studentVo) throws Exception;
	
//	교수수정
	public int updateProfessor(ProfessorVO professorVo) throws Exception;
	
//	직원수정
	public int updateEmployee(EmployeeVO employeeVo) throws Exception;
	
//	멤버 삭제
	public int deleteMember(MemberVO memberVo) throws Exception;
	
}
