package kr.or.ddit.student.readmission.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.student.readmission.vo.ReadmissionVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;

public interface ReadmissionService {
	
	// 페이징 처리
	public PaginationInfo getPaginationInfo(ReadmissionVO readmissionVo);
	
	// 리스트 가져오기
	public List<ReadmissionVO> readmissionApplyList(ReadmissionVO readmissionVo, PaginationInfo paginationInfo);
	
	// 이미 신청 진행 중인 (접수 상태) 신청 내역이 있는지 확인
	public String applyCheck(ReadmissionVO readmissionVo);
	
	// 신청하기
	public int readmissionApplyInsert(ReadmissionVO readmissionVo);
	
	// 학생 상세 정보 보기
	public StudentVO getStdInfo(HttpSession session);
	
	// 신청 상세 정보 보기 
	public ReadmissionVO readmissionApplyDetail(String readmNum);
	
	// 삭제하기
	public int readmissionApplyDelete(ReadmissionVO readmissionVo);

	/**
	 * count 정보 
	 */
	ReadmissionVO readmissionApplyCount(ReadmissionVO readmissionVo);
	
	
}
