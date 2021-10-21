package kr.or.ddit.admin.univDep.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.admin.univDep.vo.UnivDepVO;
import kr.or.ddit.admin.univDep.vo.UnivVO;

@Mapper("univDepMapper")
public interface UnivDepMapper {
	
//	학과 목록
	List<UnivDepVO> selectUnivDepList(UnivDepVO univDepVo);
	
//	전체 학과 수
	int totalUnivDep(UnivDepVO univDepVo);
	
//	대학 목록
	List<UnivVO> selectUnivList();
	
//	학과 등록 전 학과 번호 생성
	String makeUnivDepNum();
	
//	학과 등록
	int insertUnivDep(UnivDepVO univDepVo);
	
//	학과 디테일 보기
	UnivDepVO selectUnivDepDetail(String univDeptNum);
	
//	학과 수정
	int updateUnivDep(UnivDepVO univDepVo);
	
//	학과 삭제
	int deleteUnivDep(UnivDepVO univDepVo);

}
