package kr.or.ddit.common.search.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.search.mapper.PwSearchMapper;
import kr.or.ddit.common.search.service.PwSearchService;
import kr.or.ddit.common.search.vo.MemberVO;
@Service
public class PwSearchServiceImpl implements PwSearchService {
	
	@Autowired
	private PwSearchMapper searchMapper;
	
	@Override
	public int updatePw(MemberVO memberVo) {
		return this.searchMapper.updatePw(memberVo);
	}

}
