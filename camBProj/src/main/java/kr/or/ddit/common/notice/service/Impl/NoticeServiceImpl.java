package kr.or.ddit.common.notice.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.notice.mapper.NoticeMapper;
import kr.or.ddit.common.notice.service.NoticeService;
import kr.or.ddit.common.notice.vo.NoticeVO;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper noticeMapper;
	
	//전체리스트
	@Override
	public List<NoticeVO> noticeList(Map<String, Object> map){
		return this.noticeMapper.noticeList(map);		
	}
	//등록
	@Override
	public int noticeInsert(NoticeVO noticeVo) {
		return this.noticeMapper.noticeInsert(noticeVo);
	}
	//페이지 갯수
	@Override
	public int selectCnt(Map<String, Object> map){ 
		return this.noticeMapper.selectCnt(map);
	
	}
	//상세정보
	@Override
	public NoticeVO noticeDetail(String artcNum) {
		return this.noticeMapper.noticeDetail(artcNum);
	}
	//삭제
	@Override
	public int noticeDelete(String artcNum) {
		return this.noticeMapper.noticeDelete(artcNum);
	}
	//수정
	@Override
	public int noticeUpdate(NoticeVO noticeVo) {
		return this.noticeMapper.noticeUpdate(noticeVo);
	}

}
