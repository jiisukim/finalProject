package kr.or.ddit.admin.univDep.mapper;

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
		UnivDepMapper mapper = context.getBean("univDepMapper", UnivDepMapper.class);
		System.out.println(mapper.selectUnivDepList(null));
		
		
	}
}
