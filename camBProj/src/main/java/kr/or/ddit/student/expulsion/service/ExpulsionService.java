package kr.or.ddit.student.expulsion.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.student.expulsion.vo.ExpulsionVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;

public interface ExpulsionService {
	
	// 페이징 처리
	public PaginationInfo getPaginationInfo(ExpulsionVO expulsionVo);
	
	// 리스트 가져오기
	public List<ExpulsionVO> expulsionApplyList(ExpulsionVO expulsionVo, PaginationInfo paginationInfo);
	
	// 이미 신청 진행 중인 (접수 상태) 신청 내역이 있는지 확인
	public String applyCheck(ExpulsionVO expulsionVo);
	
	// 신청하기
	public int expulsionApplyInsert(ExpulsionVO expulsionVo);
	
	// 학생 상세 정보 보기
	public StudentVO getStdInfo(HttpSession session);
	
	// 신청 상세 정보 보기 
	public ExpulsionVO expulsionApplyDetail(String expulsionApplyNum);
	
	// 수정하기 
	public int expulsionApplyUpdate(ExpulsionVO expulsionVo);
	
	// 삭제하기
	public int expulsionApplyDelete(ExpulsionVO expulsionVo);

	/**
	 * count 정보
	 */
	ExpulsionVO expulsionApplyCount(ExpulsionVO expulsionVo);
	
	
}
