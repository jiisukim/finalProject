package kr.or.ddit.student.consult.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.student.dorm.mapper.DormMapper;
import kr.or.ddit.student.dorm.vo.DormVO;
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
		// context.getBean("takeOffMapper"); 의 파라미터 -> "takeOffMapper"는 mapper파일의 @Mapper 어노테이션에 써준 이름
		DormMapper mapper = context.getBean("dormMapper", DormMapper.class);
		DormVO dormVo = new DormVO();
		//[stdId=210101001, year=2021, acptYn=N, feePayYn=N, semCode=2, entrApplyNum=null, buildCode=11]
		dormVo.setStdId("210101001");
		dormVo.setYear("2021");
		dormVo.setAcptYn("N");
		dormVo.setFeePayYn("N");
		dormVo.setSemCode("2");
		dormVo.setBuildCode("11");
		dormVo.setEntrApplyNum("2");
		System.out.println(dormVo.toString());
		System.out.println(mapper.DromApply(dormVo));
		
		
		
	}/////////////////// 테스트용이지 코드에 영향 없음
}
