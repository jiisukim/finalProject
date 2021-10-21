package kr.or.ddit.student.courseChange.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.common.main.service.impl.MainService;
import kr.or.ddit.student.courseChange.service.CourseChangeService;
import kr.or.ddit.student.courseChange.vo.CourseChangeVO;
import kr.or.ddit.student.courseChange.vo.UniversityDepartmentVO;
import kr.or.ddit.student.graduate.service.GraduateService;
import kr.or.ddit.student.takeOff.vo.StudentVO;
import kr.or.ddit.util.code.service.CodeService;
import kr.or.ddit.util.code.vo.CodeVO;
import kr.or.ddit.util.format.service.FormatUtil;
import kr.or.ddit.util.saveToken.service.SaveTokenService;
/**
 * - 신청 자격 
 * 1. 전과 : 4개 학기 이상 등록. 40학점 이상 취득)
 * 2. 복수전공 : 2개 정규학기 이상 이수. 30학점 이상 취득. 
 * 3. 부전공 : 2개 정규학기 이상 이수. 30학점 이상 취득.  
 * @author PC-08
 */
@Controller
public class CourseChangeController {
	
	@Autowired
	CourseChangeService courseChangeService;
	@Autowired
	CodeService codeService; // 공통 코드 처리 용
	@Autowired
	SaveTokenService saveTokenService; // 중복 입력 방지 처리 용
	@Autowired
	MainService mainService; // 성적 일람표 처리 용
	@Autowired
	GraduateService graduateService; // 성적 일람표 처리 용
	@Autowired
	FormatUtil formatUtil; // 전화번호 형식 처리 용
	
	/**
	 * 리스트 보여주기 
	 * @param courseChangeVo : pageNo가 담김
	 * @param session : 사용자 정보가 담김
	 * @param model
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyList")
	public String courseChangeApplyList(@ModelAttribute CourseChangeVO courseChangeVo
											    , HttpSession session
											    , Model model) throws JsonProcessingException {
		// 사용자 정보 가져오기
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		courseChangeVo.setStdId(memberVo.getMemId());
		// 학생 정보 보내기 (학적 상태 재학01/휴학02 일 경우만 신청 가능)
		StudentVO studentVo = courseChangeService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		// count 정보
		model.addAttribute("courseChangeApplyCount", courseChangeService.courseChangeApplyCount(courseChangeVo));
		// 학생의 이수 정보 보내기 (복수전공, 부전공은 한 번만 신청 가능)
		Map<String, Object> courseRecodeCheck = courseChangeService.courseRecodeCheck(courseChangeVo);
		model.addAttribute("courseRecodeCheck", courseRecodeCheck);
		// 이미 신청 진행 중인 (접수 상태) 신청 내역이 있는지 확인
		Map<String, String> applyCheck = courseChangeService.applyCheck(courseChangeVo);
		model.addAttribute("applyCheck", applyCheck);
		// 성적 정보 
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> scoreMap = graduateService.gradEvaluationDetail(memberVo.getMemId());
		model.addAttribute("jsonScoreList", mapper.writeValueAsString(scoreMap.get("scoreList")));
		model.addAttribute("jsonStdAcadInfo", mapper.writeValueAsString(mainService.StdAcadInfo(memberVo.getMemId())));
		// 페이징 처리
		PaginationInfo paginationInfo = courseChangeService.getPaginationInfo(courseChangeVo);
		model.addAttribute("paginationInfo", paginationInfo);
		// 리스트 가져오기
		List<CourseChangeVO> courseChangeApplyList = courseChangeService.courseChangeApplyList(courseChangeVo, paginationInfo);
		model.addAttribute("courseChangeApplyList", courseChangeApplyList);
		
		return "student/courseChange/courseChangeApplyList";
	}
	
	/**
	 * ajax 검색한 리스트 보여주기
	 * @param courseChangeVo : searchCondition, courseChngCodeList, pageNo
	 * @param session
	 * @param model
	 * @return courseChangeApplyList, paginationInfo
	 * @throws JsonProcessingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/student/courseChange/courseChangeApplySearch", produces = "application/json; charset=utf8")
	public Map<String, Object> courseChangeApplySearch(@RequestBody CourseChangeVO courseChangeVo
														, HttpSession session
														, Model model) throws JsonProcessingException {
		
		//사용자 정보 가져오기
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		courseChangeVo.setStdId(memberVo.getMemId());
		// 페이징 처리
		PaginationInfo paginationInfo = courseChangeService.getPaginationInfo(courseChangeVo);
		// 리스트 가져오기
		List<CourseChangeVO> courseChangeApplyList = courseChangeService.courseChangeApplyList(courseChangeVo, paginationInfo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("courseChangeApplyList", courseChangeApplyList);
		map.put("paginationInfo", paginationInfo);
		
		return map;
	}
	
	
	/**
	 * 이수 변경 신청 폼 보여주기
	 * @param courseChangeVo : 이전에 위치했던 pageNo 정보가 들어있음. saveToken도 함께 넣어 보내기.
	 * @param session 
	 * @param model
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyInsertView")
	public String courseChangeApplyInsertView(@ModelAttribute CourseChangeVO courseChangeVo
													  , HttpSession session
													  , Model model) throws JsonProcessingException {
		// 학생 기본 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = courseChangeService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		courseChangeVo.setStdId(studentVo.getStdId());
		
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		courseChangeVo.setSaveToken(saveToken);
		model.addAttribute("courseChangeVo", courseChangeVo);
		
		// 학생 부가 정보
		model.addAttribute("memInfo", mainService.memInfoSelect(memberVo.getMemId()));
		model.addAttribute("stdAcadInfo", mainService.StdAcadInfo(memberVo.getMemId()));
		
		// 성적 정보
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> scoreMap = graduateService.gradEvaluationDetail(memberVo.getMemId());
		model.addAttribute("scoreList", scoreMap.get("scoreList"));
		model.addAttribute("jsonScoreList", mapper.writeValueAsString(scoreMap.get("scoreList")));
		model.addAttribute("volTime", scoreMap.get("volTime"));
		
		// 전과/복수전공/부전공 뷰 다르게 보여주기
		String view = "";
		if("01".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyInsert01";
		}else if("02".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyInsert02";
		}else if("03".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyInsert03";
		}
		return view;
	}
	
	
	/**
	 * 학과 검색 팝업
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/student/courseChange/univDeptSearchPopup")
	public String univDeptSearchPopup(@ModelAttribute CourseChangeVO courseChangeVo // stdId, courseTypeNum 필요 
									, @ModelAttribute UniversityDepartmentVO universityDepartmentVo // 사실상 빈 값
													, HttpSession session
													, Model model) {
		
		// 페이징 처리
		PaginationInfo paginationInfo = courseChangeService.getPaginationInfoForUnivDept(universityDepartmentVo);
		model.addAttribute("paginationInfo", paginationInfo);
		
		// 학생의 이수 정보 보내기 (선택 학과 값 검증 위함)
		List<String> courseRecodeList = courseChangeService.courseRecodeList(courseChangeVo);
		model.addAttribute("courseRecodeList", courseRecodeList);
		
		// 공통 코드 (대학 이름)
		List<CodeVO> codeList = codeService.univCodeList();
		model.addAttribute("codeList", codeList);
		
		// 리스트 가져오기
		List<UniversityDepartmentVO> univDeptList = courseChangeService.univDeptSearch(universityDepartmentVo, paginationInfo);
		model.addAttribute("univDeptList", univDeptList);
		
		return "student/courseChange/popup/univDeptSearchPopup";
	}
	
	/**
	 * ajax 학과 검색 팝업에서 학과 검색 리스트와 페이징 객체 보내기
	 * @param authLineStepVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/student/courseChange/univDeptSearch", produces = "application/json; charset=utf8")
	public Map<String, Object> univDeptSearch(@RequestBody UniversityDepartmentVO universityDepartmentVo) {
		
		// 페이징 처리
		PaginationInfo paginationInfo = courseChangeService.getPaginationInfoForUnivDept(universityDepartmentVo);
		
		// 리스트 가져오기
		List<UniversityDepartmentVO> univDeptList = courseChangeService.univDeptSearch(universityDepartmentVo, paginationInfo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("univDeptList", univDeptList);
		map.put("paginationInfo", paginationInfo);
		
		return map;
	}
	
	
	/**
	 * 이수 변경 신청 폼 제출하기
	 * @param courseChangeVo : pageNo와 신청 정보가 들어있음
	 * @param session
	 * @return forward로 courseChangeApplyList를 실행
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyInsert")
	public String courseChangeApplyInsert(@ModelAttribute CourseChangeVO courseChangeVo
												  , HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, courseChangeVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/courseChange/courseChangeApplyList";
		}
		
		// 신청 폼 제출
		int result = courseChangeService.courseChangeApplyInsert(courseChangeVo);
		if(result > 0) System.out.println("신청 성공 : " + courseChangeVo);
		
		return "forward:/student/courseChange/courseChangeApplyList";
	}
	
	
	
	/**
	 * 이수 변경 신청 수정 폼 보여주기
	 * @param courseChangeVo : pageNo, courseChngApplyNum이 들어있음
	 * @param session
	 * @param model
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyUpdateView")
	public String courseChangeApplyUpdateView(@ModelAttribute CourseChangeVO courseChangeVo
														, HttpSession session
														, Model model) throws JsonProcessingException {
		// 학생 기본 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = courseChangeService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		
		// 신청 정보 보내기 (덮어 씌워서 보내기)
		courseChangeVo = courseChangeService.courseChangeApplyDetail(courseChangeVo.getCourseChngApplyNum());
		
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		courseChangeVo.setSaveToken(saveToken);
		model.addAttribute("courseChangeVo", courseChangeVo);
		
		// 학생 부가 정보
		model.addAttribute("memInfo", mainService.memInfoSelect(memberVo.getMemId()));
		model.addAttribute("stdAcadInfo", mainService.StdAcadInfo(memberVo.getMemId()));
		
		// 성적 정보
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> scoreMap = graduateService.gradEvaluationDetail(memberVo.getMemId());
		model.addAttribute("scoreList", scoreMap.get("scoreList"));
		model.addAttribute("jsonScoreList", mapper.writeValueAsString(scoreMap.get("scoreList")));
		model.addAttribute("volTime", scoreMap.get("volTime"));
		
		// 공통 코드 course_chng_code
		List<CodeVO> codeList = codeService.codeList("COU_CHN");
		model.addAttribute("codeList", codeList);
		
		// 전과/복수전공/부전공 뷰 다르게 보여주기
		String view = "";
		if("01".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyUpdate01";
		}else if("02".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyUpdate02";
		}else if("03".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyUpdate03";
		}
		return view;
	}
	
	
	
	/**
	 * 이수 변경 신청 수정 폼 제출하기
	 * @param courseChangeVo : pageNo와 수정된 신청 정보가 들어있음
	 * @param session
	 * @return forward로 courseChangeApplyList를 실행
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyUpdate")
	public String courseChangeApplyUpdate(@ModelAttribute CourseChangeVO courseChangeVo
													, HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, courseChangeVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/courseChange/courseChangeApplyList";
		}
		
		//수정 폼 제출
		int result = courseChangeService.courseChangeApplyUpdate(courseChangeVo);
		if(result > 0) System.out.println("수정 성공 : " + courseChangeVo);
		
		return "forward:/student/courseChange/courseChangeApplyList";
	}

	
	
	/**
	 * 이수 변경 신청 삭제하기 (취소)
	 * @param courseChangeVo : pageNo와 courseChngApplyNum이 들어있음
	 * @return forward로 courseChangeApplyList를 실행
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyDelete")
	public String courseChangeApplyDelete(@ModelAttribute CourseChangeVO courseChangeVo) {
		
		// 삭제 
		int result = courseChangeService.courseChangeApplyDelete(courseChangeVo);
		if(result > 0) System.out.println("삭제 성공 : " + courseChangeVo);
		return "forward:/student/courseChange/courseChangeApplyList";
	}
	
	
	/**
	 * 이수 변경 신청 포기 폼 보여주기
	 * @param courseChangeVo : pageNo, courseChngApplyNum이 들어있음
	 * @param session
	 * @param model
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyGiveUpView")
	public String courseChangeApplyGiveUpView(@ModelAttribute CourseChangeVO courseChangeVo
														, HttpSession session
														, Model model) throws JsonProcessingException {
		// 학생 기본 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = courseChangeService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		
		// 신청 정보 보내기 (덮어 씌워서 보내기)
		courseChangeVo = courseChangeService.courseChangeApplyDetail(courseChangeVo.getCourseChngApplyNum());
		
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		courseChangeVo.setSaveToken(saveToken);
		model.addAttribute("courseChangeVo", courseChangeVo);
		
		// 학생 부가 정보
		model.addAttribute("memInfo", mainService.memInfoSelect(memberVo.getMemId()));
		model.addAttribute("stdAcadInfo", mainService.StdAcadInfo(memberVo.getMemId()));
		
		// 성적 정보
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> scoreMap = graduateService.gradEvaluationDetail(memberVo.getMemId());
		model.addAttribute("scoreList", scoreMap.get("scoreList"));
		model.addAttribute("jsonScoreList", mapper.writeValueAsString(scoreMap.get("scoreList")));
		model.addAttribute("volTime", scoreMap.get("volTime"));
		
		// 전과/복수전공/부전공 뷰 다르게 보여주기
		String view = "";
		if("01".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyGiveUp01";
		}else if("02".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyGiveUp02";
		}else if("03".equals(courseChangeVo.getCourseChngCode())) {
			view = "/student/courseChange/courseChangeApplyGiveUp03";
		}
		return view;
	}
	
	
	
	/**
	 * 이수 변경 신청 포기 폼 제출하기
	 * @param courseChangeVo : pageNo와 수정된 신청 정보가 들어있음
	 * @param session
	 * @return forward로 courseChangeApplyList를 실행
	 */
	@RequestMapping("/student/courseChange/courseChangeApplyGiveUp")
	public String courseChangeApplyGiveUp(@ModelAttribute CourseChangeVO courseChangeVo
													, HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, courseChangeVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/courseChange/courseChangeApplyList";
		}
		
		//수정 폼 제출
		int result = courseChangeService.courseChangeApplyUpdate(courseChangeVo);
		if(result > 0) System.out.println("수정 성공 : " + courseChangeVo);
		
		return "forward:/student/courseChange/courseChangeApplyList";
	}
	
}
