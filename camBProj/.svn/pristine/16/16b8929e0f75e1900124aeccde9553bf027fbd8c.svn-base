package kr.or.ddit.common.main.service.impl;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.common.main.vo.JobCountVO;
import kr.or.ddit.common.main.vo.MemberInfoVO;
import kr.or.ddit.common.main.vo.NoticeVO;
import kr.or.ddit.common.main.vo.StdAcadInfoVO;

public interface MainService {

	/**
	 * 최근 등록 학기 가져오기 
	 * @param stdId
	 * @return Map의 키 - year : 년도(2021), sem : 학기(1) 
	 * @throws Exception 
	 */
	Map<String, String> getYearAndSem(String stdId) throws Exception;

	/**
	 * 최근 학기 시간표 json 문자열을 가져오기
	 * @param stdId
	 * @return 최근 학기 시간표 json 문자열
	 * @throws Exception
	 */
	String lectureTimetableSelect(String stdId) throws Exception;

	/**
	 * 공지사항 리스트, 페이징 처리 객체 가져오기
	 * @return Map의 키 - noticeList : List<NoticeVO>공지사항 리스트, paginationInfo : 페이징처리 객체
	 */
	Map<String, Object> noticeList(NoticeVO noticeVo) throws Exception;

	/**
	 * 회원 공통 : 상단에 띄워줄 회원정보 가져오기 
	 */
	MemberInfoVO memInfoSelect(String memId);

	/**
	 * 학생 이수 학점 정보 가져오기
	 */
	StdAcadInfoVO StdAcadInfo(String stdId);
	
	/**
	 * 학생 학사 정보 카운트 가져오기
	 */
	JobCountVO stdAcadInfoCount(String stdId) throws Exception;
	
	/**
	 * 교수 : 상담, 결재 건수 
	 */
	JobCountVO getJobInfo(MemberVO memberVo) throws Exception;

	/**
	 * 교수의 시간표 정보 가져오기 
	 * @throws JsonProcessingException 
	 */
	String profLectureTimetableSelect(String profId) throws JsonProcessingException;

}
