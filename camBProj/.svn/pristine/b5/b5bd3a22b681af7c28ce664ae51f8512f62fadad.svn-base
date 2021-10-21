package kr.or.ddit.common.login.mapper;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.common.login.vo.MemberVO;

@Mapper("loginMapper")

public interface LoginMapper {

//	정상로그인
	MemberVO login(MemberVO memberVo);
	
//	비밀번호만 오류인건지 확인
	MemberVO checkPwdMiss(String memId);
	
//	비번에러 1 증가
	int plusErrCnt(MemberVO memberVo);
	
//	비번에러 0으로 초기화
	int resetErrCnt(MemberVO memberVo);
	
//	초기비번컬럼 초기화
	int resetFirstInsert(MemberVO memberVo);
	
//	PWD컬럼 값 입력
	int setPwd(MemberVO memberVo);
	
//  오류횟수 숫자세기
	int selectCnt(MemberVO memberVo);
	
}
