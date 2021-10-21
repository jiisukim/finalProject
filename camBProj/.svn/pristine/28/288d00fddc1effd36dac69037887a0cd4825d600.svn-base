package kr.or.ddit.common.login.service;

import kr.or.ddit.common.login.vo.MemberVO;

public interface LoginService {
	
//	정상로그인
	public MemberVO login(MemberVO memberVo) throws Exception;
	
//	비밀번호만 오류인건지 확인
	public MemberVO checkPwdMiss(String memId) throws Exception;
	
//	비번에러 1 증가
	public int plusErrCnt(MemberVO memberVo) throws Exception;
	
//	비번에러 0으로 초기화
	public int resetErrCnt(MemberVO memberVo) throws Exception;
	
//	초기비번컬럼 초기화
	public int resetFirstInsert(MemberVO memberVo) throws Exception;
	
//	PWD컬럼 값 입력
	public int setPwd(MemberVO memberVo) throws Exception;
	
//  오류횟수 숫자세기
	public int selectCnt(MemberVO memberVo) throws Exception;

}
