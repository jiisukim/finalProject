package kr.or.ddit.common.myPage.service;

import java.util.List;

import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.common.myPage.vo.VCodeBank;


public interface MyPageService {

	MemberVO myPageList(String id);

	int myPageUpdate(MemberVO memberVo);
	
//	개인정보 수정 전 비밀번호 재확인
	public MemberVO checkMember(MemberVO memberVo) throws Exception;
	
//	학생 정보 수정 
	public int myPagePwUpdate(MemberVO memberVo) throws Exception;
	
//	은행 리스트
	public List<VCodeBank> bankList() throws Exception;


}
