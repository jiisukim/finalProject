package kr.or.ddit.student.tuitionPayment.service;

import kr.or.ddit.student.tuitionPayment.vo.VrtAccntCodeVO;

public interface VrtAccntService {

	/**
	 * 가상계좌 10000개 생성하기
	 */
	void vrtAccntCodeInsert();

	/**
	 * 사용할 수 있는 계좌번호 가져오고 업데이트하기
	 * 1. USE_YN가 N인 계좌 번호 하나 가져오기
	 * 2. 해당 계좌 번호 사용 USE_YN 를 Y로 업데이트, 파라미터로 받은 mem_id로 업데이트
	 * 3. 해당 VrtAccntCodeVO return
	 */
	VrtAccntCodeVO vrtAccntCodeSelectAndUpdate(String memId);

	/**
	 * 사용이 끝난 계좌 번호 업데이트하기 
	 * 해당 계좌 번호를 파라미터로 받아서 사용 USE_YN 를 N로 업데이트, mem_id NULL로 업데이트
	 */
	void vrtAccntCodeUpdate(String vrtAccnt);
	
}
