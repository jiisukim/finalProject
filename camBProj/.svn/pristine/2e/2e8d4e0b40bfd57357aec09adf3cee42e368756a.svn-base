package kr.or.ddit.student.expulsion.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.student.expulsion.vo.ExpulsionVO;
import kr.or.ddit.student.returnBack.vo.ReturnVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;

@Mapper("expulsionMapper")
public interface ExpulsionMapper {
	
	List<ExpulsionVO> expulsionApplyList(ExpulsionVO expulsionVo);
	
	int applyCheck(ExpulsionVO expulsionVo);
	
	ExpulsionVO expulsionApplyCount(ExpulsionVO expulsionVo);
	
	ExpulsionVO expulsionApplyDetail(String expApplyNum);
	
	int expulsionApplyInsert(ExpulsionVO expulsionVo);
	
	int expulsionApplyUpdate(ExpulsionVO expulsionVo);
	
	int expulsionApplyDelete(String expApplyNum);
	
	StudentVO getStdInfo(String stdId); 
}
