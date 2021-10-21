package kr.or.ddit.util.auth.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.admin.member.vo.ProfessorVO;
import kr.or.ddit.student.courseChange.vo.CourseChangeVO;
import kr.or.ddit.student.courseChange.vo.CourseRecodeVO;
import kr.or.ddit.student.expulsion.vo.ExpulsionVO;
import kr.or.ddit.student.readmission.vo.ReadmissionVO;
import kr.or.ddit.student.returnBack.vo.ReturnVO;
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

@Mapper("authMapper")
public interface AuthMapper {
	
	/**
	 *  AuthLine 결재 라인  
	 */
	List<AuthLineStepVO> authLineList(AuthLineStepVO authLineStepVo);
	
	int authLineTotalCount(AuthLineStepVO authLineStepVo);
	
	List<AuthStepVO> authStepSearch(AuthStepVO authStepVo);
	
	int authStepCount(AuthStepVO authStepVo);
	
	List<AuthStepVO> authStepList(String authLineNum);
	
	int authLineInsert(AuthLineVO authLineVo);
	
	int authStepInsert(AuthStepVO authStepVo);
	
	String seachAdvProf(String stdId); 
	
	int authLineUpdate(AuthLineStepVO authLineStepVo);
	
	int authLineDelete(String authLineNum);
	
	int authStepDelete(String authLineNum);
	
	/**
	 *  AuthDocForm 결재 문서 양식  
	 */
	AuthDocFormVO authDocFormDetail(String authDocFormNum);
	
	
	/**
	 *  AuthDoc 결재 문서
	 */
	int authDocInsert(AuthDocVO authDocVo);
	
	List<AuthDocVO> authDocList(AuthDocVO authDocVo);

	List<AuthDocVO> authDocListForSteps(AuthDocVO authDocVo);
	
	int authDocTotalCount(AuthDocVO authDocVo);
	
	int authDocTotalCountForSteps(AuthDocVO authDocVo);
	
	AuthDocVO authDocDetail(String authDocNum);

	AuthDocVO authDocDetailForSteps(AuthDocVO authDocVo);
	 
	int authDocUpdate(AuthDocVO authDocVo);
	
	int authDocComplete(String authDocNum);
	
	int authDetailInfoInsert(List<AuthDetailInfoVO> authDetailInfoVoList);
	
	int authDocUpdateForSteps(AuthDetailInfoVO authDetailInfoVo);
	
	List<AuthDetailInfoVO> authDetailInfoList(String authDocNum);

	AuthDetailInfoVO authDetailInfoDetail(AuthDetailInfoVO authDetailInfoVo);
	
	int authDetailInfoMaxSeq(String authDocNum);
	
	int authDocDelete(String authDocNum);
	
	AuthDocVO authDocInfoCount(String memId);

	AuthDocVO authDocInfoCountForStep(String memId);
	
	/**
	 * AuthDoc 결재 문서에 필요한 신청 정보 다루는 쿼리
	 */
	kr.or.ddit.admin.member.vo.StudentVO getStdInfo(String stdId);
	
	ProfessorVO getProfInfo(String profId);
	
	int studentUpdate(StudentVO studentVo);

	TakeOffAndStudentVO takeOffDetail(String authDocNum);
	
	int takeOffUpdate(TakeOffAndStudentVO takeOffAndStudentVo);

	ReturnVO returnDetail(String authDocNum);
	
	int returnUpdate(ReturnVO ReturnVo);
	
	ReadmissionVO readmissionDetail(String authDocNum);
	
	int readmissionUpdate(ReadmissionVO readmissionVo);
	
	ExpulsionVO expulsionDetail(String authDocNum);
	
	int expulsionUpdate(ExpulsionVO expulsionVo);
	
	CourseChangeVO courseChangeDetail(String authDocNum);
	
	int courseChangeUpdate(CourseChangeVO courseChangeVo);
	
	int courseRecodeInsert(CourseRecodeVO courseRecodeVo);
	
	int courseRecodeUpdate(CourseRecodeVO courseRecodeVo);
	
	VolunteerVO volunteerDetail(String authDocNum);
	
	int volunteerUpdate(VolunteerVO volunteerVo);
	
	LectureOpenVO lectureDetail(String authDocNum);
	
	int lectureUpdate(LectureOpenVO lectureOpenVo);
}
