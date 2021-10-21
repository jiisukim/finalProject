package kr.or.ddit.student.graduate.service;

import java.util.Map;

public interface GraduateService {

	Map<String, Object> gradEvaluationDetail(String stdId);

	/**
	 * 학생 졸업 처리
	 * @param stdId
	 * @throws Exception
	 */
	void stdGraduate(String stdId) throws Exception;

}
