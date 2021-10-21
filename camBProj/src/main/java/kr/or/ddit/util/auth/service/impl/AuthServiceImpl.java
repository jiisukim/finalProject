package kr.or.ddit.util.auth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.professor.lecture.service.LectureService;
import kr.or.ddit.professor.lecture.vo.SyllabusVO;
import kr.or.ddit.student.courseChange.vo.CourseChangeVO;
import kr.or.ddit.student.courseChange.vo.CourseRecodeVO;
import kr.or.ddit.student.expulsion.vo.ExpulsionVO;
import kr.or.ddit.student.readmission.vo.ReadmissionVO;
import kr.or.ddit.student.returnBack.vo.ReturnVO;
import kr.or.ddit.student.takeOff.service.TakeOffService;
import kr.or.ddit.util.auth.mapper.AuthMapper;
import kr.or.ddit.util.auth.service.AuthService;
import kr.or.ddit.util.auth.vo.AuthDetailInfoVO;
import kr.or.ddit.util.auth.vo.AuthDocFormVO;
import kr.or.ddit.util.auth.vo.AuthDocVO;
import kr.or.ddit.util.auth.vo.AuthLineStepVO;
import kr.or.ddit.util.auth.vo.AuthLineVO;
import kr.or.ddit.util.auth.vo.AuthStepVO;
import kr.or.ddit.util.auth.vo.LectureOpenVO;
import kr.or.ddit.util.auth.vo.StudentVO;
import kr.or.ddit.util.auth.vo.TakeOffAndStudentVO;
import kr.or.ddit.util.auth.vo.VolunteerVO;
import kr.or.ddit.util.file.service.FileService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	AuthMapper authMapper;
	@Autowired
	TakeOffService takeOffService;
	@Autowired
	FileService fileService;
	@Autowired
	LectureService lectureService; // 강의 계획서 처리
	
	/*************************************************************************************************************************************************
	 * 결재 설정
	 */
	// 결재 기안 담당자 CRUD
	// 결재 선 담당자 CRUD 
	
	/*************************************************************************************************************************************************
	 *  AuthLine 결재 라인 
	 *  
	 *  09/24
	 *  - 결재 선 선택할 때 담당 직원이 '210302001'로 하드코딩되어있음
	 *  - 결재 선을 생성할 수 있는 직원이 정해지지 않음 (모든 회원이 생성할 수 있는 상태)
	 */
	
	// 결재 선 리스트 가져오기 
	@Override
	public List<AuthLineStepVO> authLineList(AuthLineStepVO authLineStepVo) {
		
		List<AuthLineStepVO> authLineList = authMapper.authLineList(authLineStepVo);
		
		return authLineList;
	}
	
	// 결재 선 리스트 수 가져오기
	@Override
	public int authLineTotalCount(AuthLineStepVO authLineStepVo) {
		return authMapper.authLineTotalCount(authLineStepVo);
	}
	
	// 결재 선에 들어갈 결재 스텝 리스트 검색하기
	@Override
	public List<AuthStepVO> authStepSearch(AuthStepVO authStepVo){
		return authMapper.authStepSearch(authStepVo);
	};
	
	
	// 결재 선에 들어갈 결재 스텝 리스트 수 가져오기
	@Override
	public int authStepCount(AuthStepVO authStepVo) {
		return authMapper.authStepCount(authStepVo);
	}
	
	// 결재 선에 들어갈 결재 스텝 저장하기
	@Override
	public int authLineStepInsert(AuthLineStepVO authLineStepVo) {
		
		AuthLineVO authLineVo = new AuthLineVO();
		authLineVo.setAuthLineName(authLineStepVo.getAuthLineName()); // 결재 선 이름
		authLineVo.setAuthLineTypeCode(authLineStepVo.getAuthLineTypeCode()); // 결재 선 업무 유형
		authLineVo.setCreator(authLineStepVo.getCreator()); // 결재 선 생성자
		authMapper.authLineInsert(authLineVo);
		String authLineNum = authLineVo.getAuthLineNum();
		
		String memIdListStr = authLineStepVo.getMemIdList(); // 결재 선 스텝(멤버) 리스트 문자열
		String[] memIdList = memIdListStr.split("-");
		
		for(int i=0; i<memIdList.length; i++) {
			AuthStepVO authStepVo = new AuthStepVO();
			authStepVo.setAuthLineNum(authLineNum);
			authStepVo.setMemId(memIdList[i]);
			authStepVo.setSequence(i+1);
			
			int result = authMapper.authStepInsert(authStepVo);
			if(result <= 0) return 0; // 실패 시 0을 리턴  
		}
		return 1;
	}
	
	// 학사 처리용 결재 선에 들어갈 지도 교수 아이디 가져오기 
	@Override
	public String seachAdvProf(String stdId) {
		return authMapper.seachAdvProf(stdId);
	}
	
	/* 기안 작성 시 사용 (아직 DB에 들어가진 않고 화면에 보여주기 용)
	 * 결재 선 선택할 때 학사 처리용 결재 선(학생 별 지도교수) 선택 시, 학생의 지도교수가 들어있는 결재 선 생성	
	 */  
	@Override
	public AuthLineStepVO getAdvProfAuthLineVo(String advProf) {
		AuthLineStepVO authLineStepVo = new AuthLineStepVO(); 
		authLineStepVo.setAuthLineNum(advProf); // 결재선 번호는 지도교수의 사번으로 넣는다
		authLineStepVo.setAuthLineName("학생 별 지도교수 결재 선");
		authLineStepVo.setAuthLineTypeCode("학사");
		authLineStepVo.setMemId(advProf+"-"+"210302001");
		return authLineStepVo;
	}
	
	/*
	 * 기안을 작성 후 DB에 반영할 때 지도교수 결재 선을 DB에 생성한다.
	 * (09/16 담당 직원이 하드코딩 되어 있음) 
	 * (09/16 같은 지도 교수 결재선이 있어도 새로 생성함)
	 */ 
	@Override
	public AuthLineStepVO insertAdvProfAuthLineVo(String advProf) {
		// 결재 선 insert
		AuthLineVO advProfLineVo = new AuthLineVO();
		advProfLineVo.setAuthLineName("학생 별 지도교수 결재 선");
		advProfLineVo.setCreator("SYSTEM");
		authMapper.authLineInsert(advProfLineVo);
		String authLineNum = advProfLineVo.getAuthLineNum();
		
		// 결재 스텝 insert
		AuthStepVO authStepVo = new AuthStepVO(); // 1. 지도교수
		authStepVo.setAuthLineNum(authLineNum);
		authStepVo.setMemId(advProf);
		authStepVo.setSequence(1);
		authMapper.authStepInsert(authStepVo);

		authStepVo.setMemId("210302001"); // 2. 담당 직원 (하드 코딩 되어 있음)
		authStepVo.setSequence(2);
		authMapper.authStepInsert(authStepVo);
		
		AuthLineStepVO authLineStepVo = new AuthLineStepVO();
		authLineStepVo.setAuthLineNum(authLineNum);
		authLineStepVo.setAuthLineName(advProfLineVo.getAuthLineName());
		authLineStepVo.setAuthLineTypeCode("학사");
		authLineStepVo.setMemId(advProf+"-"+"210302001");
		
		return authLineStepVo;
	}
	
	// 결재 선 정보 가져오기 
	@Override
	public AuthLineStepVO authLineDetail(String authLineNum) {
		AuthLineStepVO authLineStepVo = new AuthLineStepVO();
		authLineStepVo.setSearchCondition("authLineNum");
		authLineStepVo.setSearchKeyword(authLineNum);
		List<AuthLineStepVO> authLineStepVoList = authMapper.authLineList(authLineStepVo);
		authLineStepVoList.get(0);
		return authLineStepVoList.get(0); 
	}
	
	// 결재 스텝 정보 가져오기
	@Override
	public List<AuthStepVO> authStepList(String authLineNum) {
		List<AuthStepVO> authStepVolist = authMapper.authStepList(authLineNum);
		return authStepVolist;
	}
	
	// 결재 선 수정
	@Override
	public int authLineUpdate(AuthLineStepVO authLineStepVo) {
		String authLineNum = authLineStepVo.getAuthLineNum();
		// 결재 스텝 삭제
		authMapper.authStepDelete(authLineNum);
		
		// 결재 스텝 입력
		AuthLineVO authLineVo = new AuthLineVO();
		authLineVo.setAuthLineName(authLineStepVo.getAuthLineName()); // 결재 선 이름
		authLineVo.setAuthLineTypeCode(authLineStepVo.getAuthLineTypeCode()); // 결재 선 업무 유형
		// 결재 선 수정
		int result = authMapper.authLineUpdate(authLineStepVo);
//		authLineVo.setCreator(authLineStepVo.getCreator()); // 결재 선 생성자
//		authMapper.authLineInsert(authLineVo);
		
		String memIdListStr = authLineStepVo.getMemIdList(); // 결재 선 스텝(멤버) 리스트 문자열
		String[] memIdList = memIdListStr.split("-");
		
		for(int i=0; i<memIdList.length; i++) {
			AuthStepVO authStepVo = new AuthStepVO();
			authStepVo.setAuthLineNum(authLineNum);
			authStepVo.setMemId(memIdList[i]);
			authStepVo.setSequence(i+1);
			
			result = authMapper.authStepInsert(authStepVo);
			if(result <= 0) return 0; // 실패 시 0을 리턴  
		}
		
		return result;
	}
	
	
	// 결재 선 삭제
	public int authLineDelete(String authLineNum) {
		// 결재 스텝 삭제
		authMapper.authStepDelete(authLineNum);
		// 결재 선 삭제
		return authMapper.authLineDelete(authLineNum);
	}
	
	// 결재 스텝 삭제 (수정하고 싶다면 삭제 후 새로 만들기)
	public int authStepDelete(String authLineNum) {
		return authMapper.authStepDelete(authLineNum);
	}
	
	/*************************************************************************************************************************************************
	 *  AuthDocForm 결재 문서 양식  
	 */

	// 결재 문서 유형에 따라 양식 가져오기
	@Override
	public AuthDocFormVO authDocFormDetail(String authDocFormNum) {
		return authMapper.authDocFormDetail(authDocFormNum);
	}
	
	
	/*************************************************************************************************************************************************
	 *  AuthDoc 결재 문서
	 */
	
	// 각 신청의 Controller에서 사용 - 결재 문서 생성 
	@Override
	public String authDocInsert(String authDocFormNum) {
		
		AuthDocVO authDocVo = new AuthDocVO();
		
		// authDocFormNum에 따라 담당자가 다름 
		// memId(기안자)에 다른 값이 들어감
		AuthDocFormVO authDocFormVo = authMapper.authDocFormDetail(authDocFormNum);
		String memId = authDocFormVo.getMemId();
		authDocVo.setMemId(memId);
		authDocVo.setAuthDocFormNum(authDocFormNum);
		
		// insert 작업 후
		authMapper.authDocInsert(authDocVo);
		
		// authDocNum 반환
		return authDocVo.getAuthDocNum();
	}

	// 기안자 : 결재 기안 리스트 가져오기
	@Override
	public List<AuthDocVO> authDocList(AuthDocVO authDocVo) {
		return authMapper.authDocList(authDocVo);
	}
	
	// 기안자 : 결재 기안 리스트 수 가져오기
	@Override
	public int authDocTotalCount(AuthDocVO authDocVo) {
		return authMapper.authDocTotalCount(authDocVo);
	}

	// 기안자 : 결재 기안 상세 정보 가져오기
	@Override
	public AuthDocVO authDocDetail(String authDocNum) {
		return authMapper.authDocDetail(authDocNum);
	}

	// 기안자 : 결재 문서 승인한 후, 결재 스텝 별 결재 상세 정보를 등록
	@Override
	public int authDocUpdateAndAuthDetailInfoInsert(AuthDocVO authDocVo) {
		
		String authDocNum = authDocVo.getAuthDocNum();
		String authLineNum = authDocVo.getAuthLineNum();
		
		// 1. 결재선 사번 형식이라면 학사 관련 결재선이라고 판단하고 insert 
		// (회원 아이디는 2번째 인덱스가 0이다.)
		if(authLineNum.charAt(2)=='0') {
			AuthLineStepVO authLineStepVo = insertAdvProfAuthLineVo(authLineNum);
			authLineNum = authLineStepVo.getAuthLineNum();
			authDocVo.setAuthLineNum(authLineNum); // 실제 결재선 번호로 바꿔준다.
		}
		
		// 2. 결재 문서를 승인
		int result = authMapper.authDocUpdate(authDocVo);
		
		if(result <= 0) {
			return 0;
		}
		
		// 3. 결재 스텝 별 결재 상세 정보를 등록
		List<AuthDetailInfoVO> authDetailInfoVoList = new ArrayList<>();
		List<AuthStepVO> stepList = authMapper.authStepList(authLineNum);
		for(AuthStepVO authStepVo: stepList) {
			AuthDetailInfoVO authDetailInfoVo = new AuthDetailInfoVO();
			authDetailInfoVo.setAuthDocNum(authDocNum);
			authDetailInfoVo.setAuthLineNum(authLineNum);
			authDetailInfoVo.setMemId(authStepVo.getMemId());
			authDetailInfoVo.setProcStatCode("01");
			authDetailInfoVoList.add(authDetailInfoVo);
		}
		result = authMapper.authDetailInfoInsert(authDetailInfoVoList);
		
		if(result <= 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	// 기안자 : 결재 스텝 별로 결재 상세 정보 입력하기
	@Override
	public int authDetailInfoInsert(List<AuthDetailInfoVO> authDetailInfoVoList) {
		return authMapper.authDetailInfoInsert(authDetailInfoVoList);
	}
	
	// 결재 기안 문서 삭제  
	public int authDocDelete(String authDocNum) {
		return authMapper.authDocDelete(authDocNum);
	}
	
	/*
	 **************************************************************************/
	
	// 결재자 : 결재 리스트 가져오기
	@Override
	public List<AuthDocVO> authDocListForSteps(AuthDocVO authDocVo) {
		return authMapper.authDocListForSteps(authDocVo);
	}

	// 결재자 : 결재 리스트 수 가져오기
	@Override
	public int authDocTotalCountForSteps(AuthDocVO authDocVo) {
		return authMapper.authDocTotalCountForSteps(authDocVo);
	}
	
	// 결재자 : 결재 상세 정보 가져오기
	@Override
	public AuthDocVO authDocDetailForSteps(AuthDocVO authDocVo) {
		return authMapper.authDocDetailForSteps(authDocVo);
	}

	// 결재자 : 승인/미승인 처리를 결재 상세 정보에 반영
	@Override
	public int authDocUpdateForSteps(AuthDetailInfoVO authDetailInfoVo) {
		return authMapper.authDocUpdateForSteps(authDetailInfoVo);
	}
	
	// 결재 기안에 '결재 완료' 처리하기
	@Override
	public int authDocComplete(String authDocNum) {
		return authMapper.authDocComplete(authDocNum);
	}
	
	/*
	 **************************************************************************/
	
	/*
	 * 각 신청 별로 조건에 따라 결재 완료 처리
	 * 마지막 순번이 승인한 경우 
	 * (공통) 처리 상태(승인 02, 미승인03), 미승인 사유 업데이트
	 * AUTH_DOC_FORM_NUM에 따라... 
	 * 1. 휴학 : 학사 상태 휴학(02)으로 업데이트
	 * 2. 복학: 학사 상태  재학(01)으로 업데이트
	 * 3. 복적재입학 : 학사 상태 재학(01)으로 업데이트
	 * 4. 퇴학 : 학사 상태 퇴학06으로 업데이트
	 * 5. 이수변경 
	 *   1) 전과 : 이수테이블 (CT1) 수정 및 추가, 학생 테이블 UNIV_DEPT_NUM 수정
	 *   2) 복수전공 : 이수테이블 (CT2) 추가
	 *   3) 부전공 : 이수테이블 (CT3) 추가
	 * 6. 봉사 
	 * 7. 강의 개설 : 개설 여부 Y,N 수정
	 */
	@Override
	public void authDocCompleteByApplyTypes(AuthDetailInfoVO authDetailInfoVo) {
		
		// 결재 문서 번호
		String authDocNum = authDetailInfoVo.getAuthDocNum();
		// 신청 유형
		String applyType = authDocDetail(authDocNum).getAuthDocFormNum();
		
		// 미승인을 한 경우 - 결재 완료
		String disauthRsn = authDetailInfoVo.getDisauthRsn();
		if("03".equals(authDetailInfoVo.getProcStatCode())) {
			authDocCompleteByApplyTypesDisauth(authDocNum, applyType, disauthRsn);	// 각 신청 별 미승인 결과 업데이트
			authDocComplete(authDocNum);  // 결재 문서 - 결재 완료 업데이트
			return;
		}
		
		// 결재선의 마지막 순번이 아닌 사람이 승인한 경우 - 결재 미완료 
		int maxSeq = authDetailInfoMaxSeq(authDocNum);
		if(authDetailInfoVo.getSequence() != maxSeq) {
			return;
		}
		
		// 결재선의 마지막 순번이 승인한 경우 - 결재 완료
		authDocComplete(authDetailInfoVo.getAuthDocNum()); 		// 결재 문서 - 결재 완료 업데이트
		authDocCompleteByApplyTypesAuth(authDocNum, applyType);	// 각 신청 별 미승인 결과 업데이트
	}
	
	// 승인 처리
	public void authDocCompleteByApplyTypesAuth(String authDocNum, String applyType) {
		String authCode = "02";
		StudentVO studentVo = new StudentVO();
		if("휴학".equals(applyType)) {						
			TakeOffAndStudentVO takeOffAndStudentVo = authMapper.takeOffDetail(authDocNum);
			
			// 휴학 신청 테이블 처리 상태 02로 수정
			takeOffAndStudentVo.setProcStatCode(authCode);  
			authMapper.takeOffUpdate(takeOffAndStudentVo);
			 
			// 학생 테이블 학사 상태 02로 수정
			studentVo.setAcadStatCode("02");
			studentVo.setStdId(takeOffAndStudentVo.getStdId());
			authMapper.studentUpdate(studentVo);
			
		}else if("복학".equals(applyType)){
			// 복학 신청 테이블 처리 상태 02로 수정
			ReturnVO returnVo = authMapper.returnDetail(authDocNum);
			returnVo.setProcStatCode(authCode);
			authMapper.returnUpdate(returnVo);
			
			// 학생 테이블  학사 상태  재학(01)으로 업데이트
			studentVo.setAcadStatCode("01");
			studentVo.setStdId(returnVo.getStdId());
			authMapper.studentUpdate(studentVo);
			
		}else if("복적 재입학".equals(applyType)){
			// 복적 신청 테이블 처리 상태 02로 수정
			ReadmissionVO readmissionVo = authMapper.readmissionDetail(authDocNum);
			readmissionVo.setProcStatCode(authCode);
			authMapper.readmissionUpdate(readmissionVo);
			
			// 학생 테이블 학사 상태 재학(01)으로 업데이트
			studentVo.setAcadStatCode("01");
			studentVo.setStdId(readmissionVo.getStdId());
			authMapper.studentUpdate(studentVo);
			
		}else if("퇴학".equals(applyType)){
			// 퇴학 신청 테이블 처리 상태 02로 수정
			ExpulsionVO expulsionVo = authMapper.expulsionDetail(authDocNum);
			expulsionVo.setProcStatCode(authCode);
			authMapper.expulsionUpdate(expulsionVo);
			
			// 학사 상태 퇴학(06)으로 업데이트
			studentVo.setAcadStatCode("06");
			studentVo.setStdId(expulsionVo.getStdId());
			authMapper.studentUpdate(studentVo);
			
		}else if("이수 변경".equals(applyType)){
			// 이수 변경 신청 테이블 처리 상태 02로 수정
			CourseChangeVO courseChangeVo = authMapper.courseChangeDetail(authDocNum);
			courseChangeVo.setProcStatCode(authCode);
			authMapper.courseChangeUpdate(courseChangeVo);
			
			// 이수 변경 유형 코드에 따라 다른 처리 (코드는 FN_GET_CODE_NAME 처리되어 있음)
			courseChangeUpdate(courseChangeVo);
			
		}else if("봉사".equals(applyType)){
			// 봉사 신청 테이블 처리 상태 02로 수정
			VolunteerVO volunteerVo = authMapper.volunteerDetail(authDocNum);
			volunteerVo.setProcStatCode(authCode);
			authMapper.volunteerUpdate(volunteerVo);
			
		}else if("강의 개설".equals(applyType)){
			// 강의 개설 신청 테이블 처리 상태 02로 수정
			// 개설 여부 Y 수정
			LectureOpenVO lectureOpenVo = authMapper.lectureDetail(authDocNum);
			lectureOpenVo.setProcStatCode(authCode);
			lectureOpenVo.setOpenYn("Y");
			authMapper.lectureUpdate(lectureOpenVo);
			
		}
	}
	
	// 이수 변경 유형 코드에 따라 다른 처리
	public void courseChangeUpdate(CourseChangeVO courseChangeVo) {
		String courseChngCode = courseChangeVo.getCourseChngCode();
		
		if("전과".equals(courseChngCode)) {
			//이수테이블 (CT1) 수정 및 추가 
			CourseRecodeVO courseRecodeVo = new CourseRecodeVO();
			courseRecodeVo.setStdId(courseChangeVo.getStdId());
			courseRecodeVo.setCourseTypeNum("CT1");
			authMapper.courseRecodeUpdate(courseRecodeVo); // stdId와 courseTypeNum로 찾아 aband_yn을 Y로 수정
			
			courseRecodeVo.setUnivDeptNum(courseChangeVo.getUnivDeptNum());
			authMapper.courseRecodeInsert(courseRecodeVo); // 새로운 주전공 추가
			
			//학생 테이블 UNIV_DEPT_NUM 수정
			StudentVO studentVo = new StudentVO();
			studentVo.setUnivDeptNum(courseChangeVo.getUnivDeptNum());
			studentVo.setStdId(courseChangeVo.getStdId());
			authMapper.studentUpdate(studentVo);
			
		}else if("복수 전공".equals(courseChngCode)) {
			//이수테이블 (CT2) 추가
			CourseRecodeVO courseRecodeVo = new CourseRecodeVO();
			courseRecodeVo.setStdId(courseChangeVo.getStdId());
			courseRecodeVo.setCourseTypeNum("CT2");
			courseRecodeVo.setUnivDeptNum(courseChangeVo.getUnivDeptNum());
			authMapper.courseRecodeInsert(courseRecodeVo);
			
		}else if("부 전공".equals(courseChngCode)) {
			//이수테이블 (CT3) 추가
			CourseRecodeVO courseRecodeVo = new CourseRecodeVO();
			courseRecodeVo.setStdId(courseChangeVo.getStdId());
			courseRecodeVo.setCourseTypeNum("CT3");
			courseRecodeVo.setUnivDeptNum(courseChangeVo.getUnivDeptNum());
			authMapper.courseRecodeInsert(courseRecodeVo);
		}
		
	}
	
	// 미승인 처리
	public void authDocCompleteByApplyTypesDisauth(String authDocNum, String applyType, String disauthRsn) {
		String disauthCode = "03";
		if("휴학".equals(applyType)) {
			TakeOffAndStudentVO takeOffAndStudentVo = authMapper.takeOffDetail(authDocNum);

			// 휴학 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			takeOffAndStudentVo.setProcStatCode(disauthCode);  
			takeOffAndStudentVo.setDisauthRsn(disauthRsn);
			authMapper.takeOffUpdate(takeOffAndStudentVo);
			
		}else if("복학".equals(applyType)){
			
			// 복학 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			ReturnVO returnVo = authMapper.returnDetail(authDocNum);
			returnVo.setProcStatCode(disauthCode);
			returnVo.setDisauthRsn(disauthRsn);
			authMapper.returnUpdate(returnVo);
			
		}else if("복적 재입학".equals(applyType)){
			
			// 복적 재입학 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			ReadmissionVO readmissionVo = authMapper.readmissionDetail(authDocNum);
			readmissionVo.setProcStatCode(disauthCode);
			readmissionVo.setDisauthRsn(disauthRsn);
			authMapper.readmissionUpdate(readmissionVo);
			
		}else if("퇴학".equals(applyType)){
			
			// 퇴학 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			ExpulsionVO expulsionVo = authMapper.expulsionDetail(authDocNum);
			expulsionVo.setProcStatCode(disauthCode);
			expulsionVo.setDisauthRsn(disauthRsn);
			authMapper.expulsionUpdate(expulsionVo);
			
		}else if("이수 변경".equals(applyType)){
			
			// 이수 변경 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			CourseChangeVO courseChangeVo = authMapper.courseChangeDetail(authDocNum);
			courseChangeVo.setProcStatCode(disauthCode);
			courseChangeVo.setDisauthRsn(disauthRsn);
			authMapper.courseChangeUpdate(courseChangeVo);
			
		}else if("봉사".equals(applyType)){
			
			// 봉사 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			VolunteerVO volunteerVo = authMapper.volunteerDetail(authDocNum);
			volunteerVo.setProcStatCode(disauthCode);
			volunteerVo.setDisauthRsn(disauthRsn);
			authMapper.volunteerUpdate(volunteerVo);
			
		}else if("강의 개설".equals(applyType)){
			
			// 강의 개설 신청 테이블 처리 상태 03, 미승인 사유 업데이트
			kr.or.ddit.util.auth.vo.LectureOpenVO lectureOpenVo = authMapper.lectureDetail(authDocNum);
			lectureOpenVo.setProcStatCode(disauthCode);
			lectureOpenVo.setOpenYn("N");
			lectureOpenVo.setDisauthRsn(disauthRsn); // 오타 고쳐야 함 
			authMapper.lectureUpdate(lectureOpenVo);
		}
	}
	
	// 결재 상세 정보 리스트를 결재 스텝 순서대로 가져오기 
	@Override
	public List<AuthDetailInfoVO> authDetailInfoList(String authDocNum) {
		return authMapper.authDetailInfoList(authDocNum);
	}
	
	// 특정 결재 스텝의 결재 상세 정보 가져오기
	@Override
	public AuthDetailInfoVO authDetailInfoDetail(AuthDetailInfoVO authDetailInfoVo) {
		return authMapper.authDetailInfoDetail(authDetailInfoVo);
	}
	
	// 특정 결재 문서의 마지막 결재 순번 가져오기
	// authDocCompleteByApplyTypes메서드에서 마지막 결재자의 승인인지 확인하기 위해 사용
	@Override
	public int authDetailInfoMaxSeq(String authDocNum) {
		return authMapper.authDetailInfoMaxSeq(authDocNum);
	}
	
	
	/**
	 * 결재 기안 / 결재 문서 count 정보
	 * authDocInfoCount : 결재 기안 key
	 * authDocInfoCountForStep : 결재 문서 key
	 */
	@Override
	public Map<String, Object> authDocInfoCount(String memId) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("authDocInfoCount", authMapper.authDocInfoCount(memId));
		map.put("authDocInfoCountForStep", authMapper.authDocInfoCountForStep(memId));
		
		return map;
	}
	
	/*************************************************************************************************************************************************
	 * AuthDoc 결재 문서에 필요한 신청 정보 가져오기
	 */
	@Override
	public Map<String, Object> getApplyDetail(AuthDocVO authDocVo) {
		String authDocNum = authDocVo.getAuthDocNum();
		
		Map<String, Object> map = new HashMap<>();
		
		if("휴학".equals(authDocVo.getAuthDocFormNum())) {
			TakeOffAndStudentVO applyVo = authMapper.takeOffDetail(authDocNum);
			applyVo = setEndYearSem(applyVo);
			if(applyVo.getFileGrNum()!=null) { // 붙임 파일 처리
				map.put("fileList", fileService.fileList(applyVo.getFileGrNum()));
			}
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getStdId()));
		}else if("복학".equals(authDocVo.getAuthDocFormNum())) {
			ReturnVO applyVo = authMapper.returnDetail(authDocNum);
			if(applyVo.getFileGrNum()!=null) { // 붙임 파일 처리
				map.put("fileList", fileService.fileList(applyVo.getFileGrNum()));
			}
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getStdId()));
		}else if("복적 재입학".equals(authDocVo.getAuthDocFormNum())) {
			ReadmissionVO applyVo = authMapper.readmissionDetail(authDocNum);
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getStdId()));
		}else if("퇴학".equals(authDocVo.getAuthDocFormNum())) {
			ExpulsionVO applyVo = authMapper.expulsionDetail(authDocNum);
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getStdId()));
		}else if("이수 변경".equals(authDocVo.getAuthDocFormNum())) {
			CourseChangeVO applyVo = authMapper.courseChangeDetail(authDocNum);
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getStdId()));
		}else if("봉사".equals(authDocVo.getAuthDocFormNum())) {
			VolunteerVO applyVo = authMapper.volunteerDetail(authDocNum);
			if(applyVo.getFileGrNum()!=null) { // 붙임 파일 처리
				map.put("fileList", fileService.fileList(applyVo.getFileGrNum()));
			}
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getStdId()));
		}else if("강의 개설".equals(authDocVo.getAuthDocFormNum())) {
			LectureOpenVO applyVo = authMapper.lectureDetail(authDocNum);
			map.put("applyVo", applyVo);
			map.put("memberVo", authMapper.getStdInfo(applyVo.getProfId()));
			
			// 강의 계획서
			SyllabusVO syllabusVo =lectureService.detailSyllabus(applyVo.getLectOpenNum());
			map.put("syllabusvo", syllabusVo);
		}
		
		return map;
	}
	
	// 휴학 신청 정보에 endYearSem 정보 입력
	public TakeOffAndStudentVO setEndYearSem(TakeOffAndStudentVO takeOffAndStudentVo) {
		int year = Integer.parseInt(takeOffAndStudentVo.getYear());
		String sem = takeOffAndStudentVo.getSemCode();
		int semCnt = takeOffAndStudentVo.getSemCnt();
		String endYearSem = takeOffService.getEndYearSem(year, sem, semCnt);
		takeOffAndStudentVo.setEndYearSem(endYearSem);
		return takeOffAndStudentVo;
	}
	
}
