package kr.or.ddit.student.returnBack.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.student.returnBack.service.ReturnService;
import kr.or.ddit.student.returnBack.vo.ReturnVO;
import kr.or.ddit.student.takeOff.vo.StudentVO;
import kr.or.ddit.util.code.service.CodeService;
import kr.or.ddit.util.code.vo.CodeVO;
import kr.or.ddit.util.file.service.FileService;
import kr.or.ddit.util.file.vo.AttachFileVO;
import kr.or.ddit.util.format.service.FormatUtil;
import kr.or.ddit.util.saveToken.service.SaveTokenService;

@Controller
public class ReturnController {
	
	@Autowired
	ReturnService returnService;
	@Autowired
	CodeService codeService; // 공통 코드 처리 용
	@Autowired
	SaveTokenService saveTokenService; // 중복 입력 방지 처리 용
	@Autowired
	FileService fileService; // 파일 처리 용
	@Autowired
	FormatUtil formatUtil; // 전화번호 형식 처리 용
	
	@RequestMapping("/testTiles")
	public String test() {
		return "/student/return/takeOffApplyUpdate";
	}
	
	/**
	 * 리스트 보여주기 
	 * @param returnVo : pageNo가 담김
	 * @param session : 사용자 정보가 담김
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/return/returnApplyList")
	public String returnApplyList(@ModelAttribute ReturnVO returnVo
											    , HttpSession session
											    , Model model) {
		// 사용자 정보 가져오기
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		returnVo.setStdId(memberVo.getMemId());
		// 학생 정보 보내기 (휴학02 일 경우만 신청 가능)
		StudentVO studentVo = returnService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		
		model.addAttribute("returnApplyCount", returnService.returnApplyCount(returnVo));
		
		// 신청 정보 보내기 (접수 중인 복학 신청이 있으면 신청 불가능 - 한 번에 한 번만 신청하도록)
		String applyCheck = returnService.applyCheck(returnVo);
		model.addAttribute("applyCheck", applyCheck);
		// 페이징 처리
		PaginationInfo paginationInfo = returnService.getPaginationInfo(returnVo);
		model.addAttribute("paginationInfo", paginationInfo);
		// 리스트 가져오기
		List<ReturnVO> returnApplyList = returnService.returnApplyList(returnVo, paginationInfo);
		model.addAttribute("returnApplyList", returnApplyList);
		
		return "student/return/returnApplyList";
	}
	
	
	
	/**
	 * 복학 신청 폼 보여주기
	 * @param returnVo : 이전에 위치했던 pageNo 정보가 들어있음. saveToken도 함께 넣어 보내기.
	 * @param session 
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/return/returnApplyInsertView")
	public String returnApplyInsertView(@ModelAttribute ReturnVO returnVo
													  , HttpSession session
													  , Model model) {
		// 학생 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = returnService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		returnVo.setSaveToken(saveToken);
		model.addAttribute("returnVo", returnVo);
		// 공통 코드
		List<CodeVO> codeList = codeService.codeList("RET_TYP");
		model.addAttribute("codeList", codeList);
		
		return "/student/return/returnApplyInsert";
	}
	
	
	
	/**
	 * 복학 신청 폼 제출하기
	 * 파일이 첨부되었을 때만 fileUpload 메서드를 실행함
	 * @param returnVo : pageNo와 신청 정보가 들어있음
	 * @param fileCheck : 파일이 첨부되지 않으면 null
	 * @param session
	 * @return forward로 returnApplyList를 실행
	 */
	@RequestMapping("/student/return/returnApplyInsert")
	public String returnApplyInsert(@ModelAttribute ReturnVO returnVo
												  , @RequestParam(value="fileCheck", required=false) String fileCheck
												  , HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, returnVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/return/returnApplyList";
		}
		
		// 신청 폼 제출
		int result = returnService.returnApplyInsert(returnVo, fileCheck);
		if(result > 0) System.out.println("신청 성공 : " + returnVo);
		
		return "forward:/student/return/returnApplyList";
	}
	
	
	
	/**
	 * 복학 신청 수정 폼 보여주기
	 * @param returnVo : pageNo, returnApplyNum이 들어있음
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/student/return/returnApplyUpdateView")
	public String returnApplyUpdateView(@ModelAttribute ReturnVO returnVo
														, HttpSession session
														, Model model) {
		// 학생 정보 보내기
		MemberVO memberVo = (MemberVO)session.getAttribute("memberVo");
		memberVo.setPhNum(formatUtil.phone(memberVo.getPhNum()));
		model.addAttribute("memberVo", memberVo);
		StudentVO studentVo = returnService.getStdInfo(session);
		model.addAttribute("studentVo", studentVo);
		// 신청 정보 보내기 (덮어 씌워서 보내기)
		returnVo = returnService.returnApplyDetail(returnVo.getReturnApplyNum());
		model.addAttribute("returnVo", returnVo);
		// 첨부 파일 정보
		if(returnVo.getFileGrNum() != null) { // 파일이 들어 있을 경우
			List<AttachFileVO> fileList = fileService.fileList(returnVo.getFileGrNum());
			model.addAttribute("fileList", fileList);
		}
		// 중복 입력 방지 토큰
		String saveToken = saveTokenService.getToken(session);
		returnVo.setSaveToken(saveToken);
		// 공통 코드
		List<CodeVO> codeList = codeService.codeList("RET_TYP");
		model.addAttribute("codeList", codeList);
		
		return "/student/return/returnApplyUpdate";
	}
	
	
	
	/**
	 * 복학 신청 수정 폼 제출하기
	 * 파일이 첨부되었을 때만 fileUpload 메서드를 실행함
	 * @param returnVo : pageNo와 수정된 신청 정보가 들어있음
	 * @param fileCheck : 파일이 첨부되지 않으면 null
	 * @param session
	 * @return forward로 returnApplyList를 실행
	 */
	@RequestMapping("/student/return/returnApplyUpdate")
	public String returnApplyUpdate(@ModelAttribute ReturnVO returnVo
													, @RequestParam(value="fileCheck", required=false) String fileCheck
													, HttpSession session) {
		// 중복 입력 방지 토큰 체크
		Boolean isDuplicate = saveTokenService.isDuplicate(session, returnVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/student/return/returnApplyList";
		}
		
		//수정 폼 제출
		int result = returnService.returnApplyUpdate(returnVo, fileCheck);
		if(result > 0) System.out.println("수정 성공 : " + returnVo);
		
		return "forward:/student/return/returnApplyList";
	}

	
	
	/**
	 * 복학 신청 삭제하기
	 * @param returnVo : pageNo와 returnApplyNum이 들어있음
	 * @return forward로 returnApplyList를 실행
	 */
	@RequestMapping("/student/return/returnApplyDelete")
	public String returnApplyDelete(@ModelAttribute ReturnVO returnVo) {
		
		// 삭제 
		int result = returnService.returnApplyDelete(returnVo);
		if(result > 0) System.out.println("삭제 성공 : " + returnVo);
		return "forward:/student/return/returnApplyList";
	}
	
	
	
	
	

}
