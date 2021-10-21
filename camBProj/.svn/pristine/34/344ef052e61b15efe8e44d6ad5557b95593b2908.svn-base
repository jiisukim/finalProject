package kr.or.ddit.common.faq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.faq.mapper.FaqMapper;
import kr.or.ddit.common.faq.service.FaqService;
import kr.or.ddit.common.faq.vo.FaqVO;

@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqMapper faqMapper;

	@Override
	public List<FaqVO> faqList(Map<String, Object> map) {
		return this.faqMapper.faqList(map);

	}

	@Override
	public int faqInsert(FaqVO faqVo) {
		return this.faqMapper.faqInsert(faqVo);

	}

	@Override
	public FaqVO faqDetail(String artcNum) {
		return this.faqMapper.faqDetail(artcNum);

	}

	@Override
	public int selectCount(Map<String, Object> map){ 
		return this.faqMapper.selectCount(map);
	

	}

	@Override
	public int faqDelete(String artcNum) {
		
		return this.faqMapper.faqDelete(artcNum);
	}

	@Override
	public int faqUpdate(FaqVO faqVo) {
		
		return this.faqMapper.faqUpdate(faqVo);
	}
}