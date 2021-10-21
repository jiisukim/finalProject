package kr.or.ddit.common.search.contorller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.search.service.PwSearchService;
import kr.or.ddit.common.search.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil.CryptoUtil;
import kr.or.ddit.util.mail.Mailer;

@Controller
public class PwSearchController {

   private Logger logger = LoggerFactory.getLogger(this.getClass());
   
   @Autowired
   private Mailer testMailer;

   
     @Autowired private PwSearchService pwSearchService;
    
   
   public String sendmailLogin(Map<String, Object> map) {
      System.out.println("sendmailLogin >> map : " + map);
      try {
         testMailer.sendMail(map.get("email").toString()
               , "CamB 로그인 비밀번호 입니다."
               , map.get("authNo").toString()+"\n 변경된 비밀번호 입니다.");
      } catch (Exception e) {
         e.printStackTrace();
         return "FAIL";         
      }
      
      return "SUCC";
   }   
   @RequestMapping(value = "/common/search/searchPw", method = RequestMethod.GET)
   public String searchPw() {

      return "/common/search/searchPw";
   }
   @RequestMapping(value = "/common/search/searchPw", method = RequestMethod.POST)
   public String searchPwPost(@RequestParam Map<String,Object> map, @ModelAttribute MemberVO memberVo) throws Exception {
//      랜덤한 5자리 정수 생성
      String authNo = Integer.toString((int)(Math.random() * (99999 - 10000 + 1)) + 10000);
      logger.info("랜덤5자리 : >> " + authNo);
      
      map.put("authNo", authNo);
		/* map.put("email", memberVo.getEmail()); */
      
      System.out.println("searchPW >> map : " + map);      

//      이메일 발송
      String result = sendmailLogin(map);
      
//      이메일 발송 실패시
      if("FAIL".equals(result)) {
         logger.info("이메일 발송 실패");
      }
      
//      DB에 넣기 위해 암호화
      String newPw = CryptoUtil.sha512(authNo);
      map.put("newPw", newPw);
        
      memberVo.setNewPw(newPw);
      logger.info("멤버VOOOOOOO: " + memberVo);
      
      int newPw2 = this.pwSearchService.updatePw(memberVo);
      
      return "/common/search/searchPw";
   }
   
}