package kr.or.ddit.student.tuitionPayment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.common.login.vo.MemberVO;
import kr.or.ddit.student.tuitionPayment.service.TuitionPaymentService;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;
import kr.or.ddit.util.saveToken.service.SaveTokenService;

/**
 * 등록금 납부 고지서
 * @author PC-08
 */
@Controller
public class TuitionPaymentController {
	
	@Autowired
	TuitionPaymentService tuitionPaymentService;
	@Autowired
	SaveTokenService saveTokenService; // 중복 입력 방지 처리 용
	
	/**
	 * 등록금 납부 고지서 수동 발행 화면 보여주기
	 * - 시연, 데이터 생성을 위함
	 * @throws Exception 
	 */
	@RequestMapping("/admin/tuitionPayment/tuitionPaymentList")
	public String tuitionPaymentInsertView(TuitionPaymentVO tuitionPaymentVo, Model model, HttpSession session) throws Exception {
		
		// 중복 입력 방지 토큰 (세션과 뷰에 저장)
		tuitionPaymentVo.setSaveToken(saveTokenService.getToken(session));
		model.addAttribute("tuitionPaymentVo", tuitionPaymentVo);
				
		Map<String, Object> resultMap = tuitionPaymentService.tuitionPaymentInsertSelect(tuitionPaymentVo);
		model.addAttribute("paginationInfo", resultMap.get("paginationInfo"));
		model.addAttribute("tuitionPaymentList", resultMap.get("tuitionPaymentList"));
		model.addAttribute("totalCnt", resultMap.get("totalCnt"));
		return "admin/tuitionPayment/tuitionPaymentInsert";
	}
	
	/**
	 * 등록금 납부 고지서 수동 발행 (학기, 년도 입력받음)
	 * - 시연, 데이터 생성을 위함
	 * @throws Exception 
	 */
	@RequestMapping("/admin/tuitionPayment/tuitionPaymentInsert")
	public String tuitionPaymentInsert(TuitionPaymentVO tuitionPaymentVo, HttpSession session) throws Exception {
		
		Boolean isDuplicate = saveTokenService.isDuplicate(session, tuitionPaymentVo.getSaveToken());
		if(isDuplicate) {
			return "forward:/admin/tuitionPayment/tuitionPaymentList";
		}
		
		tuitionPaymentService.tuitionPaymentInsert(tuitionPaymentVo);
		return "forward:/admin/tuitionPayment/tuitionPaymentList";
	}
	
	/**
	 * 등록금 내역 조회
	 * @throws Exception 
	 */
	@RequestMapping(value = "/student/tuitionPayment/tuitionPaymentList")
	public String tuitionPaymentList(@ModelAttribute TuitionPaymentVO tuitionPaymentVo
												    , HttpSession session
												    , Model model) throws Exception {
		// 사용자 정보 가져오기
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		tuitionPaymentVo.setStdId(memberVo.getMemId());
		model.addAttribute("studentVo", tuitionPaymentService.getStdInfo(memberVo.getMemId()));
		
		// 페이징 처리
		PaginationInfo paginationInfo = tuitionPaymentService.getPaginationInfo(tuitionPaymentVo);
		model.addAttribute("paginationInfo", paginationInfo);
		// 리스트 가져오기
		List<TuitionPaymentVO> tuitionPaymentList = tuitionPaymentService.tuitionPaymentList(tuitionPaymentVo, paginationInfo);
		model.addAttribute("tuitionPaymentList", tuitionPaymentList);
		// 완납, 미납 건수
		model.addAttribute("tuitionPaymentCount", tuitionPaymentService.tuitionPaymentCount(tuitionPaymentVo));
		return "/student/tuitionPayment/tuitionPaymentList";
	}
	
	/**
	 * ajax : 등록금 납부 고지서 조회 모달에 값 전달
	 * Map : 학생vo, 장학금vo, 등록금vo
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/student/tuitionPayment/tuitionPaymentBillDetail", produces = "application/json; charset=utf8")
	public Map<String, Object> tuitionPaymentBillDetail(@RequestBody TuitionPaymentVO tuitionPaymentVo
														    , HttpSession session
														    , Model model) throws Exception {
		// 사용자 정보 가져오기
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		tuitionPaymentVo.setStdId(memberVo.getMemId());
		
		// 학생vo, 장학금vo, 등록금vo 가져오기
		Map<String, Object> map = tuitionPaymentService.tuitionPaymentBillDetail(tuitionPaymentVo);
		return map;
	}
	
	/**
	 * 등록금 납부되었으면 업데이트 - 
	 * 1. 사용자가 입금액 입력 후 입금완료 버튼을 클릭
	 * 2. 가상계좌번호와 입금액 데이터를 받아서 처리하기
	 * 3.1. 완납일 경우 : 완납처리. rgst_sem + 1 해주기 - 완료
	 * 3.2. 미납일 경우 : 미납처리. 
	 * 3.3. 과납일 경우 : 환불 알림-이자처리-환불처리 - 환불 완료 후 완납처리 (시간 상 생략)
	 * @throws Exception 
	 */
	@RequestMapping(value = "/student/tuitionPayment/tuitionPaymentUpdate")
	public String tuitionPaymentUpdate(@ModelAttribute TuitionPaymentVO tuitionPaymentVo) throws Exception {
		tuitionPaymentService.tuitionPaymentUpdate(tuitionPaymentVo);
		return "forward:/student/tuitionPayment/tuitionPaymentList";
	}
}
