package kr.or.ddit.student.registrationLecture.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.admin.member.vo.StudentVO;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.professor.lecture.vo.LectureEvalItemVO;
import kr.or.ddit.student.registrationLecture.controller.RegistrationLectureController;
import kr.or.ddit.student.registrationLecture.mapper.RegistrationLectureMapper;
import kr.or.ddit.student.registrationLecture.service.RegistrationLectureService;
import kr.or.ddit.student.registrationLecture.vo.CartVO;
import kr.or.ddit.student.registrationLecture.vo.LectureOpenAndSyllabusVO;
import kr.or.ddit.student.registrationLecture.vo.LectureOpenVO;
import kr.or.ddit.student.registrationLecture.vo.LectureScoreVO;
import kr.or.ddit.student.registrationLecture.vo.LectureTimetableVO;
import kr.or.ddit.student.registrationLecture.vo.RegistrationLectureVO;
import kr.or.ddit.student.registrationLecture.vo.StdRegInfoVO;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;

@Service
public class RegistrationLectureServiceImpl implements RegistrationLectureService {
	
	@Autowired
	RegistrationLectureMapper registrationLectureMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLectureServiceImpl.class);
	
	/**
	 * 학생의 신청 가능한 학점 가져오기
	 * 학사 경고 : 이전 학기 성적 평점 평균이 1.7 미달이거나, 3개 과목 이상 또는 6학점 이상 F인 자는 3점 하향. 
	 */
	
	
	/**
	 * 현재 수강 신청한 강의 수, 학점 합계
	 */
	@Override
	public LectureOpenVO registrationLectureCountAndCredSum(LectureOpenVO lectureOpenVo) throws Exception {
		LOGGER.info("> " + lectureOpenVo.toString());
		// year, semCode을 현재 날짜에 기반해 계산
		if(lectureOpenVo.getYear() == null) {
			Map<String, String> yearSemCode = getYearSemCode();
			lectureOpenVo.setYear(yearSemCode.get("year"));
			lectureOpenVo.setSemCode(yearSemCode.get("semCode"));
		}
		return registrationLectureMapper.registrationLectureCountAndCredSum(lectureOpenVo);
	}
	
	/**
	 * 장바구니에 담긴 강의 목록을 가져온다.
	 * @param lectureOpenVo : stdId, year, semCode 
	 * @return Map<String, Object> listAndCount : List<LectureOpenAndSyllabusVO> 장바구니에 담긴 강의 목록 & int 강의 수
	 */
	@Override
	public Map<String, Object> cartLectOpenNumSelect(LectureOpenVO lectureOpenVo) throws Exception{
		// year, semCode을 현재 날짜에 기반해 계산
		if(lectureOpenVo.getYear() == null) {
			Map<String, String> yearSemCode = getYearSemCode();
			lectureOpenVo.setYear(yearSemCode.get("year"));
			lectureOpenVo.setSemCode(yearSemCode.get("semCode"));
		}
		// lectOpenNumList를 lectureOpenVo로 옮기기
		String[] lectOpenNumList = registrationLectureMapper.cartLectOpenNumSelect(lectureOpenVo);
		// lectOpenNumList의 길이가 0보다 길면 LectureOpenSelect 메서드 호출
		Map<String, Object> listAndCount = new HashMap<>();
		listAndCount.put("count", 0);
		listAndCount.put("list", "[]");
		listAndCount.put("jsonList", "[]");
		lectureOpenVo.setLectOpenNumList(lectOpenNumList);
		if(lectOpenNumList.length > 0) {
			listAndCount = lectureOpenSelect(lectureOpenVo);
		}
		return listAndCount;
	}
	
	/**
	 * 수강신청 완료한 강의 목록을 가져온다.
	 * 
	 * @param lectureOpenVo : stdId, year, semCode 
	 * @return Map<String, Object> listAndCount : List<LectureOpenAndSyllabusVO> 수강신청 완료한 강의 목록 & int 강의 수
	 */
	@Override
	public Map<String, Object> registrationLectureLectOpenNumSelect(LectureOpenVO lectureOpenVo) throws Exception{
		
		if(lectureOpenVo.getYear() == null) {
			// year, semCode 파라미터가 비어있다면, 현재 날짜에 기반해 해당 학기 계산
			Map<String, String> yearSemCode = getYearSemCode();
			lectureOpenVo.setYear(yearSemCode.get("year"));
			lectureOpenVo.setSemCode(yearSemCode.get("semCode"));
		}
		
		// lectOpenNumList를 lectureOpenVo로 옮기기
		String[] lectOpenNumList = registrationLectureMapper.registrationLectureLectOpenNumSelect(lectureOpenVo);
		for(String i : lectOpenNumList) {
			LOGGER.info(">>>>>>>>>>>>> lectOpenNumList : " + i);
		}
		
		// LectureOpenSelect 메서드 호출
		Map<String, Object> listAndCount = new HashMap<>();
		listAndCount.put("count", 0);
		listAndCount.put("list", "[]");
		listAndCount.put("jsonList", "[]");
		lectureOpenVo.setLectOpenNumList(lectOpenNumList);
		if(lectOpenNumList.length > 0) {
			listAndCount  = lectureOpenSelect(lectureOpenVo);
		}
		
		LOGGER.info(">>>>>>>>>>>>> listAndCount : " + listAndCount.get("jsonList").toString());
		return listAndCount;
	}
	
	/**
	 * 조건에 맞는 강의 목록과 강의의 수를 가져온다.
	 * (수강신청 가능 강의 / 장바구니에 담은 강의 / 수강 신청 완료 강의)
	 * @param lectureOpenVo : pageNo, year, semCode는 필수
	 * @return Map<String, Object> listAndCount : List<LectureOpenAndSyllabusVO> 조건에 맞는 강의 목록 & int 강의 수
	 */
	@Override
	public Map<String, Object> lectureOpenSelect(LectureOpenVO lectureOpenVo) throws Exception{
		// year, semCode을 현재 날짜에 기반해 계산
		if(lectureOpenVo.getYear() == null) {
			Map<String, String> yearSemCode = getYearSemCode();
			lectureOpenVo.setYear(yearSemCode.get("year"));
			lectureOpenVo.setSemCode(yearSemCode.get("semCode"));
		}
		
		// 페이징 처리
		PaginationInfo paginationInfo = getPaginationInfo(lectureOpenVo, 1);
		lectureOpenVo.setFirstIndex(paginationInfo.getFirstRecordIndex()+1);
		lectureOpenVo.setLastIndex(paginationInfo.getLastRecordIndex()); // 약식 장바구니, 신청 완료 페이지는 lectureOpenCount(lectureOpenVo)
		
		int totalCnt = registrationLectureMapper.lectureOpenCount(lectureOpenVo);
		
		// 약식 장바구니, 신청 완료 페이지는 페이징 처리 X -> lastRecodeIndex가 모든 항목 수
		if(lectureOpenVo.isNotPaging()) {
			lectureOpenVo.setLastIndex(totalCnt); 
		}
		
		Map<String, Object> listAndCount = new HashMap<>();
		
		List<LectureOpenAndSyllabusVO> list = registrationLectureMapper.lectureOpenSelect(lectureOpenVo);
		listAndCount.put("list", list);
		ObjectMapper mapper = new ObjectMapper(); // json 객체 보내기
		listAndCount.put("jsonList", mapper.writeValueAsString(list));
		listAndCount.put("count", totalCnt);
		
		return listAndCount;
	}
	
	/**
	 * 날짜를 기반으로 year, semcode 구하기
	 */
	@Override
	public Map<String, String> getYearSemCode() {
		Map<String, String> map = new HashMap<>();
		
		LocalDate now = LocalDate.now();
		map.put("year", String.valueOf(now.getYear()));
		
		int month = now.getMonthValue();
		// 정규 학기만 계산 - 1(3) ~ 6월 : 1학기 / 7(9) ~ 12월 : 2학기
		String semCode = month < 7 ? "1" : "2";
		map.put("semCode", semCode);
		
		return map;
	}
	
	/**
	 * pageNo가 저장된 lectureOpenVo로 페이징 처리 객체 가져오기
	 * flag : 1(강의), 2(장바구니), 3(신청 완료)
	 */
	@Override
	public PaginationInfo getPaginationInfo(LectureOpenVO lectureOpenVo, int flag) throws Exception{
		int recodeCount = 0;
		if(flag == 1) {
			recodeCount = registrationLectureMapper.lectureOpenCount(lectureOpenVo);
		}else if(flag == 2) {
			recodeCount = registrationLectureMapper.cartCount(lectureOpenVo);
		}else {
			recodeCount = registrationLectureMapper.registrationLectureCountAndCredSum(lectureOpenVo).getLectCount();
		}
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(lectureOpenVo.getPageNo());
		paginationInfo.setRecordCountPerPage(5);
		paginationInfo.setPageSize(5);
		paginationInfo.setTotalRecordCount(recodeCount);
		return paginationInfo;
	}
	
	
	/**
	 * 장바구니에 넣기
	 */
	@Override
	public void cartInsert(CartVO cartVo) throws Exception{
		// year, semCode을 현재 날짜에 기반해 계산
		Map<String, String> yearSemCode = getYearSemCode();
		cartVo.setYear(yearSemCode.get("year"));
		cartVo.setSemCode(yearSemCode.get("semCode"));
		
		registrationLectureMapper.cartInsert(cartVo);
	}
	
	/**
	 * 장바구니에서 삭제하기
	 */
	@Override
	public int cartDelete(CartVO cartVo) throws Exception{
		return registrationLectureMapper.cartDelete(cartVo);
	}
	
	/**
	 * 1. 수강 신청 완료 목록에 넣기
	 * 2. 해당 강의 신청 학생 수 입력
	 * 3. 장바구니 목록에서 빼기
	 * 4. 성적 테이블에 입력하기
	 */
	@Override
	public String registrationLectureInsert(LectureOpenVO lectureOpenVo, HttpSession session) throws Exception {
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		String stdId = memberVo.getMemId();
		StudentVO stdVo = registrationLectureMapper.stdSelect(stdId);
		
		RegistrationLectureVO registrationLectureVo = new RegistrationLectureVO();
		registrationLectureVo.setStdId(stdId);
		registrationLectureVo.setStdRgstSem(stdVo.getRgstSem());
		
		int rgstSem = Integer.parseInt(stdVo.getRgstSem());
		registrationLectureVo.setStdGrade(String.valueOf(getStdGrade(rgstSem)));
		registrationLectureVo.setLectOpenNum(lectureOpenVo.getLectOpenNum());
		registrationLectureVo.setLectUnivDeptNum(lectureOpenVo.getUnivDeptNum());
		registrationLectureVo.setLectGrdtnRequYn(lectureOpenVo.getGrdtnRequYn());
		
		// 자리가 있는지 확인
		int maxCnt = registrationLectureMapper.lectureOpenSelect(lectureOpenVo).get(0).getMaxStdCnt();
		int stdCnt = registrationLectureMapper.lectureOpenSelect(lectureOpenVo).get(0).getStdCnt();
		if(maxCnt <= stdCnt) {
			return "fail";
		}
		
		registrationLectureMapper.registrationLectureInsert(registrationLectureVo); // 1. 수강 신청 완료 목록에 넣기 
		
		registrationLectureMapper.stdCntUpdate(registrationLectureVo.getLectOpenNum()); // 2. 해당 강의 신청 학생 수 입력
		
		CartVO cartVo = new CartVO();
		cartVo.setStdId(stdId);
		cartVo.setLectOpenNum(registrationLectureVo.getLectOpenNum());
		registrationLectureMapper.cartDelete(cartVo); // 3. 장바구니에서 삭제
		
		registrationLectureMapper.lectureScoreInsert(registrationLectureVo);  // 4. 성적 테이블에 입력하기
		
		return "success";
	}

	/**
	 * 학생의 학년 구하기
	 */
	 public int getStdGrade(int rgstSem) {
		 int grade = 0;
		 if(rgstSem < 3) {
			 grade = 1;
		 }else if(rgstSem < 5) {
			 grade = 2;
		 }else if(rgstSem < 7) {
			 grade = 3;
		 }else {
			 grade = 4;
		 }
		 return grade;
	 }
	
	/**
	 * 1. 성적 테이블에서 삭제하기
	 * 2. 수강 신청 완료 목록에서 삭제하기
	 * 3. 해당 강의 신청 학생 수 입력
	 */
    @Override
	public void registrationLectureDelete(LectureOpenVO lectureOpenVo, HttpSession session) throws Exception {
		RegistrationLectureVO registrationLectureVo = new RegistrationLectureVO();
		
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		registrationLectureVo.setStdId(memberVo.getMemId());
		registrationLectureVo.setLectOpenNum(lectureOpenVo.getLectOpenNum());
		registrationLectureMapper.lectureScoreDelete(registrationLectureVo); // 1. 성적 테이블에서 삭제하기
		registrationLectureMapper.registrationLectureDelete(registrationLectureVo); // 2. 수강 신청 완료 목록에서 삭제하기
		registrationLectureMapper.stdCntUpdate(registrationLectureVo.getLectOpenNum()); // 3. 해당 강의 신청 학생 수 입력
		
	}
	
    
    /**
     * 시간표 가져오기
     * std_id, sem_code, year 정보 받아 
     * 1. registrationLectureLectOpenNumSelect로 강의 목록 가져오고, (없으면 빈 json을 반환) 
     * 2. 1을 파라미터로 넣어서 lectureTimetableSelect 실행
     * json 형태로 준다
     * @throws JsonProcessingException 
     */
    @Override
    public String lectureTimetableSelect(LectureOpenVO lectureOpenVo) throws JsonProcessingException {
    	
    	if(lectureOpenVo.getYear() == null) {
			// year, semCode 파라미터가 비어있다면, 현재 날짜에 기반해 해당 학기 계산
			Map<String, String> yearSemCode = getYearSemCode();
			lectureOpenVo.setYear(yearSemCode.get("year"));
			lectureOpenVo.setSemCode(yearSemCode.get("semCode"));
		}
    	
    	String[] lectOpenNumList = registrationLectureMapper.registrationLectureLectOpenNumSelect(lectureOpenVo);
    	lectureOpenVo.setLectOpenNumList(lectOpenNumList);
    	
    	if(lectOpenNumList.length  == 0) { // 강의가 없을 경우 빈 json 반환
    		return "[]";
    	}
    	
    	List<LectureTimetableVO> lectTimeTableList = registrationLectureMapper.lectureTimetableSelect(lectureOpenVo);
    	ObjectMapper mapper = new ObjectMapper(); // json 객체 보내기
    	
    	return mapper.writeValueAsString(lectTimeTableList);
    }
    
    
    /**
     * 학생이 등록한 학기 정보 
     */
    @Override
     public List<TuitionPaymentVO> registrationSemSelect(String stdId) throws Exception{
    	return registrationLectureMapper.registrationSemSelect(stdId);
     }
    
    /**
     * 학생의 성적과 성적 기준, 교수 정보 가져오기
     */
    @Override
    public List<LectureScoreVO> lectScoreSelect(LectureOpenVO lectureOpenVo) throws Exception{
    	return registrationLectureMapper.lectScoreSelect(lectureOpenVo);
    }
    
    /**
     * 강의 평가 항목 / 입력했던 답안 보내기
     */
	@Override
	public List<LectureEvalItemVO> lectEvalItemSelect(LectureOpenVO lectureOpenVo) throws Exception {
		return registrationLectureMapper.lectEvalItemSelect(lectureOpenVo);
	}
	
	/**
	 * 강의 평가 요약 (강의 번호, 평가 일자, 평가한 강의 수) 
	 * - count_answer : 평가한 강의 수로 사용했다
	 */
	@Override
	public List<LectureEvalItemVO> lectureEvalInfo(LectureOpenVO lectureOpenVo) throws Exception {
		
		if(lectureOpenVo.getYear() == null) {
			// year, semCode 파라미터가 비어있다면, 현재 날짜에 기반해 해당 학기 계산
			Map<String, String> yearSemCode = getYearSemCode();
			lectureOpenVo.setYear(yearSemCode.get("year"));
			lectureOpenVo.setSemCode(yearSemCode.get("semCode"));
		}
		
		List<LectureEvalItemVO> lectureEvalInfo= registrationLectureMapper.lectureEvalInfo(lectureOpenVo);
		
		if(lectureEvalInfo.size() <= 0) { // 공집합일 경우 평가한 강의가 0이라는 행을 하나 만들어서 보내준다.
			LectureEvalItemVO infoNullVo = new LectureEvalItemVO();
			infoNullVo.setCountAnswer("0");
			lectureEvalInfo.add(infoNullVo);
		}
		return lectureEvalInfo;
	}
	
	/**
	 * 강의 평가 입력하기
	 */
	@Override
	public void lectureEvalInsert(List<LectureEvalItemVO> lectureEvalItemList) throws Exception {
		for(LectureEvalItemVO lectureEvalItemVo : lectureEvalItemList) {
			registrationLectureMapper.lectureEvalInsert(lectureEvalItemVo);
		}
	}
}
