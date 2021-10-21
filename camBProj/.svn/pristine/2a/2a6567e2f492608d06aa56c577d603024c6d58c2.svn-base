package kr.or.ddit.util.saveToken.service;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class SaveTokenService {
	
	/**
	 * 중복 입력 방지를 위한 토큰을 생성한 뒤, 
	 * 세션에 "saveToken" 속성으로 담고, 문자열로 반환한다.
	 * (사용 방법 : 반환된 문자열 값을 view단으로 보내 hidden input에 넣은 후
	 * 				insert 시 controller단으로 가져오면 된다)
	 * @param session
	 * @return 중복 입력 방지를 위한 토큰 문자열
	 */
	public String getToken(HttpSession session) {
		String saveToken = UUID.randomUUID().toString(); // 토큰 생성
		session.setAttribute("saveToken", saveToken); // 세션에 담기
		return saveToken; // 토큰 스트링 반환
	}
	
	/**
	 * view단에서 넘어온 중복 방지 토큰 값과 세션에 저장된 토큰 값을 비교한다.
	 * 비교 후 세션을 삭제한다. 
	 * @param session
	 * @param paramToken
	 * @return 두 토큰이 달라 중복 입력이라고 판단될 경우 true
	 */
	public Boolean isDuplicate(HttpSession session, String paramToken) {
		String sessionToken = String.valueOf(session.getAttribute("saveToken")); // 세션의 토큰 가져오기
		System.out.println("sessionToken : " + sessionToken);
		System.out.println("paramToken : " + paramToken);
		if(paramToken.equals(sessionToken)) { // 입력한 토큰과 비교해 같은 경우 false 반환
			session.removeAttribute("saveToken");
			return false;
		}else {
			session.removeAttribute("saveToken"); 
			return true;
		}
	}
	
}
