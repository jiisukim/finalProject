package kr.or.ddit.common.search.mapper;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.common.search.vo.MemberVO;

@Mapper("searchMapper")
public interface PwSearchMapper {
	
	int updatePw(MemberVO memberVo);
}
