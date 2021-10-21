package kr.or.ddit.util.code.service;

import java.util.List;

import kr.or.ddit.util.code.vo.CodeVO;

public interface CodeService {
	
	/**
	 * 코드 타입을 입력하면 해당 타입의 코드 정보를 List<CodeVO>로 반환
	 * @param codeType
	 * @return List<CodeVO> (코드 타입, 코드 타입 명, 코드 값, 코드 명)
	 */
	public List<CodeVO> codeList(String codeType);
	
	/**
	 * 전체 학과 코드를 'UNIV_DEPT77' 형식 학과 코드를 CodeVo에 담아 반환
	 * @return List<CodeVO>
	 */
	public List<CodeVO> univDeqtCodeList();
	
	
	/**
	 * 'UNIV1' 형식 대학 코드를 CodeVo에 담아 반환
	 * @return List<CodeVO>
	 */
	public List<CodeVO> univCodeList();
	
}
