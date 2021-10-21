package kr.or.ddit.student.readmission.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.student.readmission.vo.ReadmissionVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;

@Mapper("readmissionMapper")
public interface ReadmissionMapper {
	
	List<ReadmissionVO> readmissionApplyList(ReadmissionVO readmissionVo);
	
	int applyCheck(ReadmissionVO readmissionVo);
	
	ReadmissionVO readmissionApplyCount(ReadmissionVO readmissionVo);
	
	ReadmissionVO readmissionApplyDetail(String readmNum);
	
	int readmissionApplyInsert(ReadmissionVO readmissionVo);
	
	int readmissionApplyDelete(String readmNum);
	
	StudentVO getStdInfo(String stdId); 
}
