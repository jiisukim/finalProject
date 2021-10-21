package kr.or.ddit.student.tuitionPayment.service;

import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentRecodeVO;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;

public interface TuitionPaymentRecodeService {

	/**
	 * 최초 등록 시 : 등록금 납부 기록 입력하기
	 */
	public void tuitionPaymentRecodeInsert(TuitionPaymentVO tuitionPaymentVo) throws Exception;
	
	/**
	 * tuitionPaymentRecode에 완납 기록 - 업데이트
	 * @return 
	 */
	@Transactional
	public String tuitionPaymentRecodeUpdate(TuitionPaymentRecodeVO tuitionPaymentRecodeVo) throws Exception;
	
}
