package kr.or.ddit.student.courseChange.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.student.courseChange.mapper.CourseChangeMapper;
import kr.or.ddit.student.courseChange.service.CourseChangeService;
import kr.or.ddit.student.courseChange.vo.CourseChangeVO;
import kr.or.ddit.student.courseChange.vo.CourseRecodeVO;
import kr.or.ddit.student.courseChange.vo.UniversityDepartmentVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;
import kr.or.ddit.util.auth.service.AuthService;
import kr.or.ddit.util.format.service.FormatUtil;

@Service
public class CourseChangeServiceImpl implements CourseChangeService{
	
	@Autowired
	CourseChangeMapper courseChangeMapper;
	
	@Autowired
	AuthService authService; // 결재 처리 용
	
	@Autowired
	FormatUtil formatUtil; // 전화번호 형식 처리 용

	/**
	 * pageNo가 저장된 courseChangeVo를 페이징 처리 객체 가져오기
	 * @param courseChangeVo : pageNo가 저장된 courseChangeVo
	 * @return PaginationInfo : 1. 뷰단에 보내고 2. 리스트 쿼리에 firstInext, lastIndex 정보를 줄 페이징 객체  
	 */
	@Override
	public PaginationInfo getPaginationInfo(CourseChangeVO courseChangeVo) {
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(courseChangeVo.getPageNo());
		paginationInfo.setRecordCountPerPage(5);
		paginationInfo.setPageSize(5);
		paginationInfo.setTotalRecordCount(courseChangeMapper.courseChangeApplyCount(courseChangeVo).getTotalCnt());
		return paginationInfo;
	}
	
	/** 
	 * count 정보 
	 */
	@Override
	public CourseChangeVO courseChangeApplyCount(CourseChangeVO courseChangeVo) {
		return courseChangeMapper.courseChangeApplyCount(courseChangeVo);
	}
	
	/**
	 * 학과 검색에서 사용하는 페이징 처리 객체 가져오기
	 * @param universityDepartmentVo : pageNo가 저장된 universityDepartmentVo
	 * @return PaginationInfo : 1. 뷰단에 보내고 2. 리스트 쿼리에 firstInext, lastIndex 정보를 줄 페이징 객체  
	 */
	@Override
	public PaginationInfo getPaginationInfoForUnivDept(UniversityDepartmentVO universityDepartmentVo) {
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(universityDepartmentVo.getPageNo());
		paginationInfo.setRecordCountPerPage(5);
		paginationInfo.setPageSize(5);
		paginationInfo.setTotalRecordCount(courseChangeMapper.univDeptTotalCount(universityDepartmentVo));
		return paginationInfo;
	}

	/**
	 * 페이징 처리된 신청 내역 리스트 가져오기
	 */
	@Override
	public List<CourseChangeVO> courseChangeApplyList(CourseChangeVO courseChangeVo, PaginationInfo paginationInfo) {
		// 페이징 처리
		courseChangeVo.setFirstIndex(paginationInfo.getFirstRecordIndex()+1); 
		courseChangeVo.setLastIndex(paginationInfo.getLastRecordIndex());	
		
		// 리스트 가져오기 
		List<CourseChangeVO> courseChangeApplyList = courseChangeMapper.courseChangeApplyList(courseChangeVo);
		return courseChangeApplyList;
	}
	
	/**
	 * 페이징 처리된 학과 리스트 가져오기
	 */
	@Override
	public List<UniversityDepartmentVO> univDeptSearch(UniversityDepartmentVO universityDepartmentVo, PaginationInfo paginationInfo){
		// 페이징 처리
		universityDepartmentVo.setFirstIndex(paginationInfo.getFirstRecordIndex()+1);
		universityDepartmentVo.setLastIndex(paginationInfo.getLastRecordIndex());
		
		// 리스트 가져오기
		List<UniversityDepartmentVO> UniversityDepartmentList = courseChangeMapper.univDeptSearch(universityDepartmentVo);
		return UniversityDepartmentList;
	}
	
	/**
	 * 이미 신청 진행 중인 (접수 상태) 신청 내역이 있는지 확인
	 * @return 접수 가능하면 True, 불가능하면 False
	 */
	@Override
	public Map<String, String> applyCheck(CourseChangeVO courseChangeVo) {
		
		Map<String, String> map = new HashMap<>();
		
		// 전과
		courseChangeVo.setCourseChngCode("01");
		int rowCnt01 = courseChangeMapper.applyCheck(courseChangeVo);
		if(rowCnt01 > 0) {
			map.put("applyCheck01", "False");
		}else {
			map.put("applyCheck01", "True");
		}
		// 복수전공
		courseChangeVo.setCourseChngCode("02");
		int rowCnt02 = courseChangeMapper.applyCheck(courseChangeVo);
		if(rowCnt02 > 0) {
			map.put("applyCheck02", "False");
		}else {
			map.put("applyCheck02", "True");
		}
		// 부전공
		courseChangeVo.setCourseChngCode("03");
		int rowCnt03 = courseChangeMapper.applyCheck(courseChangeVo);
		if(rowCnt03 > 0) {
			map.put("applyCheck03", "False");
		}else {
			map.put("applyCheck03", "True");
		}
		return map;
	}
	
	
	/**
	 * 이수 변경 신청 폼 제출하기
	 */
	@Override
	public int courseChangeApplyInsert(CourseChangeVO courseChangeVo) {
		String authDocNum = authService.authDocInsert("05");
		courseChangeVo.setAuthDocNum(authDocNum);
		int result = courseChangeMapper.courseChangeApplyInsert(courseChangeVo);
		return result;
	}

	/**
	 * 학생 정보 가져오기 : 학년, 전공, 전화번호
	 * 그 밖의 회원 정보는 session에서 꺼내 쓰기 
	 */
	@Override
	public StudentVO getStdInfo(HttpSession session) {
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		StudentVO studentVo = courseChangeMapper.getStdInfo(memberVo.getMemId());
		studentVo.setPhNum(formatUtil.phone(memberVo.getPhNum())); // 휴대폰 번호 형식에 맞춰 넣어주기 
		return studentVo;
	}
	
	/**
	 * 학생 이수 정보 가져오기 - 이수 변경 신청 가능한지 조회하기. (복수전공을 이미 했는지, 부전공을 이미 했는지)
	 * Map : key - 02, 03 / value - 신청 가능하다면 true, 불가능하다면  false
	 */
	@Override
	public Map<String, Object> courseRecodeCheck(CourseChangeVO courseChangeVo){
		Map<String, Object> map = new HashMap<>();
		map.put("CT2", "True");
		map.put("CT3", "True");
		
		CourseRecodeVO courseRecodeVo = new CourseRecodeVO();
		courseRecodeVo.setStdId(courseChangeVo.getStdId());
		
		List<CourseRecodeVO> list = courseChangeMapper.courseRecodeList(courseRecodeVo);
		
		for(CourseRecodeVO vo: list) {
			if("CT2".equals(vo.getCourseTypeNum())) {
				map.replace("CT2", "False");
			}else if("CT3".equals(vo.getCourseTypeNum())) {
				map.replace("CT3", "False");
			}
		}
		
		System.out.println("service map : " + map);
		return map;
	}
	
	/**
	 * 학생 이수 정보 가져오기 - 선택할 수 없는 학과의 학과 번호를 list로 보내기
	 */
	@Override
	public List<String> courseRecodeList(CourseChangeVO courseChangeVo){
		List<String> courseRecodeList = new ArrayList<>();
		
		CourseRecodeVO courseRecodeVo = new CourseRecodeVO();
		courseRecodeVo.setStdId(courseChangeVo.getStdId());
		
		List<CourseRecodeVO> list = courseChangeMapper.courseRecodeList(courseRecodeVo);
		
		String ct1 = "";
		String ct2 = "";
		String ct3 = "";
		
		for(CourseRecodeVO vo: list) {
			if("CT1".equals(vo.getCourseTypeNum())) {
				ct1 = vo.getUnivDeptNum();
			}else if("CT2".equals(vo.getCourseTypeNum())) {
				ct2 = vo.getUnivDeptNum();
			}else if("CT3".equals(vo.getCourseTypeNum())) {
				ct3 = vo.getUnivDeptNum();
			}
		}
		
		if("01".equals(courseChangeVo.getCourseChngCode())) {
			courseRecodeList.add(ct1);
		}else if("02".equals(courseChangeVo.getCourseChngCode())) {
			courseRecodeList.add(ct1);
			courseRecodeList.add(ct3);
		}else if("03".equals(courseChangeVo.getCourseChngCode())) {
			courseRecodeList.add(ct1);
			courseRecodeList.add(ct2);
		}
		
		return courseRecodeList;
	}
	
	
	/**
	 * 이수 변경 신청 상세 정보 가져오기
	 */
	@Override
	public CourseChangeVO courseChangeApplyDetail(String courseChngApplyNum) {
		CourseChangeVO courseChangeVo = courseChangeMapper.courseChangeApplyDetail(courseChngApplyNum);
		return courseChangeVo;
	}

	/**
	 * 이수 변경 신청 수정 폼 제출하기
	 */
	@Override
	public int courseChangeApplyUpdate(CourseChangeVO courseChangeVo) {
		int result = courseChangeMapper.courseChangeApplyUpdate(courseChangeVo);
		return result;
	}

	/**
	 * 이수 변경 신청 삭제하기
	 */
	@Override
	public int courseChangeApplyDelete(CourseChangeVO courseChangeVo) {
		courseChangeVo = courseChangeApplyDetail(courseChangeVo.getCourseChngApplyNum());
		// 결재 기안 삭제하기
		authService.authDocDelete(courseChangeVo.getAuthDocNum());

		// 신청 내역 삭제하기
		int result = courseChangeMapper.courseChangeApplyDelete(courseChangeVo.getCourseChngApplyNum());
		return result;
	}
	
	
	
	

}
