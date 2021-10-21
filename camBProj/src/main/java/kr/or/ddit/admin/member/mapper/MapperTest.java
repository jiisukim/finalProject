package kr.or.ddit.admin.member.mapper;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.admin.member.vo.MemberVO;
import kr.or.ddit.admin.member.vo.StudentVO;
/**
 * 이 파일 자체를 테스트 하고 싶은 mapper 폴더로 복사 한 뒤 사용하세요.
 * @author PC-08
 */
public class MapperTest {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "egovframework/spring/context-common.xml"
									,"egovframework/spring/context-datasource.xml"
									,"egovframework/spring/context-mapper.xml"
					});
		
		// 여기에서 테스트하고 싶은 Mapper를 불러와 메서드를 실행해보면 됨 (ctrl + F11 으로 자바 어플리케이션에서 실행하기)
		// context.getBean("takeOffMapper"); 의 파라미터 -> "MemberMapper"는 mapper파일의 @Mapper 어노테이션에 써준 이름
		MemberMapper memberMapper = context.getBean("memberMapper", MemberMapper.class);
		StudentVO stv = new StudentVO();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");	
		stv.setStdId("210101008");
		stv.setAdmDate(sdf.parse("2021-09-01"));
		stv.setUnivDeptNum("01");
		stv.setAdvProf("210201001");
		System.out.println("stv : >>" + stv.toString());
		int count = memberMapper.insertStudent(stv);
		System.out.println(">> mapper test : " + count);
	}
}
