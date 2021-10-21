package kr.or.ddit.student.tuitionPayment.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentRecodeVO;

@Mapper("tuitionPaymentRecodeMapper")
public interface TuitionPaymentRecodeMapper {
	// 등록금 납부 기록 가져오기
	List<TuitionPaymentRecodeVO> tuitionPaymentRecodeSelect(TuitionPaymentRecodeVO tuitionPaymentRecodeVo);
	
	// 최초 등록 시 : 등록금 납부 기록 입력하기
	int tuitionPaymentRecodeInsert(TuitionPaymentRecodeVO tuitionPaymentRecodeVo);
	
	// 납부 : 등록금 납부 기록 업데이트
	int tuitionPaymentRecodeUpdate(TuitionPaymentRecodeVO tuitionPaymentRecodeVo);
}	
