package kr.or.ddit.common.error;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.login.vo.MemberVO;

@Controller
public class ErrorController {
	
	// 로그인 된 상태면 main으로, 로그인 되지 않은 상태면 login으로 돌아가기
	
	@RequestMapping("/common/error")
	public String error(HttpSession session, Model model) {
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		String viewUrl = "/common/main"; // 로그인 되어 있으면
		String viewStr = "메인";
		if(memberVo == null) { // 로그인 되어 있지 않으면
			viewUrl = "/common/login";
			viewStr = "로그인";
		}
		model.addAttribute("viewUrl", viewUrl);
		model.addAttribute("viewStr", viewStr);
		return "common/error";
	}

	@RequestMapping("/common/error404")
	public String error404(HttpSession session, Model model) {
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		String viewUrl = "/common/main"; // 로그인 되어 있으면
		String viewStr = "메인";
		if(memberVo == null) { // 로그인 되어 있지 않으면
			viewUrl = "/common/login";
			viewStr = "로그인";
		}
		model.addAttribute("viewUrl", viewUrl);
		model.addAttribute("viewStr", viewStr);
		return "common/error404";
	}
	
	@RequestMapping("/common/error500")
	public String error500(HttpSession session, Model model) {
		MemberVO memberVo = (MemberVO) session.getAttribute("memberVo");
		String viewUrl = "/common/main"; // 로그인 되어 있으면
		String viewStr = "메인";
		if(memberVo == null) { // 로그인 되어 있지 않으면
			viewUrl = "/common/login";
			viewStr = "로그인";
		}
		model.addAttribute("viewUrl", viewUrl);
		model.addAttribute("viewStr", viewStr);
		return "common/error500";
	}

}
