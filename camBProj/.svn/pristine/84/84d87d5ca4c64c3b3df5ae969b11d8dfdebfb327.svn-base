package kr.or.ddit.student.tuitionPayment.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.admin.member.vo.StudentVO;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;

public interface TuitionPaymentService {
	

	/**
	 * 관리자 등록금 납부 고지서 발급 내역
	 */
	Map<String, Object> tuitionPaymentInsertSelect(TuitionPaymentVO tuitionPaymentVo) throws Exception;

	/**
	 * 스케쥴러 JOB을 돌리는 메서드 
	 * 등록금 납부 고지서 입력
	 * @throws Exception 
	 */
	public void tuitionPaymentInsertJob() throws Exception;
	
	/**
	 * 등록금 내역 조회
	 */
	public List<TuitionPaymentVO> tuitionPaymentList(TuitionPaymentVO tuitionPaymentVo, PaginationInfo paginationInfo) throws Exception;
	
	/**
	 * 페이징 처리
	 */
	public PaginationInfo getPaginationInfo(TuitionPaymentVO tuitionPaymentVo) throws Exception;
	
	/**
	 * 등록금 납부 고지서 조회
	 * Map : 학생vo, 장학금vo, 등록금vo
	 */
	public Map<String, Object> tuitionPaymentBillDetail(TuitionPaymentVO tuitionPaymentVo) throws Exception;
	
	/**
	 * (계절학기 제외한 정규학기 등록금 납부)
	 * 등록금 납부 고지서 입력
	 * 납부 기간이 되면 재학생을 대상으로 등록금 납부 고지서가 생성되어야 함
	 * - vo list를 만들어서 다중 insert  
	 */
	public int tuitionPaymentInsert(TuitionPaymentVO paramTuitionPaymentVo) throws Exception;
	/**
	 * 등록금 납부되었으면 업데이트
	 * - 가상계좌 입금을 어떻게 확인하고 업데이트해주지? 스케줄러?
	 * - rgst_sem + 1 해주기
	 */
	@Transactional
	public void tuitionPaymentUpdate(TuitionPaymentVO tuitionPaymentVo) throws Exception;

	/**
	 * 등록금 count 정보
	 */
	TuitionPaymentVO tuitionPaymentCount(TuitionPaymentVO tuitionPaymentVo) throws Exception;

	/**
	 * 학생 정보
	 */
	StudentVO getStdInfo(String stdId) throws Exception;

	

	

	
	
}
