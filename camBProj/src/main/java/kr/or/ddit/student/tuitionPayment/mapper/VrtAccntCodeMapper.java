package kr.or.ddit.student.tuitionPayment.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.student.tuitionPayment.vo.VrtAccntCodeVO;

@Mapper("vrtAccntCodeMapper")
public interface VrtAccntCodeMapper {
	
	// 가상계좌 불러오기
	List<VrtAccntCodeVO> vrtAccntCodeSelect(VrtAccntCodeVO vrtAccntCodeVo);
	
	// 생성된 가상계좌 수
	int vrtAccntCodeCount(VrtAccntCodeVO vrtAccntCodeVo);
	
	// 가상계좌 생성하기
	int vrtAccntCodeInsert(VrtAccntCodeVO vrtAccntCodeVo);
	
	// 가상계좌 수정하기
	int vrtAccntCodeUpdate(VrtAccntCodeVO vrtAccntCodeVo);
	
}	
	