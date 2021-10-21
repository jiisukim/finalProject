package kr.or.ddit.student.tuitionPayment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.student.tuitionPayment.mapper.TuitionPaymentRecodeMapper;
import kr.or.ddit.student.tuitionPayment.service.TuitionPaymentRecodeService;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentRecodeVO;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;

@Service
public class TuitionPaymentServiceRecodeImpl implements TuitionPaymentRecodeService{
	
	@Autowired
	TuitionPaymentRecodeMapper tuitionpaymentRecodeMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TuitionPaymentServiceRecodeImpl.class);
	
	
	/**
	 * 최초 등록 시 : 등록금 납부 기록 입력하기
	 */
	@Override
	public void tuitionPaymentRecodeInsert(TuitionPaymentVO tuitionPaymentVo) {
		TuitionPaymentRecodeVO tuitionPaymentRecodeVo = new TuitionPaymentRecodeVO();
		tuitionPaymentRecodeVo.setVrtAccntNum(tuitionPaymentVo.getVrtAccntNum());
		tuitionPaymentRecodeVo.setActualPayAmt(tuitionPaymentVo.getActualPayAmt());
		tuitionPaymentRecodeVo.setNotPayAmt(tuitionPaymentVo.getActualPayAmt());
		tuitionpaymentRecodeMapper.tuitionPaymentRecodeInsert(tuitionPaymentRecodeVo);
	}

	/**
	 * tuitionPaymentRecode에 완납 기록 - 업데이트
	 */
	@Override
	@Transactional
	public String tuitionPaymentRecodeUpdate(TuitionPaymentRecodeVO tuitionPaymentRecodeVo) throws Exception{
		String payCode = "";
		
		try {
			// payAmt, vrtAccntNum를 파라미터로 받음 -> notPayAmt, payCode를 넣어주기
			int payAmt = tuitionPaymentRecodeVo.getPayAmt();
			
			// 1. vrtAccntNum로 detail을 알아온다음 - 실제로 내야 할 금액을 알아낸다.
			tuitionPaymentRecodeVo = tuitionpaymentRecodeMapper.tuitionPaymentRecodeSelect(tuitionPaymentRecodeVo).get(0);
			int actualPayAmt = tuitionPaymentRecodeVo.getActualPayAmt();
			System.out.println("tuitionPaymentRecodeVo : " + tuitionPaymentRecodeVo);
			
			// 2. 납부해야 할 금액과 남부한 금액을 빼서 완납인지 알아낸다.
			int notPayAmt = payAmt - actualPayAmt;
			if(notPayAmt == 0) { // 완납
				payCode = "04";
			}
			
			// 3. payAmt(new), notPayAmt(new), payCode(new), vrtAccntNum로 업데이트한다
			tuitionPaymentRecodeVo.setPayAmt(payAmt);
			tuitionPaymentRecodeVo.setPayCode(payCode);
			tuitionPaymentRecodeVo.setNotPayAmt(notPayAmt);
			
			tuitionpaymentRecodeMapper.tuitionPaymentRecodeUpdate(tuitionPaymentRecodeVo);
			
		} catch (Exception e) {
			LOGGER.error("tuitionPaymentRecodeUpdate 에러 - rollback : " + e.getMessage());
		}
		
		return payCode;
	}
	
}
