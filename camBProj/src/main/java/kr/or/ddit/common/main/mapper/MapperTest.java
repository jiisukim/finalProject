package kr.or.ddit.common.main.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.common.main.vo.JobCountVO;
import kr.or.ddit.common.main.vo.NoticeVO;
import kr.or.ddit.common.main.vo.StdAcadInfoVO;
import kr.or.ddit.student.returnBack.vo.ReturnVO;

public class MapperTest {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "egovframework/spring/context-common.xml"
								,"egovframework/spring/context-datasource.xml"
								,"egovframework/spring/context-mapper.xml"
				});
		
		MainMapper mapper = context.getBean("mainMapper", MainMapper.class);
		
		JobCountVO target = mapper.consultCount("210201001");
		JobCountVO source = mapper.authDocInfoCountForStep("210201001");
		
		// 소스, 타겟
		BeanUtils.copyProperties(source, target, "consultCnt01", "consultCnt02", "consultCnt03", "consultCnt04");
		
		System.out.println("target: " + target.toString() );
		
	}
}
