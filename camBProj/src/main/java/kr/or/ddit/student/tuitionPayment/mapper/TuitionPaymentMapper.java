package kr.or.ddit.student.tuitionPayment.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.admin.member.vo.StudentVO;
import kr.or.ddit.student.courseChange.vo.UniversityDepartmentVO;
import kr.or.ddit.student.scholarship.vo.ScholarshipRecodeVO;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;

@Mapper("tuitionPaymentMapper")
public interface TuitionPaymentMapper {
	
	 // 관리자 - 등록금 고지서 발급 내역 출력하기
	 String tuitionPaymentInsertCount();
	 List<TuitionPaymentVO> tuitionPaymentInsertSelelct(TuitionPaymentVO tuitionPaymentVo);
	
	 int tuitionPaymentInsert(Map<String, Object> map);
	 
	 List<TuitionPaymentVO> tuitionPaymentList(TuitionPaymentVO tuitionPaymentVo);
	 
	 TuitionPaymentVO tuitionPaymentBillDetail(TuitionPaymentVO tuitionPaymentVo);

	 int tuitionPaymentUpdate(TuitionPaymentVO tuitionPaymentVo);
	 
	 // 재학생 리스트 가져오기
	 List<StudentVO> studentList();
	 
	 // 학과 등록금 리스트 가져오기
	 List<UniversityDepartmentVO> univDepartList(UniversityDepartmentVO universityDepartmentVo);
	 
	 // 장학금 정보 가져오기
	 ScholarshipRecodeVO scholaRecodeDetail(ScholarshipRecodeVO scholarshipRecodeVo);
	 
	 // 학생 정보 가져오기
	 StudentVO getStdInfo(String stdId);
	 
	 // 학생 정보 업데이트
	 int stdUpdate(StudentVO studentVo);
	 
	 // count 정보 가져오기 
	 TuitionPaymentVO tuitionPaymentCount(TuitionPaymentVO tuitionPaymentVo);
}	
