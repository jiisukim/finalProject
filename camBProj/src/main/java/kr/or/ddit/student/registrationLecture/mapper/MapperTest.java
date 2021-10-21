package kr.or.ddit.student.registrationLecture.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.student.courseChange.mapper.CourseChangeMapper;
import kr.or.ddit.student.registrationLecture.vo.CartVO;
import kr.or.ddit.student.registrationLecture.vo.LectureOpenAndSyllabusVO;
import kr.or.ddit.student.registrationLecture.vo.LectureOpenVO;
import kr.or.ddit.student.registrationLecture.vo.RegistrationLectureVO;
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
		RegistrationLectureMapper mapper = context.getBean("registrationLectureMapper", RegistrationLectureMapper.class);
//		210101001(String), 2021(String), 2(String)
		LectureOpenVO vo = new LectureOpenVO();
		vo.setYear("2021");
		vo.setSemCode("2");
		vo.setStdId("210101001");
		System.out.println(mapper.registrationLectureCountAndCredSum(vo));
		
	}
}
