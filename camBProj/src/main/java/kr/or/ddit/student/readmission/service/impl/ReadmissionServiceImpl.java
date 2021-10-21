package kr.or.ddit.student.readmission.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.student.readmission.mapper.ReadmissionMapper;
import kr.or.ddit.student.readmission.service.ReadmissionService;
import kr.or.ddit.student.readmission.vo.ReadmissionVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;
import kr.or.ddit.util.auth.service.AuthService;
import kr.or.ddit.util.format.service.FormatUtil;

@Service
public class ReadmissionServiceImpl implements ReadmissionService{
	
	@Autowired
	ReadmissionMapper readmissionMapper;
	
	@Autowired
	AuthService authService; // 결재 처리 용
	
	@Autowired
	FormatUtil formatUtil; // 전화번호 형식 처리 용
	
	/**
	 * pageNo가 저장된 returnVo를 페이징 처리 객체 가져오기
	 * @param returnVo : pageNo가 저장된 ReturnVO
	 * @return PaginationInfo : 1. 뷰단에 보내고 2. 리스트 쿼리에 firstInext, lastIndex 정보를 줄 페이징 객체  
	 */
	@Override
	public PaginationInfo getPaginationInfo(ReadmissionVO readmissionVo) {
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(readmissionVo.getPageNo());
		paginationInfo.setRecordCountPerPage(5);
		paginationInfo.setPageSize(5);
		paginationInfo.setTotalRecordCount(readmissionMapper.readmissionApplyCount(readmissionVo).getTotalCnt());
		return paginationInfo;
	}
	
	/**
	 * 페이징 처리된 리스트 가져오기
	 */
	@Override
	public List<ReadmissionVO> readmissionApplyList(ReadmissionVO readmissionVo
												, PaginationInfo paginationInfo) {
		
		// 페이징 처리
		readmissionVo.setFirstIndex(paginationInfo.getFirstRecordIndex()+1); 
		readmissionVo.setLastIndex(paginationInfo.getLastRecordIndex());	
		
		// 리스트 가져오기 
		List<ReadmissionVO> returnApplyList = readmissionMapper.readmissionApplyList(readmissionVo);
		return returnApplyList;
	}
	
	/**
	 * 이미 신청 진행 중인 (접수 상태) 신청 내역이 있는지 확인
	 * @return 접수 가능하면 True, 불가능하면 False
	 */
	@Override
	public String applyCheck(ReadmissionVO readmissionVo) {
		int rowCnt = readmissionMapper.applyCheck(readmissionVo);
		if(rowCnt > 0) {
			return "False";
		}
		return "True";
	}
	
	/**
	 * count 정보 
	 */
	@Override
	public ReadmissionVO readmissionApplyCount(ReadmissionVO readmissionVo) {
		return readmissionMapper.readmissionApplyCount(readmissionVo);
	}

	
	/**
	 * 복적 재입학 신청 폼 제출하기
	 */
	@Override
	public int readmissionApplyInsert(ReadmissionVO readmissionVo) {
		
		String authDocNum = authService.authDocInsert("03");
		readmissionVo.setAuthDocNum(authDocNum);
		int result = readmissionMapper.readmissionApplyInsert(readmissionVo);
		return result;
	}

	/**
	 * 학생 정보 가져오기 : 학년, 전공, 전화번호
	 * 그 밖의 회원 정보는 session에서 꺼내 쓰기 
	 */
	@Override
	public StudentVO getStdInfo(HttpSession session) {
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		StudentVO studentVo = readmissionMapper.getStdInfo(memberVo.getMemId());
		studentVo.setPhNum(formatUtil.phone(memberVo.getPhNum())); // 휴대폰 번호 형식에 맞춰 넣어주기 
		return studentVo;
	}
	
	
	/**
	 * 복적 재입학 신청 상세 정보 가져오기
	 */
	@Override
	public ReadmissionVO readmissionApplyDetail(String readmNum) {
		ReadmissionVO readmissionVo = readmissionMapper.readmissionApplyDetail(readmNum);
		return readmissionVo;
	}
	
	/**
	 * 복적 재입학 신청 삭제하기
	 */
	@Override
	public int readmissionApplyDelete(ReadmissionVO readmissionVo) {
		readmissionVo = readmissionApplyDetail(readmissionVo.getReadmNum());
		// 결재 기안 삭제하기
		authService.authDocDelete(readmissionVo.getAuthDocNum());

		// 신청 내역 삭제하기
		int result = readmissionMapper.readmissionApplyDelete(readmissionVo.getReadmNum());
		return result;
	}
	
}
