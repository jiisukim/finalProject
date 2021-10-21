package kr.or.ddit.common.myPage.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.common.myPage.vo.VCodeBank;

@Mapper("myPageMapper")
public interface MyPageMapper {

	MemberVO myPageList(String id);
	
	int myPageUpdate(MemberVO memberVo);

//	개인정보 수정 전 비밀번호 재확인
	MemberVO checkMember(MemberVO memberVo)throws Exception;

//	학생 정보 수정 
	int myPagePwUpdate(MemberVO memberVo)throws Exception;
	
//	은행 리스트
	List<VCodeBank> bankList() throws Exception;
	
	
	
}
