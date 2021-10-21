package kr.or.ddit.common.faq.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.faq.vo.FaqVO;

public interface FaqService {

	List<FaqVO> faqList(Map<String, Object> map);

	int faqInsert(FaqVO faqVo);

	FaqVO faqDetail(String artcNum);
	
	//페이징
	int selectCount(Map<String, Object> map);

	int faqDelete(String artcNum);
	//업데이트
	int faqUpdate(FaqVO faqVo);

}
