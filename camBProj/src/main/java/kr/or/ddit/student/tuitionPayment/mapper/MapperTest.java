package kr.or.ddit.student.tuitionPayment.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentRecodeVO;
import kr.or.ddit.student.tuitionPayment.vo.TuitionPaymentVO;
import kr.or.ddit.student.tuitionPayment.vo.VrtAccntCodeVO;
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
//		TuitionPaymentMapper mapper = context.getBean("tuitionPaymentMapper", TuitionPaymentMapper.class);
		TuitionPaymentRecodeMapper mapper = context.getBean("tuitionPaymentRecodeMapper", TuitionPaymentRecodeMapper.class);
		
		TuitionPaymentRecodeVO tuitionPaymentRecodeVo = new TuitionPaymentRecodeVO();
		tuitionPaymentRecodeVo.setVrtAccntNum("123456");
		tuitionPaymentRecodeVo.setActualPayAmt(1000);
		mapper.tuitionPaymentRecodeInsert(tuitionPaymentRecodeVo);
		
		String test = "";
		if(new TuitionPaymentVO().getYear() == null) {
			test = "1";
		}
		
		System.out.println(test);
		
		
	}
}
