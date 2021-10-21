package kr.or.ddit.student.expulsion.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.student.expulsion.service.ExpulsionService;
import kr.or.ddit.student.expulsion.vo.ExpulsionVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;
import kr.or.ddit.util.code.service.CodeService;
import kr.or.ddit.util.code.vo.CodeVO;
import kr.or.ddit.util.format.service.FormatUtil;
import kr.or.ddit.util.saveToken.service.SaveTokenService;

@Controller
public class ExpulsionController {
	
	@Autowired
	ExpulsionService expulsionService;
	@Autowired
	CodeService codeService; // 공통 코드 처리 용
	@Autowired
	SaveTokenService saveTokenService; // 중복 입력 방지 처리 용
	@Autowired
	FormatUtil formatUtil; // 전화번호 형식 처리 용
	
	/**
	 * 리스트 보여주기 
	 * @param expulsionVo : pageNo가 담김
	 * @param session : 사용자 정보가 담김
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/expulsion/expulsionApplyList")
	public String expulsionApplyList(@ModelAttribute ExpulsionVO expulsionVo
											    , HttpSession session
											    , Model model) {
		// 사용자 정보 가져오기
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		expulsionVo.setStdId(memberVo.getMemId());
		// 학생 정보 보내기 (학적 상태 재학01/휴학02 일 경우만 신청 가능)
		StudentVO studentVo = expulsionService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		// count 정보
		model.addAttribute("expulsionApplyCount", expulsionService.expulsionApplyCount(expulsionVo));
		// 신청 정보 보내기 (접수 중인 복학 신청이 있으면 신청 불가능 - 한 번에 한 번만 신청하도록)
		String applyCheck = expulsionService.applyCheck(expulsionVo);
		model.addAttribute("applyCheck", applyCheck);
		// 페이징 처리
		PaginationInfo paginationInfo = expulsionService.getPaginationInfo(expulsionVo);
		model.addAttribute("paginationInfo", paginationInfo);
		// 리스트 가져오기
		List<ExpulsionVO> expulsionApplyList = expulsionService.expulsionApplyList(expulsionVo, paginationInfo);
		model.addAttribute("expulsionApplyList", expulsionApplyList);
		
		return "student/expulsion/expulsionApplyList";
	}
	
	
	
	/**
	 * 퇴학(자퇴) 신청 폼 보여주기
	 * @param expulsionVo : 이전에 위치했던 pageNo 정보가 들어있음. saveToken도 함께 넣어 보내기.
	 * @param session 
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/expulsion/expulsionApplyInsertView")
	public String expulsionApplyInsertView(@ModelAttribute ExpulsionVO expulsionVo
													  , HttpSession session
													  , Model model) {
		// 학생 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = expulsionService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		expulsionVo.setSaveToken(saveToken);
		model.addAttribute("expulsionVo", expulsionVo);
		// 공통 코드
		List<CodeVO> codeList = codeService.codeList("RET_TYP");
		model.addAttribute("codeList", codeList);
		
		return "/student/expulsion/expulsionApplyInsert";
	}
	
	
	/**
	 * 퇴학(자퇴) 신청 폼 제출하기
	 * 파일이 첨부되었을 때만 fileUpload 메서드를 실행함
	 * @param expulsionVo : pageNo와 신청 정보가 들어있음
	 * @param session
	 * @return forward로 expulsionApplyList를 실행
	 */
	@RequestMapping("/student/expulsion/expulsionApplyInsert")
	public String expulsionApplyInsert(@ModelAttribute ExpulsionVO expulsionVo
												  , HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, expulsionVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/expulsion/expulsionApplyList";
		}
		
		// 신청 폼 제출
		int result = expulsionService.expulsionApplyInsert(expulsionVo);
		if(result > 0) System.out.println("신청 성공 : " + expulsionVo);
		
		return "forward:/student/expulsion/expulsionApplyList";
	}
	
	
	
	/**
	 * 퇴학(자퇴) 신청 수정 폼 보여주기
	 * @param expulsionVo : pageNo, expulsionApplyNum이 들어있음
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/expulsion/expulsionApplyUpdateView")
	public String expulsionApplyUpdateView(@ModelAttribute ExpulsionVO expulsionVo
														, HttpSession session
														, Model model) {
		// 학생 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = expulsionService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		// 신청 정보 보내기 (덮어 씌워서 보내기)
		expulsionVo = expulsionService.expulsionApplyDetail(expulsionVo.getExpApplyNum());
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		expulsionVo.setSaveToken(saveToken);
		model.addAttribute("expulsionVo", expulsionVo);
		// 공통 코드
		List<CodeVO> codeList = codeService.codeList("RET_TYP");
		model.addAttribute("codeList", codeList);
		
		return "/student/expulsion/expulsionApplyUpdate";
	}
	
	
	
	/**
	 * 퇴학(자퇴) 신청 수정 폼 제출하기
	 * 파일이 첨부되었을 때만 fileUpload 메서드를 실행함
	 * @param expulsionVo : pageNo와 수정된 신청 정보가 들어있음
	 * @param session
	 * @return forward로 expulsionApplyList를 실행
	 */
	@RequestMapping("/student/expulsion/expulsionApplyUpdate")
	public String expulsionApplyUpdate(@ModelAttribute ExpulsionVO expulsionVo
													, HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, expulsionVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/expulsion/expulsionApplyList";
		}
		
		//수정 폼 제출
		int result = expulsionService.expulsionApplyUpdate(expulsionVo);
		if(result > 0) System.out.println("수정 성공 : " + expulsionVo);
		
		return "forward:/student/expulsion/expulsionApplyList";
	}

	
	
	/**
	 * 퇴학(자퇴) 신청 삭제하기
	 * @param expulsionVo : pageNo와 expulsionApplyNum이 들어있음
	 * @return forward로 expulsionApplyList를 실행
	 */
	@RequestMapping("/student/expulsion/expulsionApplyDelete")
	public String expulsionApplyDelete(@ModelAttribute ExpulsionVO expulsionVo) {
		
		// 삭제 
		int result = expulsionService.expulsionApplyDelete(expulsionVo);
		if(result > 0) System.out.println("삭제 성공 : " + expulsionVo);
		return "forward:/student/expulsion/expulsionApplyList";
	}
	
	
	
	
	

}
