package kr.or.ddit.student.returnBack.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.student.returnBack.vo.ReturnVO;

public class MapperTest {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "egovframework/spring/context-common.xml"
								,"egovframework/spring/context-datasource.xml"
								,"egovframework/spring/context-mapper.xml"
				});
		
		//202109002
		// 여기에서 테스트하고 싶은 Mapper를 불러와 메서드를 실행해보면 됨 (ctrl + F11 으로 자바 어플리케이션에서 실행하기)
		ReturnMapper mapper = context.getBean("returnMapper", ReturnMapper.class);
		ReturnVO vo = new ReturnVO();
//		vo.setStdId("210101001");
		vo.setReturnTypeCode("02");
//		vo.setYear("2021");
//		vo.setSemCode("2");
//		vo.setProcStatCode("01");
//		vo.setAuthDocNum("0000");
		vo.setReturnApplyNum("202109001");
		//202109001
//		System.out.println(mapper.returnApplyInsert(vo));
//		System.out.println(mapper.returnApplyDelete("202109001"));
		System.out.println(mapper.getStdInfo("210101001"));
		
		
	}
}
