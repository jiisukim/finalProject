package kr.or.ddit.student.takeOff.service;

import java.util.List;

import kr.or.ddit.student.takeOff.vo.StudentVO;
import kr.or.ddit.student.takeOff.vo.TakeOffVO;

public interface TakeOffService {
	
	public List<TakeOffVO> takeOffApplyList(TakeOffVO takeOffVo);
	
	public String applyCheck(TakeOffVO takeOffVo);
	
	public TakeOffVO getEndYearSem(TakeOffVO takeOffVo);
	
	public String getEndYearSem(int year, String sem, int semCnt);

	public TakeOffVO takeOffApplyCount(TakeOffVO takeOffVo);
	
	public TakeOffVO takeOffApplyDetail(String takeOffApplyNum);
	
	public int takeOffApply(TakeOffVO takeOffVo);
	
	public int takeOffApplyUpdate(TakeOffVO takeOffVo);
	
	public int takeOffApplyDelete(String takeOffApplyNum);

	/**
	 * 신청 폼에 보낼 학생 정보 가져오기
	 */
	StudentVO getStdInfo(String stdId);
	
	/**
	 * 신청 폼에 보낼 학생 정보 중 휴학 가능한 학기 기간 가져오기
	 */
	int getAvailableSemCnt(String stdId);
}
