package kr.or.ddit.common.myPage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.common.myPage.mapper.MyPageMapper;
import kr.or.ddit.common.myPage.service.MyPageService;
import kr.or.ddit.common.myPage.vo.VCodeBank;

@Service
public class MyPageServiceImpl implements MyPageService {
	@Autowired
	private MyPageMapper myPageMapper;
	
	@Override
	public MemberVO myPageList(String id) {
		return this.myPageMapper.myPageList(id);
	}

	@Override
	public int myPageUpdate(MemberVO memberVo) {
		return this.myPageMapper.myPageUpdate(memberVo);
	}

//	개인정보 수정 전 비밀번호 재확인
	@Override
	public MemberVO checkMember(MemberVO memberVo) throws Exception {
		return this.myPageMapper.checkMember(memberVo);
	}
	
//	학생 정보 수정 
	@Override
	public int myPagePwUpdate(MemberVO memberVo)throws Exception {
		return this.myPageMapper.myPagePwUpdate(memberVo);
	}

//	은행 리스트
	@Override
	public List<VCodeBank> bankList() throws Exception {
		return this.myPageMapper.bankList();
	}



}
