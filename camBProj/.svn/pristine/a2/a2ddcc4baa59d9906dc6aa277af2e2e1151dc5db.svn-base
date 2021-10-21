package kr.or.ddit.common.main.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.common.main.vo.JobCountVO;
import kr.or.ddit.common.main.vo.MemberInfoVO;
import kr.or.ddit.common.main.vo.NoticeVO;
import kr.or.ddit.common.main.vo.StdAcadInfoVO;
import kr.or.ddit.student.registrationLecture.vo.LectureOpenVO;

@Mapper
public interface MainMapper {
	
	List<NoticeVO> noticeSelect(NoticeVO noticeVo);
	
	MemberInfoVO memInfoSelect(String memId);
	
	StdAcadInfoVO getCourseCredit(String stdId);
	
	StdAcadInfoVO getGrdtnCred();
	
	JobCountVO consultCount(String memId);

	JobCountVO authDocInfoCount(String memId);
	
	JobCountVO authDocInfoCountForStep(String memId);
	
	String[] profLectureSelect(LectureOpenVO lectureOpenVo);
	
	String[] authDocNumSelect(String memId);

	String[] authDocNumForStepSelect(String memId);
	
	String empQnaCnt();
	
	JobCountVO stdAcadInfoCount(String stdId);
	
}
